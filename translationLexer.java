// $ANTLR 3.4 translation.g 2013-11-26 15:34:01

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class translationLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public translationLexer() {} 
    public translationLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public translationLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "translation.g"; }

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:30:8: ( '[' )
            // translation.g:30:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:31:8: ( ']' )
            // translation.g:31:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:32:8: ( '{' )
            // translation.g:32:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:33:8: ( '}' )
            // translation.g:33:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:34:7: ( ':' )
            // translation.g:34:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "VERSION"
    public final void mVERSION() throws RecognitionException {
        try {
            int _type = VERSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:36:9: ( 'version' )
            // translation.g:36:11: 'version'
            {
            match("version"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VERSION"

    // $ANTLR start "NUM"
    public final void mNUM() throws RecognitionException {
        try {
            int _type = NUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:39:5: ( ( '0' .. '9' )+ )
            // translation.g:39:7: ( '0' .. '9' )+
            {
            // translation.g:39:7: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // translation.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:40:9: ( ( '\\r' )? '\\n' )
            // translation.g:40:11: ( '\\r' )? '\\n'
            {
            // translation.g:40:11: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // translation.g:40:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WHITE"
    public final void mWHITE() throws RecognitionException {
        try {
            int _type = WHITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:41:7: ( ( ' ' | '\\t' )+ )
            // translation.g:41:9: ( ' ' | '\\t' )+
            {
            // translation.g:41:9: ( ' ' | '\\t' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\t'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // translation.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITE"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:42:9: ( ';;' ( . )* NEWLINE )
            // translation.g:42:11: ';;' ( . )* NEWLINE
            {
            match(";;"); 



            // translation.g:42:15: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\r') ) {
                    alt4=2;
                }
                else if ( (LA4_0=='\n') ) {
                    alt4=2;
                }
                else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // translation.g:42:15: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            mNEWLINE(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // translation.g:43:8: ( '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\\\\\"' )* '\"' )
            // translation.g:43:10: '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\\\\\"' )* '\"'
            {
            match('\"'); 

            // translation.g:43:14: (~ ( '\\r' | '\\n' | '\"' ) | '\\\\\"' )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2=='\"') ) {
                        int LA5_4 = input.LA(3);

                        if ( ((LA5_4 >= '\u0000' && LA5_4 <= '\t')||(LA5_4 >= '\u000B' && LA5_4 <= '\f')||(LA5_4 >= '\u000E' && LA5_4 <= '\uFFFF')) ) {
                            alt5=2;
                        }

                        else {
                            alt5=1;
                        }


                    }
                    else if ( ((LA5_2 >= '\u0000' && LA5_2 <= '\t')||(LA5_2 >= '\u000B' && LA5_2 <= '\f')||(LA5_2 >= '\u000E' && LA5_2 <= '!')||(LA5_2 >= '#' && LA5_2 <= '\uFFFF')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '[')||(LA5_0 >= ']' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // translation.g:43:16: ~ ( '\\r' | '\\n' | '\"' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // translation.g:43:40: '\\\\\"'
            	    {
            	    match("\\\""); 



            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // translation.g:1:8: ( LBRACK | RBRACK | LCURLY | RCURLY | COLON | VERSION | NUM | NEWLINE | WHITE | COMMENT | STRING )
        int alt6=11;
        switch ( input.LA(1) ) {
        case '[':
            {
            alt6=1;
            }
            break;
        case ']':
            {
            alt6=2;
            }
            break;
        case '{':
            {
            alt6=3;
            }
            break;
        case '}':
            {
            alt6=4;
            }
            break;
        case ':':
            {
            alt6=5;
            }
            break;
        case 'v':
            {
            alt6=6;
            }
            break;
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt6=7;
            }
            break;
        case '\n':
        case '\r':
            {
            alt6=8;
            }
            break;
        case '\t':
        case ' ':
            {
            alt6=9;
            }
            break;
        case ';':
            {
            alt6=10;
            }
            break;
        case '\"':
            {
            alt6=11;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 6, 0, input);

            throw nvae;

        }

        switch (alt6) {
            case 1 :
                // translation.g:1:10: LBRACK
                {
                mLBRACK(); 


                }
                break;
            case 2 :
                // translation.g:1:17: RBRACK
                {
                mRBRACK(); 


                }
                break;
            case 3 :
                // translation.g:1:24: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 4 :
                // translation.g:1:31: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 5 :
                // translation.g:1:38: COLON
                {
                mCOLON(); 


                }
                break;
            case 6 :
                // translation.g:1:44: VERSION
                {
                mVERSION(); 


                }
                break;
            case 7 :
                // translation.g:1:52: NUM
                {
                mNUM(); 


                }
                break;
            case 8 :
                // translation.g:1:56: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 9 :
                // translation.g:1:64: WHITE
                {
                mWHITE(); 


                }
                break;
            case 10 :
                // translation.g:1:70: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 11 :
                // translation.g:1:78: STRING
                {
                mSTRING(); 


                }
                break;

        }

    }


 

}