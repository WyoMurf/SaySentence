// $ANTLR 3.4 SayScript.g 2013-11-26 15:34:03

import java.util.regex.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SayScriptParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACT_CUT", "ACT_DONE", "ACT_NEGATE", "ACT_RANGE", "ACT_RESTART", "ACT_ZERO", "ANYDATE", "ATBEGIN", "ATEXIT", "COLON", "COMMA", "COMMENT", "DASH", "DATEFUT_GREATER", "DATEFUT_RANGE", "DATEPAST_GREATER", "DATEPAST_RANGE", "DAYAMOUNT", "EQUALS", "FE_Lsubr", "FE_Rsubr", "FE_date_century", "FE_date_decade", "FE_date_dom", "FE_date_dow", "FE_date_dowstr", "FE_date_month", "FE_date_monthstr", "FE_date_year", "FE_num", "FE_opt", "FE_time_12hour", "FE_time_12hour2d", "FE_time_24hour", "FE_time_24hour2d", "FE_time_ampm", "FE_time_cm", "FE_time_min", "FE_time_sec", "FE_time_tz", "FE_time_xm", "FE_timeval", "GREATER", "HDR_SILENCE", "HOUR_RANGE", "ID", "LANG", "LBRACK", "LCURLY", "LESS", "LPAR", "MINUTE_RANGE", "NEWLINE", "NOTOPT", "NOTVAR", "NUM", "NUMLEN", "OPT", "PAT", "PATHCONST", "PATTERN", "PERIOD", "PLUS", "QUESTION", "RANG", "RANGE", "RBRACK", "RCURLY", "RPAR", "SECOND_RANGE", "SEMICOLON", "VAR", "WHITE", "YEAR_PATTERN", "YEAR_RANGE"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public SayScriptParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public SayScriptParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return SayScriptParser.tokenNames; }
    public String getGrammarFileName() { return "SayScript.g"; }


    //public String getErrorMessage(RecognitionException e, String[] tokenNames)
    //{
    //	List stack = getRuleInvocationStack(e, this.getClass().getName());
    //	String msg = null;
    //	if ( e instanceof NoViableAltException ) 
    //	{
    //		NoViableAltException nvae = (NoViableAltException)e;
    //		msg = " no viable alt; token="+e.token+" (decision="+nvae.decisionNumber+" state "+nvae.stateNumber+")"+" decision=<<"+nvae.grammarDecisionDescription+">>";
    //	}
    //	else
    //	{
    //		msg = super.getErrorMessage(e,tokenNames);
    //	}
    //	return stack+" "+msg;
    //}
    //public String getTokenErrorDisplay(Token t)
    //{
    //	return t.toString();
    //}


    public static class oper_return extends ParserRuleReturnScope {
        public int x;
        public int line;
    };


    // $ANTLR start "oper"
    // SayScript.g:121:1: oper[SS_script script] returns [int x, int line] : (z= RANGE |z= PATTERN |z= GREATER |z= LESS |z= VAR |z= NOTVAR |z= NUMLEN |z= ATBEGIN |z= ATEXIT |z= DATEPAST_RANGE |z= DATEFUT_RANGE |z= DATEPAST_GREATER |z= DATEFUT_GREATER |z= ANYDATE |z= MINUTE_RANGE |z= SECOND_RANGE |z= HOUR_RANGE |z= YEAR_RANGE |z= OPT |z= NOTOPT |z= YEAR_PATTERN ) ;
    public final SayScriptParser.oper_return oper(SS_script script) throws RecognitionException {
        SayScriptParser.oper_return retval = new SayScriptParser.oper_return();
        retval.start = input.LT(1);


        Token z=null;

        try {
            // SayScript.g:123:6: ( (z= RANGE |z= PATTERN |z= GREATER |z= LESS |z= VAR |z= NOTVAR |z= NUMLEN |z= ATBEGIN |z= ATEXIT |z= DATEPAST_RANGE |z= DATEFUT_RANGE |z= DATEPAST_GREATER |z= DATEFUT_GREATER |z= ANYDATE |z= MINUTE_RANGE |z= SECOND_RANGE |z= HOUR_RANGE |z= YEAR_RANGE |z= OPT |z= NOTOPT |z= YEAR_PATTERN ) )
            // SayScript.g:123:8: (z= RANGE |z= PATTERN |z= GREATER |z= LESS |z= VAR |z= NOTVAR |z= NUMLEN |z= ATBEGIN |z= ATEXIT |z= DATEPAST_RANGE |z= DATEFUT_RANGE |z= DATEPAST_GREATER |z= DATEFUT_GREATER |z= ANYDATE |z= MINUTE_RANGE |z= SECOND_RANGE |z= HOUR_RANGE |z= YEAR_RANGE |z= OPT |z= NOTOPT |z= YEAR_PATTERN )
            {
            // SayScript.g:123:8: (z= RANGE |z= PATTERN |z= GREATER |z= LESS |z= VAR |z= NOTVAR |z= NUMLEN |z= ATBEGIN |z= ATEXIT |z= DATEPAST_RANGE |z= DATEFUT_RANGE |z= DATEPAST_GREATER |z= DATEFUT_GREATER |z= ANYDATE |z= MINUTE_RANGE |z= SECOND_RANGE |z= HOUR_RANGE |z= YEAR_RANGE |z= OPT |z= NOTOPT |z= YEAR_PATTERN )
            int alt1=21;
            switch ( input.LA(1) ) {
            case RANGE:
                {
                alt1=1;
                }
                break;
            case PATTERN:
                {
                alt1=2;
                }
                break;
            case GREATER:
                {
                alt1=3;
                }
                break;
            case LESS:
                {
                alt1=4;
                }
                break;
            case VAR:
                {
                alt1=5;
                }
                break;
            case NOTVAR:
                {
                alt1=6;
                }
                break;
            case NUMLEN:
                {
                alt1=7;
                }
                break;
            case ATBEGIN:
                {
                alt1=8;
                }
                break;
            case ATEXIT:
                {
                alt1=9;
                }
                break;
            case DATEPAST_RANGE:
                {
                alt1=10;
                }
                break;
            case DATEFUT_RANGE:
                {
                alt1=11;
                }
                break;
            case DATEPAST_GREATER:
                {
                alt1=12;
                }
                break;
            case DATEFUT_GREATER:
                {
                alt1=13;
                }
                break;
            case ANYDATE:
                {
                alt1=14;
                }
                break;
            case MINUTE_RANGE:
                {
                alt1=15;
                }
                break;
            case SECOND_RANGE:
                {
                alt1=16;
                }
                break;
            case HOUR_RANGE:
                {
                alt1=17;
                }
                break;
            case YEAR_RANGE:
                {
                alt1=18;
                }
                break;
            case OPT:
                {
                alt1=19;
                }
                break;
            case NOTOPT:
                {
                alt1=20;
                }
                break;
            case YEAR_PATTERN:
                {
                alt1=21;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // SayScript.g:123:9: z= RANGE
                    {
                    z=(Token)match(input,RANGE,FOLLOW_RANGE_in_oper714); 

                    retval.x =SS_op.SS_OP_TYPE_RANGE;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 2 :
                    // SayScript.g:123:62: z= PATTERN
                    {
                    z=(Token)match(input,PATTERN,FOLLOW_PATTERN_in_oper722); 

                    retval.x =SS_op.SS_OP_TYPE_PATTERN;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 3 :
                    // SayScript.g:124:8: z= GREATER
                    {
                    z=(Token)match(input,GREATER,FOLLOW_GREATER_in_oper735); 

                    retval.x =SS_op.SS_OP_TYPE_GREATER;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 4 :
                    // SayScript.g:124:65: z= LESS
                    {
                    z=(Token)match(input,LESS,FOLLOW_LESS_in_oper743); 

                    retval.x =SS_op.SS_OP_TYPE_LESS;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 5 :
                    // SayScript.g:124:116: z= VAR
                    {
                    z=(Token)match(input,VAR,FOLLOW_VAR_in_oper751); 

                    retval.x =SS_op.SS_OP_TYPE_VAR;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 6 :
                    // SayScript.g:124:165: z= NOTVAR
                    {
                    z=(Token)match(input,NOTVAR,FOLLOW_NOTVAR_in_oper759); 

                    retval.x =SS_op.SS_OP_TYPE_NOTVAR;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 7 :
                    // SayScript.g:125:14: z= NUMLEN
                    {
                    z=(Token)match(input,NUMLEN,FOLLOW_NUMLEN_in_oper778); 

                    retval.x =SS_op.SS_OP_TYPE_NUMLEN;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 8 :
                    // SayScript.g:125:68: z= ATBEGIN
                    {
                    z=(Token)match(input,ATBEGIN,FOLLOW_ATBEGIN_in_oper785); 

                    retval.x =SS_op.SS_OP_TYPE_ATBEGIN;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 9 :
                    // SayScript.g:125:124: z= ATEXIT
                    {
                    z=(Token)match(input,ATEXIT,FOLLOW_ATEXIT_in_oper792); 

                    retval.x =SS_op.SS_OP_TYPE_ATEXIT;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 10 :
                    // SayScript.g:126:14: z= DATEPAST_RANGE
                    {
                    z=(Token)match(input,DATEPAST_RANGE,FOLLOW_DATEPAST_RANGE_in_oper811); 

                    retval.x =SS_op.SS_OP_TYPE_DATEPAST_RANGE;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 11 :
                    // SayScript.g:126:84: z= DATEFUT_RANGE
                    {
                    z=(Token)match(input,DATEFUT_RANGE,FOLLOW_DATEFUT_RANGE_in_oper818); 

                    retval.x =SS_op.SS_OP_TYPE_DATEFUT_RANGE;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 12 :
                    // SayScript.g:127:14: z= DATEPAST_GREATER
                    {
                    z=(Token)match(input,DATEPAST_GREATER,FOLLOW_DATEPAST_GREATER_in_oper838); 

                    retval.x =SS_op.SS_OP_TYPE_DATEPAST_GREATER;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 13 :
                    // SayScript.g:128:14: z= DATEFUT_GREATER
                    {
                    z=(Token)match(input,DATEFUT_GREATER,FOLLOW_DATEFUT_GREATER_in_oper858); 

                    retval.x =SS_op.SS_OP_TYPE_DATEFUT_GREATER;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 14 :
                    // SayScript.g:129:14: z= ANYDATE
                    {
                    z=(Token)match(input,ANYDATE,FOLLOW_ANYDATE_in_oper877); 

                    retval.x =SS_op.SS_OP_TYPE_ANYDATE;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 15 :
                    // SayScript.g:129:71: z= MINUTE_RANGE
                    {
                    z=(Token)match(input,MINUTE_RANGE,FOLLOW_MINUTE_RANGE_in_oper885); 

                    retval.x =SS_op.SS_OP_TYPE_MINUTE_RANGE;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 16 :
                    // SayScript.g:129:139: z= SECOND_RANGE
                    {
                    z=(Token)match(input,SECOND_RANGE,FOLLOW_SECOND_RANGE_in_oper894); 

                    retval.x =SS_op.SS_OP_TYPE_SECOND_RANGE;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 17 :
                    // SayScript.g:130:14: z= HOUR_RANGE
                    {
                    z=(Token)match(input,HOUR_RANGE,FOLLOW_HOUR_RANGE_in_oper914); 

                    retval.x =SS_op.SS_OP_TYPE_HOUR_RANGE;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 18 :
                    // SayScript.g:130:77: z= YEAR_RANGE
                    {
                    z=(Token)match(input,YEAR_RANGE,FOLLOW_YEAR_RANGE_in_oper922); 

                    retval.x =SS_op.SS_OP_TYPE_YEAR_RANGE;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 19 :
                    // SayScript.g:130:140: z= OPT
                    {
                    z=(Token)match(input,OPT,FOLLOW_OPT_in_oper930); 

                    retval.x =SS_op.SS_OP_TYPE_OPT;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 20 :
                    // SayScript.g:131:14: z= NOTOPT
                    {
                    z=(Token)match(input,NOTOPT,FOLLOW_NOTOPT_in_oper950); 

                    retval.x =SS_op.SS_OP_TYPE_NOTOPT;retval.line =(z!=null?z.getLine():0);

                    }
                    break;
                case 21 :
                    // SayScript.g:131:69: z= YEAR_PATTERN
                    {
                    z=(Token)match(input,YEAR_PATTERN,FOLLOW_YEAR_PATTERN_in_oper958); 

                    retval.x =SS_op.SS_OP_TYPE_YEAR_PATTERN;retval.line =(z!=null?z.getLine():0);

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "oper"



    // $ANTLR start "oper_list"
    // SayScript.g:133:1: oper_list[SS_script script, SS_statement stat] : x= oper[$script] ( COMMA y= oper[script] )* ;
    public final void oper_list(SS_script script, SS_statement stat) throws RecognitionException {
        SayScriptParser.oper_return x =null;

        SayScriptParser.oper_return y =null;


        try {
            // SayScript.g:133:48: (x= oper[$script] ( COMMA y= oper[script] )* )
            // SayScript.g:133:50: x= oper[$script] ( COMMA y= oper[script] )*
            {
            pushFollow(FOLLOW_oper_in_oper_list972);
            x=oper(script);

            state._fsp--;



            			stat.lineno = (x!=null?x.line:0);
            			SS_op op = new SS_op((x!=null?x.x:0));
            			stat.oplist.add(op);
            		 

            // SayScript.g:138:6: ( COMMA y= oper[script] )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMMA) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SayScript.g:138:8: COMMA y= oper[script]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_oper_list989); 

            	    pushFollow(FOLLOW_oper_in_oper_list993);
            	    y=oper(script);

            	    state._fsp--;



            	    		    stat.lineno = (y!=null?y.line:0);
            	    			SS_op op2 = new SS_op((y!=null?y.x:0));
            	    			stat.oplist.add(op2);
            	             

            	    }
            	    break;

            	default :
            	    break loop2;
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
        return ;
    }
    // $ANTLR end "oper_list"



    // $ANTLR start "arg"
    // SayScript.g:146:1: arg[SS_script script, SS_statement stat] returns [SS_op_arg oa] : (t= NUM |u= ID |v= PAT |w= DAYAMOUNT ) ;
    public final SS_op_arg arg(SS_script script, SS_statement stat) throws RecognitionException {
        SS_op_arg oa = null;


        Token t=null;
        Token u=null;
        Token v=null;
        Token w=null;


        	  oa = new SS_op_arg();

        try {
            // SayScript.g:151:10: ( (t= NUM |u= ID |v= PAT |w= DAYAMOUNT ) )
            // SayScript.g:151:12: (t= NUM |u= ID |v= PAT |w= DAYAMOUNT )
            {
            // SayScript.g:151:12: (t= NUM |u= ID |v= PAT |w= DAYAMOUNT )
            int alt3=4;
            switch ( input.LA(1) ) {
            case NUM:
                {
                alt3=1;
                }
                break;
            case ID:
                {
                alt3=2;
                }
                break;
            case PAT:
                {
                alt3=3;
                }
                break;
            case DAYAMOUNT:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // SayScript.g:152:13: t= NUM
                    {
                    t=(Token)match(input,NUM,FOLLOW_NUM_in_arg1052); 

                    oa.num = Long.parseLong((t!=null?t.getText():null));

                    }
                    break;
                case 2 :
                    // SayScript.g:153:7: u= ID
                    {
                    u=(Token)match(input,ID,FOLLOW_ID_in_arg1065); 

                    oa.str=(u!=null?u.getText():null);

                    }
                    break;
                case 3 :
                    // SayScript.g:154:7: v= PAT
                    {
                    v=(Token)match(input,PAT,FOLLOW_PAT_in_arg1078); 

                    oa.pattern=(v!=null?v.getText():null).substring(1,(v!=null?v.getText():null).length()-1);
                    				  try {
                    						oa.preg = Pattern.compile(oa.pattern);
                    				   } catch (PatternSyntaxException pse) {
                    				   	 System.out.print("Wow! the pattern in line "+stat.lineno+" is bad! message="+pse.getMessage()+" and Desc: "+ pse.getDescription()+".\n");
                    					 /* should generate LOG here */
                    				   }
                    		   		 

                    }
                    break;
                case 4 :
                    // SayScript.g:162:7: w= DAYAMOUNT
                    {
                    w=(Token)match(input,DAYAMOUNT,FOLLOW_DAYAMOUNT_in_arg1090); 


                    					/* turn this into the number of days, getting rid of the suffix */
                    					Pattern dayabbrev = Pattern.compile("([0-9]+)([MmWwYy])");
                    					Matcher daymatch = dayabbrev.matcher((w!=null?w.getText():null));
                    					if (daymatch.matches())
                    					{
                    						long theNum = Long.parseLong(daymatch.group(1));
                    						String mult = daymatch.group(2);
                    						if (mult.equals("w") || mult.equals("W"))
                    						   theNum *= 7;
                    						else if (mult.equals("m") || mult.equals("M"))
                    						   theNum *= 30;
                                            else if (mult.equals("y") || mult.equals("Y"))
                    						   theNum *= 365;
                    						oa.num = theNum;
                    					}
                    				 

                    }
                    break;

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
        return oa;
    }
    // $ANTLR end "arg"



    // $ANTLR start "arglist"
    // SayScript.g:184:1: arglist[SS_script script, SS_statement stat] : p= arg[script, stat] ( COMMA q= arg[script, stat] )* ;
    public final void arglist(SS_script script, SS_statement stat) throws RecognitionException {
        SS_op_arg p =null;

        SS_op_arg q =null;


        try {
            // SayScript.g:184:46: (p= arg[script, stat] ( COMMA q= arg[script, stat] )* )
            // SayScript.g:184:48: p= arg[script, stat] ( COMMA q= arg[script, stat] )*
            {
            pushFollow(FOLLOW_arg_in_arglist1126);
            p=arg(script, stat);

            state._fsp--;


            stat.arglist.add(p);

            // SayScript.g:184:92: ( COMMA q= arg[script, stat] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==COMMA) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // SayScript.g:184:93: COMMA q= arg[script, stat]
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_arglist1133); 

            	    pushFollow(FOLLOW_arg_in_arglist1137);
            	    q=arg(script, stat);

            	    state._fsp--;


            	    stat.arglist.add(q);

            	    }
            	    break;

            	default :
            	    break loop4;
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
        return ;
    }
    // $ANTLR end "arglist"



    // $ANTLR start "file_var"
    // SayScript.g:186:1: file_var returns [SS_play_expr expr] : LCURLY ( ( FE_num | FE_opt COLON x= ID | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= NUM ( COLON z= NUM )? RBRACK )? | FE_timeval ) RCURLY ;
    public final SS_play_expr file_var() throws RecognitionException {
        SS_play_expr expr = null;


        Token x=null;
        Token y=null;
        Token z=null;


        	  expr = new SS_play_expr();

        try {
            // SayScript.g:191:18: ( LCURLY ( ( FE_num | FE_opt COLON x= ID | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= NUM ( COLON z= NUM )? RBRACK )? | FE_timeval ) RCURLY )
            // SayScript.g:191:20: LCURLY ( ( FE_num | FE_opt COLON x= ID | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= NUM ( COLON z= NUM )? RBRACK )? | FE_timeval ) RCURLY
            {
            match(input,LCURLY,FOLLOW_LCURLY_in_file_var1178); 

            // SayScript.g:191:27: ( ( FE_num | FE_opt COLON x= ID | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= NUM ( COLON z= NUM )? RBRACK )? | FE_timeval )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0 >= FE_date_century && LA8_0 <= FE_time_xm)) ) {
                alt8=1;
            }
            else if ( (LA8_0==FE_timeval) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // SayScript.g:191:29: ( FE_num | FE_opt COLON x= ID | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= NUM ( COLON z= NUM )? RBRACK )?
                    {
                    // SayScript.g:191:29: ( FE_num | FE_opt COLON x= ID | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade )
                    int alt5=20;
                    switch ( input.LA(1) ) {
                    case FE_num:
                        {
                        alt5=1;
                        }
                        break;
                    case FE_opt:
                        {
                        alt5=2;
                        }
                        break;
                    case FE_time_sec:
                        {
                        alt5=3;
                        }
                        break;
                    case FE_time_min:
                        {
                        alt5=4;
                        }
                        break;
                    case FE_time_12hour:
                        {
                        alt5=5;
                        }
                        break;
                    case FE_time_12hour2d:
                        {
                        alt5=6;
                        }
                        break;
                    case FE_time_24hour:
                        {
                        alt5=7;
                        }
                        break;
                    case FE_time_24hour2d:
                        {
                        alt5=8;
                        }
                        break;
                    case FE_time_ampm:
                        {
                        alt5=9;
                        }
                        break;
                    case FE_time_xm:
                        {
                        alt5=10;
                        }
                        break;
                    case FE_time_cm:
                        {
                        alt5=11;
                        }
                        break;
                    case FE_time_tz:
                        {
                        alt5=12;
                        }
                        break;
                    case FE_date_dom:
                        {
                        alt5=13;
                        }
                        break;
                    case FE_date_dow:
                        {
                        alt5=14;
                        }
                        break;
                    case FE_date_month:
                        {
                        alt5=15;
                        }
                        break;
                    case FE_date_dowstr:
                        {
                        alt5=16;
                        }
                        break;
                    case FE_date_monthstr:
                        {
                        alt5=17;
                        }
                        break;
                    case FE_date_year:
                        {
                        alt5=18;
                        }
                        break;
                    case FE_date_century:
                        {
                        alt5=19;
                        }
                        break;
                    case FE_date_decade:
                        {
                        alt5=20;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;

                    }

                    switch (alt5) {
                        case 1 :
                            // SayScript.g:191:30: FE_num
                            {
                            match(input,FE_num,FOLLOW_FE_num_in_file_var1183); 

                            expr.type = expr.SS_EXPR_NUM;

                            }
                            break;
                        case 2 :
                            // SayScript.g:191:70: FE_opt COLON x= ID
                            {
                            match(input,FE_opt,FOLLOW_FE_opt_in_file_var1188); 

                            match(input,COLON,FOLLOW_COLON_in_file_var1190); 

                            x=(Token)match(input,ID,FOLLOW_ID_in_file_var1194); 

                            expr.type = expr.SS_EXPR_OPT; expr.str = (x!=null?x.getText():null);

                            }
                            break;
                        case 3 :
                            // SayScript.g:192:20: FE_time_sec
                            {
                            match(input,FE_time_sec,FOLLOW_FE_time_sec_in_file_var1218); 

                            expr.type = expr.SS_EXPR_TIME_SEC;

                            }
                            break;
                        case 4 :
                            // SayScript.g:192:71: FE_time_min
                            {
                            match(input,FE_time_min,FOLLOW_FE_time_min_in_file_var1224); 

                            expr.type = expr.SS_EXPR_TIME_MIN;

                            }
                            break;
                        case 5 :
                            // SayScript.g:193:20: FE_time_12hour
                            {
                            match(input,FE_time_12hour,FOLLOW_FE_time_12hour_in_file_var1248); 

                            expr.type = expr.SS_EXPR_TIME_12HOUR;

                            }
                            break;
                        case 6 :
                            // SayScript.g:193:77: FE_time_12hour2d
                            {
                            match(input,FE_time_12hour2d,FOLLOW_FE_time_12hour2d_in_file_var1254); 

                            expr.type = expr.SS_EXPR_TIME_12HOUR2D;

                            }
                            break;
                        case 7 :
                            // SayScript.g:194:20: FE_time_24hour
                            {
                            match(input,FE_time_24hour,FOLLOW_FE_time_24hour_in_file_var1277); 

                            expr.type = expr.SS_EXPR_TIME_24HOUR;

                            }
                            break;
                        case 8 :
                            // SayScript.g:194:77: FE_time_24hour2d
                            {
                            match(input,FE_time_24hour2d,FOLLOW_FE_time_24hour2d_in_file_var1283); 

                            expr.type = expr.SS_EXPR_TIME_24HOUR2D;

                            }
                            break;
                        case 9 :
                            // SayScript.g:195:8: FE_time_ampm
                            {
                            match(input,FE_time_ampm,FOLLOW_FE_time_ampm_in_file_var1295); 

                            expr.type = expr.SS_EXPR_TIME_AMPM;

                            }
                            break;
                        case 10 :
                            // SayScript.g:196:20: FE_time_xm
                            {
                            match(input,FE_time_xm,FOLLOW_FE_time_xm_in_file_var1319); 

                            expr.type = expr.SS_EXPR_TIME_XM;

                            }
                            break;
                        case 11 :
                            // SayScript.g:196:69: FE_time_cm
                            {
                            match(input,FE_time_cm,FOLLOW_FE_time_cm_in_file_var1325); 

                            expr.type = expr.SS_EXPR_TIME_CM;

                            }
                            break;
                        case 12 :
                            // SayScript.g:196:118: FE_time_tz
                            {
                            match(input,FE_time_tz,FOLLOW_FE_time_tz_in_file_var1331); 

                            expr.type = expr.SS_EXPR_TIME_TZ;

                            }
                            break;
                        case 13 :
                            // SayScript.g:197:20: FE_date_dom
                            {
                            match(input,FE_date_dom,FOLLOW_FE_date_dom_in_file_var1354); 

                            expr.type = expr.SS_EXPR_DATE_DOM;

                            }
                            break;
                        case 14 :
                            // SayScript.g:197:71: FE_date_dow
                            {
                            match(input,FE_date_dow,FOLLOW_FE_date_dow_in_file_var1360); 

                            expr.type = expr.SS_EXPR_DATE_DOW;

                            }
                            break;
                        case 15 :
                            // SayScript.g:198:20: FE_date_month
                            {
                            match(input,FE_date_month,FOLLOW_FE_date_month_in_file_var1384); 

                            expr.type = expr.SS_EXPR_DATE_MONTH;

                            }
                            break;
                        case 16 :
                            // SayScript.g:198:75: FE_date_dowstr
                            {
                            match(input,FE_date_dowstr,FOLLOW_FE_date_dowstr_in_file_var1390); 

                            expr.type = expr.SS_EXPR_DATE_DOWSTR;

                            }
                            break;
                        case 17 :
                            // SayScript.g:199:20: FE_date_monthstr
                            {
                            match(input,FE_date_monthstr,FOLLOW_FE_date_monthstr_in_file_var1413); 

                            expr.type = expr.SS_EXPR_DATE_MONTHSTR;

                            }
                            break;
                        case 18 :
                            // SayScript.g:199:82: FE_date_year
                            {
                            match(input,FE_date_year,FOLLOW_FE_date_year_in_file_var1420); 

                            expr.type = expr.SS_EXPR_DATE_YEAR;

                            }
                            break;
                        case 19 :
                            // SayScript.g:200:8: FE_date_century
                            {
                            match(input,FE_date_century,FOLLOW_FE_date_century_in_file_var1433); 

                            expr.type = expr.SS_EXPR_DATE_CENT;

                            }
                            break;
                        case 20 :
                            // SayScript.g:200:65: FE_date_decade
                            {
                            match(input,FE_date_decade,FOLLOW_FE_date_decade_in_file_var1440); 

                            expr.type = expr.SS_EXPR_DATE_DECADE;

                            }
                            break;

                    }


                    // SayScript.g:201:21: ( LBRACK y= NUM ( COLON z= NUM )? RBRACK )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==LBRACK) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // SayScript.g:201:23: LBRACK y= NUM ( COLON z= NUM )? RBRACK
                            {
                            match(input,LBRACK,FOLLOW_LBRACK_in_file_var1470); 

                            y=(Token)match(input,NUM,FOLLOW_NUM_in_file_var1474); 

                            expr.range_type = expr.SS_EXPR_RANGE_START; expr.range_start = Integer.parseInt((y!=null?y.getText():null));

                            // SayScript.g:202:14: ( COLON z= NUM )?
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( (LA6_0==COLON) ) {
                                alt6=1;
                            }
                            switch (alt6) {
                                case 1 :
                                    // SayScript.g:202:15: COLON z= NUM
                                    {
                                    match(input,COLON,FOLLOW_COLON_in_file_var1493); 

                                    z=(Token)match(input,NUM,FOLLOW_NUM_in_file_var1497); 

                                    expr.range_type = expr.SS_EXPR_RANGE; expr.range_end = Integer.parseInt((z!=null?z.getText():null));

                                    }
                                    break;

                            }


                            match(input,RBRACK,FOLLOW_RBRACK_in_file_var1503); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // SayScript.g:203:20: FE_timeval
                    {
                    match(input,FE_timeval,FOLLOW_FE_timeval_in_file_var1528); 

                    expr.type = expr.SS_EXPR_TIMEVAL;

                    }
                    break;

            }


            match(input,RCURLY,FOLLOW_RCURLY_in_file_var1534); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "file_var"



    // $ANTLR start "subcall"
    // SayScript.g:206:1: subcall returns [SS_play_expr expr] : FE_Lsubr a= ID COLON (b= PATHCONST |c= file_var )* FE_Rsubr ;
    public final SS_play_expr subcall() throws RecognitionException {
        SS_play_expr expr = null;


        Token a=null;
        Token b=null;
        SS_play_expr c =null;



        	  expr = new SS_play_expr(); expr.subcall_exprlist = new ArrayList<SS_play_expr>();

        try {
            // SayScript.g:211:17: ( FE_Lsubr a= ID COLON (b= PATHCONST |c= file_var )* FE_Rsubr )
            // SayScript.g:211:19: FE_Lsubr a= ID COLON (b= PATHCONST |c= file_var )* FE_Rsubr
            {
            match(input,FE_Lsubr,FOLLOW_FE_Lsubr_in_subcall1571); 

            a=(Token)match(input,ID,FOLLOW_ID_in_subcall1575); 

            expr.type = expr.SS_EXPR_SUBCALL;expr.subcall_script_name = (a!=null?a.getText():null);

            match(input,COLON,FOLLOW_COLON_in_subcall1598); 

            // SayScript.g:212:25: (b= PATHCONST |c= file_var )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==PATHCONST) ) {
                    alt9=1;
                }
                else if ( (LA9_0==LCURLY) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // SayScript.g:212:26: b= PATHCONST
            	    {
            	    b=(Token)match(input,PATHCONST,FOLLOW_PATHCONST_in_subcall1603); 

            	    SS_play_expr b2 = new SS_play_expr(); b2.type=expr.SS_EXPR_STR_CONST;b2.str=(b!=null?b.getText():null); expr.subcall_exprlist.add(b2); 

            	    }
            	    break;
            	case 2 :
            	    // SayScript.g:213:29: c= file_var
            	    {
            	    pushFollow(FOLLOW_file_var_in_subcall1638);
            	    c=file_var();

            	    state._fsp--;


            	     expr.subcall_exprlist.add(c);

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match(input,FE_Rsubr,FOLLOW_FE_Rsubr_in_subcall1645); 



            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return expr;
    }
    // $ANTLR end "subcall"



    // $ANTLR start "file_element"
    // SayScript.g:217:1: file_element[SS_statement stat] : (a= PATHCONST |b= ID |c= file_var |d= subcall |e= NUM );
    public final void file_element(SS_statement stat) throws RecognitionException {
        Token a=null;
        Token b=null;
        Token e=null;
        SS_play_expr c =null;

        SS_play_expr d =null;


        try {
            // SayScript.g:218:9: (a= PATHCONST |b= ID |c= file_var |d= subcall |e= NUM )
            int alt10=5;
            switch ( input.LA(1) ) {
            case PATHCONST:
                {
                alt10=1;
                }
                break;
            case ID:
                {
                alt10=2;
                }
                break;
            case LCURLY:
                {
                alt10=3;
                }
                break;
            case FE_Lsubr:
                {
                alt10=4;
                }
                break;
            case NUM:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // SayScript.g:218:11: a= PATHCONST
                    {
                    a=(Token)match(input,PATHCONST,FOLLOW_PATHCONST_in_file_element1673); 

                    SS_play_expr b2 = new SS_play_expr(); b2.type=SS_play_expr.SS_EXPR_STR_CONST;b2.str=(a!=null?a.getText():null); stat.playlist.add(b2);

                    }
                    break;
                case 2 :
                    // SayScript.g:219:11: b= ID
                    {
                    b=(Token)match(input,ID,FOLLOW_ID_in_file_element1690); 

                    SS_play_expr b2 = new SS_play_expr(); b2.type=SS_play_expr.SS_EXPR_STR_CONST;b2.str=(b!=null?b.getText():null); stat.playlist.add(b2);

                    }
                    break;
                case 3 :
                    // SayScript.g:220:11: c= file_var
                    {
                    pushFollow(FOLLOW_file_var_in_file_element1706);
                    c=file_var();

                    state._fsp--;


                    stat.playlist.add(c);

                    }
                    break;
                case 4 :
                    // SayScript.g:221:11: d= subcall
                    {
                    pushFollow(FOLLOW_subcall_in_file_element1723);
                    d=subcall();

                    state._fsp--;


                    stat.playlist.add(d);

                    }
                    break;
                case 5 :
                    // SayScript.g:222:11: e= NUM
                    {
                    e=(Token)match(input,NUM,FOLLOW_NUM_in_file_element1740); 

                    SS_play_expr e2 = new SS_play_expr(); e2.type=SS_play_expr.SS_EXPR_STR_CONST;e2.str=(e!=null?e.getText():null); stat.playlist.add(e2);

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
    // $ANTLR end "file_element"



    // $ANTLR start "file_silence"
    // SayScript.g:225:1: file_silence[SS_statement stat] : ( COLON | COMMA | PERIOD | PLUS | SEMICOLON | QUESTION );
    public final void file_silence(SS_statement stat) throws RecognitionException {

        	  SS_play_expr expr = new SS_play_expr();

        try {
            // SayScript.g:229:5: ( COLON | COMMA | PERIOD | PLUS | SEMICOLON | QUESTION )
            int alt11=6;
            switch ( input.LA(1) ) {
            case COLON:
                {
                alt11=1;
                }
                break;
            case COMMA:
                {
                alt11=2;
                }
                break;
            case PERIOD:
                {
                alt11=3;
                }
                break;
            case PLUS:
                {
                alt11=4;
                }
                break;
            case SEMICOLON:
                {
                alt11=5;
                }
                break;
            case QUESTION:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // SayScript.g:229:7: COLON
                    {
                    match(input,COLON,FOLLOW_COLON_in_file_silence1769); 

                    expr.type=expr.SS_EXPR_SILENCE_COLON; stat.playlist.add(expr);

                    }
                    break;
                case 2 :
                    // SayScript.g:230:7: COMMA
                    {
                    match(input,COMMA,FOLLOW_COMMA_in_file_silence1779); 

                    expr.type=expr.SS_EXPR_SILENCE_COMMA; stat.playlist.add(expr);

                    }
                    break;
                case 3 :
                    // SayScript.g:231:7: PERIOD
                    {
                    match(input,PERIOD,FOLLOW_PERIOD_in_file_silence1789); 

                    expr.type=expr.SS_EXPR_SILENCE_PERIOD; stat.playlist.add(expr);

                    }
                    break;
                case 4 :
                    // SayScript.g:232:7: PLUS
                    {
                    match(input,PLUS,FOLLOW_PLUS_in_file_silence1799); 

                    expr.type=expr.SS_EXPR_SILENCE_PLUS; stat.playlist.add(expr);

                    }
                    break;
                case 5 :
                    // SayScript.g:233:7: SEMICOLON
                    {
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_file_silence1809); 

                    expr.type=expr.SS_EXPR_SILENCE_SEMICOLON; stat.playlist.add(expr);

                    }
                    break;
                case 6 :
                    // SayScript.g:234:7: QUESTION
                    {
                    match(input,QUESTION,FOLLOW_QUESTION_in_file_silence1819); 

                    expr.type=expr.SS_EXPR_SILENCE_QUESTION; stat.playlist.add(expr);

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
    // $ANTLR end "file_silence"



    // $ANTLR start "file_expr"
    // SayScript.g:238:1: file_expr[SS_statement stat] : ( file_element[stat] | file_silence[stat] )+ ;
    public final void file_expr(SS_statement stat) throws RecognitionException {
        try {
            // SayScript.g:238:30: ( ( file_element[stat] | file_silence[stat] )+ )
            // SayScript.g:238:32: ( file_element[stat] | file_silence[stat] )+
            {
            // SayScript.g:238:32: ( file_element[stat] | file_silence[stat] )+
            int cnt12=0;
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==FE_Lsubr||LA12_0==ID||LA12_0==LCURLY||LA12_0==NUM||LA12_0==PATHCONST) ) {
                    alt12=1;
                }
                else if ( ((LA12_0 >= COLON && LA12_0 <= COMMA)||(LA12_0 >= PERIOD && LA12_0 <= QUESTION)||LA12_0==SEMICOLON) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // SayScript.g:238:33: file_element[stat]
            	    {
            	    pushFollow(FOLLOW_file_element_in_file_expr1837);
            	    file_element(stat);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // SayScript.g:238:54: file_silence[stat]
            	    {
            	    pushFollow(FOLLOW_file_silence_in_file_expr1842);
            	    file_silence(stat);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
        return ;
    }
    // $ANTLR end "file_expr"



    // $ANTLR start "varset"
    // SayScript.g:242:1: varset[SS_statement stat] : a= ID EQUALS (b= ID |c= NUM ) ( COMMA d= ID EQUALS (e= ID |f= NUM ) )* ;
    public final void varset(SS_statement stat) throws RecognitionException {
        Token a=null;
        Token b=null;
        Token c=null;
        Token d=null;
        Token e=null;
        Token f=null;


        	  

        try {
            // SayScript.g:246:6: (a= ID EQUALS (b= ID |c= NUM ) ( COMMA d= ID EQUALS (e= ID |f= NUM ) )* )
            // SayScript.g:246:8: a= ID EQUALS (b= ID |c= NUM ) ( COMMA d= ID EQUALS (e= ID |f= NUM ) )*
            {
            a=(Token)match(input,ID,FOLLOW_ID_in_varset1879); 

            match(input,EQUALS,FOLLOW_EQUALS_in_varset1881); 

            // SayScript.g:246:20: (b= ID |c= NUM )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ID) ) {
                alt13=1;
            }
            else if ( (LA13_0==NUM) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // SayScript.g:246:21: b= ID
                    {
                    b=(Token)match(input,ID,FOLLOW_ID_in_varset1886); 

                      
                    						 SS_vardef var = new SS_vardef(); 
                    					  	 var.varname = (a!=null?a.getText():null); 
                    						 var.varval = (b!=null?b.getText():null); 
                    						 stat.varlist.add(var);
                    					  

                    }
                    break;
                case 2 :
                    // SayScript.g:253:8: c= NUM
                    {
                    c=(Token)match(input,NUM,FOLLOW_NUM_in_varset1908); 


                    						 SS_vardef var = new SS_vardef(); 
                    					  	 var.varname = (a!=null?a.getText():null); 
                    						 var.varval = (c!=null?c.getText():null); 
                    						 stat.varlist.add(var);
                    					  

                    }
                    break;

            }


            // SayScript.g:259:12: ( COMMA d= ID EQUALS (e= ID |f= NUM ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMMA) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // SayScript.g:259:13: COMMA d= ID EQUALS (e= ID |f= NUM )
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_varset1923); 

            	    d=(Token)match(input,ID,FOLLOW_ID_in_varset1927); 

            	    match(input,EQUALS,FOLLOW_EQUALS_in_varset1929); 

            	    // SayScript.g:259:31: (e= ID |f= NUM )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( (LA14_0==ID) ) {
            	        alt14=1;
            	    }
            	    else if ( (LA14_0==NUM) ) {
            	        alt14=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // SayScript.g:259:32: e= ID
            	            {
            	            e=(Token)match(input,ID,FOLLOW_ID_in_varset1934); 


            	            						 SS_vardef var = new SS_vardef(); 
            	            					  	 var.varname = (d!=null?d.getText():null); 
            	            						 var.varval = (e!=null?e.getText():null); 
            	            						 stat.varlist.add(var);
            	            					  

            	            }
            	            break;
            	        case 2 :
            	            // SayScript.g:266:8: f= NUM
            	            {
            	            f=(Token)match(input,NUM,FOLLOW_NUM_in_varset1956); 


            	            						 SS_vardef var = new SS_vardef(); 
            	            					  	 var.varname = (d!=null?d.getText():null); 
            	            						 var.varval = (f!=null?f.getText():null); 
            	            						 stat.varlist.add(var);
            	            					  

            	            }
            	            break;

            	    }


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
        return ;
    }
    // $ANTLR end "varset"



    // $ANTLR start "action"
    // SayScript.g:275:1: action[SS_statement stat] : ( ACT_DONE | ACT_RANGE | ACT_RESTART | ACT_NEGATE | ACT_CUT LPAR a= NUM RPAR | ACT_ZERO LPAR a= NUM RPAR );
    public final void action(SS_statement stat) throws RecognitionException {
        Token a=null;

        try {
            // SayScript.g:276:6: ( ACT_DONE | ACT_RANGE | ACT_RESTART | ACT_NEGATE | ACT_CUT LPAR a= NUM RPAR | ACT_ZERO LPAR a= NUM RPAR )
            int alt16=6;
            switch ( input.LA(1) ) {
            case ACT_DONE:
                {
                alt16=1;
                }
                break;
            case ACT_RANGE:
                {
                alt16=2;
                }
                break;
            case ACT_RESTART:
                {
                alt16=3;
                }
                break;
            case ACT_NEGATE:
                {
                alt16=4;
                }
                break;
            case ACT_CUT:
                {
                alt16=5;
                }
                break;
            case ACT_ZERO:
                {
                alt16=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // SayScript.g:276:8: ACT_DONE
                    {
                    match(input,ACT_DONE,FOLLOW_ACT_DONE_in_action1992); 

                    stat.action.action_type = SS_action.SS_ACTION_DONE; 

                    }
                    break;
                case 2 :
                    // SayScript.g:277:8: ACT_RANGE
                    {
                    match(input,ACT_RANGE,FOLLOW_ACT_RANGE_in_action2003); 

                    stat.action.action_type = SS_action.SS_ACTION_RANGE_ERROR;

                    }
                    break;
                case 3 :
                    // SayScript.g:278:8: ACT_RESTART
                    {
                    match(input,ACT_RESTART,FOLLOW_ACT_RESTART_in_action2014); 

                    stat.action.action_type = SS_action.SS_ACTION_RESTART;

                    }
                    break;
                case 4 :
                    // SayScript.g:279:8: ACT_NEGATE
                    {
                    match(input,ACT_NEGATE,FOLLOW_ACT_NEGATE_in_action2025); 

                    stat.action.action_type = SS_action.SS_ACTION_NEGATE;

                    }
                    break;
                case 5 :
                    // SayScript.g:280:8: ACT_CUT LPAR a= NUM RPAR
                    {
                    match(input,ACT_CUT,FOLLOW_ACT_CUT_in_action2037); 

                    match(input,LPAR,FOLLOW_LPAR_in_action2039); 

                    a=(Token)match(input,NUM,FOLLOW_NUM_in_action2043); 

                    match(input,RPAR,FOLLOW_RPAR_in_action2045); 

                    stat.action.action_type = SS_action.SS_ACTION_CUT; stat.action.arg = Integer.parseInt((a!=null?a.getText():null));

                    }
                    break;
                case 6 :
                    // SayScript.g:281:8: ACT_ZERO LPAR a= NUM RPAR
                    {
                    match(input,ACT_ZERO,FOLLOW_ACT_ZERO_in_action2056); 

                    match(input,LPAR,FOLLOW_LPAR_in_action2058); 

                    a=(Token)match(input,NUM,FOLLOW_NUM_in_action2062); 

                    match(input,RPAR,FOLLOW_RPAR_in_action2064); 

                    stat.action.action_type = SS_action.SS_ACTION_ZERO; stat.action.arg = Integer.parseInt((a!=null?a.getText():null));

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
    // $ANTLR end "action"



    // $ANTLR start "statement"
    // SayScript.g:284:1: statement[SS_scriptset scriptset, SS_script script] : ( WHITE )? ( ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) ) | ( COMMENT | NEWLINE ) ) ;
    public final void statement(SS_scriptset scriptset, SS_script script) throws RecognitionException {
         SS_statement stat = new SS_statement(); 
        try {
            // SayScript.g:286:11: ( ( WHITE )? ( ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) ) | ( COMMENT | NEWLINE ) ) )
            // SayScript.g:286:13: ( WHITE )? ( ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) ) | ( COMMENT | NEWLINE ) )
            {
            // SayScript.g:286:13: ( WHITE )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==WHITE) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // SayScript.g:286:13: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_statement2097); 

                    }
                    break;

            }


            // SayScript.g:286:20: ( ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) ) | ( COMMENT | NEWLINE ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0 >= ANYDATE && LA22_0 <= ATEXIT)||(LA22_0 >= DATEFUT_GREATER && LA22_0 <= DATEPAST_RANGE)||LA22_0==GREATER||LA22_0==HOUR_RANGE||LA22_0==LESS||LA22_0==MINUTE_RANGE||(LA22_0 >= NOTOPT && LA22_0 <= NOTVAR)||(LA22_0 >= NUMLEN && LA22_0 <= OPT)||LA22_0==PATTERN||LA22_0==RANGE||LA22_0==SECOND_RANGE||LA22_0==VAR||(LA22_0 >= YEAR_PATTERN && LA22_0 <= YEAR_RANGE)) ) {
                alt22=1;
            }
            else if ( (LA22_0==COMMENT||LA22_0==NEWLINE) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // SayScript.g:286:21: ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) )
                    {
                    // SayScript.g:286:21: ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) )
                    // SayScript.g:286:22: oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT )
                    {
                    pushFollow(FOLLOW_oper_list_in_statement2102);
                    oper_list(script, stat);

                    state._fsp--;


                    match(input,WHITE,FOLLOW_WHITE_in_statement2105); 

                    // SayScript.g:286:51: ( arglist[script,stat] | DASH )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==DAYAMOUNT||LA18_0==ID||LA18_0==NUM||LA18_0==PAT) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==DASH) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;

                    }
                    switch (alt18) {
                        case 1 :
                            // SayScript.g:286:52: arglist[script,stat]
                            {
                            pushFollow(FOLLOW_arglist_in_statement2108);
                            arglist(script, stat);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // SayScript.g:286:75: DASH
                            {
                            match(input,DASH,FOLLOW_DASH_in_statement2113); 

                            }
                            break;

                    }


                    match(input,WHITE,FOLLOW_WHITE_in_statement2116); 

                    // SayScript.g:286:87: ( file_expr[stat] | DASH )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( ((LA19_0 >= COLON && LA19_0 <= COMMA)||LA19_0==FE_Lsubr||LA19_0==ID||LA19_0==LCURLY||LA19_0==NUM||LA19_0==PATHCONST||(LA19_0 >= PERIOD && LA19_0 <= QUESTION)||LA19_0==SEMICOLON) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==DASH) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;

                    }
                    switch (alt19) {
                        case 1 :
                            // SayScript.g:286:88: file_expr[stat]
                            {
                            pushFollow(FOLLOW_file_expr_in_statement2119);
                            file_expr(stat);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // SayScript.g:286:106: DASH
                            {
                            match(input,DASH,FOLLOW_DASH_in_statement2124); 

                            }
                            break;

                    }


                    match(input,WHITE,FOLLOW_WHITE_in_statement2127); 

                    // SayScript.g:286:118: ( varset[stat] | DASH )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==ID) ) {
                        alt20=1;
                    }
                    else if ( (LA20_0==DASH) ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;

                    }
                    switch (alt20) {
                        case 1 :
                            // SayScript.g:286:119: varset[stat]
                            {
                            pushFollow(FOLLOW_varset_in_statement2130);
                            varset(stat);

                            state._fsp--;


                            }
                            break;
                        case 2 :
                            // SayScript.g:286:134: DASH
                            {
                            match(input,DASH,FOLLOW_DASH_in_statement2135); 

                            }
                            break;

                    }


                    match(input,WHITE,FOLLOW_WHITE_in_statement2138); 

                    pushFollow(FOLLOW_action_in_statement2140);
                    action(stat);

                    state._fsp--;


                    // SayScript.g:286:159: ( WHITE )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==WHITE) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // SayScript.g:286:159: WHITE
                            {
                            match(input,WHITE,FOLLOW_WHITE_in_statement2143); 

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
                    break;
                case 2 :
                    // SayScript.g:286:189: ( COMMENT | NEWLINE )
                    {
                    if ( input.LA(1)==COMMENT||input.LA(1)==NEWLINE ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;

            }


            if(!stat.oplist.isEmpty())script.statement_list.add(stat);

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
    // $ANTLR end "statement"



    // $ANTLR start "bad_statement"
    // SayScript.g:289:1: bad_statement[SS_scriptset scriptset] : x= ID ( WHITE | COMMA | RANGE | PATTERN | GREATER | LESS | NUMLEN | ATBEGIN | DATEPAST_RANGE | DATEFUT_RANGE | DATEPAST_GREATER | DATEFUT_GREATER | ANYDATE | MINUTE_RANGE | HOUR_RANGE | YEAR_RANGE | NOTOPT | YEAR_PATTERN | VAR | NOTVAR | ATEXIT | SECOND_RANGE | OPT | NUM | ID | DAYAMOUNT | PATHCONST | LCURLY | RCURLY | FE_num | COLON | LBRACK | RBRACK | FE_opt | FE_time_sec | FE_time_12hour | FE_time_24hour | FE_time_ampm | FE_time_xm | FE_date_dom | FE_date_month | FE_date_monthstr | FE_date_century | FE_timeval | FE_time_min | FE_time_12hour2d | FE_time_24hour2d | FE_time_cm | FE_date_dow | FE_date_dowstr | FE_date_year | FE_date_decade | FE_time_tz | FE_Lsubr | FE_Rsubr | PERIOD | PLUS | SEMICOLON | QUESTION | PAT | DASH | ACT_DONE | ACT_RESTART | ACT_CUT | ACT_RANGE | LPAR | RPAR )* ( COMMENT | NEWLINE )+ ;
    public final void bad_statement(SS_scriptset scriptset) throws RecognitionException {
        Token x=null;

        try {
            // SayScript.g:290:3: (x= ID ( WHITE | COMMA | RANGE | PATTERN | GREATER | LESS | NUMLEN | ATBEGIN | DATEPAST_RANGE | DATEFUT_RANGE | DATEPAST_GREATER | DATEFUT_GREATER | ANYDATE | MINUTE_RANGE | HOUR_RANGE | YEAR_RANGE | NOTOPT | YEAR_PATTERN | VAR | NOTVAR | ATEXIT | SECOND_RANGE | OPT | NUM | ID | DAYAMOUNT | PATHCONST | LCURLY | RCURLY | FE_num | COLON | LBRACK | RBRACK | FE_opt | FE_time_sec | FE_time_12hour | FE_time_24hour | FE_time_ampm | FE_time_xm | FE_date_dom | FE_date_month | FE_date_monthstr | FE_date_century | FE_timeval | FE_time_min | FE_time_12hour2d | FE_time_24hour2d | FE_time_cm | FE_date_dow | FE_date_dowstr | FE_date_year | FE_date_decade | FE_time_tz | FE_Lsubr | FE_Rsubr | PERIOD | PLUS | SEMICOLON | QUESTION | PAT | DASH | ACT_DONE | ACT_RESTART | ACT_CUT | ACT_RANGE | LPAR | RPAR )* ( COMMENT | NEWLINE )+ )
            // SayScript.g:291:3: x= ID ( WHITE | COMMA | RANGE | PATTERN | GREATER | LESS | NUMLEN | ATBEGIN | DATEPAST_RANGE | DATEFUT_RANGE | DATEPAST_GREATER | DATEFUT_GREATER | ANYDATE | MINUTE_RANGE | HOUR_RANGE | YEAR_RANGE | NOTOPT | YEAR_PATTERN | VAR | NOTVAR | ATEXIT | SECOND_RANGE | OPT | NUM | ID | DAYAMOUNT | PATHCONST | LCURLY | RCURLY | FE_num | COLON | LBRACK | RBRACK | FE_opt | FE_time_sec | FE_time_12hour | FE_time_24hour | FE_time_ampm | FE_time_xm | FE_date_dom | FE_date_month | FE_date_monthstr | FE_date_century | FE_timeval | FE_time_min | FE_time_12hour2d | FE_time_24hour2d | FE_time_cm | FE_date_dow | FE_date_dowstr | FE_date_year | FE_date_decade | FE_time_tz | FE_Lsubr | FE_Rsubr | PERIOD | PLUS | SEMICOLON | QUESTION | PAT | DASH | ACT_DONE | ACT_RESTART | ACT_CUT | ACT_RANGE | LPAR | RPAR )* ( COMMENT | NEWLINE )+
            {
            x=(Token)match(input,ID,FOLLOW_ID_in_bad_statement2186); 

            // SayScript.g:291:8: ( WHITE | COMMA | RANGE | PATTERN | GREATER | LESS | NUMLEN | ATBEGIN | DATEPAST_RANGE | DATEFUT_RANGE | DATEPAST_GREATER | DATEFUT_GREATER | ANYDATE | MINUTE_RANGE | HOUR_RANGE | YEAR_RANGE | NOTOPT | YEAR_PATTERN | VAR | NOTVAR | ATEXIT | SECOND_RANGE | OPT | NUM | ID | DAYAMOUNT | PATHCONST | LCURLY | RCURLY | FE_num | COLON | LBRACK | RBRACK | FE_opt | FE_time_sec | FE_time_12hour | FE_time_24hour | FE_time_ampm | FE_time_xm | FE_date_dom | FE_date_month | FE_date_monthstr | FE_date_century | FE_timeval | FE_time_min | FE_time_12hour2d | FE_time_24hour2d | FE_time_cm | FE_date_dow | FE_date_dowstr | FE_date_year | FE_date_decade | FE_time_tz | FE_Lsubr | FE_Rsubr | PERIOD | PLUS | SEMICOLON | QUESTION | PAT | DASH | ACT_DONE | ACT_RESTART | ACT_CUT | ACT_RANGE | LPAR | RPAR )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= ACT_CUT && LA23_0 <= ACT_DONE)||(LA23_0 >= ACT_RANGE && LA23_0 <= ACT_RESTART)||(LA23_0 >= ANYDATE && LA23_0 <= COMMA)||(LA23_0 >= DASH && LA23_0 <= DAYAMOUNT)||(LA23_0 >= FE_Lsubr && LA23_0 <= GREATER)||(LA23_0 >= HOUR_RANGE && LA23_0 <= ID)||(LA23_0 >= LBRACK && LA23_0 <= MINUTE_RANGE)||(LA23_0 >= NOTOPT && LA23_0 <= QUESTION)||(LA23_0 >= RANGE && LA23_0 <= YEAR_RANGE)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // SayScript.g:
            	    {
            	    if ( (input.LA(1) >= ACT_CUT && input.LA(1) <= ACT_DONE)||(input.LA(1) >= ACT_RANGE && input.LA(1) <= ACT_RESTART)||(input.LA(1) >= ANYDATE && input.LA(1) <= COMMA)||(input.LA(1) >= DASH && input.LA(1) <= DAYAMOUNT)||(input.LA(1) >= FE_Lsubr && input.LA(1) <= GREATER)||(input.LA(1) >= HOUR_RANGE && input.LA(1) <= ID)||(input.LA(1) >= LBRACK && input.LA(1) <= MINUTE_RANGE)||(input.LA(1) >= NOTOPT && input.LA(1) <= QUESTION)||(input.LA(1) >= RANGE && input.LA(1) <= YEAR_RANGE) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            // SayScript.g:298:122: ( COMMENT | NEWLINE )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==COMMENT||LA24_0==NEWLINE) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // SayScript.g:
            	    {
            	    if ( input.LA(1)==COMMENT||input.LA(1)==NEWLINE ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);



            			SS_log log = new SS_log((x!=null?x.getLine():0), (x!=null?x.getCharPositionInLine():0), "Syntax Error", "Expecting an OP, but got '"+(x!=null?x.getText():null)+"' instead! This line ignored!");
            			scriptset.log_list.add(log);
            		

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
    // $ANTLR end "bad_statement"



    // $ANTLR start "statement_list"
    // SayScript.g:305:1: statement_list[SS_scriptset scriptset, SS_script script] : ( statement[scriptset,script] | bad_statement[scriptset] )+ ;
    public final void statement_list(SS_scriptset scriptset, SS_script script) throws RecognitionException {
        try {
            // SayScript.g:305:58: ( ( statement[scriptset,script] | bad_statement[scriptset] )+ )
            // SayScript.g:305:60: ( statement[scriptset,script] | bad_statement[scriptset] )+
            {
            // SayScript.g:305:60: ( statement[scriptset,script] | bad_statement[scriptset] )+
            int cnt25=0;
            loop25:
            do {
                int alt25=3;
                switch ( input.LA(1) ) {
                case WHITE:
                    {
                    int LA25_2 = input.LA(2);

                    if ( ((LA25_2 >= ANYDATE && LA25_2 <= ATEXIT)||LA25_2==COMMENT||(LA25_2 >= DATEFUT_GREATER && LA25_2 <= DATEPAST_RANGE)||LA25_2==GREATER||LA25_2==HOUR_RANGE||LA25_2==LESS||(LA25_2 >= MINUTE_RANGE && LA25_2 <= NOTVAR)||(LA25_2 >= NUMLEN && LA25_2 <= OPT)||LA25_2==PATTERN||LA25_2==RANGE||LA25_2==SECOND_RANGE||LA25_2==VAR||(LA25_2 >= YEAR_PATTERN && LA25_2 <= YEAR_RANGE)) ) {
                        alt25=1;
                    }


                    }
                    break;
                case ANYDATE:
                case ATBEGIN:
                case ATEXIT:
                case COMMENT:
                case DATEFUT_GREATER:
                case DATEFUT_RANGE:
                case DATEPAST_GREATER:
                case DATEPAST_RANGE:
                case GREATER:
                case HOUR_RANGE:
                case LESS:
                case MINUTE_RANGE:
                case NEWLINE:
                case NOTOPT:
                case NOTVAR:
                case NUMLEN:
                case OPT:
                case PATTERN:
                case RANGE:
                case SECOND_RANGE:
                case VAR:
                case YEAR_PATTERN:
                case YEAR_RANGE:
                    {
                    alt25=1;
                    }
                    break;
                case ID:
                    {
                    alt25=2;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // SayScript.g:305:61: statement[scriptset,script]
            	    {
            	    pushFollow(FOLLOW_statement_in_statement_list2543);
            	    statement(scriptset, script);

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // SayScript.g:305:91: bad_statement[scriptset]
            	    {
            	    pushFollow(FOLLOW_bad_statement_in_statement_list2548);
            	    bad_statement(scriptset);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
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
        return ;
    }
    // $ANTLR end "statement_list"



    // $ANTLR start "header"
    // SayScript.g:307:1: header[SS_scriptset scriptset, SS_script script] : ( WHITE )? LBRACK x= ID ( COMMA y= ID )* RBRACK ( WHITE )? ( NEWLINE | COMMENT ) ;
    public final void header(SS_scriptset scriptset, SS_script script) throws RecognitionException {
        Token x=null;
        Token y=null;

        try {
            // SayScript.g:307:50: ( ( WHITE )? LBRACK x= ID ( COMMA y= ID )* RBRACK ( WHITE )? ( NEWLINE | COMMENT ) )
            // SayScript.g:307:52: ( WHITE )? LBRACK x= ID ( COMMA y= ID )* RBRACK ( WHITE )? ( NEWLINE | COMMENT )
            {
            // SayScript.g:307:52: ( WHITE )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==WHITE) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // SayScript.g:307:52: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_header2565); 

                    }
                    break;

            }


            match(input,LBRACK,FOLLOW_LBRACK_in_header2568); 

            x=(Token)match(input,ID,FOLLOW_ID_in_header2572); 


            		SS_script_name z3 = new SS_script_name((x!=null?x.getText():null)); 
                    script.names.add(z3); 
                    // Add the name to the script set hash table
            		scriptset.by_name.put((x!=null?x.getText():null), script);
            		/* System.out.println("### Adding name "+(x!=null?x.getText():null)+" to the scriptset"); */
            		script.script_type = script.get_type_for_name((x!=null?x.getText():null));
            		if (script.script_type == script.SS_S_TYPE_DATE_FORMAT) {
            		   scriptset.date_format_list.add(script);
            		}
                 

            // SayScript.g:318:8: ( COMMA y= ID )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==COMMA) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // SayScript.g:318:9: COMMA y= ID
            	    {
            	    match(input,COMMA,FOLLOW_COMMA_in_header2583); 

            	    y=(Token)match(input,ID,FOLLOW_ID_in_header2587); 


            	    		 		SS_script_name z4 = new SS_script_name((y!=null?y.getText():null)); 
            	    				script.names.add(z4); 
            	    				// Add the name to the script set hash table
            	    		/* System.out.println("#### Adding name (2) "+(y!=null?y.getText():null)+" to the scriptset"); */
            	    				scriptset.by_name.put((y!=null?y.getText():null), script);
            	    				if (script.script_type == script.SS_S_TYPE_DATE_FORMAT) {
            	    		   		   scriptset.date_format_list.add(script);
            	                    }
            	             

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            match(input,RBRACK,FOLLOW_RBRACK_in_header2603); 

            // SayScript.g:328:21: ( WHITE )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==WHITE) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // SayScript.g:328:21: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_header2605); 

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



    // $ANTLR start "silence_statement"
    // SayScript.g:330:1: silence_statement[SS_scriptset scriptset] : ( WHITE )? nam= ID ( WHITE )? EQUALS ( WHITE )? ( ( LANG pc= PATHCONST RANG )+ | DASH ) ( WHITE )? ( NEWLINE | COMMENT ) ;
    public final void silence_statement(SS_scriptset scriptset) throws RecognitionException {
        Token nam=null;
        Token pc=null;

         SS_silence_def sd = new SS_silence_def(); if(sd != null) scriptset.silence_def_list.add(sd);
        try {
            // SayScript.g:332:19: ( ( WHITE )? nam= ID ( WHITE )? EQUALS ( WHITE )? ( ( LANG pc= PATHCONST RANG )+ | DASH ) ( WHITE )? ( NEWLINE | COMMENT ) )
            // SayScript.g:332:21: ( WHITE )? nam= ID ( WHITE )? EQUALS ( WHITE )? ( ( LANG pc= PATHCONST RANG )+ | DASH ) ( WHITE )? ( NEWLINE | COMMENT )
            {
            // SayScript.g:332:21: ( WHITE )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==WHITE) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // SayScript.g:332:21: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_silence_statement2647); 

                    }
                    break;

            }


            nam=(Token)match(input,ID,FOLLOW_ID_in_silence_statement2652); 

            // SayScript.g:332:35: ( WHITE )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==WHITE) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // SayScript.g:332:35: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_silence_statement2654); 

                    }
                    break;

            }


            match(input,EQUALS,FOLLOW_EQUALS_in_silence_statement2657); 

            // SayScript.g:332:49: ( WHITE )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==WHITE) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // SayScript.g:332:49: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_silence_statement2659); 

                    }
                    break;

            }


             
               	 if ((nam!=null?nam.getText():null).equals("SENT_SPACE")) {
            	 	SS_silence_def x = scriptset.findsilence(' ', '\0');
            		if (x != null) {
            		  SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "This token is already defined on line " + x.lineno + "!");
            		  scriptset.log_list.add(y);
                    } else {
            		  sd.set_fields((nam!=null?nam.getLine():0), ' ', '\0');
            		}
            	 } else if ((nam!=null?nam.getText():null).equals("SENT_COMMA")) {
            	 	SS_silence_def x = scriptset.findsilence(',', '\0');
            		if (x != null) {
            		  SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "This token is already defined on line " + x.lineno + "!");
            		  scriptset.log_list.add(y);
                    } else {
            		  sd.set_fields((nam!=null?nam.getLine():0), ',', '\0');
            		}
            	 } else if ((nam!=null?nam.getText():null).equals("SCRIPT_COMMA")) {
            	 	SS_silence_def x = scriptset.findsilence('\0', ',');
            		if (x != null) {
            		  SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "This token is already defined on line " + x.lineno + "!");
            		  scriptset.log_list.add(y);
                    } else {
            		  sd.set_fields((nam!=null?nam.getLine():0), '\0', ',');
                  	}
            	 } else if ((nam!=null?nam.getText():null).equals("BOTH_COLON")) {
            	 	SS_silence_def x = scriptset.findsilence(':', ':');
            		if (x != null) {
            		  SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "This token is already defined on line " + x.lineno + "!");
            		  scriptset.log_list.add(y);
                    } else {
            		  sd.set_fields((nam!=null?nam.getLine():0), ':', ':');
                  	}
            	 } else if ((nam!=null?nam.getText():null).equals("BOTH_SEMICOLON")) {
            	 	SS_silence_def x = scriptset.findsilence(';', ';');
            		if (x != null) {
            		  SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "This token is already defined on line " + x.lineno + "!");
            		  scriptset.log_list.add(y);
                    } else {
            		  sd.set_fields((nam!=null?nam.getLine():0), ';', ';');
                  	}
            	 } else if ((nam!=null?nam.getText():null).equals("BOTH_PERIOD")) {
            	 	SS_silence_def x = scriptset.findsilence('.', '.');
            		if (x != null) {
            		  SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "This token is already defined on line " + x.lineno + "!");
            		  scriptset.log_list.add(y);
                    } else {
            		  sd.set_fields((nam!=null?nam.getLine():0), '.', '.');
                  	}
            	 } else if ((nam!=null?nam.getText():null).equals("BOTH_QUESTION")) {
            	 	SS_silence_def x = scriptset.findsilence('?', '?');
            		if (x != null) {
            		  SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "This token is already defined on line " + x.lineno + "!");
            		  scriptset.log_list.add(y);
                    } else {
            		  sd.set_fields((nam!=null?nam.getLine():0), '?', '?');
                  	}
            	 } else if ((nam!=null?nam.getText():null).equals("BOTH_PLUS")) {
            	 	SS_silence_def x = scriptset.findsilence('+', '+');
            		if (x != null) {
            		  SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "This token is already defined on line " + x.lineno + "!");
            		  scriptset.log_list.add(y);
                    } else {
            		  sd.set_fields((nam!=null?nam.getLine():0), '+', '+');
                  	}
            	 } else {
            	   SS_log y = new SS_log((nam!=null?nam.getLine():0), (nam!=null?nam.getCharPositionInLine():0), (nam!=null?nam.getText():null), "Unrecognized silence value. Check the documentation. Ignoring...");
            	   scriptset.log_list.add(y);
            	 }
               

            // SayScript.g:403:11: ( ( LANG pc= PATHCONST RANG )+ | DASH )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==LANG) ) {
                alt33=1;
            }
            else if ( (LA33_0==DASH) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // SayScript.g:403:13: ( LANG pc= PATHCONST RANG )+
                    {
                    // SayScript.g:403:13: ( LANG pc= PATHCONST RANG )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==LANG) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // SayScript.g:403:14: LANG pc= PATHCONST RANG
                    	    {
                    	    match(input,LANG,FOLLOW_LANG_in_silence_statement2681); 

                    	    pc=(Token)match(input,PATHCONST,FOLLOW_PATHCONST_in_silence_statement2685); 

                    	    match(input,RANG,FOLLOW_RANG_in_silence_statement2687); 

                    	    SS_playlist pl = new SS_playlist(); pl.str = (pc!=null?pc.getText():null); sd.playfiles.add(pl);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // SayScript.g:403:121: DASH
                    {
                    match(input,DASH,FOLLOW_DASH_in_silence_statement2696); 

                    }
                    break;

            }


            // SayScript.g:403:127: ( WHITE )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==WHITE) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // SayScript.g:403:127: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_silence_statement2699); 

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "silence_statement"



    // $ANTLR start "silence_statement_list"
    // SayScript.g:406:1: silence_statement_list[SS_scriptset scriptset] : ( silence_statement[scriptset] )+ ;
    public final void silence_statement_list(SS_scriptset scriptset) throws RecognitionException {
        try {
            // SayScript.g:406:48: ( ( silence_statement[scriptset] )+ )
            // SayScript.g:406:50: ( silence_statement[scriptset] )+
            {
            // SayScript.g:406:50: ( silence_statement[scriptset] )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==WHITE) ) {
                    int LA35_2 = input.LA(2);

                    if ( (LA35_2==ID) ) {
                        alt35=1;
                    }


                }
                else if ( (LA35_0==ID) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // SayScript.g:406:50: silence_statement[scriptset]
            	    {
            	    pushFollow(FOLLOW_silence_statement_in_silence_statement_list2724);
            	    silence_statement(scriptset);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
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
        return ;
    }
    // $ANTLR end "silence_statement_list"



    // $ANTLR start "silence_header"
    // SayScript.g:408:1: silence_header : ( WHITE )? LBRACK HDR_SILENCE RBRACK ( WHITE )? ( NEWLINE | COMMENT ) ;
    public final void silence_header() throws RecognitionException {
        try {
            // SayScript.g:408:16: ( ( WHITE )? LBRACK HDR_SILENCE RBRACK ( WHITE )? ( NEWLINE | COMMENT ) )
            // SayScript.g:408:18: ( WHITE )? LBRACK HDR_SILENCE RBRACK ( WHITE )? ( NEWLINE | COMMENT )
            {
            // SayScript.g:408:18: ( WHITE )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==WHITE) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // SayScript.g:408:18: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_silence_header2737); 

                    }
                    break;

            }


            match(input,LBRACK,FOLLOW_LBRACK_in_silence_header2740); 

            match(input,HDR_SILENCE,FOLLOW_HDR_SILENCE_in_silence_header2742); 

            match(input,RBRACK,FOLLOW_RBRACK_in_silence_header2744); 

            // SayScript.g:408:51: ( WHITE )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==WHITE) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // SayScript.g:408:51: WHITE
                    {
                    match(input,WHITE,FOLLOW_WHITE_in_silence_header2746); 

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "silence_header"



    // $ANTLR start "script"
    // SayScript.g:411:1: script[SS_scriptset scriptset] returns [SS_script script] : (hdr= header[scriptset, script] statement_list[scriptset, script] | silence_header silence_statement_list[scriptset] );
    public final SS_script script(SS_scriptset scriptset) throws RecognitionException {
        SS_script script = null;


         script = new SS_script();    
        try {
            // SayScript.g:414:8: (hdr= header[scriptset, script] statement_list[scriptset, script] | silence_header silence_statement_list[scriptset] )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==WHITE) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==LBRACK) ) {
                    int LA38_2 = input.LA(3);

                    if ( (LA38_2==ID) ) {
                        alt38=1;
                    }
                    else if ( (LA38_2==HDR_SILENCE) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA38_0==LBRACK) ) {
                int LA38_2 = input.LA(2);

                if ( (LA38_2==ID) ) {
                    alt38=1;
                }
                else if ( (LA38_2==HDR_SILENCE) ) {
                    alt38=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }
            switch (alt38) {
                case 1 :
                    // SayScript.g:414:10: hdr= header[scriptset, script] statement_list[scriptset, script]
                    {
                    pushFollow(FOLLOW_header_in_script2786);
                    header(scriptset, script);

                    state._fsp--;


                    pushFollow(FOLLOW_statement_list_in_script2789);
                    statement_list(scriptset, script);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // SayScript.g:415:10: silence_header silence_statement_list[scriptset]
                    {
                    pushFollow(FOLLOW_silence_header_in_script2801);
                    silence_header();

                    state._fsp--;


                    pushFollow(FOLLOW_silence_statement_list_in_script2803);
                    silence_statement_list(scriptset);

                    state._fsp--;


                    script = null;

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
        return script;
    }
    // $ANTLR end "script"



    // $ANTLR start "script_set"
    // SayScript.g:418:1: script_set[ArrayList<SS_log> log_list] returns [SS_scriptset scriptset] : ( ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset] )+ ;
    public final SS_scriptset script_set(ArrayList<SS_log> log_list) throws RecognitionException {
        SS_scriptset scriptset = null;


         scriptset = new SS_scriptset(); scriptset.log_list = log_list; 
        try {
            // SayScript.g:421:8: ( ( ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset] )+ )
            // SayScript.g:421:10: ( ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset] )+
            {
            // SayScript.g:421:10: ( ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset] )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==COMMENT||LA41_0==LBRACK||LA41_0==NEWLINE||LA41_0==WHITE) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // SayScript.g:421:11: ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset]
            	    {
            	    // SayScript.g:421:11: ( ( WHITE )? ( COMMENT | NEWLINE ) )*
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==WHITE) ) {
            	            int LA40_1 = input.LA(2);

            	            if ( (LA40_1==COMMENT||LA40_1==NEWLINE) ) {
            	                alt40=1;
            	            }


            	        }
            	        else if ( (LA40_0==COMMENT||LA40_0==NEWLINE) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // SayScript.g:421:12: ( WHITE )? ( COMMENT | NEWLINE )
            	    	    {
            	    	    // SayScript.g:421:12: ( WHITE )?
            	    	    int alt39=2;
            	    	    int LA39_0 = input.LA(1);

            	    	    if ( (LA39_0==WHITE) ) {
            	    	        alt39=1;
            	    	    }
            	    	    switch (alt39) {
            	    	        case 1 :
            	    	            // SayScript.g:421:12: WHITE
            	    	            {
            	    	            match(input,WHITE,FOLLOW_WHITE_in_script_set2841); 

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
            	    	    break;

            	    	default :
            	    	    break loop40;
            	        }
            	    } while (true);


            	    pushFollow(FOLLOW_script_in_script_set2854);
            	    script(scriptset);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
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
        return scriptset;
    }
    // $ANTLR end "script_set"

    // Delegated rules


 

    public static final BitSet FOLLOW_RANGE_in_oper714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATTERN_in_oper722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_in_oper735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESS_in_oper743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_oper751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTVAR_in_oper759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMLEN_in_oper778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATBEGIN_in_oper785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATEXIT_in_oper792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATEPAST_RANGE_in_oper811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATEFUT_RANGE_in_oper818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATEPAST_GREATER_in_oper838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATEFUT_GREATER_in_oper858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANYDATE_in_oper877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUTE_RANGE_in_oper885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SECOND_RANGE_in_oper894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HOUR_RANGE_in_oper914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YEAR_RANGE_in_oper922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPT_in_oper930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTOPT_in_oper950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YEAR_PATTERN_in_oper958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oper_in_oper_list972 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_COMMA_in_oper_list989 = new BitSet(new long[]{0x36A14000001E1C00L,0x0000000000006A21L});
    public static final BitSet FOLLOW_oper_in_oper_list993 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_NUM_in_arg1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_arg1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PAT_in_arg1078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAYAMOUNT_in_arg1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arg_in_arglist1126 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_COMMA_in_arglist1133 = new BitSet(new long[]{0x4802000000200000L});
    public static final BitSet FOLLOW_arg_in_arglist1137 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_LCURLY_in_file_var1178 = new BitSet(new long[]{0x00003FFFFE000000L});
    public static final BitSet FOLLOW_FE_num_in_file_var1183 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_opt_in_file_var1188 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_file_var1190 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ID_in_file_var1194 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_sec_in_file_var1218 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_min_in_file_var1224 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_12hour_in_file_var1248 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_12hour2d_in_file_var1254 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_24hour_in_file_var1277 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_24hour2d_in_file_var1283 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_ampm_in_file_var1295 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_xm_in_file_var1319 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_cm_in_file_var1325 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_time_tz_in_file_var1331 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_date_dom_in_file_var1354 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_date_dow_in_file_var1360 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_date_month_in_file_var1384 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_date_dowstr_in_file_var1390 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_date_monthstr_in_file_var1413 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_date_year_in_file_var1420 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_date_century_in_file_var1433 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_date_decade_in_file_var1440 = new BitSet(new long[]{0x0008000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_LBRACK_in_file_var1470 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NUM_in_file_var1474 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_file_var1493 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NUM_in_file_var1497 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RBRACK_in_file_var1503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_FE_timeval_in_file_var1528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_RCURLY_in_file_var1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FE_Lsubr_in_subcall1571 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ID_in_subcall1575 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_subcall1598 = new BitSet(new long[]{0x8010000001000000L});
    public static final BitSet FOLLOW_PATHCONST_in_subcall1603 = new BitSet(new long[]{0x8010000001000000L});
    public static final BitSet FOLLOW_file_var_in_subcall1638 = new BitSet(new long[]{0x8010000001000000L});
    public static final BitSet FOLLOW_FE_Rsubr_in_subcall1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PATHCONST_in_file_element1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_file_element1690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_file_var_in_file_element1706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subcall_in_file_element1723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_in_file_element1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_file_silence1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_file_silence1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERIOD_in_file_silence1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_file_silence1799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_file_silence1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUESTION_in_file_silence1819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_file_element_in_file_expr1837 = new BitSet(new long[]{0x8812000000806002L,0x000000000000040EL});
    public static final BitSet FOLLOW_file_silence_in_file_expr1842 = new BitSet(new long[]{0x8812000000806002L,0x000000000000040EL});
    public static final BitSet FOLLOW_ID_in_varset1879 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUALS_in_varset1881 = new BitSet(new long[]{0x0802000000000000L});
    public static final BitSet FOLLOW_ID_in_varset1886 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_NUM_in_varset1908 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_COMMA_in_varset1923 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ID_in_varset1927 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUALS_in_varset1929 = new BitSet(new long[]{0x0802000000000000L});
    public static final BitSet FOLLOW_ID_in_varset1934 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_NUM_in_varset1956 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_ACT_DONE_in_action1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACT_RANGE_in_action2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACT_RESTART_in_action2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACT_NEGATE_in_action2025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACT_CUT_in_action2037 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_LPAR_in_action2039 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NUM_in_action2043 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAR_in_action2045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACT_ZERO_in_action2056 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_LPAR_in_action2058 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_NUM_in_action2062 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_RPAR_in_action2064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHITE_in_statement2097 = new BitSet(new long[]{0x37A14000001E9C00L,0x0000000000006A21L});
    public static final BitSet FOLLOW_oper_list_in_statement2102 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_statement2105 = new BitSet(new long[]{0x4802000000210000L});
    public static final BitSet FOLLOW_arglist_in_statement2108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_DASH_in_statement2113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_statement2116 = new BitSet(new long[]{0x8812000000816000L,0x000000000000040EL});
    public static final BitSet FOLLOW_file_expr_in_statement2119 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_DASH_in_statement2124 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_statement2127 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_varset_in_statement2130 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_DASH_in_statement2135 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_statement2138 = new BitSet(new long[]{0x00000000000003F0L});
    public static final BitSet FOLLOW_action_in_statement2140 = new BitSet(new long[]{0x0100000000008000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_statement2143 = new BitSet(new long[]{0x0100000000008000L});
    public static final BitSet FOLLOW_set_in_statement2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_statement2157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_bad_statement2186 = new BitSet(new long[]{0xFFFB7FFFFFBFFDB0L,0x0000000000007FEFL});
    public static final BitSet FOLLOW_statement_in_statement_list2543 = new BitSet(new long[]{0x37A34000001E9C02L,0x0000000000007A21L});
    public static final BitSet FOLLOW_bad_statement_in_statement_list2548 = new BitSet(new long[]{0x37A34000001E9C02L,0x0000000000007A21L});
    public static final BitSet FOLLOW_WHITE_in_header2565 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LBRACK_in_header2568 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ID_in_header2572 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000040L});
    public static final BitSet FOLLOW_COMMA_in_header2583 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ID_in_header2587 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RBRACK_in_header2603 = new BitSet(new long[]{0x0100000000008000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_header2605 = new BitSet(new long[]{0x0100000000008000L});
    public static final BitSet FOLLOW_set_in_header2608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHITE_in_silence_statement2647 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ID_in_silence_statement2652 = new BitSet(new long[]{0x0000000000400000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_silence_statement2654 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_EQUALS_in_silence_statement2657 = new BitSet(new long[]{0x0004000000010000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_silence_statement2659 = new BitSet(new long[]{0x0004000000010000L});
    public static final BitSet FOLLOW_LANG_in_silence_statement2681 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_PATHCONST_in_silence_statement2685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RANG_in_silence_statement2687 = new BitSet(new long[]{0x0104000000008000L,0x0000000000001000L});
    public static final BitSet FOLLOW_DASH_in_silence_statement2696 = new BitSet(new long[]{0x0100000000008000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_silence_statement2699 = new BitSet(new long[]{0x0100000000008000L});
    public static final BitSet FOLLOW_set_in_silence_statement2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_silence_statement_in_silence_statement_list2724 = new BitSet(new long[]{0x0002000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_silence_header2737 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_LBRACK_in_silence_header2740 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_HDR_SILENCE_in_silence_header2742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_RBRACK_in_silence_header2744 = new BitSet(new long[]{0x0100000000008000L,0x0000000000001000L});
    public static final BitSet FOLLOW_WHITE_in_silence_header2746 = new BitSet(new long[]{0x0100000000008000L});
    public static final BitSet FOLLOW_set_in_silence_header2749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_script2786 = new BitSet(new long[]{0x37A34000001E9C00L,0x0000000000007A21L});
    public static final BitSet FOLLOW_statement_list_in_script2789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_silence_header_in_script2801 = new BitSet(new long[]{0x0002000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_silence_statement_list_in_script2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHITE_in_script_set2841 = new BitSet(new long[]{0x0100000000008000L});
    public static final BitSet FOLLOW_set_in_script_set2844 = new BitSet(new long[]{0x0108000000008000L,0x0000000000001000L});
    public static final BitSet FOLLOW_script_in_script_set2854 = new BitSet(new long[]{0x0108000000008002L,0x0000000000001000L});

}