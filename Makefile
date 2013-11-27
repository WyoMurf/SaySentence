SS_FILES = SS_action.java SS_arglist.java SS_engine.java SS_format_element.java SS_format.java SS_log.java SS_op_arg.java SS_op.java SS_play_expr.java SS_playlist.java SS_script.java SS_script_name.java SS_scriptset.java SS_silence_def.java SS_statement.java SS_translation.java SS_translationset.java SS_translationstring.java SS_vardef.java


all: test.class SaySentenceServer.class


translationLexer.java translationParser.java : translation.g
	antlr3 translation.g

SayScriptLexer.java SayScriptParser.java :  SayScript.g
	antlr3 SayScript.g

formatLexer.java formatParser.java : format.g
	antlr3 format.g
	
SaySentenceServer.class : SS_interp.java SS_update_thread.java translationLexer.java translationParser.java SayScriptLexer.java SayScriptParser.java \
			formatParser.java formatLexer.java MultiThreadedServer.java WorkerRunnable.java SaySentenceServer.java  $(SS_FILES)
	javac -g SS_interp.java SS_update_thread.java translationLexer.java translationParser.java SayScriptLexer.java SayScriptParser.java formatParser.java formatLexer.java MultiThreadedServer.java WorkerRunnable.java SaySentenceServer.java

test.class : SS_interp.java SS_update_thread.java translationLexer.java translationParser.java SayScriptLexer.java SayScriptParser.java formatParser.java formatLexer.java test.java $(SS_FILES)
	javac -g -Xlint:unchecked SS_interp.java SS_update_thread.java translationLexer.java translationParser.java SayScriptLexer.java SayScriptParser.java formatParser.java formatLexer.java test.java

test :  
	java test

run:
	java SaySentenceServer
