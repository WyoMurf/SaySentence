// $ANTLR 3.4 translation.g 2013-11-26 15:34:01

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;
import java.util.Stack;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class translationParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLON", "COMMENT", "LBRACK", "LCURLY", "NEWLINE", "NUM", "RBRACK", "RCURLY", "STRING", "VERSION", "WHITE"
    };

    public static final int EOF=-1;
    public static final int COLON=4;
    public static final int COMMENT=5;
    public static final int LBRACK=6;
    public static final int LCURLY=7;
    public static final int NEWLINE=8;
    public static final int NUM=9;
    public static final int RBRACK=10;
    public static final int RCURLY=11;
    public static final int STRING=12;
    public static final int VERSION=13;
    public static final int WHITE=14;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public translationParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public translationParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return translationParser.tokenNames; }
    public String getGrammarFileName() { return "translation.g"; }





    // $ANTLR start "top"
    // translation.g:45:1: top[SS_translationset tset] : ( ( WHITE )? kw= VERSION ( WHITE )? COLON ( WHITE )? str= STRING )? ( ( WHITE )? ( COMMENT | NEWLINE ) ) ;
    public final void top(SS_translationset tset) throws RecognitionException {
        Token kw=null;
        Token str=null;

        try {
            // translation.g:46:12: ( ( ( WHITE )? kw= VERSION ( WHITE )? COLON ( WHITE )? str= STRING )? ( ( WHITE )? ( COMMENT | NEWLINE ) ) )
            // translation.g:46:14: ( ( WHITE )? kw= VERSION ( WHITE )? COLON ( WHITE )? str= STRING )? ( ( WHITE )? ( COMMENT | NEWLINE ) )
            {
            // translation.g:46:14: ( ( WHITE )? kw= VERSION ( WHITE )? COLON ( WHITE )? str= STRING )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==WHITE) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==VERSION) ) {
                    alt4=1;
                }
            }
            else if ( (LA4_0==VERSION) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // translation.g:46:15: ( WHITE )? kw= VERSION ( WHITE )? COLON ( WHITE )? str= STRING
                    {
                    // translation.g:46:15: ( WHITE )?
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==WHITE) ) {
                        alt1=1;
                    }
                    switch (alt1) {
                        case 1 :
                            // translation.g:46:15: WHITE
                            {
                            match(input,WHITE,FOLLOW_WHITE_in_top177); 

                            }
                            break;

                    }


                    kw=(Token)match(input,VERSION,FOLLOW_VERSION_in_top182); 

                    // translation.g:46:33: ( WHITE )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==WHITE) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // translation.g:46:33: WHITE
                            {
                            match(input,WHITE,FOLLOW_WHITE_in_top184); 

                            }
                            break;

                    }



                    	if (tset.version != null)
                    	{
                    		System.out.print("Hey! the version was previously defined. The definition at line "+(kw!=null?kw.getLine():0)+" will be ignored!\n");
                    		SS_log log1 = new SS_log((kw!=null?kw.getLine():0), (kw!=null?kw.getCharPositionInLine():0), "Re-Definition", "The version was previously defined as "+ tset.version + ", so this declaration will be ignored");
                    		tset.loglist.add(log1);
                    	}


                    match(input,COLON,FOLLOW_COLON_in_top190); 

                    // translation.g:54:9: ( WHITE )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==WHITE) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // translation.g:54:9: WHITE
                            {
                            match(input,WHITE,FOLLOW_WHITE_in_top192); 

                            }
                            break;

                    }


                    str=(Token)match(input,STRING,FOLLOW_STRING_in_top197); 


                    	tset.version = new String((str!=null?str.getText():null));


                    }
                    break;

            }


            // translation.g:57:6: ( ( WHITE )? ( COMMENT | NEWLINE ) )
            // translation.g:57:7: ( WHITE )? ( COMMENT | NEWLINE )
            {
            // translation.g:57:7: ( WHITE )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WHITE) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // translation.g:57:7: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_top206); 

                    }
                    break;

            }


            if ( input.LA(1)==COMMENT||input.LA(1)==NEWLINE ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "top"



    // $ANTLR start "header"
    // translation.g:60:1: header[SS_translationset tset] : LBRACK str= STRING RBRACK ;
    public final void header(SS_translationset tset) throws RecognitionException {
        Token str=null;

        try {
            // translation.g:61:8: ( LBRACK str= STRING RBRACK )
            // translation.g:61:10: LBRACK str= STRING RBRACK
            {
            match(input,LBRACK,FOLLOW_LBRACK_in_header241); 

            str=(Token)match(input,STRING,FOLLOW_STRING_in_header245); 

            match(input,RBRACK,FOLLOW_RBRACK_in_header247); 

             
              String x4 = new String((str!=null?str.getText():null).substring(1,(str!=null?str.getText():null).length()-1)); 
              SS_translation y4;
              try 
              {
                 y4 = tset.by_format.get(x4);
              }
              catch (IndexOutOfBoundsException excpt)
              {
                 y4 = null;
              }
              if (y4 != null)
              {
            	System.out.print("Hey-- the header string at line "+(str!=null?str.getLine():0)+" has already been declared at line "+y4.lineno+"!!!\n");
            	SS_log log1 = new SS_log((str!=null?str.getLine():0), (str!=null?str.getCharPositionInLine():0), "Re-Definition", "The header name "+x4+" was previously defined at line "+ y4.lineno + ", so this declaration will be ignored");
            	tset.loglist.add(log1);
              }
              else
              {
            	((entry_scope)entry_stack.peek()).hdr = new SS_translation(); 
              	((entry_scope)entry_stack.peek()).hdr.lineno = (str!=null?str.getLine():0); 
              	((entry_scope)entry_stack.peek()).hdr.Format = new String((str!=null?str.getText():null)); 
              	((entry_scope)entry_stack.peek()).hdr.Translations= new ArrayList<SS_translationstring>(); 
            	tset.by_format.put(x4, ((entry_scope)entry_stack.peek()).hdr);
              }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "header"


    protected static class entry_scope {
        SS_translation hdr;
    }
    protected Stack entry_stack = new Stack();



    // $ANTLR start "entry"
    // translation.g:89:1: entry[SS_translationset tset] : ( WHITE )? header[tset] ( ( WHITE )? ( COMMENT | NEWLINE ) ) ( entry_list[tset,$entry::hdr] )* ;
    public final void entry(SS_translationset tset) throws RecognitionException {
        entry_stack.push(new entry_scope());
        try {
            // translation.g:93:8: ( ( WHITE )? header[tset] ( ( WHITE )? ( COMMENT | NEWLINE ) ) ( entry_list[tset,$entry::hdr] )* )
            // translation.g:93:10: ( WHITE )? header[tset] ( ( WHITE )? ( COMMENT | NEWLINE ) ) ( entry_list[tset,$entry::hdr] )*
            {
            // translation.g:93:10: ( WHITE )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==WHITE) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // translation.g:93:10: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_entry276); 

                    }
                    break;

            }


            pushFollow(FOLLOW_header_in_entry279);
            header(tset);

            state._fsp--;


            // translation.g:93:30: ( ( WHITE )? ( COMMENT | NEWLINE ) )
            // translation.g:93:31: ( WHITE )? ( COMMENT | NEWLINE )
            {
            // translation.g:93:31: ( WHITE )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==WHITE) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // translation.g:93:31: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_entry283); 

                    }
                    break;

            }


            if ( input.LA(1)==COMMENT||input.LA(1)==NEWLINE ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }


            // translation.g:93:59: ( entry_list[tset,$entry::hdr] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==WHITE) ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==COMMENT||(LA8_2 >= LCURLY && LA8_2 <= NEWLINE)||LA8_2==STRING) ) {
                        alt8=1;
                    }


                }
                else if ( (LA8_0==COMMENT||(LA8_0 >= LCURLY && LA8_0 <= NEWLINE)||LA8_0==STRING) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // translation.g:93:59: entry_list[tset,$entry::hdr]
            	    {
            	    pushFollow(FOLLOW_entry_list_in_entry295);
            	    entry_list(tset, ((entry_scope)entry_stack.peek()).hdr);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            entry_stack.pop();
        }
        return ;
    }
    // $ANTLR end "entry"



    // $ANTLR start "entry_list"
    // translation.g:96:1: entry_list[SS_translationset tset, SS_translation trans] : ( ( ( WHITE )? LCURLY x= NUM RCURLY )? ( WHITE )? s2= STRING )? ( ( WHITE )? ( COMMENT | NEWLINE ) ) ;
    public final void entry_list(SS_translationset tset, SS_translation trans) throws RecognitionException {
        Token x=null;
        Token s2=null;


        	int index1 = -1;

        try {
            // translation.g:101:3: ( ( ( ( WHITE )? LCURLY x= NUM RCURLY )? ( WHITE )? s2= STRING )? ( ( WHITE )? ( COMMENT | NEWLINE ) ) )
            // translation.g:101:5: ( ( ( WHITE )? LCURLY x= NUM RCURLY )? ( WHITE )? s2= STRING )? ( ( WHITE )? ( COMMENT | NEWLINE ) )
            {
            // translation.g:101:5: ( ( ( WHITE )? LCURLY x= NUM RCURLY )? ( WHITE )? s2= STRING )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==WHITE) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==LCURLY||LA12_1==STRING) ) {
                    alt12=1;
                }
            }
            else if ( (LA12_0==LCURLY||LA12_0==STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // translation.g:101:6: ( ( WHITE )? LCURLY x= NUM RCURLY )? ( WHITE )? s2= STRING
                    {
                    // translation.g:101:6: ( ( WHITE )? LCURLY x= NUM RCURLY )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==WHITE) ) {
                        int LA10_1 = input.LA(2);

                        if ( (LA10_1==LCURLY) ) {
                            alt10=1;
                        }
                    }
                    else if ( (LA10_0==LCURLY) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // translation.g:101:8: ( WHITE )? LCURLY x= NUM RCURLY
                            {
                            // translation.g:101:8: ( WHITE )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0==WHITE) ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // translation.g:101:8: WHITE
                                    {
                                    match(input,WHITE,FOLLOW_WHITE_in_entry_list321); 

                                    }
                                    break;

                            }


                            match(input,LCURLY,FOLLOW_LCURLY_in_entry_list324); 

                            x=(Token)match(input,NUM,FOLLOW_NUM_in_entry_list328); 

                            match(input,RCURLY,FOLLOW_RCURLY_in_entry_list330); 

                            index1 = Integer.parseInt((x!=null?x.getText():null));

                            }
                            break;

                    }


                    // translation.g:101:75: ( WHITE )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==WHITE) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // translation.g:101:75: WHITE
                            {
                            match(input,WHITE,FOLLOW_WHITE_in_entry_list336); 

                            }
                            break;

                    }


                    s2=(Token)match(input,STRING,FOLLOW_STRING_in_entry_list341); 


                    	if (index1 == -1) index1 = 0;
                            boolean prob = false;
                    	for (SS_translationstring w3 : trans.Translations)
                            {
                        	   if (w3.num == index1)
                    	   {
                    		System.out.print("Hey! the translation for "+ trans.Format 
                    			+" was already defined at line "+ w3.lineno+ ". The string on line "
                    			+(s2!=null?s2.getLine():0)+" will be ignored!\n");
                    		SS_log log1 = new SS_log((s2!=null?s2.getLine():0), (s2!=null?s2.getCharPositionInLine():0), "Re-Definition", "The translation for '"+ trans.Format + "' was already defined at line "+ w3.lineno+", so this declaration will be ignored");
                    		tset.loglist.add(log1);
                    		prob = true;
                    	   }
                            }
                    	if (!prob)
                    	{
                    		String z4 = new String((s2!=null?s2.getText():null).substring(1,(s2!=null?s2.getText():null).length()-1));
                    		SS_translationstring z2 = new SS_translationstring(z4);
                    		z2.lineno = (s2!=null?s2.getLine():0);
                                    z2.num = index1;
                    		/* System.out.println("== About to set Translations[" + index1 + "] to: " + z2); */
                    		trans.Translations.add(z2);
                    	}


                    }
                    break;

            }


            // translation.g:126:5: ( ( WHITE )? ( COMMENT | NEWLINE ) )
            // translation.g:126:6: ( WHITE )? ( COMMENT | NEWLINE )
            {
            // translation.g:126:6: ( WHITE )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==WHITE) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // translation.g:126:6: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_entry_list349); 

                    }
                    break;

            }


            if ( input.LA(1)==COMMENT||input.LA(1)==NEWLINE ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "entry_list"



    // $ANTLR start "file"
    // translation.g:129:1: file[ArrayList<SS_log> loglist] returns [SS_translationset transet] : ( top[transet] )* ( entry[transet] )* ;
    public final SS_translationset file(ArrayList<SS_log> loglist) throws RecognitionException {
        SS_translationset transet = null;



        	  transet = new SS_translationset(loglist);

        try {
            // translation.g:134:8: ( ( top[transet] )* ( entry[transet] )* )
            // translation.g:134:10: ( top[transet] )* ( entry[transet] )*
            {
            // translation.g:134:10: ( top[transet] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==WHITE) ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1==COMMENT||LA14_1==NEWLINE||LA14_1==VERSION) ) {
                        alt14=1;
                    }


                }
                else if ( (LA14_0==COMMENT||LA14_0==NEWLINE||LA14_0==VERSION) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // translation.g:134:10: top[transet]
            	    {
            	    pushFollow(FOLLOW_top_in_file387);
            	    top(transet);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            // translation.g:134:24: ( entry[transet] )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==LBRACK||LA15_0==WHITE) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // translation.g:134:25: entry[transet]
            	    {
            	    pushFollow(FOLLOW_entry_in_file392);
            	    entry(transet);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return transet;
    }
    // $ANTLR end "file"

    // Delegated rules


 

    public static final BitSet FOLLOW_WHITE_in_top177 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_VERSION_in_top182 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_WHITE_in_top184 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_top190 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_WHITE_in_top192 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_top197 = new BitSet(new long[]{0x0000000000004120L});
    public static final BitSet FOLLOW_WHITE_in_top206 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_set_in_top209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_header241 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_header245 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK_in_header247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHITE_in_entry276 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_header_in_entry279 = new BitSet(new long[]{0x0000000000004120L});
    public static final BitSet FOLLOW_WHITE_in_entry283 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_set_in_entry286 = new BitSet(new long[]{0x00000000000051A2L});
    public static final BitSet FOLLOW_entry_list_in_entry295 = new BitSet(new long[]{0x00000000000051A2L});
    public static final BitSet FOLLOW_WHITE_in_entry_list321 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_LCURLY_in_entry_list324 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NUM_in_entry_list328 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RCURLY_in_entry_list330 = new BitSet(new long[]{0x0000000000005000L});
    public static final BitSet FOLLOW_WHITE_in_entry_list336 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_entry_list341 = new BitSet(new long[]{0x0000000000004120L});
    public static final BitSet FOLLOW_WHITE_in_entry_list349 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_set_in_entry_list352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_top_in_file387 = new BitSet(new long[]{0x0000000000006162L});
    public static final BitSet FOLLOW_entry_in_file392 = new BitSet(new long[]{0x0000000000004042L});

}