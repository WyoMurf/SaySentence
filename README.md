SaySentence
===========

The "SayScript" project for Asterisk is contained here.

This Project introduces a new concept to Asterisk: Instead of 
playing sounds in discreet chunks, we play them now a sentence
at a time. We introduce the concepts from the GNU gettext package,
and for pronouncing numbers, we introduce a new and concise 
language called "sayscript".

Many thanks to Luigi Rizzo and Tilghman Lesher, as they pioneered
this domain, and I build on their concepts and ideas.

The SayScripts for pronouncing numbers, strings of numbers, dates,
and so forth are all gathered, with the soundfiles, and scripts,
and translation mapping files, into a single tar file called a 
"Sound Pack". A sound pack can introduce a new language for Asterisk
to play, or override parts of an existing locale's soundpack. 

A new routine is introduced to asterisk: int ast_say_sentence(chen, ecodes, format, ... (args))

It returns the character that interrupted the playback, if any, or 0.
It returns a -1 if there were any problems, like say, a missing file.

There are just a few simple rules to its usage coders should keep in mind:

1. Thou shalt not use a variable for the format arg! It should be a raw string constant.
   To work the way it is intended to work, you need to specify the files you want to play
   directly here. If you want to use a variable here, use a switch or something to provide
   the constant string for the files you want to play, and use separate calls to ast_say_sentence() 
   in your code. Play a whole sentence. None of this partial sentence sentence crud! 
   This can be a pain at times, but providing translations based on partial sentences is much, 
   much worse than this!

2. Thou shalt not use %z to work around (1). Using %z in the format string will allow
   you to play a variable file name. There are only a few cases where this might be OK.
   The first is when you are playing a user-generated sound file not included in the soundpack.
   This is common for user-recorded greetings in voicemail, and such like. Please add a comment
   after the say_sentence() call to indicate the reason.

3. Try as best you can to have ast_say_sentence() calls all on one line by themselves. Makes it
   easier to find them this way!

4. Stop using ast_play_and_wait(), say_and_wait(), ast_streamfile(), ast_waitstream(), and all their
  many variants. Use ast_say_sentence() instead. At least, when you can. Which should be almost all
  the time! Use ast_say_sentence() even to play beeps, and so forth. This allows these soundfiles to
  be customized, overridden, substituted for individuals and so forth. 


WHY SAYSCRIPT?

Why, oh Why, oh Why-Why-WHY are you introducing a new LANGUAGE to this scene? I explain some
reasons in my proposal document. (see the pdf in this directory). As it turns out, the main
factor might end up being security! We will be loading SoundPacks from unknown sources, and
they contain executable code. Dangerous! But SayScripts have no language features to generate
files, run other processes, and so forth, and only give an xml response as output. The input
is parsed and the task aborts on errors. I am hoping that NOT using general purpose languages
will both reduce the learning curve, keep the code simple, and improve security.



Building:

In this repository, I have two files, app_say_sentence.c, and asterisk-trunk-diffs. THey are 
both based on trunk version 403615. I may provide frequent updates to follow trunk, but it would
appear that most of the files I have patches for aren't in very combustible code. I let the
trunk version lapse for two years before I finally did another "svn update", and got like two
small conflicts total! 

cd to your asterisk trunk and do a patch -p0 < asterisk-trunk-diffs; then copy the app_say_sentence.c
into the apps dir. Do a make, make install.

The code I added will only be used if the directory /var/lib/asterisk/translation exists. If you
want to test the say_sentence code, do a "mkdir /var/lib/asterisk/translation /var/lib/asterisk/language"

copy the en.sayscript file to /usr/lib/asterisk/language/en  -- It is the base script for playing all the
different numbers, sequences, etc, and is meant to be distributed with asterisk when say_sentence is 
incorporated.

Copy the en.translationset file to /var/lib/asterisk/translation/en   -- this file allows you to map
any format string into whatever you WANT them to be. Right now, it's empty, but really needs to be populated
with all the possible format strings, and provide the value based mappings (eg, there are a few places
in the asterisk code where different output is generated based on the value of a pronounced number; these
need to be removed from the code, and put in the translation file instead. Someday real soon!).

