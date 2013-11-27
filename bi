#! /bin/bash


echo compiling SayScript.g...
antlr3 SayScript.g
echo compiling translation.g...
antlr3 translation.g
echo compiling format.g...
antlr3 format.g
echo =================================================================================================
echo Compiling SayScriptLexer, SayScriptParser, and the rest into the SaySentenceServer
javac -g SS_interp.java SS_update_thread.java translationLexer.java translationParser.java SayScriptLexer.java SayScriptParser.java formatParser.java formatLexer.java MultiThreadedServer.java WorkerRunnable.java SaySentenceServer.java
echo =================================================================================================
echo Compiling SayScriptLexer, SayScriptParser, test, and the rest into an exec
javac -g -Xlint:unchecked SS_interp.java SS_update_thread.java translationLexer.java translationParser.java SayScriptLexer.java SayScriptParser.java formatParser.java formatLexer.java test.java
echo Running the test...
java test
