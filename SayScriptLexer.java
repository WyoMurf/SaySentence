// $ANTLR 3.4 SayScript.g 2059-12-16 10:21:23

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SayScriptLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ACT_CUT=4;
    public static final int ACT_DONE=5;
    public static final int ACT_NEGATE=6;
    public static final int ACT_RANGE=7;
    public static final int ACT_RESTART=8;
    public static final int ACT_ZERO=9;
    public static final int ANYDATE=10;
    public static final int ATBEGIN=11;
    public static final int ATEXIT=12;
    public static final int COLON=13;
    public static final int COMMA=14;
    public static final int COMMENT=15;
    public static final int DASH=16;
    public static final int DATEFUT_GREATER=17;
    public static final int DATEFUT_RANGE=18;
    public static final int DATEPAST_GREATER=19;
    public static final int DATEPAST_RANGE=20;
    public static final int DAYAMOUNT=21;
    public static final int EQUALS=22;
    public static final int FE_Lsubr=23;
    public static final int FE_Rsubr=24;
    public static final int FE_date_century=25;
    public static final int FE_date_decade=26;
    public static final int FE_date_dom=27;
    public static final int FE_date_dow=28;
    public static final int FE_date_dowstr=29;
    public static final int FE_date_month=30;
    public static final int FE_date_monthstr=31;
    public static final int FE_date_year=32;
    public static final int FE_num=33;
    public static final int FE_opt=34;
    public static final int FE_time_12hour=35;
    public static final int FE_time_12hour2d=36;
    public static final int FE_time_24hour=37;
    public static final int FE_time_24hour2d=38;
    public static final int FE_time_ampm=39;
    public static final int FE_time_cm=40;
    public static final int FE_time_min=41;
    public static final int FE_time_sec=42;
    public static final int FE_time_tz=43;
    public static final int FE_time_xm=44;
    public static final int FE_timeval=45;
    public static final int GREATER=46;
    public static final int HDR_SILENCE=47;
    public static final int HOUR_RANGE=48;
    public static final int ID=49;
    public static final int LANG=50;
    public static final int LBRACK=51;
    public static final int LCURLY=52;
    public static final int LESS=53;
    public static final int LPAR=54;
    public static final int MINUTE_RANGE=55;
    public static final int NEWLINE=56;
    public static final int NOTOPT=57;
    public static final int NOTVAR=58;
    public static final int NUM=59;
    public static final int NUMLEN=60;
    public static final int OPT=61;
    public static final int PAT=62;
    public static final int PATHCONST=63;
    public static final int PATTERN=64;
    public static final int PERIOD=65;
    public static final int PLUS=66;
    public static final int QUESTION=67;
    public static final int RANG=68;
    public static final int RANGE=69;
    public static final int RBRACK=70;
    public static final int RCURLY=71;
    public static final int RPAR=72;
    public static final int SECOND_RANGE=73;
    public static final int SEMICOLON=74;
    public static final int VAR=75;
    public static final int WHITE=76;
    public static final int YEAR_PATTERN=77;
    public static final int YEAR_RANGE=78;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public SayScriptLexer() {} 
    public SayScriptLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SayScriptLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "SayScript.g"; }

    // $ANTLR start "HDR_SILENCE"
    public final void mHDR_SILENCE() throws RecognitionException {
        try {
            int _type = HDR_SILENCE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:45:13: ( 'silence' )
            // SayScript.g:45:15: 'silence'
            {
            match("silence"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HDR_SILENCE"

    // $ANTLR start "FE_num"
    public final void mFE_num() throws RecognitionException {
        try {
            int _type = FE_num;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:46:8: ( 'num' )
            // SayScript.g:46:10: 'num'
            {
            match("num"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_num"

    // $ANTLR start "FE_opt"
    public final void mFE_opt() throws RecognitionException {
        try {
            int _type = FE_opt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:47:8: ( 'opt' )
            // SayScript.g:47:10: 'opt'
            {
            match("opt"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_opt"

    // $ANTLR start "FE_timeval"
    public final void mFE_timeval() throws RecognitionException {
        try {
            int _type = FE_timeval;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:48:12: ( 'timeval' )
            // SayScript.g:48:14: 'timeval'
            {
            match("timeval"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_timeval"

    // $ANTLR start "ACT_CUT"
    public final void mACT_CUT() throws RecognitionException {
        try {
            int _type = ACT_CUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:49:9: ( 'CUT' )
            // SayScript.g:49:11: 'CUT'
            {
            match("CUT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACT_CUT"

    // $ANTLR start "ACT_ZERO"
    public final void mACT_ZERO() throws RecognitionException {
        try {
            int _type = ACT_ZERO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:50:10: ( 'ZERO' )
            // SayScript.g:50:12: 'ZERO'
            {
            match("ZERO"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACT_ZERO"

    // $ANTLR start "ACT_DONE"
    public final void mACT_DONE() throws RecognitionException {
        try {
            int _type = ACT_DONE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:51:10: ( 'DONE' )
            // SayScript.g:51:12: 'DONE'
            {
            match("DONE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACT_DONE"

    // $ANTLR start "ACT_RANGE"
    public final void mACT_RANGE() throws RecognitionException {
        try {
            int _type = ACT_RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:52:11: ( 'RANGE_ERROR' )
            // SayScript.g:52:13: 'RANGE_ERROR'
            {
            match("RANGE_ERROR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACT_RANGE"

    // $ANTLR start "ACT_RESTART"
    public final void mACT_RESTART() throws RecognitionException {
        try {
            int _type = ACT_RESTART;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:53:13: ( 'RESTART' )
            // SayScript.g:53:15: 'RESTART'
            {
            match("RESTART"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACT_RESTART"

    // $ANTLR start "ACT_NEGATE"
    public final void mACT_NEGATE() throws RecognitionException {
        try {
            int _type = ACT_NEGATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:54:12: ( 'NEGATE' )
            // SayScript.g:54:14: 'NEGATE'
            {
            match("NEGATE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACT_NEGATE"

    // $ANTLR start "WHITE"
    public final void mWHITE() throws RecognitionException {
        try {
            int _type = WHITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:55:7: ( ( ' ' | '\\t' )+ )
            // SayScript.g:55:9: ( ' ' | '\\t' )+
            {
            // SayScript.g:55:9: ( ' ' | '\\t' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // SayScript.g:
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
    // $ANTLR end "WHITE"

    // $ANTLR start "DASH"
    public final void mDASH() throws RecognitionException {
        try {
            int _type = DASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:56:6: ( '-' )
            // SayScript.g:56:8: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DASH"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:57:9: ( ( '\\r' )? '\\n' )
            // SayScript.g:57:11: ( '\\r' )? '\\n'
            {
            // SayScript.g:57:11: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // SayScript.g:57:11: '\\r'
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

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:58:7: ( ',' )
            // SayScript.g:58:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:59:8: ( '{' )
            // SayScript.g:59:10: '{'
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
            // SayScript.g:60:8: ( '}' )
            // SayScript.g:60:10: '}'
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

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:61:8: ( '[' )
            // SayScript.g:61:10: '['
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
            // SayScript.g:62:8: ( ']' )
            // SayScript.g:62:10: ']'
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

    // $ANTLR start "LPAR"
    public final void mLPAR() throws RecognitionException {
        try {
            int _type = LPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:63:6: ( '(' )
            // SayScript.g:63:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAR"

    // $ANTLR start "RPAR"
    public final void mRPAR() throws RecognitionException {
        try {
            int _type = RPAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:64:6: ( ')' )
            // SayScript.g:64:8: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAR"

    // $ANTLR start "LANG"
    public final void mLANG() throws RecognitionException {
        try {
            int _type = LANG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:65:6: ( '<' )
            // SayScript.g:65:8: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LANG"

    // $ANTLR start "RANG"
    public final void mRANG() throws RecognitionException {
        try {
            int _type = RANG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:66:6: ( '>' )
            // SayScript.g:66:8: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RANG"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:67:7: ( ':' )
            // SayScript.g:67:9: ':'
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

    // $ANTLR start "PERIOD"
    public final void mPERIOD() throws RecognitionException {
        try {
            int _type = PERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:68:8: ( '.' )
            // SayScript.g:68:10: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PERIOD"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:69:7: ( '+' )
            // SayScript.g:69:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:70:10: ( '?' )
            // SayScript.g:70:12: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:71:8: ( '=' )
            // SayScript.g:71:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:72:11: ( ';' )
            // SayScript.g:72:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:73:7: ( 'RANGE' )
            // SayScript.g:73:9: 'RANGE'
            {
            match("RANGE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "PATTERN"
    public final void mPATTERN() throws RecognitionException {
        try {
            int _type = PATTERN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:74:9: ( 'PATTERN' )
            // SayScript.g:74:11: 'PATTERN'
            {
            match("PATTERN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PATTERN"

    // $ANTLR start "YEAR_PATTERN"
    public final void mYEAR_PATTERN() throws RecognitionException {
        try {
            int _type = YEAR_PATTERN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:75:14: ( 'YEAR_PATTERN' )
            // SayScript.g:75:16: 'YEAR_PATTERN'
            {
            match("YEAR_PATTERN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "YEAR_PATTERN"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:76:9: ( 'GREATER' )
            // SayScript.g:76:11: 'GREATER'
            {
            match("GREATER"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GREATER"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:77:9: ( 'LESS' )
            // SayScript.g:77:11: 'LESS'
            {
            match("LESS"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:78:9: ( 'VAR' )
            // SayScript.g:78:11: 'VAR'
            {
            match("VAR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "NOTVAR"
    public final void mNOTVAR() throws RecognitionException {
        try {
            int _type = NOTVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:79:12: ( 'NOTVAR' )
            // SayScript.g:79:14: 'NOTVAR'
            {
            match("NOTVAR"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOTVAR"

    // $ANTLR start "NUMLEN"
    public final void mNUMLEN() throws RecognitionException {
        try {
            int _type = NUMLEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:80:9: ( 'NUMLEN' )
            // SayScript.g:80:11: 'NUMLEN'
            {
            match("NUMLEN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMLEN"

    // $ANTLR start "ATBEGIN"
    public final void mATBEGIN() throws RecognitionException {
        try {
            int _type = ATBEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:81:10: ( 'ATBEGIN' )
            // SayScript.g:81:12: 'ATBEGIN'
            {
            match("ATBEGIN"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ATBEGIN"

    // $ANTLR start "ATEXIT"
    public final void mATEXIT() throws RecognitionException {
        try {
            int _type = ATEXIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:82:9: ( 'ATEXIT' )
            // SayScript.g:82:11: 'ATEXIT'
            {
            match("ATEXIT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ATEXIT"

    // $ANTLR start "DATEPAST_RANGE"
    public final void mDATEPAST_RANGE() throws RecognitionException {
        try {
            int _type = DATEPAST_RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:83:16: ( 'DATEPAST_RANGE' )
            // SayScript.g:83:18: 'DATEPAST_RANGE'
            {
            match("DATEPAST_RANGE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATEPAST_RANGE"

    // $ANTLR start "DATEPAST_GREATER"
    public final void mDATEPAST_GREATER() throws RecognitionException {
        try {
            int _type = DATEPAST_GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:84:18: ( 'DATEPAST_GREATER' )
            // SayScript.g:84:20: 'DATEPAST_GREATER'
            {
            match("DATEPAST_GREATER"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATEPAST_GREATER"

    // $ANTLR start "DATEFUT_RANGE"
    public final void mDATEFUT_RANGE() throws RecognitionException {
        try {
            int _type = DATEFUT_RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:85:15: ( 'DATEFUT_RANGE' )
            // SayScript.g:85:17: 'DATEFUT_RANGE'
            {
            match("DATEFUT_RANGE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATEFUT_RANGE"

    // $ANTLR start "DATEFUT_GREATER"
    public final void mDATEFUT_GREATER() throws RecognitionException {
        try {
            int _type = DATEFUT_GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:86:17: ( 'DATEFUT_GREATER' )
            // SayScript.g:86:19: 'DATEFUT_GREATER'
            {
            match("DATEFUT_GREATER"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DATEFUT_GREATER"

    // $ANTLR start "ANYDATE"
    public final void mANYDATE() throws RecognitionException {
        try {
            int _type = ANYDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:87:9: ( 'ANYDATE' )
            // SayScript.g:87:11: 'ANYDATE'
            {
            match("ANYDATE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ANYDATE"

    // $ANTLR start "SECOND_RANGE"
    public final void mSECOND_RANGE() throws RecognitionException {
        try {
            int _type = SECOND_RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:88:14: ( 'SECOND_RANGE' )
            // SayScript.g:88:16: 'SECOND_RANGE'
            {
            match("SECOND_RANGE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SECOND_RANGE"

    // $ANTLR start "MINUTE_RANGE"
    public final void mMINUTE_RANGE() throws RecognitionException {
        try {
            int _type = MINUTE_RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:89:14: ( 'MINUTE_RANGE' )
            // SayScript.g:89:16: 'MINUTE_RANGE'
            {
            match("MINUTE_RANGE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUTE_RANGE"

    // $ANTLR start "HOUR_RANGE"
    public final void mHOUR_RANGE() throws RecognitionException {
        try {
            int _type = HOUR_RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:90:12: ( 'HOUR_RANGE' )
            // SayScript.g:90:14: 'HOUR_RANGE'
            {
            match("HOUR_RANGE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HOUR_RANGE"

    // $ANTLR start "YEAR_RANGE"
    public final void mYEAR_RANGE() throws RecognitionException {
        try {
            int _type = YEAR_RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:91:12: ( 'YEAR_RANGE' )
            // SayScript.g:91:14: 'YEAR_RANGE'
            {
            match("YEAR_RANGE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "YEAR_RANGE"

    // $ANTLR start "OPT"
    public final void mOPT() throws RecognitionException {
        try {
            int _type = OPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:92:5: ( 'OPT' )
            // SayScript.g:92:7: 'OPT'
            {
            match("OPT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OPT"

    // $ANTLR start "NOTOPT"
    public final void mNOTOPT() throws RecognitionException {
        try {
            int _type = NOTOPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:93:8: ( 'NOTOPT' )
            // SayScript.g:93:10: 'NOTOPT'
            {
            match("NOTOPT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOTOPT"

    // $ANTLR start "DAYAMOUNT"
    public final void mDAYAMOUNT() throws RecognitionException {
        try {
            int _type = DAYAMOUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:94:10: ( ( '0' .. '9' )+ ( 'w' | 'W' | 'M' | 'm' | 'Y' | 'y' ) )
            // SayScript.g:94:12: ( '0' .. '9' )+ ( 'w' | 'W' | 'M' | 'm' | 'Y' | 'y' )
            {
            // SayScript.g:94:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // SayScript.g:
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
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            if ( input.LA(1)=='M'||input.LA(1)=='W'||input.LA(1)=='Y'||input.LA(1)=='m'||input.LA(1)=='w'||input.LA(1)=='y' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DAYAMOUNT"

    // $ANTLR start "NUM"
    public final void mNUM() throws RecognitionException {
        try {
            int _type = NUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:95:5: ( ( '0' .. '9' )+ )
            // SayScript.g:95:7: ( '0' .. '9' )+
            {
            // SayScript.g:95:7: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // SayScript.g:
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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

    // $ANTLR start "FE_time_sec"
    public final void mFE_time_sec() throws RecognitionException {
        try {
            int _type = FE_time_sec;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:96:13: ( 'time.sec' )
            // SayScript.g:96:15: 'time.sec'
            {
            match("time.sec"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_sec"

    // $ANTLR start "FE_time_min"
    public final void mFE_time_min() throws RecognitionException {
        try {
            int _type = FE_time_min;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:97:13: ( 'time.min' )
            // SayScript.g:97:15: 'time.min'
            {
            match("time.min"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_min"

    // $ANTLR start "FE_time_12hour"
    public final void mFE_time_12hour() throws RecognitionException {
        try {
            int _type = FE_time_12hour;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:98:16: ( 'time.12hour' )
            // SayScript.g:98:18: 'time.12hour'
            {
            match("time.12hour"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_12hour"

    // $ANTLR start "FE_time_24hour"
    public final void mFE_time_24hour() throws RecognitionException {
        try {
            int _type = FE_time_24hour;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:99:16: ( 'time.24hour' )
            // SayScript.g:99:18: 'time.24hour'
            {
            match("time.24hour"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_24hour"

    // $ANTLR start "FE_time_12hour2d"
    public final void mFE_time_12hour2d() throws RecognitionException {
        try {
            int _type = FE_time_12hour2d;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:100:18: ( 'time.12hour2d' )
            // SayScript.g:100:20: 'time.12hour2d'
            {
            match("time.12hour2d"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_12hour2d"

    // $ANTLR start "FE_time_24hour2d"
    public final void mFE_time_24hour2d() throws RecognitionException {
        try {
            int _type = FE_time_24hour2d;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:101:18: ( 'time.24hour2d' )
            // SayScript.g:101:20: 'time.24hour2d'
            {
            match("time.24hour2d"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_24hour2d"

    // $ANTLR start "FE_time_ampm"
    public final void mFE_time_ampm() throws RecognitionException {
        try {
            int _type = FE_time_ampm;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:102:14: ( 'time.ampm' )
            // SayScript.g:102:16: 'time.ampm'
            {
            match("time.ampm"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_ampm"

    // $ANTLR start "FE_time_xm"
    public final void mFE_time_xm() throws RecognitionException {
        try {
            int _type = FE_time_xm;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:103:12: ( 'time.xm' )
            // SayScript.g:103:14: 'time.xm'
            {
            match("time.xm"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_xm"

    // $ANTLR start "FE_time_cm"
    public final void mFE_time_cm() throws RecognitionException {
        try {
            int _type = FE_time_cm;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:104:12: ( 'time.cm' )
            // SayScript.g:104:14: 'time.cm'
            {
            match("time.cm"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_cm"

    // $ANTLR start "FE_time_tz"
    public final void mFE_time_tz() throws RecognitionException {
        try {
            int _type = FE_time_tz;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:105:12: ( 'time.tz' )
            // SayScript.g:105:14: 'time.tz'
            {
            match("time.tz"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_time_tz"

    // $ANTLR start "FE_date_dom"
    public final void mFE_date_dom() throws RecognitionException {
        try {
            int _type = FE_date_dom;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:106:13: ( 'date.dom' )
            // SayScript.g:106:15: 'date.dom'
            {
            match("date.dom"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_date_dom"

    // $ANTLR start "FE_date_dow"
    public final void mFE_date_dow() throws RecognitionException {
        try {
            int _type = FE_date_dow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:107:13: ( 'date.dow' )
            // SayScript.g:107:15: 'date.dow'
            {
            match("date.dow"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_date_dow"

    // $ANTLR start "FE_date_month"
    public final void mFE_date_month() throws RecognitionException {
        try {
            int _type = FE_date_month;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:108:15: ( 'date.month' )
            // SayScript.g:108:17: 'date.month'
            {
            match("date.month"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_date_month"

    // $ANTLR start "FE_date_dowstr"
    public final void mFE_date_dowstr() throws RecognitionException {
        try {
            int _type = FE_date_dowstr;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:109:16: ( 'date.dowstr' )
            // SayScript.g:109:18: 'date.dowstr'
            {
            match("date.dowstr"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_date_dowstr"

    // $ANTLR start "FE_date_monthstr"
    public final void mFE_date_monthstr() throws RecognitionException {
        try {
            int _type = FE_date_monthstr;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:110:18: ( 'date.monthstr' )
            // SayScript.g:110:20: 'date.monthstr'
            {
            match("date.monthstr"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_date_monthstr"

    // $ANTLR start "FE_date_year"
    public final void mFE_date_year() throws RecognitionException {
        try {
            int _type = FE_date_year;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:111:14: ( 'date.year' )
            // SayScript.g:111:19: 'date.year'
            {
            match("date.year"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_date_year"

    // $ANTLR start "FE_date_century"
    public final void mFE_date_century() throws RecognitionException {
        try {
            int _type = FE_date_century;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:112:17: ( 'date.century' )
            // SayScript.g:112:19: 'date.century'
            {
            match("date.century"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_date_century"

    // $ANTLR start "FE_date_decade"
    public final void mFE_date_decade() throws RecognitionException {
        try {
            int _type = FE_date_decade;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:113:16: ( 'date.decade' )
            // SayScript.g:113:18: 'date.decade'
            {
            match("date.decade"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_date_decade"

    // $ANTLR start "FE_Lsubr"
    public final void mFE_Lsubr() throws RecognitionException {
        try {
            int _type = FE_Lsubr;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:114:10: ( '<<' )
            // SayScript.g:114:12: '<<'
            {
            match("<<"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_Lsubr"

    // $ANTLR start "FE_Rsubr"
    public final void mFE_Rsubr() throws RecognitionException {
        try {
            int _type = FE_Rsubr;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:115:10: ( '>>' )
            // SayScript.g:115:12: '>>'
            {
            match(">>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FE_Rsubr"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:116:9: ( ';;' ( . )* NEWLINE )
            // SayScript.g:116:11: ';;' ( . )* NEWLINE
            {
            match(";;"); 



            // SayScript.g:116:15: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\r') ) {
                    alt5=2;
                }
                else if ( (LA5_0=='\n') ) {
                    alt5=2;
                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // SayScript.g:116:15: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
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

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:117:4: ( ( 'A' .. 'Z' | 'a' .. 'z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )* )
            // SayScript.g:117:6: ( 'A' .. 'Z' | 'a' .. 'z' ) ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // SayScript.g:117:25: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // SayScript.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "PATHCONST"
    public final void mPATHCONST() throws RecognitionException {
        try {
            int _type = PATHCONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:118:11: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '/' | '-' | '.' )+ )
            // SayScript.g:118:13: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '/' | '-' | '.' )+
            {
            // SayScript.g:118:13: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '/' | '-' | '.' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '-' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // SayScript.g:
            	    {
            	    if ( (input.LA(1) >= '-' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PATHCONST"

    // $ANTLR start "PAT"
    public final void mPAT() throws RecognitionException {
        try {
            int _type = PAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SayScript.g:119:5: ( '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\\\\\"' )* '\"' )
            // SayScript.g:119:7: '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\\\\\"' )* '\"'
            {
            match('\"'); 

            // SayScript.g:119:11: (~ ( '\\r' | '\\n' | '\"' ) | '\\\\\"' )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2=='\"') ) {
                        int LA8_4 = input.LA(3);

                        if ( ((LA8_4 >= '\u0000' && LA8_4 <= '\t')||(LA8_4 >= '\u000B' && LA8_4 <= '\f')||(LA8_4 >= '\u000E' && LA8_4 <= '\uFFFF')) ) {
                            alt8=2;
                        }

                        else {
                            alt8=1;
                        }


                    }
                    else if ( ((LA8_2 >= '\u0000' && LA8_2 <= '\t')||(LA8_2 >= '\u000B' && LA8_2 <= '\f')||(LA8_2 >= '\u000E' && LA8_2 <= '!')||(LA8_2 >= '#' && LA8_2 <= '\uFFFF')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '!')||(LA8_0 >= '#' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // SayScript.g:119:13: ~ ( '\\r' | '\\n' | '\"' )
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
            	    // SayScript.g:119:37: '\\\\\"'
            	    {
            	    match("\\\""); 



            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "PAT"

    public void mTokens() throws RecognitionException {
        // SayScript.g:1:8: ( HDR_SILENCE | FE_num | FE_opt | FE_timeval | ACT_CUT | ACT_ZERO | ACT_DONE | ACT_RANGE | ACT_RESTART | ACT_NEGATE | WHITE | DASH | NEWLINE | COMMA | LCURLY | RCURLY | LBRACK | RBRACK | LPAR | RPAR | LANG | RANG | COLON | PERIOD | PLUS | QUESTION | EQUALS | SEMICOLON | RANGE | PATTERN | YEAR_PATTERN | GREATER | LESS | VAR | NOTVAR | NUMLEN | ATBEGIN | ATEXIT | DATEPAST_RANGE | DATEPAST_GREATER | DATEFUT_RANGE | DATEFUT_GREATER | ANYDATE | SECOND_RANGE | MINUTE_RANGE | HOUR_RANGE | YEAR_RANGE | OPT | NOTOPT | DAYAMOUNT | NUM | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_24hour | FE_time_12hour2d | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade | FE_Lsubr | FE_Rsubr | COMMENT | ID | PATHCONST | PAT )
        int alt9=75;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // SayScript.g:1:10: HDR_SILENCE
                {
                mHDR_SILENCE(); 


                }
                break;
            case 2 :
                // SayScript.g:1:22: FE_num
                {
                mFE_num(); 


                }
                break;
            case 3 :
                // SayScript.g:1:29: FE_opt
                {
                mFE_opt(); 


                }
                break;
            case 4 :
                // SayScript.g:1:36: FE_timeval
                {
                mFE_timeval(); 


                }
                break;
            case 5 :
                // SayScript.g:1:47: ACT_CUT
                {
                mACT_CUT(); 


                }
                break;
            case 6 :
                // SayScript.g:1:55: ACT_ZERO
                {
                mACT_ZERO(); 


                }
                break;
            case 7 :
                // SayScript.g:1:64: ACT_DONE
                {
                mACT_DONE(); 


                }
                break;
            case 8 :
                // SayScript.g:1:73: ACT_RANGE
                {
                mACT_RANGE(); 


                }
                break;
            case 9 :
                // SayScript.g:1:83: ACT_RESTART
                {
                mACT_RESTART(); 


                }
                break;
            case 10 :
                // SayScript.g:1:95: ACT_NEGATE
                {
                mACT_NEGATE(); 


                }
                break;
            case 11 :
                // SayScript.g:1:106: WHITE
                {
                mWHITE(); 


                }
                break;
            case 12 :
                // SayScript.g:1:112: DASH
                {
                mDASH(); 


                }
                break;
            case 13 :
                // SayScript.g:1:117: NEWLINE
                {
                mNEWLINE(); 


                }
                break;
            case 14 :
                // SayScript.g:1:125: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 15 :
                // SayScript.g:1:131: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 16 :
                // SayScript.g:1:138: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 17 :
                // SayScript.g:1:145: LBRACK
                {
                mLBRACK(); 


                }
                break;
            case 18 :
                // SayScript.g:1:152: RBRACK
                {
                mRBRACK(); 


                }
                break;
            case 19 :
                // SayScript.g:1:159: LPAR
                {
                mLPAR(); 


                }
                break;
            case 20 :
                // SayScript.g:1:164: RPAR
                {
                mRPAR(); 


                }
                break;
            case 21 :
                // SayScript.g:1:169: LANG
                {
                mLANG(); 


                }
                break;
            case 22 :
                // SayScript.g:1:174: RANG
                {
                mRANG(); 


                }
                break;
            case 23 :
                // SayScript.g:1:179: COLON
                {
                mCOLON(); 


                }
                break;
            case 24 :
                // SayScript.g:1:185: PERIOD
                {
                mPERIOD(); 


                }
                break;
            case 25 :
                // SayScript.g:1:192: PLUS
                {
                mPLUS(); 


                }
                break;
            case 26 :
                // SayScript.g:1:197: QUESTION
                {
                mQUESTION(); 


                }
                break;
            case 27 :
                // SayScript.g:1:206: EQUALS
                {
                mEQUALS(); 


                }
                break;
            case 28 :
                // SayScript.g:1:213: SEMICOLON
                {
                mSEMICOLON(); 


                }
                break;
            case 29 :
                // SayScript.g:1:223: RANGE
                {
                mRANGE(); 


                }
                break;
            case 30 :
                // SayScript.g:1:229: PATTERN
                {
                mPATTERN(); 


                }
                break;
            case 31 :
                // SayScript.g:1:237: YEAR_PATTERN
                {
                mYEAR_PATTERN(); 


                }
                break;
            case 32 :
                // SayScript.g:1:250: GREATER
                {
                mGREATER(); 


                }
                break;
            case 33 :
                // SayScript.g:1:258: LESS
                {
                mLESS(); 


                }
                break;
            case 34 :
                // SayScript.g:1:263: VAR
                {
                mVAR(); 


                }
                break;
            case 35 :
                // SayScript.g:1:267: NOTVAR
                {
                mNOTVAR(); 


                }
                break;
            case 36 :
                // SayScript.g:1:274: NUMLEN
                {
                mNUMLEN(); 


                }
                break;
            case 37 :
                // SayScript.g:1:281: ATBEGIN
                {
                mATBEGIN(); 


                }
                break;
            case 38 :
                // SayScript.g:1:289: ATEXIT
                {
                mATEXIT(); 


                }
                break;
            case 39 :
                // SayScript.g:1:296: DATEPAST_RANGE
                {
                mDATEPAST_RANGE(); 


                }
                break;
            case 40 :
                // SayScript.g:1:311: DATEPAST_GREATER
                {
                mDATEPAST_GREATER(); 


                }
                break;
            case 41 :
                // SayScript.g:1:328: DATEFUT_RANGE
                {
                mDATEFUT_RANGE(); 


                }
                break;
            case 42 :
                // SayScript.g:1:342: DATEFUT_GREATER
                {
                mDATEFUT_GREATER(); 


                }
                break;
            case 43 :
                // SayScript.g:1:358: ANYDATE
                {
                mANYDATE(); 


                }
                break;
            case 44 :
                // SayScript.g:1:366: SECOND_RANGE
                {
                mSECOND_RANGE(); 


                }
                break;
            case 45 :
                // SayScript.g:1:379: MINUTE_RANGE
                {
                mMINUTE_RANGE(); 


                }
                break;
            case 46 :
                // SayScript.g:1:392: HOUR_RANGE
                {
                mHOUR_RANGE(); 


                }
                break;
            case 47 :
                // SayScript.g:1:403: YEAR_RANGE
                {
                mYEAR_RANGE(); 


                }
                break;
            case 48 :
                // SayScript.g:1:414: OPT
                {
                mOPT(); 


                }
                break;
            case 49 :
                // SayScript.g:1:418: NOTOPT
                {
                mNOTOPT(); 


                }
                break;
            case 50 :
                // SayScript.g:1:425: DAYAMOUNT
                {
                mDAYAMOUNT(); 


                }
                break;
            case 51 :
                // SayScript.g:1:435: NUM
                {
                mNUM(); 


                }
                break;
            case 52 :
                // SayScript.g:1:439: FE_time_sec
                {
                mFE_time_sec(); 


                }
                break;
            case 53 :
                // SayScript.g:1:451: FE_time_min
                {
                mFE_time_min(); 


                }
                break;
            case 54 :
                // SayScript.g:1:463: FE_time_12hour
                {
                mFE_time_12hour(); 


                }
                break;
            case 55 :
                // SayScript.g:1:478: FE_time_24hour
                {
                mFE_time_24hour(); 


                }
                break;
            case 56 :
                // SayScript.g:1:493: FE_time_12hour2d
                {
                mFE_time_12hour2d(); 


                }
                break;
            case 57 :
                // SayScript.g:1:510: FE_time_24hour2d
                {
                mFE_time_24hour2d(); 


                }
                break;
            case 58 :
                // SayScript.g:1:527: FE_time_ampm
                {
                mFE_time_ampm(); 


                }
                break;
            case 59 :
                // SayScript.g:1:540: FE_time_xm
                {
                mFE_time_xm(); 


                }
                break;
            case 60 :
                // SayScript.g:1:551: FE_time_cm
                {
                mFE_time_cm(); 


                }
                break;
            case 61 :
                // SayScript.g:1:562: FE_time_tz
                {
                mFE_time_tz(); 


                }
                break;
            case 62 :
                // SayScript.g:1:573: FE_date_dom
                {
                mFE_date_dom(); 


                }
                break;
            case 63 :
                // SayScript.g:1:585: FE_date_dow
                {
                mFE_date_dow(); 


                }
                break;
            case 64 :
                // SayScript.g:1:597: FE_date_month
                {
                mFE_date_month(); 


                }
                break;
            case 65 :
                // SayScript.g:1:611: FE_date_dowstr
                {
                mFE_date_dowstr(); 


                }
                break;
            case 66 :
                // SayScript.g:1:626: FE_date_monthstr
                {
                mFE_date_monthstr(); 


                }
                break;
            case 67 :
                // SayScript.g:1:643: FE_date_year
                {
                mFE_date_year(); 


                }
                break;
            case 68 :
                // SayScript.g:1:656: FE_date_century
                {
                mFE_date_century(); 


                }
                break;
            case 69 :
                // SayScript.g:1:672: FE_date_decade
                {
                mFE_date_decade(); 


                }
                break;
            case 70 :
                // SayScript.g:1:687: FE_Lsubr
                {
                mFE_Lsubr(); 


                }
                break;
            case 71 :
                // SayScript.g:1:696: FE_Rsubr
                {
                mFE_Rsubr(); 


                }
                break;
            case 72 :
                // SayScript.g:1:705: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 73 :
                // SayScript.g:1:713: ID
                {
                mID(); 


                }
                break;
            case 74 :
                // SayScript.g:1:716: PATHCONST
                {
                mPATHCONST(); 


                }
                break;
            case 75 :
                // SayScript.g:1:726: PAT
                {
                mPAT(); 


                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\11\55\1\uffff\1\72\10\uffff\1\74\1\76\1\uffff\1\77\3\uffff"+
        "\1\101\12\55\1\116\2\55\2\uffff\2\55\1\uffff\14\55\10\uffff\13\55"+
        "\1\151\1\uffff\2\55\1\154\1\155\1\55\1\157\14\55\1\175\6\55\1\u0084"+
        "\1\uffff\2\55\2\uffff\1\55\1\uffff\1\u0089\1\u008a\12\55\1\u0096"+
        "\1\uffff\6\55\1\uffff\3\55\1\51\2\uffff\2\55\1\u00ab\10\55\1\uffff"+
        "\6\55\1\51\2\55\10\51\3\55\1\uffff\1\55\1\u00cd\1\u00ce\1\u00cf"+
        "\1\u00d0\5\55\1\u00d6\4\55\4\51\1\u00e0\1\u00e1\5\51\1\u00e7\1\u00e8"+
        "\1\u00e9\3\55\1\u00ed\4\uffff\1\u00ee\2\55\1\u00f1\1\u00f2\1\uffff"+
        "\1\u00f3\3\55\5\51\2\uffff\1\u00fd\1\u00fe\3\51\3\uffff\3\55\2\uffff"+
        "\2\55\3\uffff\3\55\1\u010b\1\u010d\4\51\2\uffff\2\51\1\u0114\11"+
        "\55\1\uffff\1\51\1\uffff\2\51\1\u0122\3\51\1\uffff\6\55\1\u012c"+
        "\2\55\1\u012f\2\51\1\u0133\1\uffff\1\51\1\u0136\1\u0138\4\55\1\u013d"+
        "\1\55\1\uffff\2\55\1\uffff\1\u0141\1\u0142\1\51\1\uffff\2\51\1\uffff"+
        "\1\51\1\uffff\4\55\1\uffff\1\u014b\1\u014c\1\u014d\2\uffff\1\51"+
        "\1\u014f\1\u0150\1\u0151\2\55\1\u0154\1\55\3\uffff\1\u0156\3\uffff"+
        "\1\u0157\1\55\1\uffff\1\55\2\uffff\1\55\1\u015b\1\u015c\2\uffff";
    static final String DFA9_eofS =
        "\u015d\uffff";
    static final String DFA9_minS =
        "\1\11\11\55\1\uffff\1\55\10\uffff\1\74\1\76\1\uffff\1\55\3\uffff"+
        "\1\73\15\55\2\uffff\2\55\1\uffff\14\55\10\uffff\14\55\1\uffff\32"+
        "\55\1\uffff\2\55\2\uffff\1\55\1\uffff\15\55\1\uffff\6\55\1\uffff"+
        "\3\55\1\61\2\uffff\13\55\1\uffff\6\55\1\143\2\55\1\145\1\151\1\62"+
        "\1\64\3\155\1\172\3\55\1\uffff\17\55\1\145\1\157\2\145\2\55\1\143"+
        "\1\156\2\150\1\160\7\55\4\uffff\5\55\1\uffff\4\55\1\155\1\143\1"+
        "\156\1\141\1\156\2\uffff\2\55\2\157\1\155\3\uffff\3\55\2\uffff\2"+
        "\55\3\uffff\5\55\1\141\1\164\1\162\1\164\2\uffff\2\165\12\55\1\uffff"+
        "\1\164\1\uffff\1\144\1\150\1\55\1\165\2\162\1\uffff\12\55\1\162"+
        "\1\145\1\55\1\uffff\1\162\10\55\1\uffff\2\55\1\uffff\2\55\1\164"+
        "\1\uffff\1\171\1\144\1\uffff\1\144\1\uffff\4\55\1\uffff\3\55\2\uffff"+
        "\1\162\7\55\3\uffff\1\55\3\uffff\2\55\1\uffff\1\55\2\uffff\3\55"+
        "\2\uffff";
    static final String DFA9_maxS =
        "\1\175\11\172\1\uffff\1\172\10\uffff\1\74\1\76\1\uffff\1\172\3\uffff"+
        "\1\73\15\172\2\uffff\2\172\1\uffff\14\172\10\uffff\14\172\1\uffff"+
        "\32\172\1\uffff\2\172\2\uffff\1\172\1\uffff\15\172\1\uffff\6\172"+
        "\1\uffff\3\172\1\170\2\uffff\13\172\1\uffff\6\172\1\171\2\172\1"+
        "\145\1\151\1\62\1\64\3\155\4\172\1\uffff\17\172\2\157\2\145\2\172"+
        "\1\143\1\156\2\150\1\160\7\172\4\uffff\5\172\1\uffff\4\172\1\167"+
        "\1\143\1\156\1\141\1\156\2\uffff\2\172\2\157\1\155\3\uffff\3\172"+
        "\2\uffff\2\172\3\uffff\5\172\1\141\1\164\1\162\1\164\2\uffff\2\165"+
        "\12\172\1\uffff\1\164\1\uffff\1\144\1\150\1\172\1\165\2\162\1\uffff"+
        "\12\172\1\162\1\145\1\172\1\uffff\1\162\10\172\1\uffff\2\172\1\uffff"+
        "\2\172\1\164\1\uffff\1\171\1\144\1\uffff\1\144\1\uffff\4\172\1\uffff"+
        "\3\172\2\uffff\1\162\7\172\3\uffff\1\172\3\uffff\2\172\1\uffff\1"+
        "\172\2\uffff\3\172\2\uffff";
    static final String DFA9_acceptS =
        "\12\uffff\1\13\1\uffff\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\2"+
        "\uffff\1\27\1\uffff\1\31\1\32\1\33\16\uffff\1\112\1\113\2\uffff"+
        "\1\111\14\uffff\1\14\1\106\1\25\1\107\1\26\1\30\1\110\1\34\14\uffff"+
        "\1\63\32\uffff\1\62\2\uffff\1\2\1\3\1\uffff\1\5\15\uffff\1\42\6"+
        "\uffff\1\60\4\uffff\1\6\1\7\13\uffff\1\41\24\uffff\1\35\41\uffff"+
        "\1\12\1\43\1\61\1\44\5\uffff\1\46\11\uffff\1\1\1\4\5\uffff\1\73"+
        "\1\74\1\75\3\uffff\1\11\1\36\2\uffff\1\40\1\45\1\53\11\uffff\1\64"+
        "\1\65\14\uffff\1\76\1\uffff\1\77\6\uffff\1\72\15\uffff\1\103\11"+
        "\uffff\1\57\2\uffff\1\56\3\uffff\1\100\2\uffff\1\66\1\uffff\1\67"+
        "\4\uffff\1\10\3\uffff\1\101\1\105\10\uffff\1\37\1\54\1\55\1\uffff"+
        "\1\104\1\70\1\71\2\uffff\1\51\1\uffff\1\102\1\47\3\uffff\1\52\1"+
        "\50";
    static final String DFA9_specialS =
        "\u015d\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\12\1\14\2\uffff\1\14\22\uffff\1\12\1\uffff\1\52\5\uffff\1"+
            "\22\1\23\1\uffff\1\30\1\15\1\13\1\27\1\51\12\46\1\26\1\33\1"+
            "\24\1\32\1\25\1\31\1\uffff\1\41\1\50\1\5\1\7\2\50\1\36\1\44"+
            "\3\50\1\37\1\43\1\11\1\45\1\34\1\50\1\10\1\42\2\50\1\40\2\50"+
            "\1\35\1\6\1\20\1\uffff\1\21\1\uffff\1\51\1\uffff\3\50\1\47\11"+
            "\50\1\2\1\3\3\50\1\1\1\4\6\50\1\16\1\uffff\1\17",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\10\54\1\53\21"+
            "\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\24\54\1\56\5"+
            "\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\17\54\1\57\12"+
            "\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\10\54\1\60\21"+
            "\54",
            "\3\51\12\54\7\uffff\24\54\1\61\5\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\4\54\1\62\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\1\64\15\54\1\63\13\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\65\3\54\1\66\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\67\11\54\1\70\5\54\1\71\5\54\4\uffff"+
            "\1\54\1\uffff\32\54",
            "",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\73",
            "\1\75",
            "",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "",
            "\1\100",
            "\3\51\12\54\7\uffff\1\102\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\103\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\21\54\1\104\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\105\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\1\106\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\15\54\1\110\5\54\1\107\6\54\4\uffff\1\54"+
            "\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\111\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\10\54\1\112\21\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\16\54\1\113\13\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\17\54\1\114\12\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\46\7\uffff\14\51\1\115\11\51\1\115\1\51\1\115\1\51"+
            "\4\uffff\1\51\1\uffff\14\51\1\115\11\51\1\115\1\51\1\115\1\51",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\1\117\31\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\13\54\1\120"+
            "\16\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\14\54\1\121"+
            "\15\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\23\54\1\122"+
            "\6\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\14\54\1\123"+
            "\15\54",
            "\3\51\12\54\7\uffff\23\54\1\124\6\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\21\54\1\125\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\15\54\1\126\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\127\6\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\15\54\1\130\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\22\54\1\131\7\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\6\54\1\132\23\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\23\54\1\133\6\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\14\54\1\134\15\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\3\51\12\54\7\uffff\23\54\1\135\6\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\1\136\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\137\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\22\54\1\140\7\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\21\54\1\141\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\54\1\142\2\54\1\143\25\54\4\uffff\1\54"+
            "\1\uffff\32\54",
            "\3\51\12\54\7\uffff\30\54\1\144\1\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\2\54\1\145\27\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\15\54\1\146\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\24\54\1\147\5\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\23\54\1\150\6\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\23\54\1\152"+
            "\6\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\4\54\1\153\25"+
            "\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\4\54\1\156\25"+
            "\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\16\54\1\160\13\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\161\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\4\54\1\162\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\6\54\1\163\23\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\23\54\1\164\6\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\1\165\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\16\54\1\167\6\54\1\166\4\54\4\uffff\1\54"+
            "\1\uffff\32\54",
            "\3\51\12\54\7\uffff\13\54\1\170\16\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\171\6\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\21\54\1\172\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\173\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\22\54\1\174\7\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\176\25\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\27\54\1\177\2\54\4\uffff\1\54\1\uffff\32"+
            "\54",
            "\3\51\12\54\7\uffff\3\54\1\u0080\26\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\16\54\1\u0081\13\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\24\54\1\u0082\5\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u0083\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\4\54\1\u0085"+
            "\25\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\15\54\1\u0086"+
            "\14\54",
            "",
            "",
            "\1\51\1\u0088\1\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff"+
            "\25\54\1\u0087\4\54",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\5\54\1\u008c\11\54\1\u008b\12\54\4\uffff"+
            "\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u008d\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\u008e\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u008f\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\u0090\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\17\54\1\u0091\12\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u0092\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u0093\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\u0094\1\uffff\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u0095\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\3\51\12\54\7\uffff\6\54\1\u0097\23\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\10\54\1\u0098\21\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\u0099\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u009a\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u009b\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\u009c\1\uffff\32\54",
            "",
            "\1\51\1\u009d\1\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\2\54\1\u009e"+
            "\27\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\1\u009f\31\54",
            "\1\u00a2\1\u00a3\56\uffff\1\u00a4\1\uffff\1\u00a6\11\uffff"+
            "\1\u00a1\5\uffff\1\u00a0\1\u00a7\3\uffff\1\u00a5",
            "",
            "",
            "\3\51\12\54\7\uffff\1\u00a8\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\24\54\1\u00a9\5\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\u00aa\1\uffff\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u00ac\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u00ad\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u00ae\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u00af\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u00b0\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u00b1\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\17\54\1\u00b2\1\54\1\u00b3\10\54\4\uffff"+
            "\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u00b4\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "\3\51\12\54\7\uffff\10\54\1\u00b5\21\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u00b6\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u00b7\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\3\54\1\u00b8\26\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u00b9\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u00ba\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\1\u00be\1\u00bb\10\uffff\1\u00bc\13\uffff\1\u00bd",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\4\54\1\u00bf"+
            "\25\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\13\54\1\u00c0"+
            "\16\54",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\3\51\12\54\7\uffff\22\54\1\u00c9\7\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u00ca\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u00cb\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "\3\51\12\54\7\uffff\23\54\1\u00cc\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u00d1\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\u00d2\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\1\u00d3\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u00d4\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u00d5\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u00d7\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\u00d8\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\u00d9\1\uffff\32\54",
            "\3\51\12\54\7\uffff\1\u00da\31\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00dc\11\uffff\1\u00db",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\1\u00e6",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\3\51\12\54\7\uffff\23\54\1\u00ea\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\u00eb\1\uffff\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u00ec\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u00ef\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u00f0\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u00f4\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u00f5\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u00f6\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\1\u00f7\11\uffff\1\u00f8",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "",
            "",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "",
            "",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\u0102\1\uffff\32\54",
            "\3\51\12\54\7\uffff\6\54\1\u0104\12\54\1\u0103\10\54\4\uffff"+
            "\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u0105\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "",
            "\3\51\12\54\7\uffff\23\54\1\u0106\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\6\54\1\u0107\23\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "",
            "",
            "\3\51\12\54\7\uffff\1\u0108\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\1\u0109\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\6\54\1\u010a\23\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\22\51\1\u010c\7\51",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "",
            "",
            "\1\u0112",
            "\1\u0113",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\3\51\12\54\7\uffff\6\54\1\u0116\12\54\1\u0115\10\54\4\uffff"+
            "\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\1\u0117\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u0118\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\16\54\1\u0119\13\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u011a\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u011b\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u011c\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u011d\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u011e\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "\1\u011f",
            "",
            "\1\u0120",
            "\1\u0121",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "",
            "\3\51\12\54\7\uffff\1\u0126\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u0127\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u0128\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u0129\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u012a\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\21\54\1\u012b\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\6\54\1\u012d\23\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\6\54\1\u012e\23\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\1\u0130",
            "\1\u0131",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\22\51\1\u0132\7\51",
            "",
            "\1\u0134",
            "\5\51\1\u0135\7\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\5\51\1\u0137\7\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\3\51\12\54\7\uffff\15\54\1\u0139\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u013a\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\6\54\1\u013b\23\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\u013c\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\15\54\1\u013e\14\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "\3\51\12\54\7\uffff\4\54\1\u013f\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u0140\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0143",
            "",
            "\1\u0144",
            "\1\u0145",
            "",
            "\1\u0146",
            "",
            "\3\51\12\54\7\uffff\6\54\1\u0147\23\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\1\u0148\31\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u0149\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u014a\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "\1\u014e",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\3\51\12\54\7\uffff\4\54\1\u0152\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\23\54\1\u0153\6\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u0155\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "",
            "",
            "\15\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\4\54\1\u0158\25\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "\3\51\12\54\7\uffff\21\54\1\u0159\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "",
            "",
            "\3\51\12\54\7\uffff\21\54\1\u015a\10\54\4\uffff\1\54\1\uffff"+
            "\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "\3\51\12\54\7\uffff\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( HDR_SILENCE | FE_num | FE_opt | FE_timeval | ACT_CUT | ACT_ZERO | ACT_DONE | ACT_RANGE | ACT_RESTART | ACT_NEGATE | WHITE | DASH | NEWLINE | COMMA | LCURLY | RCURLY | LBRACK | RBRACK | LPAR | RPAR | LANG | RANG | COLON | PERIOD | PLUS | QUESTION | EQUALS | SEMICOLON | RANGE | PATTERN | YEAR_PATTERN | GREATER | LESS | VAR | NOTVAR | NUMLEN | ATBEGIN | ATEXIT | DATEPAST_RANGE | DATEPAST_GREATER | DATEFUT_RANGE | DATEFUT_GREATER | ANYDATE | SECOND_RANGE | MINUTE_RANGE | HOUR_RANGE | YEAR_RANGE | OPT | NOTOPT | DAYAMOUNT | NUM | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_24hour | FE_time_12hour2d | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade | FE_Lsubr | FE_Rsubr | COMMENT | ID | PATHCONST | PAT );";
        }
    }
 

}