Also, if you wish to do a translation to a new language, you can form a new template by using
the extract_language_template_from_asterisk_source  script. Create links pointing to the
extract_language_template_from_asterisk_source script and to the shuffle_template program in this dir,
and run the extract script from the top level of your asterisk directory. (Or, if you have no mods
to the Asterisk directory, then you can just use the en.template file included in this repository.
The result will be the file "en.template", which you can rename to your lang_locale, provide translations/
transformations to this file, and make sure it ends up in the translation directory for your asterisk.
The corresponding sayscripts should also be placed in the language/ directory.

The .g files are the input to antlr3, a yacc/bison sort of tool. Antlr will generate the working
parser code based on the contents of the .g files. So, if you wish to play with the interpreter, you will
most likely need to find and install sable. I am using antlrworks-1.4.3. It's Java based. So, you may need to also install the
latest java-7-openjdk release.

In my .bi script, I compile the .g files with "antlr3" which is a shell script that does this:

exec java org.antlr.Tool "$@"

You may need to create this script yourself, or whatever it takes to get it running.

Here is MY CLASSPATH variable definition in my ~/.bash_profile file:

declare -x CLASSPATH=.:/usr/lib/jvm/java-7-openjdk-amd64/lib:/home/murf/java/antlrworks-1.4.3.jar:/home/murf/java/src/java

If you have a long list of CLASSPATH entries for scf, like jgoodies stuff, this can be appended to your existing CLASSPATH. If you
don't like using the Oracle Java stuff, you are on your own in that respect. Good Luck!

I have two ways to run the java SaySentence Server:  one is to use the test.java program I include. 
You run it, after compiling all the java into .class files, by saying:

java test

Or, you can run the SaySentenceServer:

java SaySentenceServer

which will run until you toss a ^c at it. The SaySentenceServer listens on port 9746. In Asterisk, the code in ast_say_sentence() (in main/file.c),
talks to port 9745 on localhost. 

You are probably asking, "Why on EARTH are you using JAVA? Why do we need another server?" and I don't blame you, but,
when I started in on this project, we wanted this code to be able to run on phones, OTPS (Other People's Phone Switches), etc.
So, Java seemed the best to start with. I have the beginnings of a c-version of the code, which, when finished, could be internally
included in Asterisk some Happy Day. Until that Happy Day arrives, you'll just have to "Cowboy Up" and make do.


To use Asterisk with ast_say_sentence, you need to have the SaySentenceServer running, or you will find Asterisk quite silent.
(oh, and don't forget to create and populate the language and translation directories mentioned above!

Oh, and one more comment. Asterisk talks to users in several places in the code. But no place in the Asterisk Code talks more than 
the code in app_voicemail.c. It has between 400 and 500 spots in the code that generate sound. It is a very elaborate chunk of code!
I have made several passes over it and have it mostly adapted to use say_sentence. There's still some work to do.

Right now, I have a test that runs when asterisk starts, and it looks to see if /var/lib/asterisk/translation exists, and if so,
all the code that is enclosed with  if (ast_using_saysentece()) will run. 

Someday, when ast_say_sentence() is fully incorporated into asterisk, then all the non-saysentence code can be removed, which will
include all the language specific functions in app_voicemail.c, along with pretty much everything in say.c. 


TODO:

1. Finish incorporating ast_say_sentence into Asterisk. I have most of this done, over 50% so far!

2. Generate full sayscripts for all the current localizations: German, French, Chinese, Swedish, Russian, Polish, and so on. This may entail
   a bit of addition to the SayScript Language to make all these possible.  Hopefully, this won't be too painful, most of
   world express/pronounce numbers in a fairly similar format: left to right in groups of 3 based on 10^3. Some languages like
   Kinyarwanda, don't use "billion/milliard" "million" "thousand", etc. to seperate the groupings, but who knows...
   There may be gender issues and so forth, based on the numbers context. Native speakers/translators will be required
   to help in this effort, as I am not linguistically enabled to handle much more than english competently. I'll do my
   best to increase the capabilities and features of sayscript to allow the many languages to be properly pronounced.

3. Generate the translation/* files to map in all the number-variant translations.

4. We will need to make the facilities of ast_say_sentence() available via AGI, extenal IVR, maybe the AMI and ARI? also. This shouldn't
   be (hopefully) too demanding! I provided the SaySentence() dialplan app, at least!

5. The tools for translators need to be developed. A functional equivalent to POedit, which can replace file names with their scripts
   in the format statements, and allow easy grouping of words into soundfiles, etc would be a really cool tool to have.  Web interfaces
   like Prevod or Kyfieithu, all might be warped to work with translation files and soundfile scripts.

6. Get rid of all the configured sound files in Asterisk, and the enties in the example config files. This is work for the translation files to do.

7. The SaySentenceServer needs a debug mode. It's pretty easy to make some errors in your sayscript, and sometimes a challenge
   to find out why.

8. We need to add a feature to the SayScript interpreter to abort after some number of cycles have elapsed, and the state hasn't
   changed. Say, 5 or 10 cycles. This should prevent any "DOS" type attacks on the SayScript engine. And, since infinite loops
   are easy to achieve, getting an error message with a line number might be very helpful for development.

10. It might be handy (and more secure) if the SayScript engine ran in a chroot jail.

11. Some automated scripts for users to do installs from soundpack tar files would be cool. Put the right stuff in the right places,
    maybe even a little checking to make sure things are within parameters. Might be cool to have a sound pack sanity check, that might
    even dive down into the scripts and make sure all sound files referenced are actually there, and etc.


