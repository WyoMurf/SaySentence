// $ANTLR 3.4 format.g 2013-11-26 15:34:05

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;
import java.util.Stack;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class formatParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FILE", "LANG", "LBRACK", "NUM", "OPT", "PERCENT", "RANG", "RBRACK", "SILENCE_COLON", "SILENCE_COMMA", "SILENCE_PERIOD", "SILENCE_PLUS", "SILENCE_QUEST", "SILENCE_SEMI", "SILENCE_SPACE", "'D'", "'c'", "'d'", "'e'", "'f'", "'i'", "'m'", "'n'", "'p'", "'r'", "'s'", "'t'", "'z'"
    };

    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int FILE=4;
    public static final int LANG=5;
    public static final int LBRACK=6;
    public static final int NUM=7;
    public static final int OPT=8;
    public static final int PERCENT=9;
    public static final int RANG=10;
    public static final int RBRACK=11;
    public static final int SILENCE_COLON=12;
    public static final int SILENCE_COMMA=13;
    public static final int SILENCE_PERIOD=14;
    public static final int SILENCE_PLUS=15;
    public static final int SILENCE_QUEST=16;
    public static final int SILENCE_SEMI=17;
    public static final int SILENCE_SPACE=18;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public formatParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public formatParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return formatParser.tokenNames; }
    public String getGrammarFileName() { return "format.g"; }





    // $ANTLR start "silence"
    // format.g:49:1: silence[SS_format form, ArrayList<SS_log> loglist] : ( SILENCE_SPACE | SILENCE_PERIOD | SILENCE_QUEST | SILENCE_SEMI | SILENCE_COLON | SILENCE_COMMA | SILENCE_PLUS );
    public final void silence(SS_format form, ArrayList<SS_log> loglist) throws RecognitionException {
        	/* System.out.println("Begin the silence"); */
        try {
            // format.g:51:6: ( SILENCE_SPACE | SILENCE_PERIOD | SILENCE_QUEST | SILENCE_SEMI | SILENCE_COLON | SILENCE_COMMA | SILENCE_PLUS )
            int alt1=7;
            switch ( input.LA(1) ) {
            case SILENCE_SPACE:
                {
                alt1=1;
                }
                break;
            case SILENCE_PERIOD:
                {
                alt1=2;
                }
                break;
            case SILENCE_QUEST:
                {
                alt1=3;
                }
                break;
            case SILENCE_SEMI:
                {
                alt1=4;
                }
                break;
            case SILENCE_COLON:
                {
                alt1=5;
                }
                break;
            case SILENCE_COMMA:
                {
                alt1=6;
                }
                break;
            case SILENCE_PLUS:
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // format.g:51:8: SILENCE_SPACE
                    {
                    match(input,SILENCE_SPACE,FOLLOW_SILENCE_SPACE_in_silence244); 

                    SS_format_element x = new SS_format_element(); 
                    		                 x.type = x.FE_TYPE_SILENCE; 
                    		                 x.silence = x.FE_SILENCE_SPACE; 
                    						 form.elements.add(x);
                    						

                    }
                    break;
                case 2 :
                    // format.g:56:5: SILENCE_PERIOD
                    {
                    match(input,SILENCE_PERIOD,FOLLOW_SILENCE_PERIOD_in_silence252); 

                    SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_PERIOD; form.elements.add(x);

                    }
                    break;
                case 3 :
                    // format.g:57:5: SILENCE_QUEST
                    {
                    match(input,SILENCE_QUEST,FOLLOW_SILENCE_QUEST_in_silence260); 

                    SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_QUEST; form.elements.add(x);

                    }
                    break;
                case 4 :
                    // format.g:58:5: SILENCE_SEMI
                    {
                    match(input,SILENCE_SEMI,FOLLOW_SILENCE_SEMI_in_silence268); 

                    SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_SEMI; form.elements.add(x);

                    }
                    break;
                case 5 :
                    // format.g:59:5: SILENCE_COLON
                    {
                    match(input,SILENCE_COLON,FOLLOW_SILENCE_COLON_in_silence276); 

                    SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_COLON; form.elements.add(x);

                    }
                    break;
                case 6 :
                    // format.g:60:5: SILENCE_COMMA
                    {
                    match(input,SILENCE_COMMA,FOLLOW_SILENCE_COMMA_in_silence284); 

                    SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_COMMA; form.elements.add(x);

                    }
                    break;
                case 7 :
                    // format.g:61:5: SILENCE_PLUS
                    {
                    match(input,SILENCE_PLUS,FOLLOW_SILENCE_PLUS_in_silence292); 

                    SS_format_element x = new SS_format_element(); x.type = x.FE_TYPE_SILENCE; x.silence = x.FE_SILENCE_PLUS; form.elements.add(x);

                    }
                    break;

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
    // $ANTLR end "silence"



    // $ANTLR start "varspec"
    // format.g:64:1: varspec[SS_format form, ArrayList<SS_log> loglist] : ( PERCENT (num= NUM )? (opt= OPT )? ( 'm' | 'd' | 't' | 'n' | 'i' | 's' | 'c' | 'p' | 'e' | 'D' | 'f' | 'r' | 'z' ) |z=~ ( 'm' | 'd' | 't' | 'n' | 'i' | 's' | 'c' | 'p' | 'e' | 'D' | 'f' | 'r' | 'z' | '<' | ',' | ' ' | '+' | ';' | ':' | '.' | '?' ) );
    public final void varspec(SS_format form, ArrayList<SS_log> loglist) throws RecognitionException {
        Token num=null;
        Token opt=null;
        Token z=null;

        try {
            // format.g:65:9: ( PERCENT (num= NUM )? (opt= OPT )? ( 'm' | 'd' | 't' | 'n' | 'i' | 's' | 'c' | 'p' | 'e' | 'D' | 'f' | 'r' | 'z' ) |z=~ ( 'm' | 'd' | 't' | 'n' | 'i' | 's' | 'c' | 'p' | 'e' | 'D' | 'f' | 'r' | 'z' | '<' | ',' | ' ' | '+' | ';' | ':' | '.' | '?' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PERCENT) ) {
                switch ( input.LA(2) ) {
                case NUM:
                    {
                    switch ( input.LA(3) ) {
                    case OPT:
                        {
                        int LA5_4 = input.LA(4);

                        if ( ((LA5_4 >= 19 && LA5_4 <= 31)) ) {
                            alt5=1;
                        }
                        else if ( (LA5_4==EOF||LA5_4==FILE||(LA5_4 >= LBRACK && LA5_4 <= SILENCE_SPACE)) ) {
                            alt5=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 4, input);

                            throw nvae;

                        }
                        }
                        break;
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                        {
                        alt5=1;
                        }
                        break;
                    case EOF:
                    case FILE:
                    case LBRACK:
                    case NUM:
                    case PERCENT:
                    case RANG:
                    case RBRACK:
                    case SILENCE_COLON:
                    case SILENCE_COMMA:
                    case SILENCE_PERIOD:
                    case SILENCE_PLUS:
                    case SILENCE_QUEST:
                    case SILENCE_SEMI:
                    case SILENCE_SPACE:
                        {
                        alt5=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 3, input);

                        throw nvae;

                    }

                    }
                    break;
                case OPT:
                    {
                    int LA5_4 = input.LA(3);

                    if ( ((LA5_4 >= 19 && LA5_4 <= 31)) ) {
                        alt5=1;
                    }
                    else if ( (LA5_4==EOF||LA5_4==FILE||(LA5_4 >= LBRACK && LA5_4 <= SILENCE_SPACE)) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 4, input);

                        throw nvae;

                    }
                    }
                    break;
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                    {
                    alt5=1;
                    }
                    break;
                case EOF:
                case FILE:
                case LBRACK:
                case PERCENT:
                case RANG:
                case RBRACK:
                case SILENCE_COLON:
                case SILENCE_COMMA:
                case SILENCE_PERIOD:
                case SILENCE_PLUS:
                case SILENCE_QUEST:
                case SILENCE_SEMI:
                case SILENCE_SPACE:
                    {
                    alt5=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }

            }
            else if ( (LA5_0==FILE||(LA5_0 >= LBRACK && LA5_0 <= OPT)||(LA5_0 >= RANG && LA5_0 <= RBRACK)) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // format.g:65:11: PERCENT (num= NUM )? (opt= OPT )? ( 'm' | 'd' | 't' | 'n' | 'i' | 's' | 'c' | 'p' | 'e' | 'D' | 'f' | 'r' | 'z' )
                    {
                    match(input,PERCENT,FOLLOW_PERCENT_in_varspec314); 

                    SS_format_element x = new SS_format_element(); 
                    		           x.type = SS_format_element.FE_TYPE_SAYSCRIPT; 
                    				   /* System.out.println("got a percent!"); */
                    				  

                    // format.g:69:13: (num= NUM )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==NUM) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // format.g:69:14: num= NUM
                            {
                            num=(Token)match(input,NUM,FOLLOW_NUM_in_varspec334); 

                            x.num = Integer.parseInt((num!=null?num.getText():null));

                            }
                            break;

                    }


                    // format.g:69:63: (opt= OPT )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==OPT) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // format.g:69:64: opt= OPT
                            {
                            opt=(Token)match(input,OPT,FOLLOW_OPT_in_varspec343); 

                            x.opt = new String((opt!=null?opt.getText():null).substring(1,(opt!=null?opt.getText():null).length()-1));

                            }
                            break;

                    }


                    // format.g:70:3: ( 'm' | 'd' | 't' | 'n' | 'i' | 's' | 'c' | 'p' | 'e' | 'D' | 'f' | 'r' | 'z' )
                    int alt4=13;
                    switch ( input.LA(1) ) {
                    case 25:
                        {
                        alt4=1;
                        }
                        break;
                    case 21:
                        {
                        alt4=2;
                        }
                        break;
                    case 30:
                        {
                        alt4=3;
                        }
                        break;
                    case 26:
                        {
                        alt4=4;
                        }
                        break;
                    case 24:
                        {
                        alt4=5;
                        }
                        break;
                    case 29:
                        {
                        alt4=6;
                        }
                        break;
                    case 20:
                        {
                        alt4=7;
                        }
                        break;
                    case 27:
                        {
                        alt4=8;
                        }
                        break;
                    case 22:
                        {
                        alt4=9;
                        }
                        break;
                    case 19:
                        {
                        alt4=10;
                        }
                        break;
                    case 23:
                        {
                        alt4=11;
                        }
                        break;
                    case 28:
                        {
                        alt4=12;
                        }
                        break;
                    case 31:
                        {
                        alt4=13;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;

                    }

                    switch (alt4) {
                        case 1 :
                            // format.g:70:5: 'm'
                            {
                            match(input,25,FOLLOW_25_in_varspec354); 

                            x.sayscript_type = SS_script.SS_S_TYPE_MONEY; form.elements.add(x);

                            }
                            break;
                        case 2 :
                            // format.g:71:5: 'd'
                            {
                            match(input,21,FOLLOW_21_in_varspec363); 

                            x.sayscript_type = SS_script.SS_S_TYPE_DATE; form.elements.add(x);

                            }
                            break;
                        case 3 :
                            // format.g:72:5: 't'
                            {
                            match(input,30,FOLLOW_30_in_varspec372); 

                            x.sayscript_type = SS_script.SS_S_TYPE_TIME; form.elements.add(x);

                            }
                            break;
                        case 4 :
                            // format.g:73:5: 'n'
                            {
                            match(input,26,FOLLOW_26_in_varspec381); 

                            x.sayscript_type = SS_script.SS_S_TYPE_NUMBER; form.elements.add(x);

                            }
                            break;
                        case 5 :
                            // format.g:74:5: 'i'
                            {
                            match(input,24,FOLLOW_24_in_varspec390); 

                            x.sayscript_type = SS_script.SS_S_TYPE_DIGIT_STR; form.elements.add(x);

                            }
                            break;
                        case 6 :
                            // format.g:75:5: 's'
                            {
                            match(input,29,FOLLOW_29_in_varspec399); 

                            x.sayscript_type = SS_script.SS_S_TYPE_ALPHANUM_STR; form.elements.add(x);

                            }
                            break;
                        case 7 :
                            // format.g:76:5: 'c'
                            {
                            match(input,20,FOLLOW_20_in_varspec408); 

                            x.sayscript_type = SS_script.SS_S_TYPE_CHAR_STR; form.elements.add(x);

                            }
                            break;
                        case 8 :
                            // format.g:77:5: 'p'
                            {
                            match(input,27,FOLLOW_27_in_varspec417); 

                            x.sayscript_type = SS_script.SS_S_TYPE_PHONETIC_STR; form.elements.add(x);

                            }
                            break;
                        case 9 :
                            // format.g:78:5: 'e'
                            {
                            match(input,22,FOLLOW_22_in_varspec426); 

                            x.sayscript_type = SS_script.SS_S_TYPE_ENUMERATION; form.elements.add(x);

                            }
                            break;
                        case 10 :
                            // format.g:79:5: 'D'
                            {
                            match(input,19,FOLLOW_19_in_varspec435); 

                            x.sayscript_type = SS_script.SS_S_TYPE_DATE_TIME; form.elements.add(x);

                            }
                            break;
                        case 11 :
                            // format.g:80:5: 'f'
                            {
                            match(input,23,FOLLOW_23_in_varspec444); 

                            x.sayscript_type = SS_script.SS_S_TYPE_DATE_FORMAT; form.elements.add(x);

                            }
                            break;
                        case 12 :
                            // format.g:81:5: 'r'
                            {
                            match(input,28,FOLLOW_28_in_varspec452); 

                            x.sayscript_type = SS_script.SS_S_TYPE_REL_DATE_TIME; form.elements.add(x);

                            }
                            break;
                        case 13 :
                            // format.g:82:5: 'z'
                            {
                            match(input,31,FOLLOW_31_in_varspec460); 

                            x.sayscript_type = SS_script.SS_S_TYPE_FILE; form.elements.add(x);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // format.g:83:5: z=~ ( 'm' | 'd' | 't' | 'n' | 'i' | 's' | 'c' | 'p' | 'e' | 'D' | 'f' | 'r' | 'z' | '<' | ',' | ' ' | '+' | ';' | ':' | '.' | '?' )
                    {
                    z=(Token)input.LT(1);

                    if ( input.LA(1)==FILE||(input.LA(1) >= LBRACK && input.LA(1) <= RBRACK) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    SS_log l = new SS_log((z!=null?z.getLine():0),(z!=null?z.getCharPositionInLine():0), "Illegal script character", "There is nothing defined for %"+(z!=null?z.getText():null)+". Please correct."); loglist.add(l); 

                    }
                    break;

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
    // $ANTLR end "varspec"



    // $ANTLR start "format"
    // format.g:88:1: format[ArrayList<SS_log> loglist] returns [SS_format form] : (z= FILE | silence[form,loglist] | varspec[form,loglist] )+ ;
    public final SS_format format(ArrayList<SS_log> loglist) throws RecognitionException {
        SS_format form = null;


        Token z=null;

         form = new SS_format(); 
        try {
            // format.g:91:3: ( (z= FILE | silence[form,loglist] | varspec[form,loglist] )+ )
            // format.g:91:6: (z= FILE | silence[form,loglist] | varspec[form,loglist] )+
            {
            // format.g:91:6: (z= FILE | silence[form,loglist] | varspec[form,loglist] )+
            int cnt6=0;
            loop6:
            do {
                int alt6=4;
                switch ( input.LA(1) ) {
                case FILE:
                    {
                    alt6=1;
                    }
                    break;
                case SILENCE_COLON:
                case SILENCE_COMMA:
                case SILENCE_PERIOD:
                case SILENCE_PLUS:
                case SILENCE_QUEST:
                case SILENCE_SEMI:
                case SILENCE_SPACE:
                    {
                    alt6=2;
                    }
                    break;
                case LBRACK:
                case NUM:
                case OPT:
                case PERCENT:
                case RANG:
                case RBRACK:
                    {
                    alt6=3;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // format.g:91:7: z= FILE
            	    {
            	    z=(Token)match(input,FILE,FOLLOW_FILE_in_format552); 

            	    SS_format_element x = new SS_format_element(); 
            	    		   		   x.type = x.FE_TYPE_FILE; 
            	    		           x.file = new String((z!=null?z.getText():null).substring(1,(z!=null?z.getText():null).length()-1));
            	    				   /* System.out.println("Just added file "+x.file+" to the form"); */
            	    				   form.elements.add(x);
            	    				  

            	    }
            	    break;
            	case 2 :
            	    // format.g:98:5: silence[form,loglist]
            	    {
            	    pushFollow(FOLLOW_silence_in_format561);
            	    silence(form, loglist);

            	    state._fsp--;


            	    /* System.out.println("Just finished silence char");*/ 

            	    }
            	    break;
            	case 3 :
            	    // format.g:99:5: varspec[form,loglist]
            	    {
            	    pushFollow(FOLLOW_varspec_in_format571);
            	    varspec(form, loglist);

            	    state._fsp--;


            	    /* System.out.println("Just finished varspec"); */

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
        return form;
    }
    // $ANTLR end "format"

    // Delegated rules


 

    public static final BitSet FOLLOW_SILENCE_SPACE_in_silence244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SILENCE_PERIOD_in_silence252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SILENCE_QUEST_in_silence260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SILENCE_SEMI_in_silence268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SILENCE_COLON_in_silence276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SILENCE_COMMA_in_silence284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SILENCE_PLUS_in_silence292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENT_in_varspec314 = new BitSet(new long[]{0x00000000FFF80180L});
    public static final BitSet FOLLOW_NUM_in_varspec334 = new BitSet(new long[]{0x00000000FFF80100L});
    public static final BitSet FOLLOW_OPT_in_varspec343 = new BitSet(new long[]{0x00000000FFF80000L});
    public static final BitSet FOLLOW_25_in_varspec354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_varspec363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_varspec372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_varspec381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_varspec390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_varspec399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_varspec408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_varspec417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_varspec426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_varspec435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_varspec444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_varspec452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_varspec460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_varspec471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILE_in_format552 = new BitSet(new long[]{0x000000000007FFD2L});
    public static final BitSet FOLLOW_silence_in_format561 = new BitSet(new long[]{0x000000000007FFD2L});
    public static final BitSet FOLLOW_varspec_in_format571 = new BitSet(new long[]{0x000000000007FFD2L});

}