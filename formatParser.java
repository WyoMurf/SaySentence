// $ANTLR 3.4 format.g 2059-12-15 23:13:50

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "FILE", "LANG", "LBRACK", "NUM", "OPT", "PERCENT", "RANG", "RBRACK", "SILENCE_COLON", "SILENCE_COMMA", "SILENCE_PERIOD", "SILENCE_PLUS", "SILENCE_QUEST", "SILENCE_SEMI", "SILENCE_SPACE", "'A'", "'B'", "'C'", "'D'", "'E'", "'F'", "'G'", "'H'", "'I'", "'J'", "'K'", "'L'", "'M'", "'N'", "'O'", "'P'", "'Q'", "'R'", "'S'", "'T'", "'U'", "'V'", "'W'", "'X'", "'Y'", "'Z'", "'a'", "'b'", "'c'", "'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", "'k'", "'l'", "'m'", "'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", "'u'", "'v'", "'w'", "'x'", "'y'", "'z'"
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
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
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
    // format.g:64:1: varspec[SS_format form, ArrayList<SS_log> loglist] : ( PERCENT (num= NUM )? (opt= OPT )? ( 'c' | 'd' | 'e' | 'f' | 'i' | 'm' | 'n' | 'p' | 'r' | 's' | 't' | 'z' | 'D' | 'a' | 'b' | 'g' | 'h' | 'j' | 'k' | 'l' | 'o' | 'q' | 'u' | 'v' | 'w' | 'x' | 'y' | 'A' | 'B' | 'C' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' ) |z=~ ( 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k' | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v' | 'w' | 'x' | 'y' | 'z' | 'A' | 'B' | 'C' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' | '<' | ',' | ' ' | '+' | ';' | ':' | '.' | '?' ) );
    public final void varspec(SS_format form, ArrayList<SS_log> loglist) throws RecognitionException {
        Token num=null;
        Token opt=null;
        Token z=null;

        try {
            // format.g:65:9: ( PERCENT (num= NUM )? (opt= OPT )? ( 'c' | 'd' | 'e' | 'f' | 'i' | 'm' | 'n' | 'p' | 'r' | 's' | 't' | 'z' | 'D' | 'a' | 'b' | 'g' | 'h' | 'j' | 'k' | 'l' | 'o' | 'q' | 'u' | 'v' | 'w' | 'x' | 'y' | 'A' | 'B' | 'C' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' ) |z=~ ( 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k' | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v' | 'w' | 'x' | 'y' | 'z' | 'A' | 'B' | 'C' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' | '<' | ',' | ' ' | '+' | ';' | ':' | '.' | '?' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==PERCENT) ) {
                switch ( input.LA(2) ) {
                case NUM:
                    {
                    switch ( input.LA(3) ) {
                    case OPT:
                        {
                        switch ( input.LA(4) ) {
                        case 47:
                            {
                            alt5=1;
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
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                            {
                            alt5=1;
                            }
                            break;
                        case EOF:
                        case FILE:
                        case LBRACK:
                        case NUM:
                        case OPT:
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
                                new NoViableAltException("", 5, 4, input);

                            throw nvae;

                        }

                        }
                        break;
                    case 47:
                        {
                        alt5=1;
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
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
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
                    switch ( input.LA(3) ) {
                    case 47:
                        {
                        alt5=1;
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
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                        {
                        alt5=1;
                        }
                        break;
                    case EOF:
                    case FILE:
                    case LBRACK:
                    case NUM:
                    case OPT:
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
                            new NoViableAltException("", 5, 4, input);

                        throw nvae;

                    }

                    }
                    break;
                case 47:
                case 48:
                case 49:
                case 50:
                case 53:
                case 57:
                case 58:
                case 60:
                case 62:
                case 63:
                case 64:
                case 70:
                    {
                    alt5=1;
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
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 51:
                case 52:
                case 54:
                case 55:
                case 56:
                case 59:
                case 61:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
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
            else if ( (LA5_0==FILE||(LA5_0 >= LBRACK && LA5_0 <= OPT)||(LA5_0 >= RANG && LA5_0 <= RBRACK)||LA5_0==22) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // format.g:65:11: PERCENT (num= NUM )? (opt= OPT )? ( 'c' | 'd' | 'e' | 'f' | 'i' | 'm' | 'n' | 'p' | 'r' | 's' | 't' | 'z' | 'D' | 'a' | 'b' | 'g' | 'h' | 'j' | 'k' | 'l' | 'o' | 'q' | 'u' | 'v' | 'w' | 'x' | 'y' | 'A' | 'B' | 'C' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' )
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


                    // format.g:70:3: ( 'c' | 'd' | 'e' | 'f' | 'i' | 'm' | 'n' | 'p' | 'r' | 's' | 't' | 'z' | 'D' | 'a' | 'b' | 'g' | 'h' | 'j' | 'k' | 'l' | 'o' | 'q' | 'u' | 'v' | 'w' | 'x' | 'y' | 'A' | 'B' | 'C' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' )
                    int alt4=52;
                    switch ( input.LA(1) ) {
                    case 47:
                        {
                        alt4=1;
                        }
                        break;
                    case 48:
                        {
                        alt4=2;
                        }
                        break;
                    case 49:
                        {
                        alt4=3;
                        }
                        break;
                    case 50:
                        {
                        alt4=4;
                        }
                        break;
                    case 53:
                        {
                        alt4=5;
                        }
                        break;
                    case 57:
                        {
                        alt4=6;
                        }
                        break;
                    case 58:
                        {
                        alt4=7;
                        }
                        break;
                    case 60:
                        {
                        alt4=8;
                        }
                        break;
                    case 62:
                        {
                        alt4=9;
                        }
                        break;
                    case 63:
                        {
                        alt4=10;
                        }
                        break;
                    case 64:
                        {
                        alt4=11;
                        }
                        break;
                    case 70:
                        {
                        alt4=12;
                        }
                        break;
                    case 22:
                        {
                        alt4=13;
                        }
                        break;
                    case 45:
                        {
                        alt4=14;
                        }
                        break;
                    case 46:
                        {
                        alt4=15;
                        }
                        break;
                    case 51:
                        {
                        alt4=16;
                        }
                        break;
                    case 52:
                        {
                        alt4=17;
                        }
                        break;
                    case 54:
                        {
                        alt4=18;
                        }
                        break;
                    case 55:
                        {
                        alt4=19;
                        }
                        break;
                    case 56:
                        {
                        alt4=20;
                        }
                        break;
                    case 59:
                        {
                        alt4=21;
                        }
                        break;
                    case 61:
                        {
                        alt4=22;
                        }
                        break;
                    case 65:
                        {
                        alt4=23;
                        }
                        break;
                    case 66:
                        {
                        alt4=24;
                        }
                        break;
                    case 67:
                        {
                        alt4=25;
                        }
                        break;
                    case 68:
                        {
                        alt4=26;
                        }
                        break;
                    case 69:
                        {
                        alt4=27;
                        }
                        break;
                    case 19:
                        {
                        alt4=28;
                        }
                        break;
                    case 20:
                        {
                        alt4=29;
                        }
                        break;
                    case 21:
                        {
                        alt4=30;
                        }
                        break;
                    case 23:
                        {
                        alt4=31;
                        }
                        break;
                    case 24:
                        {
                        alt4=32;
                        }
                        break;
                    case 25:
                        {
                        alt4=33;
                        }
                        break;
                    case 26:
                        {
                        alt4=34;
                        }
                        break;
                    case 27:
                        {
                        alt4=35;
                        }
                        break;
                    case 28:
                        {
                        alt4=36;
                        }
                        break;
                    case 29:
                        {
                        alt4=37;
                        }
                        break;
                    case 30:
                        {
                        alt4=38;
                        }
                        break;
                    case 31:
                        {
                        alt4=39;
                        }
                        break;
                    case 32:
                        {
                        alt4=40;
                        }
                        break;
                    case 33:
                        {
                        alt4=41;
                        }
                        break;
                    case 34:
                        {
                        alt4=42;
                        }
                        break;
                    case 35:
                        {
                        alt4=43;
                        }
                        break;
                    case 36:
                        {
                        alt4=44;
                        }
                        break;
                    case 37:
                        {
                        alt4=45;
                        }
                        break;
                    case 38:
                        {
                        alt4=46;
                        }
                        break;
                    case 39:
                        {
                        alt4=47;
                        }
                        break;
                    case 40:
                        {
                        alt4=48;
                        }
                        break;
                    case 41:
                        {
                        alt4=49;
                        }
                        break;
                    case 42:
                        {
                        alt4=50;
                        }
                        break;
                    case 43:
                        {
                        alt4=51;
                        }
                        break;
                    case 44:
                        {
                        alt4=52;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;

                    }

                    switch (alt4) {
                        case 1 :
                            // format.g:71:5: 'c'
                            {
                            match(input,47,FOLLOW_47_in_varspec358); 

                            x.sayscript_type = SS_script.SS_S_TYPE_CHAR_STR; form.elements.add(x);

                            }
                            break;
                        case 2 :
                            // format.g:72:5: 'd'
                            {
                            match(input,48,FOLLOW_48_in_varspec367); 

                            x.sayscript_type = SS_script.SS_S_TYPE_DATE; form.elements.add(x);

                            }
                            break;
                        case 3 :
                            // format.g:73:5: 'e'
                            {
                            match(input,49,FOLLOW_49_in_varspec376); 

                            x.sayscript_type = SS_script.SS_S_TYPE_ENUMERATION; form.elements.add(x);

                            }
                            break;
                        case 4 :
                            // format.g:74:5: 'f'
                            {
                            match(input,50,FOLLOW_50_in_varspec385); 

                            x.sayscript_type = SS_script.SS_S_TYPE_DATE_FORMAT; form.elements.add(x);

                            }
                            break;
                        case 5 :
                            // format.g:75:5: 'i'
                            {
                            match(input,53,FOLLOW_53_in_varspec393); 

                            x.sayscript_type = SS_script.SS_S_TYPE_DIGIT_STR; form.elements.add(x);

                            }
                            break;
                        case 6 :
                            // format.g:76:5: 'm'
                            {
                            match(input,57,FOLLOW_57_in_varspec402); 

                            x.sayscript_type = SS_script.SS_S_TYPE_MONEY; form.elements.add(x);

                            }
                            break;
                        case 7 :
                            // format.g:77:5: 'n'
                            {
                            match(input,58,FOLLOW_58_in_varspec411); 

                            x.sayscript_type = SS_script.SS_S_TYPE_NUMBER; form.elements.add(x);

                            }
                            break;
                        case 8 :
                            // format.g:78:5: 'p'
                            {
                            match(input,60,FOLLOW_60_in_varspec420); 

                            x.sayscript_type = SS_script.SS_S_TYPE_PHONETIC_STR; form.elements.add(x);

                            }
                            break;
                        case 9 :
                            // format.g:79:5: 'r'
                            {
                            match(input,62,FOLLOW_62_in_varspec429); 

                            x.sayscript_type = SS_script.SS_S_TYPE_REL_DATE_TIME; form.elements.add(x);

                            }
                            break;
                        case 10 :
                            // format.g:80:5: 's'
                            {
                            match(input,63,FOLLOW_63_in_varspec437); 

                            x.sayscript_type = SS_script.SS_S_TYPE_ALPHANUM_STR; form.elements.add(x);

                            }
                            break;
                        case 11 :
                            // format.g:81:5: 't'
                            {
                            match(input,64,FOLLOW_64_in_varspec446); 

                            x.sayscript_type = SS_script.SS_S_TYPE_TIME; form.elements.add(x);

                            }
                            break;
                        case 12 :
                            // format.g:82:5: 'z'
                            {
                            match(input,70,FOLLOW_70_in_varspec455); 

                            x.sayscript_type = SS_script.SS_S_TYPE_FILE; form.elements.add(x);

                            }
                            break;
                        case 13 :
                            // format.g:83:5: 'D'
                            {
                            match(input,22,FOLLOW_22_in_varspec463); 

                            x.sayscript_type = SS_script.SS_S_TYPE_DATE_TIME; form.elements.add(x);

                            }
                            break;
                        case 14 :
                            // format.g:84:6: 'a'
                            {
                            match(input,45,FOLLOW_45_in_varspec473); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("a"); form.elements.add(x); 

                            }
                            break;
                        case 15 :
                            // format.g:85:6: 'b'
                            {
                            match(input,46,FOLLOW_46_in_varspec482); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("b"); form.elements.add(x); 

                            }
                            break;
                        case 16 :
                            // format.g:86:6: 'g'
                            {
                            match(input,51,FOLLOW_51_in_varspec491); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("g"); form.elements.add(x); 

                            }
                            break;
                        case 17 :
                            // format.g:87:6: 'h'
                            {
                            match(input,52,FOLLOW_52_in_varspec500); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("h"); form.elements.add(x); 

                            }
                            break;
                        case 18 :
                            // format.g:88:6: 'j'
                            {
                            match(input,54,FOLLOW_54_in_varspec509); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("j"); form.elements.add(x); 

                            }
                            break;
                        case 19 :
                            // format.g:89:6: 'k'
                            {
                            match(input,55,FOLLOW_55_in_varspec518); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("k"); form.elements.add(x); 

                            }
                            break;
                        case 20 :
                            // format.g:90:6: 'l'
                            {
                            match(input,56,FOLLOW_56_in_varspec527); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("l"); form.elements.add(x); 

                            }
                            break;
                        case 21 :
                            // format.g:91:6: 'o'
                            {
                            match(input,59,FOLLOW_59_in_varspec536); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("o"); form.elements.add(x); 

                            }
                            break;
                        case 22 :
                            // format.g:92:6: 'q'
                            {
                            match(input,61,FOLLOW_61_in_varspec545); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("q"); form.elements.add(x); 

                            }
                            break;
                        case 23 :
                            // format.g:93:6: 'u'
                            {
                            match(input,65,FOLLOW_65_in_varspec554); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("u"); form.elements.add(x); 

                            }
                            break;
                        case 24 :
                            // format.g:94:6: 'v'
                            {
                            match(input,66,FOLLOW_66_in_varspec563); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("v"); form.elements.add(x); 

                            }
                            break;
                        case 25 :
                            // format.g:95:6: 'w'
                            {
                            match(input,67,FOLLOW_67_in_varspec572); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("w"); form.elements.add(x); 

                            }
                            break;
                        case 26 :
                            // format.g:96:6: 'x'
                            {
                            match(input,68,FOLLOW_68_in_varspec581); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("x"); form.elements.add(x); 

                            }
                            break;
                        case 27 :
                            // format.g:97:6: 'y'
                            {
                            match(input,69,FOLLOW_69_in_varspec590); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("y"); form.elements.add(x); 

                            }
                            break;
                        case 28 :
                            // format.g:98:6: 'A'
                            {
                            match(input,19,FOLLOW_19_in_varspec599); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("A"); form.elements.add(x); 

                            }
                            break;
                        case 29 :
                            // format.g:99:6: 'B'
                            {
                            match(input,20,FOLLOW_20_in_varspec608); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("B"); form.elements.add(x); 

                            }
                            break;
                        case 30 :
                            // format.g:100:6: 'C'
                            {
                            match(input,21,FOLLOW_21_in_varspec617); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("C"); form.elements.add(x); 

                            }
                            break;
                        case 31 :
                            // format.g:101:6: 'E'
                            {
                            match(input,23,FOLLOW_23_in_varspec626); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("E"); form.elements.add(x); 

                            }
                            break;
                        case 32 :
                            // format.g:102:6: 'F'
                            {
                            match(input,24,FOLLOW_24_in_varspec635); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("F"); form.elements.add(x); 

                            }
                            break;
                        case 33 :
                            // format.g:103:6: 'G'
                            {
                            match(input,25,FOLLOW_25_in_varspec644); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("G"); form.elements.add(x); 

                            }
                            break;
                        case 34 :
                            // format.g:104:6: 'H'
                            {
                            match(input,26,FOLLOW_26_in_varspec653); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("H"); form.elements.add(x); 

                            }
                            break;
                        case 35 :
                            // format.g:105:6: 'I'
                            {
                            match(input,27,FOLLOW_27_in_varspec662); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("I"); form.elements.add(x); 

                            }
                            break;
                        case 36 :
                            // format.g:106:6: 'J'
                            {
                            match(input,28,FOLLOW_28_in_varspec671); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("J"); form.elements.add(x); 

                            }
                            break;
                        case 37 :
                            // format.g:107:6: 'K'
                            {
                            match(input,29,FOLLOW_29_in_varspec680); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("K"); form.elements.add(x); 

                            }
                            break;
                        case 38 :
                            // format.g:108:6: 'L'
                            {
                            match(input,30,FOLLOW_30_in_varspec689); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("L"); form.elements.add(x); 

                            }
                            break;
                        case 39 :
                            // format.g:109:6: 'M'
                            {
                            match(input,31,FOLLOW_31_in_varspec698); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("M"); form.elements.add(x); 

                            }
                            break;
                        case 40 :
                            // format.g:110:6: 'N'
                            {
                            match(input,32,FOLLOW_32_in_varspec707); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("N"); form.elements.add(x); 

                            }
                            break;
                        case 41 :
                            // format.g:111:6: 'O'
                            {
                            match(input,33,FOLLOW_33_in_varspec716); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("O"); form.elements.add(x); 

                            }
                            break;
                        case 42 :
                            // format.g:112:6: 'P'
                            {
                            match(input,34,FOLLOW_34_in_varspec725); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("P"); form.elements.add(x); 

                            }
                            break;
                        case 43 :
                            // format.g:113:6: 'Q'
                            {
                            match(input,35,FOLLOW_35_in_varspec734); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("Q"); form.elements.add(x); 

                            }
                            break;
                        case 44 :
                            // format.g:114:6: 'R'
                            {
                            match(input,36,FOLLOW_36_in_varspec743); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("R"); form.elements.add(x); 

                            }
                            break;
                        case 45 :
                            // format.g:115:6: 'S'
                            {
                            match(input,37,FOLLOW_37_in_varspec752); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("S"); form.elements.add(x); 

                            }
                            break;
                        case 46 :
                            // format.g:116:6: 'T'
                            {
                            match(input,38,FOLLOW_38_in_varspec761); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("T"); form.elements.add(x); 

                            }
                            break;
                        case 47 :
                            // format.g:117:6: 'U'
                            {
                            match(input,39,FOLLOW_39_in_varspec770); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("U"); form.elements.add(x); 

                            }
                            break;
                        case 48 :
                            // format.g:118:6: 'V'
                            {
                            match(input,40,FOLLOW_40_in_varspec779); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("V"); form.elements.add(x); 

                            }
                            break;
                        case 49 :
                            // format.g:119:6: 'W'
                            {
                            match(input,41,FOLLOW_41_in_varspec788); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("W"); form.elements.add(x); 

                            }
                            break;
                        case 50 :
                            // format.g:120:6: 'X'
                            {
                            match(input,42,FOLLOW_42_in_varspec797); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("X"); form.elements.add(x); 

                            }
                            break;
                        case 51 :
                            // format.g:121:6: 'Y'
                            {
                            match(input,43,FOLLOW_43_in_varspec806); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("Y"); form.elements.add(x); 

                            }
                            break;
                        case 52 :
                            // format.g:122:6: 'Z'
                            {
                            match(input,44,FOLLOW_44_in_varspec815); 

                            x.sayscript_type = SS_script.SS_S_TYPE_USER_DEFINED; x.user_def_name = new String("Z"); form.elements.add(x); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // format.g:123:5: z=~ ( 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k' | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v' | 'w' | 'x' | 'y' | 'z' | 'A' | 'B' | 'C' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K' | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V' | 'W' | 'X' | 'Y' | 'Z' | '<' | ',' | ' ' | '+' | ';' | ':' | '.' | '?' )
                    {
                    z=(Token)input.LT(1);

                    if ( input.LA(1)==FILE||(input.LA(1) >= LBRACK && input.LA(1) <= RBRACK)||input.LA(1)==22 ) {
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
    // format.g:129:1: format[ArrayList<SS_log> loglist] returns [SS_format form] : (z= FILE | silence[form,loglist] | varspec[form,loglist] )+ ;
    public final SS_format format(ArrayList<SS_log> loglist) throws RecognitionException {
        SS_format form = null;


        Token z=null;

         form = new SS_format(); 
        try {
            // format.g:132:3: ( (z= FILE | silence[form,loglist] | varspec[form,loglist] )+ )
            // format.g:132:6: (z= FILE | silence[form,loglist] | varspec[form,loglist] )+
            {
            // format.g:132:6: (z= FILE | silence[form,loglist] | varspec[form,loglist] )+
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
                case 22:
                    {
                    alt6=3;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // format.g:132:7: z= FILE
            	    {
            	    z=(Token)match(input,FILE,FOLLOW_FILE_in_format987); 

            	    SS_format_element x = new SS_format_element(); 
            	    		   		   x.type = x.FE_TYPE_FILE; 
            	    		           x.file = new String((z!=null?z.getText():null).substring(1,(z!=null?z.getText():null).length()-1));
            	    				   /* System.out.println("Just added file "+x.file+" to the form"); */
            	    				   form.elements.add(x);
            	    				  

            	    }
            	    break;
            	case 2 :
            	    // format.g:139:5: silence[form,loglist]
            	    {
            	    pushFollow(FOLLOW_silence_in_format996);
            	    silence(form, loglist);

            	    state._fsp--;


            	    /* System.out.println("Just finished silence char");*/ 

            	    }
            	    break;
            	case 3 :
            	    // format.g:140:5: varspec[form,loglist]
            	    {
            	    pushFollow(FOLLOW_varspec_in_format1006);
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
    public static final BitSet FOLLOW_PERCENT_in_varspec314 = new BitSet(new long[]{0xFFFFFFFFFFF80180L,0x000000000000007FL});
    public static final BitSet FOLLOW_NUM_in_varspec334 = new BitSet(new long[]{0xFFFFFFFFFFF80100L,0x000000000000007FL});
    public static final BitSet FOLLOW_OPT_in_varspec343 = new BitSet(new long[]{0xFFFFFFFFFFF80000L,0x000000000000007FL});
    public static final BitSet FOLLOW_47_in_varspec358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_varspec367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_varspec376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_varspec385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_varspec393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_varspec402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_varspec411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_varspec420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_varspec429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_varspec437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_varspec446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_varspec455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_varspec463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_varspec473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_varspec482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_varspec491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_varspec500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_varspec509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_varspec518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_varspec527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_varspec536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_varspec545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_varspec554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_varspec563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_varspec572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_varspec581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_varspec590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_varspec599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_varspec608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_varspec617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_varspec626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_varspec635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_varspec644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_varspec653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_varspec662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_varspec671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_varspec680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_varspec689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_varspec698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_varspec707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_varspec716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_varspec725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_varspec734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_varspec743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_varspec752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_varspec761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_varspec770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_varspec779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_varspec788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_varspec797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_varspec806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_varspec815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_varspec826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILE_in_format987 = new BitSet(new long[]{0x000000000047FFD2L});
    public static final BitSet FOLLOW_silence_in_format996 = new BitSet(new long[]{0x000000000047FFD2L});
    public static final BitSet FOLLOW_varspec_in_format1006 = new BitSet(new long[]{0x000000000047FFD2L});

}