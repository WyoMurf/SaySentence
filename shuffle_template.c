#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct comment 
{
	char *string;
	struct comment *next;
};

struct format
{
	char *format;
	struct comment *list;
	struct comment *last;
	struct format *next;
};

struct comment *curr_list;
struct comment *curr_list_last;

struct format *formlist;
struct format *formlist_last;

struct comment *create_comment(char *str)
{
	struct comment *c = calloc(1, sizeof(struct comment));
	c->string = malloc(strlen(str)+1);
	strcpy(c->string, str);
	return c;
}

struct comment *destroy_comment(struct comment *c)
{
	struct comment *next = c->next;
	free(c->string);
	free(c);
	return next;
}

struct format *create_format(char *fstr, struct comment *list, struct comment *last)
{
	struct format *f = calloc(1, sizeof(struct format));
	f->format = malloc(strlen(fstr)+1);
	strcpy(f->format, fstr);
	f->list = list;
	f->last = last;
	return f;
}

struct format *destroy_format(struct format *f)
{
	struct comment *c = f->list;
	struct format *next = f->next;
	while( c && (c=destroy_comment(c)) )
		;
	f->list = 0;
	free(f->format);
	return next;
}

void usage(void)
{
	printf("Usage: shuffle_template <infilepath> <outfilepath>\n");
}

void trim(char *str)
{
	int len = strlen(str);
	if (!len) return;
	while (*str && (*str == ' ' || *str == '\t' || *str == '\n' || *str == '\r' ))
	{
		char *p = str+1;
		while (*p)
		{
			*(p-1) = *p;
			p++;
		}
		*(p-1) = 0;
		len--;
	}
	while (*str && ( *(str+len-1) == ' ' || *(str+len-1) == '\t' || *(str+len-1) == '\n' || *(str+len-1) == '\r' ))
	{
		*(str+len-1)=0;
		len--;
	}    
}

int main(int argc, char **argv)
{
	char inbuf[4096];
	FILE *inf;
	FILE *outf;
	int line = 0;
	struct format *fp, *fp2;
	struct comment *cp, *cp2;
	if (argc != 3)
	{
		usage();
		exit(1);
	}
	inf = fopen(argv[1],"r");
	outf = fopen(argv[2],"w");

	if (!inf)
	{
		printf("Couldn't open %s for reading\n", argv[1]);
		exit(2);
	}
	
	if (!outf)
	{
		printf("Couldn't open %s for writing\n", argv[2]);
		exit(3);
	}
	curr_list = NULL;
	curr_list_last = NULL;
	formlist = NULL;
	formlist_last = NULL;
	
	while( fgets(inbuf, sizeof(inbuf), inf) )
	{
		trim(inbuf);
		line++;
		if (strlen(inbuf) == 0) 
			continue;
		if (inbuf[0] == '[')
		{
			struct format *f = create_format(inbuf, curr_list, curr_list_last);
			curr_list = NULL;
			curr_list_last = NULL;
			if( !formlist)
			{
				formlist = formlist_last = f;
			}
			else
			{
				formlist_last->next = f;
				formlist_last = f;
			}
		}
		else if (inbuf[0] = '#')
		{
			struct comment *c = create_comment(inbuf);
			if(!curr_list)
			{
				curr_list = curr_list_last = c;
			}
			else
			{
				curr_list_last->next = c;
				curr_list_last = c;
			}

		}
		else
		{
			printf("Garbage in line %d: %s\n", line, inbuf);
		}
	}
	/* contents collected, now do your magic */
	for (fp=formlist; fp; fp=fp->next)
	{
		struct format *fp2next;
		struct format *fplast = fp;
		for(fp2=fp->next; fp2; fp2=fp2next)
		{
			fp2next = fp2->next;
			if( strcmp(fp->format, fp2->format) == 0 )
			{
				fp->last->next = fp2->list; /* fp absorbs the stuff in fp2 */
				fp->last = fp2->last;
				fp2->list = NULL;
				fp2->last = NULL;
				fplast->next = fp2->next;
				destroy_format(fp2);
			}
			else
			{
				fplast = fp2;
			}
		}
	}
	// Now print it out 
	fprintf(outf,"\n\n");
	for (fp=formlist; fp; fp=fp->next)
	{
		for(cp=fp->list; cp; cp=cp->next)
		{
			fprintf(outf,"%s\n", cp->string);
		}
		fprintf(outf,"%s\n\n\n", fp->format);
	}
	fclose(outf);
	/* done, destroy the data in case this all becomes a subroutine */
	fp = formlist;
	while( fp && (fp=destroy_format(fp)) )
		;
}


