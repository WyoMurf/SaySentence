// $ANTLR 3.5.1 SayScript.g 2059-12-25 23:45:49

import java.util.regex.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class SayScriptParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACT_CUT", "ACT_DONE", "ACT_NEGATE", 
		"ACT_RANGE", "ACT_RESTART", "ACT_ZERO", "ANYDATE", "ATBEGIN", "ATEXIT", 
		"BANG", "COLON", "COMMA", "COMMENT", "DASH", "DATEFUT_GREATER", "DATEFUT_RANGE", 
		"DATEPAST_GREATER", "DATEPAST_RANGE", "DAYAMOUNT", "DIV", "EQEQ", "EQUALS", 
		"FE_Lsubr", "FE_Rsubr", "FE_date_century", "FE_date_decade", "FE_date_dom", 
		"FE_date_dow", "FE_date_dowstr", "FE_date_month", "FE_date_monthstr", 
		"FE_date_year", "FE_length", "FE_num", "FE_opt", "FE_time_12hour", "FE_time_12hour2d", 
		"FE_time_24hour", "FE_time_24hour2d", "FE_time_ampm", "FE_time_cm", "FE_time_min", 
		"FE_time_sec", "FE_time_tz", "FE_time_xm", "FE_timeval", "GE", "GREATER", 
		"HDR_SILENCE", "HOUR_RANGE", "ID", "LANG", "LBRACK", "LCURLY", "LE", "LESS", 
		"LOG_AND", "LOG_OR", "LPAR", "MINUTE_RANGE", "MOD", "MULT", "NEWLINE", 
		"NOTEQ", "NOTOPT", "NOTVAR", "NUM", "NUMLEN", "OPT", "PAT", "PATHCONST", 
		"PATTERN", "PERIOD", "PLUS", "QUESTION", "RANG", "RANGE", "RBRACK", "RCURLY", 
		"RPAR", "SECOND_RANGE", "SEMICOLON", "VAR", "WHITE", "YEAR_PATTERN", "YEAR_RANGE"
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
	public static final int BANG=13;
	public static final int COLON=14;
	public static final int COMMA=15;
	public static final int COMMENT=16;
	public static final int DASH=17;
	public static final int DATEFUT_GREATER=18;
	public static final int DATEFUT_RANGE=19;
	public static final int DATEPAST_GREATER=20;
	public static final int DATEPAST_RANGE=21;
	public static final int DAYAMOUNT=22;
	public static final int DIV=23;
	public static final int EQEQ=24;
	public static final int EQUALS=25;
	public static final int FE_Lsubr=26;
	public static final int FE_Rsubr=27;
	public static final int FE_date_century=28;
	public static final int FE_date_decade=29;
	public static final int FE_date_dom=30;
	public static final int FE_date_dow=31;
	public static final int FE_date_dowstr=32;
	public static final int FE_date_month=33;
	public static final int FE_date_monthstr=34;
	public static final int FE_date_year=35;
	public static final int FE_length=36;
	public static final int FE_num=37;
	public static final int FE_opt=38;
	public static final int FE_time_12hour=39;
	public static final int FE_time_12hour2d=40;
	public static final int FE_time_24hour=41;
	public static final int FE_time_24hour2d=42;
	public static final int FE_time_ampm=43;
	public static final int FE_time_cm=44;
	public static final int FE_time_min=45;
	public static final int FE_time_sec=46;
	public static final int FE_time_tz=47;
	public static final int FE_time_xm=48;
	public static final int FE_timeval=49;
	public static final int GE=50;
	public static final int GREATER=51;
	public static final int HDR_SILENCE=52;
	public static final int HOUR_RANGE=53;
	public static final int ID=54;
	public static final int LANG=55;
	public static final int LBRACK=56;
	public static final int LCURLY=57;
	public static final int LE=58;
	public static final int LESS=59;
	public static final int LOG_AND=60;
	public static final int LOG_OR=61;
	public static final int LPAR=62;
	public static final int MINUTE_RANGE=63;
	public static final int MOD=64;
	public static final int MULT=65;
	public static final int NEWLINE=66;
	public static final int NOTEQ=67;
	public static final int NOTOPT=68;
	public static final int NOTVAR=69;
	public static final int NUM=70;
	public static final int NUMLEN=71;
	public static final int OPT=72;
	public static final int PAT=73;
	public static final int PATHCONST=74;
	public static final int PATTERN=75;
	public static final int PERIOD=76;
	public static final int PLUS=77;
	public static final int QUESTION=78;
	public static final int RANG=79;
	public static final int RANGE=80;
	public static final int RBRACK=81;
	public static final int RCURLY=82;
	public static final int RPAR=83;
	public static final int SECOND_RANGE=84;
	public static final int SEMICOLON=85;
	public static final int VAR=86;
	public static final int WHITE=87;
	public static final int YEAR_PATTERN=88;
	public static final int YEAR_RANGE=89;

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

	@Override public String[] getTokenNames() { return SayScriptParser.tokenNames; }
	@Override public String getGrammarFileName() { return "SayScript.g"; }


	public String getErrorMessage(RecognitionException e, String[] tokenNames)
	{
		List stack = getRuleInvocationStack(e, this.getClass().getName());
		String msg = null;
		if ( e instanceof NoViableAltException ) 
		{
			NoViableAltException nvae = (NoViableAltException)e;
			msg = " no viable alt; token="+e.token+" (decision="+nvae.decisionNumber+" state "+nvae.stateNumber+")"+" decision=<<"+nvae.grammarDecisionDescription+">>";
		}
		else
		{
			msg = super.getErrorMessage(e,tokenNames);
		}
		return stack+" "+msg;
	}
	public String getTokenErrorDisplay(Token t)
	{
		return t.toString();
	}


	public static class oper_return extends ParserRuleReturnScope {
		public int x;
		public int line;
	};


	// $ANTLR start "oper"
	// SayScript.g:133:1: oper[SS_script script] returns [int x, int line] : (z= RANGE |z= PATTERN |z= GREATER |z= LESS |z= VAR |z= NOTVAR |z= NUMLEN |z= ATBEGIN |z= ATEXIT |z= DATEPAST_RANGE |z= DATEFUT_RANGE |z= DATEPAST_GREATER |z= DATEFUT_GREATER |z= ANYDATE |z= MINUTE_RANGE |z= SECOND_RANGE |z= HOUR_RANGE |z= YEAR_RANGE |z= OPT |z= NOTOPT |z= YEAR_PATTERN ) ;
	public final SayScriptParser.oper_return oper(SS_script script) throws RecognitionException {
		SayScriptParser.oper_return retval = new SayScriptParser.oper_return();
		retval.start = input.LT(1);

		Token z=null;

		try {
			// SayScript.g:135:6: ( (z= RANGE |z= PATTERN |z= GREATER |z= LESS |z= VAR |z= NOTVAR |z= NUMLEN |z= ATBEGIN |z= ATEXIT |z= DATEPAST_RANGE |z= DATEFUT_RANGE |z= DATEPAST_GREATER |z= DATEFUT_GREATER |z= ANYDATE |z= MINUTE_RANGE |z= SECOND_RANGE |z= HOUR_RANGE |z= YEAR_RANGE |z= OPT |z= NOTOPT |z= YEAR_PATTERN ) )
			// SayScript.g:135:8: (z= RANGE |z= PATTERN |z= GREATER |z= LESS |z= VAR |z= NOTVAR |z= NUMLEN |z= ATBEGIN |z= ATEXIT |z= DATEPAST_RANGE |z= DATEFUT_RANGE |z= DATEPAST_GREATER |z= DATEFUT_GREATER |z= ANYDATE |z= MINUTE_RANGE |z= SECOND_RANGE |z= HOUR_RANGE |z= YEAR_RANGE |z= OPT |z= NOTOPT |z= YEAR_PATTERN )
			{
			// SayScript.g:135:8: (z= RANGE |z= PATTERN |z= GREATER |z= LESS |z= VAR |z= NOTVAR |z= NUMLEN |z= ATBEGIN |z= ATEXIT |z= DATEPAST_RANGE |z= DATEFUT_RANGE |z= DATEPAST_GREATER |z= DATEFUT_GREATER |z= ANYDATE |z= MINUTE_RANGE |z= SECOND_RANGE |z= HOUR_RANGE |z= YEAR_RANGE |z= OPT |z= NOTOPT |z= YEAR_PATTERN )
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
					// SayScript.g:135:9: z= RANGE
					{
					z=(Token)match(input,RANGE,FOLLOW_RANGE_in_oper789); 
					retval.x =SS_op.SS_OP_TYPE_RANGE;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 2 :
					// SayScript.g:135:62: z= PATTERN
					{
					z=(Token)match(input,PATTERN,FOLLOW_PATTERN_in_oper797); 
					retval.x =SS_op.SS_OP_TYPE_PATTERN;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 3 :
					// SayScript.g:136:8: z= GREATER
					{
					z=(Token)match(input,GREATER,FOLLOW_GREATER_in_oper810); 
					retval.x =SS_op.SS_OP_TYPE_GREATER;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 4 :
					// SayScript.g:136:65: z= LESS
					{
					z=(Token)match(input,LESS,FOLLOW_LESS_in_oper818); 
					retval.x =SS_op.SS_OP_TYPE_LESS;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 5 :
					// SayScript.g:136:116: z= VAR
					{
					z=(Token)match(input,VAR,FOLLOW_VAR_in_oper826); 
					retval.x =SS_op.SS_OP_TYPE_VAR;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 6 :
					// SayScript.g:136:165: z= NOTVAR
					{
					z=(Token)match(input,NOTVAR,FOLLOW_NOTVAR_in_oper834); 
					retval.x =SS_op.SS_OP_TYPE_NOTVAR;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 7 :
					// SayScript.g:137:14: z= NUMLEN
					{
					z=(Token)match(input,NUMLEN,FOLLOW_NUMLEN_in_oper853); 
					retval.x =SS_op.SS_OP_TYPE_NUMLEN;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 8 :
					// SayScript.g:137:68: z= ATBEGIN
					{
					z=(Token)match(input,ATBEGIN,FOLLOW_ATBEGIN_in_oper860); 
					retval.x =SS_op.SS_OP_TYPE_ATBEGIN;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 9 :
					// SayScript.g:137:124: z= ATEXIT
					{
					z=(Token)match(input,ATEXIT,FOLLOW_ATEXIT_in_oper867); 
					retval.x =SS_op.SS_OP_TYPE_ATEXIT;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 10 :
					// SayScript.g:138:14: z= DATEPAST_RANGE
					{
					z=(Token)match(input,DATEPAST_RANGE,FOLLOW_DATEPAST_RANGE_in_oper886); 
					retval.x =SS_op.SS_OP_TYPE_DATEPAST_RANGE;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 11 :
					// SayScript.g:138:84: z= DATEFUT_RANGE
					{
					z=(Token)match(input,DATEFUT_RANGE,FOLLOW_DATEFUT_RANGE_in_oper893); 
					retval.x =SS_op.SS_OP_TYPE_DATEFUT_RANGE;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 12 :
					// SayScript.g:139:14: z= DATEPAST_GREATER
					{
					z=(Token)match(input,DATEPAST_GREATER,FOLLOW_DATEPAST_GREATER_in_oper913); 
					retval.x =SS_op.SS_OP_TYPE_DATEPAST_GREATER;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 13 :
					// SayScript.g:140:14: z= DATEFUT_GREATER
					{
					z=(Token)match(input,DATEFUT_GREATER,FOLLOW_DATEFUT_GREATER_in_oper933); 
					retval.x =SS_op.SS_OP_TYPE_DATEFUT_GREATER;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 14 :
					// SayScript.g:141:14: z= ANYDATE
					{
					z=(Token)match(input,ANYDATE,FOLLOW_ANYDATE_in_oper952); 
					retval.x =SS_op.SS_OP_TYPE_ANYDATE;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 15 :
					// SayScript.g:141:71: z= MINUTE_RANGE
					{
					z=(Token)match(input,MINUTE_RANGE,FOLLOW_MINUTE_RANGE_in_oper960); 
					retval.x =SS_op.SS_OP_TYPE_MINUTE_RANGE;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 16 :
					// SayScript.g:141:139: z= SECOND_RANGE
					{
					z=(Token)match(input,SECOND_RANGE,FOLLOW_SECOND_RANGE_in_oper969); 
					retval.x =SS_op.SS_OP_TYPE_SECOND_RANGE;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 17 :
					// SayScript.g:142:14: z= HOUR_RANGE
					{
					z=(Token)match(input,HOUR_RANGE,FOLLOW_HOUR_RANGE_in_oper989); 
					retval.x =SS_op.SS_OP_TYPE_HOUR_RANGE;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 18 :
					// SayScript.g:142:77: z= YEAR_RANGE
					{
					z=(Token)match(input,YEAR_RANGE,FOLLOW_YEAR_RANGE_in_oper997); 
					retval.x =SS_op.SS_OP_TYPE_YEAR_RANGE;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 19 :
					// SayScript.g:142:140: z= OPT
					{
					z=(Token)match(input,OPT,FOLLOW_OPT_in_oper1005); 
					retval.x =SS_op.SS_OP_TYPE_OPT;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 20 :
					// SayScript.g:143:14: z= NOTOPT
					{
					z=(Token)match(input,NOTOPT,FOLLOW_NOTOPT_in_oper1025); 
					retval.x =SS_op.SS_OP_TYPE_NOTOPT;retval.line =(z!=null?z.getLine():0);
					}
					break;
				case 21 :
					// SayScript.g:143:69: z= YEAR_PATTERN
					{
					z=(Token)match(input,YEAR_PATTERN,FOLLOW_YEAR_PATTERN_in_oper1033); 
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
	// SayScript.g:145:1: oper_list[SS_script script, SS_statement stat] : x= oper[$script] ( COMMA y= oper[script] )* ;
	public final void oper_list(SS_script script, SS_statement stat) throws RecognitionException {
		ParserRuleReturnScope x =null;
		ParserRuleReturnScope y =null;

		try {
			// SayScript.g:145:48: (x= oper[$script] ( COMMA y= oper[script] )* )
			// SayScript.g:145:50: x= oper[$script] ( COMMA y= oper[script] )*
			{
			pushFollow(FOLLOW_oper_in_oper_list1047);
			x=oper(script);
			state._fsp--;


						stat.lineno = (x!=null?((SayScriptParser.oper_return)x).line:0);
						SS_op op = new SS_op((x!=null?((SayScriptParser.oper_return)x).x:0));
						stat.oplist.add(op);
					 
			// SayScript.g:150:6: ( COMMA y= oper[script] )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==COMMA) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// SayScript.g:150:8: COMMA y= oper[script]
					{
					match(input,COMMA,FOLLOW_COMMA_in_oper_list1064); 
					pushFollow(FOLLOW_oper_in_oper_list1068);
					y=oper(script);
					state._fsp--;


							    stat.lineno = (y!=null?((SayScriptParser.oper_return)y).line:0);
								SS_op op2 = new SS_op((y!=null?((SayScriptParser.oper_return)y).x:0));
								stat.oplist.add(op2);
					         
					}
					break;

				default :
					break loop2;
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
	}
	// $ANTLR end "oper_list"



	// $ANTLR start "arg"
	// SayScript.g:158:1: arg[SS_script script, SS_statement stat] returns [SS_op_arg oa] : (t= NUM |u= ID |v= PAT |w= DAYAMOUNT ) ;
	public final SS_op_arg arg(SS_script script, SS_statement stat) throws RecognitionException {
		SS_op_arg oa = null;


		Token t=null;
		Token u=null;
		Token v=null;
		Token w=null;


			  oa = new SS_op_arg();

		try {
			// SayScript.g:163:10: ( (t= NUM |u= ID |v= PAT |w= DAYAMOUNT ) )
			// SayScript.g:163:12: (t= NUM |u= ID |v= PAT |w= DAYAMOUNT )
			{
			// SayScript.g:163:12: (t= NUM |u= ID |v= PAT |w= DAYAMOUNT )
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
					// SayScript.g:164:21: t= NUM
					{
					t=(Token)match(input,NUM,FOLLOW_NUM_in_arg1135); 
					oa.num = Long.parseLong((t!=null?t.getText():null));
					}
					break;
				case 2 :
					// SayScript.g:165:7: u= ID
					{
					u=(Token)match(input,ID,FOLLOW_ID_in_arg1148); 
					oa.str=(u!=null?u.getText():null);
					}
					break;
				case 3 :
					// SayScript.g:166:7: v= PAT
					{
					v=(Token)match(input,PAT,FOLLOW_PAT_in_arg1161); 
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
					// SayScript.g:174:7: w= DAYAMOUNT
					{
					w=(Token)match(input,DAYAMOUNT,FOLLOW_DAYAMOUNT_in_arg1173); 

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
	// SayScript.g:196:1: arglist[SS_script script, SS_statement stat] : p= arg[script, stat] ( COMMA q= arg[script, stat] )* ;
	public final void arglist(SS_script script, SS_statement stat) throws RecognitionException {
		SS_op_arg p =null;
		SS_op_arg q =null;

		try {
			// SayScript.g:196:46: (p= arg[script, stat] ( COMMA q= arg[script, stat] )* )
			// SayScript.g:196:48: p= arg[script, stat] ( COMMA q= arg[script, stat] )*
			{
			pushFollow(FOLLOW_arg_in_arglist1209);
			p=arg(script, stat);
			state._fsp--;

			stat.arglist.add(p);
			// SayScript.g:196:92: ( COMMA q= arg[script, stat] )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==COMMA) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// SayScript.g:196:93: COMMA q= arg[script, stat]
					{
					match(input,COMMA,FOLLOW_COMMA_in_arglist1216); 
					pushFollow(FOLLOW_arg_in_arglist1220);
					q=arg(script, stat);
					state._fsp--;

					stat.arglist.add(q);
					}
					break;

				default :
					break loop4;
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
	}
	// $ANTLR end "arglist"



	// $ANTLR start "file_var"
	// SayScript.g:198:1: file_var[SS_statement stat] returns [SS_play_expr expr] : LCURLY ( ( FE_num | FE_opt COLON x= ID | FE_length | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= playexpr[stat] ( COLON z= playexpr[stat] )? RBRACK )? | FE_timeval ) RCURLY ;
	public final SS_play_expr file_var(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		Token x=null;
		SS_play_expr y =null;
		SS_play_expr z =null;


			  expr = new SS_play_expr(); expr.range_start=null; expr.range_end=null;

		try {
			// SayScript.g:203:18: ( LCURLY ( ( FE_num | FE_opt COLON x= ID | FE_length | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= playexpr[stat] ( COLON z= playexpr[stat] )? RBRACK )? | FE_timeval ) RCURLY )
			// SayScript.g:203:20: LCURLY ( ( FE_num | FE_opt COLON x= ID | FE_length | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= playexpr[stat] ( COLON z= playexpr[stat] )? RBRACK )? | FE_timeval ) RCURLY
			{
			match(input,LCURLY,FOLLOW_LCURLY_in_file_var1262); 
			// SayScript.g:203:27: ( ( FE_num | FE_opt COLON x= ID | FE_length | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= playexpr[stat] ( COLON z= playexpr[stat] )? RBRACK )? | FE_timeval )
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
					// SayScript.g:203:29: ( FE_num | FE_opt COLON x= ID | FE_length | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade ) ( LBRACK y= playexpr[stat] ( COLON z= playexpr[stat] )? RBRACK )?
					{
					// SayScript.g:203:29: ( FE_num | FE_opt COLON x= ID | FE_length | FE_time_sec | FE_time_min | FE_time_12hour | FE_time_12hour2d | FE_time_24hour | FE_time_24hour2d | FE_time_ampm | FE_time_xm | FE_time_cm | FE_time_tz | FE_date_dom | FE_date_dow | FE_date_month | FE_date_dowstr | FE_date_monthstr | FE_date_year | FE_date_century | FE_date_decade )
					int alt5=21;
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
					case FE_length:
						{
						alt5=3;
						}
						break;
					case FE_time_sec:
						{
						alt5=4;
						}
						break;
					case FE_time_min:
						{
						alt5=5;
						}
						break;
					case FE_time_12hour:
						{
						alt5=6;
						}
						break;
					case FE_time_12hour2d:
						{
						alt5=7;
						}
						break;
					case FE_time_24hour:
						{
						alt5=8;
						}
						break;
					case FE_time_24hour2d:
						{
						alt5=9;
						}
						break;
					case FE_time_ampm:
						{
						alt5=10;
						}
						break;
					case FE_time_xm:
						{
						alt5=11;
						}
						break;
					case FE_time_cm:
						{
						alt5=12;
						}
						break;
					case FE_time_tz:
						{
						alt5=13;
						}
						break;
					case FE_date_dom:
						{
						alt5=14;
						}
						break;
					case FE_date_dow:
						{
						alt5=15;
						}
						break;
					case FE_date_month:
						{
						alt5=16;
						}
						break;
					case FE_date_dowstr:
						{
						alt5=17;
						}
						break;
					case FE_date_monthstr:
						{
						alt5=18;
						}
						break;
					case FE_date_year:
						{
						alt5=19;
						}
						break;
					case FE_date_century:
						{
						alt5=20;
						}
						break;
					case FE_date_decade:
						{
						alt5=21;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}
					switch (alt5) {
						case 1 :
							// SayScript.g:203:30: FE_num
							{
							match(input,FE_num,FOLLOW_FE_num_in_file_var1267); 
							expr.type = expr.SS_EXPR_NUM;
							}
							break;
						case 2 :
							// SayScript.g:203:70: FE_opt COLON x= ID
							{
							match(input,FE_opt,FOLLOW_FE_opt_in_file_var1272); 
							match(input,COLON,FOLLOW_COLON_in_file_var1274); 
							x=(Token)match(input,ID,FOLLOW_ID_in_file_var1278); 
							expr.type = expr.SS_EXPR_OPT; expr.str = (x!=null?x.getText():null);
							}
							break;
						case 3 :
							// SayScript.g:204:6: FE_length
							{
							match(input,FE_length,FOLLOW_FE_length_in_file_var1288); 
							expr.type = expr.SS_EXPR_LEN;
							}
							break;
						case 4 :
							// SayScript.g:205:21: FE_time_sec
							{
							match(input,FE_time_sec,FOLLOW_FE_time_sec_in_file_var1313); 
							expr.type = expr.SS_EXPR_TIME_SEC;
							}
							break;
						case 5 :
							// SayScript.g:205:72: FE_time_min
							{
							match(input,FE_time_min,FOLLOW_FE_time_min_in_file_var1319); 
							expr.type = expr.SS_EXPR_TIME_MIN;
							}
							break;
						case 6 :
							// SayScript.g:206:21: FE_time_12hour
							{
							match(input,FE_time_12hour,FOLLOW_FE_time_12hour_in_file_var1344); 
							expr.type = expr.SS_EXPR_TIME_12HOUR;
							}
							break;
						case 7 :
							// SayScript.g:206:78: FE_time_12hour2d
							{
							match(input,FE_time_12hour2d,FOLLOW_FE_time_12hour2d_in_file_var1350); 
							expr.type = expr.SS_EXPR_TIME_12HOUR2D;
							}
							break;
						case 8 :
							// SayScript.g:207:21: FE_time_24hour
							{
							match(input,FE_time_24hour,FOLLOW_FE_time_24hour_in_file_var1374); 
							expr.type = expr.SS_EXPR_TIME_24HOUR;
							}
							break;
						case 9 :
							// SayScript.g:207:78: FE_time_24hour2d
							{
							match(input,FE_time_24hour2d,FOLLOW_FE_time_24hour2d_in_file_var1380); 
							expr.type = expr.SS_EXPR_TIME_24HOUR2D;
							}
							break;
						case 10 :
							// SayScript.g:208:8: FE_time_ampm
							{
							match(input,FE_time_ampm,FOLLOW_FE_time_ampm_in_file_var1392); 
							expr.type = expr.SS_EXPR_TIME_AMPM;
							}
							break;
						case 11 :
							// SayScript.g:209:21: FE_time_xm
							{
							match(input,FE_time_xm,FOLLOW_FE_time_xm_in_file_var1417); 
							expr.type = expr.SS_EXPR_TIME_XM;
							}
							break;
						case 12 :
							// SayScript.g:209:70: FE_time_cm
							{
							match(input,FE_time_cm,FOLLOW_FE_time_cm_in_file_var1423); 
							expr.type = expr.SS_EXPR_TIME_CM;
							}
							break;
						case 13 :
							// SayScript.g:209:119: FE_time_tz
							{
							match(input,FE_time_tz,FOLLOW_FE_time_tz_in_file_var1429); 
							expr.type = expr.SS_EXPR_TIME_TZ;
							}
							break;
						case 14 :
							// SayScript.g:210:21: FE_date_dom
							{
							match(input,FE_date_dom,FOLLOW_FE_date_dom_in_file_var1453); 
							expr.type = expr.SS_EXPR_DATE_DOM;
							}
							break;
						case 15 :
							// SayScript.g:210:72: FE_date_dow
							{
							match(input,FE_date_dow,FOLLOW_FE_date_dow_in_file_var1459); 
							expr.type = expr.SS_EXPR_DATE_DOW;
							}
							break;
						case 16 :
							// SayScript.g:211:21: FE_date_month
							{
							match(input,FE_date_month,FOLLOW_FE_date_month_in_file_var1484); 
							expr.type = expr.SS_EXPR_DATE_MONTH;
							}
							break;
						case 17 :
							// SayScript.g:211:76: FE_date_dowstr
							{
							match(input,FE_date_dowstr,FOLLOW_FE_date_dowstr_in_file_var1490); 
							expr.type = expr.SS_EXPR_DATE_DOWSTR;
							}
							break;
						case 18 :
							// SayScript.g:212:22: FE_date_monthstr
							{
							match(input,FE_date_monthstr,FOLLOW_FE_date_monthstr_in_file_var1515); 
							expr.type = expr.SS_EXPR_DATE_MONTHSTR;
							}
							break;
						case 19 :
							// SayScript.g:212:84: FE_date_year
							{
							match(input,FE_date_year,FOLLOW_FE_date_year_in_file_var1522); 
							expr.type = expr.SS_EXPR_DATE_YEAR;
							}
							break;
						case 20 :
							// SayScript.g:213:8: FE_date_century
							{
							match(input,FE_date_century,FOLLOW_FE_date_century_in_file_var1535); 
							expr.type = expr.SS_EXPR_DATE_CENT;
							}
							break;
						case 21 :
							// SayScript.g:213:65: FE_date_decade
							{
							match(input,FE_date_decade,FOLLOW_FE_date_decade_in_file_var1542); 
							expr.type = expr.SS_EXPR_DATE_DECADE;
							}
							break;

					}

					// SayScript.g:214:23: ( LBRACK y= playexpr[stat] ( COLON z= playexpr[stat] )? RBRACK )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==LBRACK) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// SayScript.g:214:25: LBRACK y= playexpr[stat] ( COLON z= playexpr[stat] )? RBRACK
							{
							match(input,LBRACK,FOLLOW_LBRACK_in_file_var1574); 
							pushFollow(FOLLOW_playexpr_in_file_var1578);
							y=playexpr(stat);
							state._fsp--;


														expr.range_type = expr.SS_EXPR_RANGE_START; expr.range_start = y; 
							// SayScript.g:216:14: ( COLON z= playexpr[stat] )?
							int alt6=2;
							int LA6_0 = input.LA(1);
							if ( (LA6_0==COLON) ) {
								alt6=1;
							}
							switch (alt6) {
								case 1 :
									// SayScript.g:216:15: COLON z= playexpr[stat]
									{
									match(input,COLON,FOLLOW_COLON_in_file_var1598); 
									pushFollow(FOLLOW_playexpr_in_file_var1602);
									z=playexpr(stat);
									state._fsp--;

									expr.range_type = expr.SS_EXPR_RANGE; expr.range_end = z; 
									}
									break;

							}

							match(input,RBRACK,FOLLOW_RBRACK_in_file_var1609); 
							}
							break;

					}

					}
					break;
				case 2 :
					// SayScript.g:217:22: FE_timeval
					{
					match(input,FE_timeval,FOLLOW_FE_timeval_in_file_var1636); 
					expr.type = expr.SS_EXPR_TIMEVAL;
					}
					break;

			}

			match(input,RCURLY,FOLLOW_RCURLY_in_file_var1642); 
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
	// SayScript.g:220:1: subcall[SS_statement stat] returns [SS_play_expr expr] : FE_Lsubr a= ID ( COLON OPT d= PATHCONST )? COLON (b= PATHCONST |c= file_var[stat] )* FE_Rsubr ;
	public final SS_play_expr subcall(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		Token a=null;
		Token d=null;
		Token b=null;
		SS_play_expr c =null;


			  expr = new SS_play_expr(); expr.subcall_exprlist = new ArrayList<SS_play_expr>();

		try {
			// SayScript.g:225:17: ( FE_Lsubr a= ID ( COLON OPT d= PATHCONST )? COLON (b= PATHCONST |c= file_var[stat] )* FE_Rsubr )
			// SayScript.g:225:19: FE_Lsubr a= ID ( COLON OPT d= PATHCONST )? COLON (b= PATHCONST |c= file_var[stat] )* FE_Rsubr
			{
			match(input,FE_Lsubr,FOLLOW_FE_Lsubr_in_subcall1679); 
			a=(Token)match(input,ID,FOLLOW_ID_in_subcall1683); 
			expr.type = expr.SS_EXPR_SUBCALL;expr.subcall_script_name = (a!=null?a.getText():null); expr.subcall_options=null; 
			// SayScript.g:226:5: ( COLON OPT d= PATHCONST )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==COLON) ) {
				int LA9_1 = input.LA(2);
				if ( (LA9_1==OPT) ) {
					alt9=1;
				}
			}
			switch (alt9) {
				case 1 :
					// SayScript.g:226:6: COLON OPT d= PATHCONST
					{
					match(input,COLON,FOLLOW_COLON_in_subcall1693); 
					match(input,OPT,FOLLOW_OPT_in_subcall1695); 
					d=(Token)match(input,PATHCONST,FOLLOW_PATHCONST_in_subcall1699); 
					expr.subcall_options = (d!=null?d.getText():null);
					}
					break;

			}

			match(input,COLON,FOLLOW_COLON_in_subcall1724); 
			// SayScript.g:227:25: (b= PATHCONST |c= file_var[stat] )*
			loop10:
			while (true) {
				int alt10=3;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==PATHCONST) ) {
					alt10=1;
				}
				else if ( (LA10_0==LCURLY) ) {
					alt10=2;
				}

				switch (alt10) {
				case 1 :
					// SayScript.g:227:26: b= PATHCONST
					{
					b=(Token)match(input,PATHCONST,FOLLOW_PATHCONST_in_subcall1729); 
					expr = new SS_play_expr(); expr.type=expr.SS_EXPR_STR_CONST;expr.str=(b!=null?b.getText():null); expr.subcall_exprlist.add(expr); 
					}
					break;
				case 2 :
					// SayScript.g:228:27: c= file_var[stat]
					{
					pushFollow(FOLLOW_file_var_in_subcall1762);
					c=file_var(stat);
					state._fsp--;

					 expr.subcall_exprlist.add(c);
					}
					break;

				default :
					break loop10;
				}
			}

			match(input,FE_Rsubr,FOLLOW_FE_Rsubr_in_subcall1770); 

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
	// SayScript.g:232:1: file_element[SS_statement stat] returns [SS_play_expr expr] : (a= PATHCONST |b= ID |c= file_var[stat] |d= subcall[stat] |e= NUM | LPAR f= playexpr[stat] RPAR );
	public final SS_play_expr file_element(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		Token a=null;
		Token b=null;
		Token e=null;
		SS_play_expr c =null;
		SS_play_expr d =null;
		SS_play_expr f =null;

		try {
			// SayScript.g:234:9: (a= PATHCONST |b= ID |c= file_var[stat] |d= subcall[stat] |e= NUM | LPAR f= playexpr[stat] RPAR )
			int alt11=6;
			switch ( input.LA(1) ) {
			case PATHCONST:
				{
				alt11=1;
				}
				break;
			case ID:
				{
				alt11=2;
				}
				break;
			case LCURLY:
				{
				alt11=3;
				}
				break;
			case FE_Lsubr:
				{
				alt11=4;
				}
				break;
			case NUM:
				{
				alt11=5;
				}
				break;
			case LPAR:
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
					// SayScript.g:234:11: a= PATHCONST
					{
					a=(Token)match(input,PATHCONST,FOLLOW_PATHCONST_in_file_element1801); 
					expr = new SS_play_expr(); expr.type=SS_play_expr.SS_EXPR_STR_CONST;expr.str=(a!=null?a.getText():null); 
					}
					break;
				case 2 :
					// SayScript.g:235:11: b= ID
					{
					b=(Token)match(input,ID,FOLLOW_ID_in_file_element1818); 
					expr = new SS_play_expr(); expr.type=SS_play_expr.SS_EXPR_STR_CONST;expr.str=(b!=null?b.getText():null); 
					}
					break;
				case 3 :
					// SayScript.g:236:11: c= file_var[stat]
					{
					pushFollow(FOLLOW_file_var_in_file_element1834);
					c=file_var(stat);
					state._fsp--;

					expr = c; 
					}
					break;
				case 4 :
					// SayScript.g:237:11: d= subcall[stat]
					{
					pushFollow(FOLLOW_subcall_in_file_element1852);
					d=subcall(stat);
					state._fsp--;

					expr = d; 
					}
					break;
				case 5 :
					// SayScript.g:238:11: e= NUM
					{
					e=(Token)match(input,NUM,FOLLOW_NUM_in_file_element1870); 
					expr = new SS_play_expr(); expr.type=SS_play_expr.SS_EXPR_STR_CONST;expr.str=(e!=null?e.getText():null); 
					}
					break;
				case 6 :
					// SayScript.g:239:11: LPAR f= playexpr[stat] RPAR
					{
					match(input,LPAR,FOLLOW_LPAR_in_file_element1884); 
					pushFollow(FOLLOW_playexpr_in_file_element1888);
					f=playexpr(stat);
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_file_element1891); 
					expr = new SS_play_expr(); expr.type=SS_play_expr.SS_EXPR_PAREN;expr.Left=f; 
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
		return expr;
	}
	// $ANTLR end "file_element"



	// $ANTLR start "playexpr"
	// SayScript.g:242:1: playexpr[SS_statement stat] returns [SS_play_expr expr] : a= logicalOrExpr[stat] ( QUESTION b= logicalOrExpr[stat] COLON c= logicalOrExpr[stat] )? ;
	public final SS_play_expr playexpr(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		SS_play_expr a =null;
		SS_play_expr b =null;
		SS_play_expr c =null;


			expr = new SS_play_expr(); 

		try {
			// SayScript.g:247:3: (a= logicalOrExpr[stat] ( QUESTION b= logicalOrExpr[stat] COLON c= logicalOrExpr[stat] )? )
			// SayScript.g:247:5: a= logicalOrExpr[stat] ( QUESTION b= logicalOrExpr[stat] COLON c= logicalOrExpr[stat] )?
			{
			pushFollow(FOLLOW_logicalOrExpr_in_playexpr1923);
			a=logicalOrExpr(stat);
			state._fsp--;

			// SayScript.g:247:27: ( QUESTION b= logicalOrExpr[stat] COLON c= logicalOrExpr[stat] )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==QUESTION) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// SayScript.g:247:28: QUESTION b= logicalOrExpr[stat] COLON c= logicalOrExpr[stat]
					{
					match(input,QUESTION,FOLLOW_QUESTION_in_playexpr1927); 
					pushFollow(FOLLOW_logicalOrExpr_in_playexpr1931);
					b=logicalOrExpr(stat);
					state._fsp--;

					match(input,COLON,FOLLOW_COLON_in_playexpr1934); 
					pushFollow(FOLLOW_logicalOrExpr_in_playexpr1938);
					c=logicalOrExpr(stat);
					state._fsp--;

					expr = new SS_play_expr(); expr.type=SS_play_expr.SS_EXPR_CONDITIONAL;expr.cond=a; expr.Left = b; expr.Right = c; 
					}
					break;

			}

			 if (b==null) expr=a;  
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
	// $ANTLR end "playexpr"



	// $ANTLR start "logicalOrExpr"
	// SayScript.g:250:1: logicalOrExpr[SS_statement stat] returns [SS_play_expr expr] : a= logicalAndExpr[stat] ( LOG_OR b= logicalAndExpr[stat] )? ;
	public final SS_play_expr logicalOrExpr(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		SS_play_expr a =null;
		SS_play_expr b =null;

		try {
			// SayScript.g:252:3: (a= logicalAndExpr[stat] ( LOG_OR b= logicalAndExpr[stat] )? )
			// SayScript.g:252:5: a= logicalAndExpr[stat] ( LOG_OR b= logicalAndExpr[stat] )?
			{
			pushFollow(FOLLOW_logicalAndExpr_in_logicalOrExpr1965);
			a=logicalAndExpr(stat);
			state._fsp--;

			// SayScript.g:252:28: ( LOG_OR b= logicalAndExpr[stat] )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==LOG_OR) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// SayScript.g:252:29: LOG_OR b= logicalAndExpr[stat]
					{
					match(input,LOG_OR,FOLLOW_LOG_OR_in_logicalOrExpr1969); 
					pushFollow(FOLLOW_logicalAndExpr_in_logicalOrExpr1973);
					b=logicalAndExpr(stat);
					state._fsp--;

					expr = new SS_play_expr(); expr.type=SS_play_expr.SS_EXPR_LOGOR; expr.Left = a; expr.Right = b;  
					}
					break;

			}

			 if (b==null) expr=a; 
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
	// $ANTLR end "logicalOrExpr"



	// $ANTLR start "logicalAndExpr"
	// SayScript.g:255:1: logicalAndExpr[SS_statement stat] returns [SS_play_expr expr] : a= equalityExpr[stat] ( LOG_AND b= equalityExpr[stat] )? ;
	public final SS_play_expr logicalAndExpr(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		SS_play_expr a =null;
		SS_play_expr b =null;

		try {
			// SayScript.g:257:3: (a= equalityExpr[stat] ( LOG_AND b= equalityExpr[stat] )? )
			// SayScript.g:257:5: a= equalityExpr[stat] ( LOG_AND b= equalityExpr[stat] )?
			{
			pushFollow(FOLLOW_equalityExpr_in_logicalAndExpr1999);
			a=equalityExpr(stat);
			state._fsp--;

			// SayScript.g:257:26: ( LOG_AND b= equalityExpr[stat] )?
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==LOG_AND) ) {
				alt14=1;
			}
			switch (alt14) {
				case 1 :
					// SayScript.g:257:27: LOG_AND b= equalityExpr[stat]
					{
					match(input,LOG_AND,FOLLOW_LOG_AND_in_logicalAndExpr2003); 
					pushFollow(FOLLOW_equalityExpr_in_logicalAndExpr2007);
					b=equalityExpr(stat);
					state._fsp--;

					expr = new SS_play_expr(); expr.type=SS_play_expr.SS_EXPR_LOGAND; expr.Left = a; expr.Right = b;  
					}
					break;

			}

			 if (b==null) expr=a; 
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
	// $ANTLR end "logicalAndExpr"



	// $ANTLR start "equalityExpr"
	// SayScript.g:260:1: equalityExpr[SS_statement stat] returns [SS_play_expr expr] : a= relationalExpr[stat] (e= ( EQEQ | NOTEQ ) b= relationalExpr[stat] )? ;
	public final SS_play_expr equalityExpr(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		Token e=null;
		SS_play_expr a =null;
		SS_play_expr b =null;

		try {
			// SayScript.g:262:3: (a= relationalExpr[stat] (e= ( EQEQ | NOTEQ ) b= relationalExpr[stat] )? )
			// SayScript.g:262:5: a= relationalExpr[stat] (e= ( EQEQ | NOTEQ ) b= relationalExpr[stat] )?
			{
			pushFollow(FOLLOW_relationalExpr_in_equalityExpr2033);
			a=relationalExpr(stat);
			state._fsp--;

			// SayScript.g:262:28: (e= ( EQEQ | NOTEQ ) b= relationalExpr[stat] )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==EQEQ||LA15_0==NOTEQ) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// SayScript.g:262:29: e= ( EQEQ | NOTEQ ) b= relationalExpr[stat]
					{
					e=input.LT(1);
					if ( input.LA(1)==EQEQ||input.LA(1)==NOTEQ ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_relationalExpr_in_equalityExpr2049);
					b=relationalExpr(stat);
					state._fsp--;

					expr = new SS_play_expr(); if((e!=null?e.getText():null).equals("==")) expr.type=SS_play_expr.SS_EXPR_EQ; else expr.type=SS_play_expr.SS_EXPR_NEQ; expr.Left = a; expr.Right = b;  
					}
					break;

			}

			 if (b==null) expr=a; 
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
	// $ANTLR end "equalityExpr"



	// $ANTLR start "relationalExpr"
	// SayScript.g:266:1: relationalExpr[SS_statement stat] returns [SS_play_expr expr] : a= additiveExpr[stat] (j= ( LANG | RANG | LE | GE ) b= additiveExpr[stat] )? ;
	public final SS_play_expr relationalExpr(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		Token j=null;
		SS_play_expr a =null;
		SS_play_expr b =null;

		try {
			// SayScript.g:268:3: (a= additiveExpr[stat] (j= ( LANG | RANG | LE | GE ) b= additiveExpr[stat] )? )
			// SayScript.g:268:5: a= additiveExpr[stat] (j= ( LANG | RANG | LE | GE ) b= additiveExpr[stat] )?
			{
			pushFollow(FOLLOW_additiveExpr_in_relationalExpr2078);
			a=additiveExpr(stat);
			state._fsp--;

			// SayScript.g:268:26: (j= ( LANG | RANG | LE | GE ) b= additiveExpr[stat] )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==GE||LA16_0==LANG||LA16_0==LE||LA16_0==RANG) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// SayScript.g:268:27: j= ( LANG | RANG | LE | GE ) b= additiveExpr[stat]
					{
					j=input.LT(1);
					if ( input.LA(1)==GE||input.LA(1)==LANG||input.LA(1)==LE||input.LA(1)==RANG ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_additiveExpr_in_relationalExpr2096);
					b=additiveExpr(stat);
					state._fsp--;

					expr = new SS_play_expr(); if ((j!=null?j.getText():null).equals("<"))
													expr.type=SS_play_expr.SS_EXPR_LT; 
											    else if ((j!=null?j.getText():null).equals(">"))
													expr.type=SS_play_expr.SS_EXPR_GT;
											    else if ((j!=null?j.getText():null).equals("<="))
													expr.type=SS_play_expr.SS_EXPR_LE;
											    else
													expr.type=SS_play_expr.SS_EXPR_GE;
								 expr.Left = a; expr.Right = b; 
					}
					break;

			}

			 if (b==null) expr=a; 
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
	// $ANTLR end "relationalExpr"



	// $ANTLR start "additiveExpr"
	// SayScript.g:283:1: additiveExpr[SS_statement stat] returns [SS_play_expr expr] : a= multiplyExpr[stat] (j= ( PLUS | DASH ) b= multiplyExpr[stat] )? ;
	public final SS_play_expr additiveExpr(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		Token j=null;
		SS_play_expr a =null;
		SS_play_expr b =null;

		try {
			// SayScript.g:285:3: (a= multiplyExpr[stat] (j= ( PLUS | DASH ) b= multiplyExpr[stat] )? )
			// SayScript.g:285:5: a= multiplyExpr[stat] (j= ( PLUS | DASH ) b= multiplyExpr[stat] )?
			{
			pushFollow(FOLLOW_multiplyExpr_in_additiveExpr2130);
			a=multiplyExpr(stat);
			state._fsp--;

			// SayScript.g:285:26: (j= ( PLUS | DASH ) b= multiplyExpr[stat] )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==DASH||LA17_0==PLUS) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// SayScript.g:285:27: j= ( PLUS | DASH ) b= multiplyExpr[stat]
					{
					j=input.LT(1);
					if ( input.LA(1)==DASH||input.LA(1)==PLUS ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multiplyExpr_in_additiveExpr2144);
					b=multiplyExpr(stat);
					state._fsp--;

					expr = new SS_play_expr(); if((j!=null?j.getText():null).equals("+"))expr.type=SS_play_expr.SS_EXPR_PLUS; else expr.type=SS_play_expr.SS_EXPR_MINUS; expr.Left = a; expr.Right = b; 
					}
					break;

			}

			 if (b==null) expr=a; 
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
	// $ANTLR end "additiveExpr"



	// $ANTLR start "multiplyExpr"
	// SayScript.g:291:1: multiplyExpr[SS_statement stat] returns [SS_play_expr expr] : a= unaryExpr[stat] (j= ( MULT | DIV | MOD ) b= unaryExpr[stat] )? ;
	public final SS_play_expr multiplyExpr(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		Token j=null;
		SS_play_expr a =null;
		SS_play_expr b =null;

		try {
			// SayScript.g:293:3: (a= unaryExpr[stat] (j= ( MULT | DIV | MOD ) b= unaryExpr[stat] )? )
			// SayScript.g:293:5: a= unaryExpr[stat] (j= ( MULT | DIV | MOD ) b= unaryExpr[stat] )?
			{
			pushFollow(FOLLOW_unaryExpr_in_multiplyExpr2175);
			a=unaryExpr(stat);
			state._fsp--;

			// SayScript.g:293:23: (j= ( MULT | DIV | MOD ) b= unaryExpr[stat] )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==DIV||(LA18_0 >= MOD && LA18_0 <= MULT)) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// SayScript.g:293:24: j= ( MULT | DIV | MOD ) b= unaryExpr[stat]
					{
					j=input.LT(1);
					if ( input.LA(1)==DIV||(input.LA(1) >= MOD && input.LA(1) <= MULT) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unaryExpr_in_multiplyExpr2192);
					b=unaryExpr(stat);
					state._fsp--;

					expr = new SS_play_expr(); 
								 if ((j!=null?j.getText():null).equals("*"))
									expr.type=SS_play_expr.SS_EXPR_MULT; 
								 else if ((j!=null?j.getText():null).equals("/"))
									expr.type=SS_play_expr.SS_EXPR_DIV;
								 else 
									expr.type=SS_play_expr.SS_EXPR_MOD;
								expr.Left = a; expr.Right = b; 
					}
					break;

			}

			 if (b==null) expr=a; 
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
	// $ANTLR end "multiplyExpr"



	// $ANTLR start "unaryExpr"
	// SayScript.g:306:1: unaryExpr[SS_statement stat] returns [SS_play_expr expr] : ( BANG a= file_element[stat] |a= file_element[stat] );
	public final SS_play_expr unaryExpr(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		SS_play_expr a =null;

		try {
			// SayScript.g:308:3: ( BANG a= file_element[stat] |a= file_element[stat] )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BANG) ) {
				alt19=1;
			}
			else if ( (LA19_0==FE_Lsubr||LA19_0==ID||LA19_0==LCURLY||LA19_0==LPAR||LA19_0==NUM||LA19_0==PATHCONST) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// SayScript.g:308:5: BANG a= file_element[stat]
					{
					match(input,BANG,FOLLOW_BANG_in_unaryExpr2223); 
					pushFollow(FOLLOW_file_element_in_unaryExpr2227);
					a=file_element(stat);
					state._fsp--;

					expr = new SS_play_expr(); expr.type=SS_play_expr.SS_EXPR_NOT; expr.Left = a; 
					}
					break;
				case 2 :
					// SayScript.g:309:5: a= file_element[stat]
					{
					pushFollow(FOLLOW_file_element_in_unaryExpr2241);
					a=file_element(stat);
					state._fsp--;

					expr = a;  
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
		return expr;
	}
	// $ANTLR end "unaryExpr"



	// $ANTLR start "file_silence"
	// SayScript.g:314:1: file_silence[SS_statement stat] returns [SS_play_expr expr] : ( COLON | COMMA | PERIOD | SEMICOLON );
	public final SS_play_expr file_silence(SS_statement stat) throws RecognitionException {
		SS_play_expr expr = null;


		try {
			// SayScript.g:316:5: ( COLON | COMMA | PERIOD | SEMICOLON )
			int alt20=4;
			switch ( input.LA(1) ) {
			case COLON:
				{
				alt20=1;
				}
				break;
			case COMMA:
				{
				alt20=2;
				}
				break;
			case PERIOD:
				{
				alt20=3;
				}
				break;
			case SEMICOLON:
				{
				alt20=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// SayScript.g:316:7: COLON
					{
					match(input,COLON,FOLLOW_COLON_in_file_silence2269); 
					expr = new SS_play_expr(); expr.type=expr.SS_EXPR_SILENCE_COLON; 
					}
					break;
				case 2 :
					// SayScript.g:317:7: COMMA
					{
					match(input,COMMA,FOLLOW_COMMA_in_file_silence2279); 
					expr = new SS_play_expr();expr.type=expr.SS_EXPR_SILENCE_COMMA; 
					}
					break;
				case 3 :
					// SayScript.g:318:7: PERIOD
					{
					match(input,PERIOD,FOLLOW_PERIOD_in_file_silence2289); 
					expr = new SS_play_expr();expr.type=expr.SS_EXPR_SILENCE_PERIOD; 
					}
					break;
				case 4 :
					// SayScript.g:319:7: SEMICOLON
					{
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_file_silence2299); 
					expr = new SS_play_expr();expr.type=expr.SS_EXPR_SILENCE_SEMICOLON; 
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
		return expr;
	}
	// $ANTLR end "file_silence"



	// $ANTLR start "file_expr"
	// SayScript.g:323:1: file_expr[SS_statement stat] : (a= file_element[stat] |b= file_silence[stat] )+ ;
	public final void file_expr(SS_statement stat) throws RecognitionException {
		SS_play_expr a =null;
		SS_play_expr b =null;

		try {
			// SayScript.g:323:30: ( (a= file_element[stat] |b= file_silence[stat] )+ )
			// SayScript.g:323:32: (a= file_element[stat] |b= file_silence[stat] )+
			{
			// SayScript.g:323:32: (a= file_element[stat] |b= file_silence[stat] )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=3;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==FE_Lsubr||LA21_0==ID||LA21_0==LCURLY||LA21_0==LPAR||LA21_0==NUM||LA21_0==PATHCONST) ) {
					alt21=1;
				}
				else if ( ((LA21_0 >= COLON && LA21_0 <= COMMA)||LA21_0==PERIOD||LA21_0==SEMICOLON) ) {
					alt21=2;
				}

				switch (alt21) {
				case 1 :
					// SayScript.g:323:33: a= file_element[stat]
					{
					pushFollow(FOLLOW_file_element_in_file_expr2319);
					a=file_element(stat);
					state._fsp--;

					stat.playlist.add(a);
					}
					break;
				case 2 :
					// SayScript.g:323:87: b= file_silence[stat]
					{
					pushFollow(FOLLOW_file_silence_in_file_expr2329);
					b=file_silence(stat);
					state._fsp--;

					stat.playlist.add(b);
					}
					break;

				default :
					if ( cnt21 >= 1 ) break loop21;
					EarlyExitException eee = new EarlyExitException(21, input);
					throw eee;
				}
				cnt21++;
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
	}
	// $ANTLR end "file_expr"



	// $ANTLR start "varset"
	// SayScript.g:327:1: varset[SS_statement stat] : a= ID EQUALS (b= ID |c= NUM ) ( COMMA d= ID EQUALS (e= ID |f= NUM ) )* ;
	public final void varset(SS_statement stat) throws RecognitionException {
		Token a=null;
		Token b=null;
		Token c=null;
		Token d=null;
		Token e=null;
		Token f=null;


			  

		try {
			// SayScript.g:331:6: (a= ID EQUALS (b= ID |c= NUM ) ( COMMA d= ID EQUALS (e= ID |f= NUM ) )* )
			// SayScript.g:331:8: a= ID EQUALS (b= ID |c= NUM ) ( COMMA d= ID EQUALS (e= ID |f= NUM ) )*
			{
			a=(Token)match(input,ID,FOLLOW_ID_in_varset2369); 
			match(input,EQUALS,FOLLOW_EQUALS_in_varset2371); 
			// SayScript.g:331:20: (b= ID |c= NUM )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==ID) ) {
				alt22=1;
			}
			else if ( (LA22_0==NUM) ) {
				alt22=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// SayScript.g:331:21: b= ID
					{
					b=(Token)match(input,ID,FOLLOW_ID_in_varset2376); 
					  
											 SS_vardef var = new SS_vardef(); 
										  	 var.varname = (a!=null?a.getText():null); 
											 var.varval = (b!=null?b.getText():null); 
											 stat.varlist.add(var);
										  
					}
					break;
				case 2 :
					// SayScript.g:338:11: c= NUM
					{
					c=(Token)match(input,NUM,FOLLOW_NUM_in_varset2401); 

											 SS_vardef var = new SS_vardef(); 
										  	 var.varname = (a!=null?a.getText():null); 
											 var.varval = (c!=null?c.getText():null); 
											 stat.varlist.add(var);
										  
					}
					break;

			}

			// SayScript.g:344:44: ( COMMA d= ID EQUALS (e= ID |f= NUM ) )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==COMMA) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// SayScript.g:344:45: COMMA d= ID EQUALS (e= ID |f= NUM )
					{
					match(input,COMMA,FOLLOW_COMMA_in_varset2448); 
					d=(Token)match(input,ID,FOLLOW_ID_in_varset2452); 
					match(input,EQUALS,FOLLOW_EQUALS_in_varset2454); 
					// SayScript.g:344:63: (e= ID |f= NUM )
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==ID) ) {
						alt23=1;
					}
					else if ( (LA23_0==NUM) ) {
						alt23=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 23, 0, input);
						throw nvae;
					}

					switch (alt23) {
						case 1 :
							// SayScript.g:344:64: e= ID
							{
							e=(Token)match(input,ID,FOLLOW_ID_in_varset2459); 

													 SS_vardef var = new SS_vardef(); 
												  	 var.varname = (d!=null?d.getText():null); 
													 var.varval = (e!=null?e.getText():null); 
													 stat.varlist.add(var);
												  
							}
							break;
						case 2 :
							// SayScript.g:351:16: f= NUM
							{
							f=(Token)match(input,NUM,FOLLOW_NUM_in_varset2489); 

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
					break loop24;
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
	}
	// $ANTLR end "varset"



	// $ANTLR start "action"
	// SayScript.g:360:1: action[SS_statement stat] : ( ACT_DONE | ACT_RANGE | ACT_RESTART | ACT_NEGATE | ACT_CUT LPAR a= NUM RPAR | ACT_ZERO LPAR a= NUM RPAR );
	public final void action(SS_statement stat) throws RecognitionException {
		Token a=null;

		try {
			// SayScript.g:361:6: ( ACT_DONE | ACT_RANGE | ACT_RESTART | ACT_NEGATE | ACT_CUT LPAR a= NUM RPAR | ACT_ZERO LPAR a= NUM RPAR )
			int alt25=6;
			switch ( input.LA(1) ) {
			case ACT_DONE:
				{
				alt25=1;
				}
				break;
			case ACT_RANGE:
				{
				alt25=2;
				}
				break;
			case ACT_RESTART:
				{
				alt25=3;
				}
				break;
			case ACT_NEGATE:
				{
				alt25=4;
				}
				break;
			case ACT_CUT:
				{
				alt25=5;
				}
				break;
			case ACT_ZERO:
				{
				alt25=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// SayScript.g:361:8: ACT_DONE
					{
					match(input,ACT_DONE,FOLLOW_ACT_DONE_in_action2595); 
					stat.action.action_type = SS_action.SS_ACTION_DONE; 
					}
					break;
				case 2 :
					// SayScript.g:362:8: ACT_RANGE
					{
					match(input,ACT_RANGE,FOLLOW_ACT_RANGE_in_action2606); 
					stat.action.action_type = SS_action.SS_ACTION_RANGE_ERROR;
					}
					break;
				case 3 :
					// SayScript.g:363:8: ACT_RESTART
					{
					match(input,ACT_RESTART,FOLLOW_ACT_RESTART_in_action2617); 
					stat.action.action_type = SS_action.SS_ACTION_RESTART;
					}
					break;
				case 4 :
					// SayScript.g:364:8: ACT_NEGATE
					{
					match(input,ACT_NEGATE,FOLLOW_ACT_NEGATE_in_action2628); 
					stat.action.action_type = SS_action.SS_ACTION_NEGATE;
					}
					break;
				case 5 :
					// SayScript.g:365:8: ACT_CUT LPAR a= NUM RPAR
					{
					match(input,ACT_CUT,FOLLOW_ACT_CUT_in_action2640); 
					match(input,LPAR,FOLLOW_LPAR_in_action2642); 
					a=(Token)match(input,NUM,FOLLOW_NUM_in_action2646); 
					match(input,RPAR,FOLLOW_RPAR_in_action2648); 
					stat.action.action_type = SS_action.SS_ACTION_CUT; stat.action.arg = Integer.parseInt((a!=null?a.getText():null));
					}
					break;
				case 6 :
					// SayScript.g:366:8: ACT_ZERO LPAR a= NUM RPAR
					{
					match(input,ACT_ZERO,FOLLOW_ACT_ZERO_in_action2659); 
					match(input,LPAR,FOLLOW_LPAR_in_action2661); 
					a=(Token)match(input,NUM,FOLLOW_NUM_in_action2665); 
					match(input,RPAR,FOLLOW_RPAR_in_action2667); 
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
	}
	// $ANTLR end "action"



	// $ANTLR start "statement"
	// SayScript.g:369:1: statement[SS_scriptset scriptset, SS_script script] : ( WHITE )? ( ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) ) | ( COMMENT | NEWLINE ) ) ;
	public final void statement(SS_scriptset scriptset, SS_script script) throws RecognitionException {
		 SS_statement stat = new SS_statement(); 
		try {
			// SayScript.g:371:11: ( ( WHITE )? ( ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) ) | ( COMMENT | NEWLINE ) ) )
			// SayScript.g:371:13: ( WHITE )? ( ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) ) | ( COMMENT | NEWLINE ) )
			{
			// SayScript.g:371:13: ( WHITE )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==WHITE) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// SayScript.g:371:13: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_statement2700); 
					}
					break;

			}

			// SayScript.g:371:20: ( ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) ) | ( COMMENT | NEWLINE ) )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( ((LA31_0 >= ANYDATE && LA31_0 <= ATEXIT)||(LA31_0 >= DATEFUT_GREATER && LA31_0 <= DATEPAST_RANGE)||LA31_0==GREATER||LA31_0==HOUR_RANGE||LA31_0==LESS||LA31_0==MINUTE_RANGE||(LA31_0 >= NOTOPT && LA31_0 <= NOTVAR)||(LA31_0 >= NUMLEN && LA31_0 <= OPT)||LA31_0==PATTERN||LA31_0==RANGE||LA31_0==SECOND_RANGE||LA31_0==VAR||(LA31_0 >= YEAR_PATTERN && LA31_0 <= YEAR_RANGE)) ) {
				alt31=1;
			}
			else if ( (LA31_0==COMMENT||LA31_0==NEWLINE) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// SayScript.g:371:21: ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) )
					{
					// SayScript.g:371:21: ( oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT ) )
					// SayScript.g:371:22: oper_list[script,stat] WHITE ( arglist[script,stat] | DASH ) WHITE ( file_expr[stat] | DASH ) WHITE ( varset[stat] | DASH ) WHITE action[stat] ( WHITE )? ( NEWLINE | COMMENT )
					{
					pushFollow(FOLLOW_oper_list_in_statement2705);
					oper_list(script, stat);
					state._fsp--;

					match(input,WHITE,FOLLOW_WHITE_in_statement2708); 
					// SayScript.g:371:51: ( arglist[script,stat] | DASH )
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==DAYAMOUNT||LA27_0==ID||LA27_0==NUM||LA27_0==PAT) ) {
						alt27=1;
					}
					else if ( (LA27_0==DASH) ) {
						alt27=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 27, 0, input);
						throw nvae;
					}

					switch (alt27) {
						case 1 :
							// SayScript.g:371:52: arglist[script,stat]
							{
							pushFollow(FOLLOW_arglist_in_statement2711);
							arglist(script, stat);
							state._fsp--;

							}
							break;
						case 2 :
							// SayScript.g:371:75: DASH
							{
							match(input,DASH,FOLLOW_DASH_in_statement2716); 
							}
							break;

					}

					match(input,WHITE,FOLLOW_WHITE_in_statement2719); 
					// SayScript.g:371:87: ( file_expr[stat] | DASH )
					int alt28=2;
					int LA28_0 = input.LA(1);
					if ( ((LA28_0 >= COLON && LA28_0 <= COMMA)||LA28_0==FE_Lsubr||LA28_0==ID||LA28_0==LCURLY||LA28_0==LPAR||LA28_0==NUM||LA28_0==PATHCONST||LA28_0==PERIOD||LA28_0==SEMICOLON) ) {
						alt28=1;
					}
					else if ( (LA28_0==DASH) ) {
						alt28=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 28, 0, input);
						throw nvae;
					}

					switch (alt28) {
						case 1 :
							// SayScript.g:371:88: file_expr[stat]
							{
							pushFollow(FOLLOW_file_expr_in_statement2722);
							file_expr(stat);
							state._fsp--;

							}
							break;
						case 2 :
							// SayScript.g:371:106: DASH
							{
							match(input,DASH,FOLLOW_DASH_in_statement2727); 
							}
							break;

					}

					match(input,WHITE,FOLLOW_WHITE_in_statement2730); 
					// SayScript.g:371:118: ( varset[stat] | DASH )
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==ID) ) {
						alt29=1;
					}
					else if ( (LA29_0==DASH) ) {
						alt29=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 29, 0, input);
						throw nvae;
					}

					switch (alt29) {
						case 1 :
							// SayScript.g:371:119: varset[stat]
							{
							pushFollow(FOLLOW_varset_in_statement2733);
							varset(stat);
							state._fsp--;

							}
							break;
						case 2 :
							// SayScript.g:371:134: DASH
							{
							match(input,DASH,FOLLOW_DASH_in_statement2738); 
							}
							break;

					}

					match(input,WHITE,FOLLOW_WHITE_in_statement2741); 
					pushFollow(FOLLOW_action_in_statement2743);
					action(stat);
					state._fsp--;

					// SayScript.g:371:159: ( WHITE )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==WHITE) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// SayScript.g:371:159: WHITE
							{
							match(input,WHITE,FOLLOW_WHITE_in_statement2746); 
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
					// SayScript.g:371:189: ( COMMENT | NEWLINE )
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
	}
	// $ANTLR end "statement"



	// $ANTLR start "statement_list"
	// SayScript.g:412:1: statement_list[SS_scriptset scriptset, SS_script script] : ( statement[scriptset,script] )+ ;
	public final void statement_list(SS_scriptset scriptset, SS_script script) throws RecognitionException {
		try {
			// SayScript.g:412:58: ( ( statement[scriptset,script] )+ )
			// SayScript.g:412:60: ( statement[scriptset,script] )+
			{
			// SayScript.g:412:60: ( statement[scriptset,script] )+
			int cnt32=0;
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==WHITE) ) {
					int LA32_2 = input.LA(2);
					if ( ((LA32_2 >= ANYDATE && LA32_2 <= ATEXIT)||LA32_2==COMMENT||(LA32_2 >= DATEFUT_GREATER && LA32_2 <= DATEPAST_RANGE)||LA32_2==GREATER||LA32_2==HOUR_RANGE||LA32_2==LESS||LA32_2==MINUTE_RANGE||LA32_2==NEWLINE||(LA32_2 >= NOTOPT && LA32_2 <= NOTVAR)||(LA32_2 >= NUMLEN && LA32_2 <= OPT)||LA32_2==PATTERN||LA32_2==RANGE||LA32_2==SECOND_RANGE||LA32_2==VAR||(LA32_2 >= YEAR_PATTERN && LA32_2 <= YEAR_RANGE)) ) {
						alt32=1;
					}

				}
				else if ( ((LA32_0 >= ANYDATE && LA32_0 <= ATEXIT)||LA32_0==COMMENT||(LA32_0 >= DATEFUT_GREATER && LA32_0 <= DATEPAST_RANGE)||LA32_0==GREATER||LA32_0==HOUR_RANGE||LA32_0==LESS||LA32_0==MINUTE_RANGE||LA32_0==NEWLINE||(LA32_0 >= NOTOPT && LA32_0 <= NOTVAR)||(LA32_0 >= NUMLEN && LA32_0 <= OPT)||LA32_0==PATTERN||LA32_0==RANGE||LA32_0==SECOND_RANGE||LA32_0==VAR||(LA32_0 >= YEAR_PATTERN && LA32_0 <= YEAR_RANGE)) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// SayScript.g:412:60: statement[scriptset,script]
					{
					pushFollow(FOLLOW_statement_in_statement_list2790);
					statement(scriptset, script);
					state._fsp--;

					}
					break;

				default :
					if ( cnt32 >= 1 ) break loop32;
					EarlyExitException eee = new EarlyExitException(32, input);
					throw eee;
				}
				cnt32++;
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
	}
	// $ANTLR end "statement_list"



	// $ANTLR start "header"
	// SayScript.g:414:1: header[SS_scriptset scriptset, SS_script script] : ( WHITE )? LBRACK x= ID ( COMMA y= ID )* RBRACK ( WHITE )? ( NEWLINE | COMMENT ) ;
	public final void header(SS_scriptset scriptset, SS_script script) throws RecognitionException {
		Token x=null;
		Token y=null;

		try {
			// SayScript.g:414:50: ( ( WHITE )? LBRACK x= ID ( COMMA y= ID )* RBRACK ( WHITE )? ( NEWLINE | COMMENT ) )
			// SayScript.g:414:52: ( WHITE )? LBRACK x= ID ( COMMA y= ID )* RBRACK ( WHITE )? ( NEWLINE | COMMENT )
			{
			// SayScript.g:414:52: ( WHITE )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==WHITE) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// SayScript.g:414:52: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_header2805); 
					}
					break;

			}

			match(input,LBRACK,FOLLOW_LBRACK_in_header2808); 
			x=(Token)match(input,ID,FOLLOW_ID_in_header2812); 

					SS_script_name z3 = new SS_script_name((x!=null?x.getText():null)); 
			        script.names.add(z3); 
			        // Add the name to the script set hash table
					scriptset.by_name.put((x!=null?x.getText():null), script);
					/* System.out.println("### Adding name "+(x!=null?x.getText():null)+" to the scriptset"); */
					script.script_type = script.get_type_for_name((x!=null?x.getText():null));
					if (script.script_type == script.SS_S_TYPE_DATE_FORMAT) {
					   scriptset.date_format_list.add(script);
					}
			     
			// SayScript.g:425:8: ( COMMA y= ID )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==COMMA) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// SayScript.g:425:9: COMMA y= ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_header2822); 
					y=(Token)match(input,ID,FOLLOW_ID_in_header2826); 

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
					break loop34;
				}
			}

			match(input,RBRACK,FOLLOW_RBRACK_in_header2842); 
			// SayScript.g:435:21: ( WHITE )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==WHITE) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// SayScript.g:435:21: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_header2844); 
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
	}
	// $ANTLR end "header"



	// $ANTLR start "silence_statement"
	// SayScript.g:437:1: silence_statement[SS_scriptset scriptset] : ( WHITE )? nam= ID ( WHITE )? EQUALS ( WHITE )? ( ( LANG pc= PATHCONST RANG )+ | DASH ) ( WHITE )? ( NEWLINE | COMMENT ) ;
	public final void silence_statement(SS_scriptset scriptset) throws RecognitionException {
		Token nam=null;
		Token pc=null;

		 SS_silence_def sd = new SS_silence_def(); if(sd != null) scriptset.silence_def_list.add(sd);
		try {
			// SayScript.g:439:19: ( ( WHITE )? nam= ID ( WHITE )? EQUALS ( WHITE )? ( ( LANG pc= PATHCONST RANG )+ | DASH ) ( WHITE )? ( NEWLINE | COMMENT ) )
			// SayScript.g:439:21: ( WHITE )? nam= ID ( WHITE )? EQUALS ( WHITE )? ( ( LANG pc= PATHCONST RANG )+ | DASH ) ( WHITE )? ( NEWLINE | COMMENT )
			{
			// SayScript.g:439:21: ( WHITE )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==WHITE) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// SayScript.g:439:21: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_silence_statement2886); 
					}
					break;

			}

			nam=(Token)match(input,ID,FOLLOW_ID_in_silence_statement2891); 
			// SayScript.g:439:35: ( WHITE )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==WHITE) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// SayScript.g:439:35: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_silence_statement2893); 
					}
					break;

			}

			match(input,EQUALS,FOLLOW_EQUALS_in_silence_statement2896); 
			// SayScript.g:439:49: ( WHITE )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==WHITE) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// SayScript.g:439:49: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_silence_statement2898); 
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
			   
			// SayScript.g:510:11: ( ( LANG pc= PATHCONST RANG )+ | DASH )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==LANG) ) {
				alt40=1;
			}
			else if ( (LA40_0==DASH) ) {
				alt40=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// SayScript.g:510:13: ( LANG pc= PATHCONST RANG )+
					{
					// SayScript.g:510:13: ( LANG pc= PATHCONST RANG )+
					int cnt39=0;
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==LANG) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// SayScript.g:510:14: LANG pc= PATHCONST RANG
							{
							match(input,LANG,FOLLOW_LANG_in_silence_statement2920); 
							pc=(Token)match(input,PATHCONST,FOLLOW_PATHCONST_in_silence_statement2924); 
							match(input,RANG,FOLLOW_RANG_in_silence_statement2926); 
							SS_playlist pl = new SS_playlist(); pl.str = (pc!=null?pc.getText():null); sd.playfiles.add(pl);
							}
							break;

						default :
							if ( cnt39 >= 1 ) break loop39;
							EarlyExitException eee = new EarlyExitException(39, input);
							throw eee;
						}
						cnt39++;
					}

					}
					break;
				case 2 :
					// SayScript.g:510:121: DASH
					{
					match(input,DASH,FOLLOW_DASH_in_silence_statement2935); 
					}
					break;

			}

			// SayScript.g:510:127: ( WHITE )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==WHITE) ) {
				alt41=1;
			}
			switch (alt41) {
				case 1 :
					// SayScript.g:510:127: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_silence_statement2938); 
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
	}
	// $ANTLR end "silence_statement"



	// $ANTLR start "silence_statement_list"
	// SayScript.g:513:1: silence_statement_list[SS_scriptset scriptset] : ( silence_statement[scriptset] )+ ;
	public final void silence_statement_list(SS_scriptset scriptset) throws RecognitionException {
		try {
			// SayScript.g:513:48: ( ( silence_statement[scriptset] )+ )
			// SayScript.g:513:50: ( silence_statement[scriptset] )+
			{
			// SayScript.g:513:50: ( silence_statement[scriptset] )+
			int cnt42=0;
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==WHITE) ) {
					int LA42_2 = input.LA(2);
					if ( (LA42_2==ID) ) {
						alt42=1;
					}

				}
				else if ( (LA42_0==ID) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// SayScript.g:513:50: silence_statement[scriptset]
					{
					pushFollow(FOLLOW_silence_statement_in_silence_statement_list2963);
					silence_statement(scriptset);
					state._fsp--;

					}
					break;

				default :
					if ( cnt42 >= 1 ) break loop42;
					EarlyExitException eee = new EarlyExitException(42, input);
					throw eee;
				}
				cnt42++;
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
	}
	// $ANTLR end "silence_statement_list"



	// $ANTLR start "silence_header"
	// SayScript.g:515:1: silence_header : ( WHITE )? LBRACK HDR_SILENCE RBRACK ( WHITE )? ( NEWLINE | COMMENT ) ;
	public final void silence_header() throws RecognitionException {
		try {
			// SayScript.g:515:16: ( ( WHITE )? LBRACK HDR_SILENCE RBRACK ( WHITE )? ( NEWLINE | COMMENT ) )
			// SayScript.g:515:18: ( WHITE )? LBRACK HDR_SILENCE RBRACK ( WHITE )? ( NEWLINE | COMMENT )
			{
			// SayScript.g:515:18: ( WHITE )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==WHITE) ) {
				alt43=1;
			}
			switch (alt43) {
				case 1 :
					// SayScript.g:515:18: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_silence_header2976); 
					}
					break;

			}

			match(input,LBRACK,FOLLOW_LBRACK_in_silence_header2979); 
			match(input,HDR_SILENCE,FOLLOW_HDR_SILENCE_in_silence_header2981); 
			match(input,RBRACK,FOLLOW_RBRACK_in_silence_header2983); 
			// SayScript.g:515:51: ( WHITE )?
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==WHITE) ) {
				alt44=1;
			}
			switch (alt44) {
				case 1 :
					// SayScript.g:515:51: WHITE
					{
					match(input,WHITE,FOLLOW_WHITE_in_silence_header2985); 
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
	}
	// $ANTLR end "silence_header"



	// $ANTLR start "script"
	// SayScript.g:518:1: script[SS_scriptset scriptset] returns [SS_script script] : (hdr= header[scriptset, script] statement_list[scriptset, script] | silence_header silence_statement_list[scriptset] );
	public final SS_script script(SS_scriptset scriptset) throws RecognitionException {
		SS_script script = null;


		 script = new SS_script();    
		try {
			// SayScript.g:521:8: (hdr= header[scriptset, script] statement_list[scriptset, script] | silence_header silence_statement_list[scriptset] )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==WHITE) ) {
				int LA45_1 = input.LA(2);
				if ( (LA45_1==LBRACK) ) {
					int LA45_2 = input.LA(3);
					if ( (LA45_2==ID) ) {
						alt45=1;
					}
					else if ( (LA45_2==HDR_SILENCE) ) {
						alt45=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 45, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 45, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA45_0==LBRACK) ) {
				int LA45_2 = input.LA(2);
				if ( (LA45_2==ID) ) {
					alt45=1;
				}
				else if ( (LA45_2==HDR_SILENCE) ) {
					alt45=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 45, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// SayScript.g:521:10: hdr= header[scriptset, script] statement_list[scriptset, script]
					{
					pushFollow(FOLLOW_header_in_script3025);
					header(scriptset, script);
					state._fsp--;

					pushFollow(FOLLOW_statement_list_in_script3028);
					statement_list(scriptset, script);
					state._fsp--;

					}
					break;
				case 2 :
					// SayScript.g:522:10: silence_header silence_statement_list[scriptset]
					{
					pushFollow(FOLLOW_silence_header_in_script3040);
					silence_header();
					state._fsp--;

					pushFollow(FOLLOW_silence_statement_list_in_script3042);
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
	// SayScript.g:525:1: script_set[ArrayList<SS_log> log_list] returns [SS_scriptset scriptset] : ( ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset] )+ ;
	public final SS_scriptset script_set(ArrayList<SS_log> log_list) throws RecognitionException {
		SS_scriptset scriptset = null;


		 scriptset = new SS_scriptset(); scriptset.log_list = log_list; 
		try {
			// SayScript.g:528:8: ( ( ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset] )+ )
			// SayScript.g:528:10: ( ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset] )+
			{
			// SayScript.g:528:10: ( ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset] )+
			int cnt48=0;
			loop48:
			while (true) {
				int alt48=2;
				int LA48_0 = input.LA(1);
				if ( (LA48_0==COMMENT||LA48_0==LBRACK||LA48_0==NEWLINE||LA48_0==WHITE) ) {
					alt48=1;
				}

				switch (alt48) {
				case 1 :
					// SayScript.g:528:11: ( ( WHITE )? ( COMMENT | NEWLINE ) )* script[scriptset]
					{
					// SayScript.g:528:11: ( ( WHITE )? ( COMMENT | NEWLINE ) )*
					loop47:
					while (true) {
						int alt47=2;
						int LA47_0 = input.LA(1);
						if ( (LA47_0==WHITE) ) {
							int LA47_1 = input.LA(2);
							if ( (LA47_1==COMMENT||LA47_1==NEWLINE) ) {
								alt47=1;
							}

						}
						else if ( (LA47_0==COMMENT||LA47_0==NEWLINE) ) {
							alt47=1;
						}

						switch (alt47) {
						case 1 :
							// SayScript.g:528:12: ( WHITE )? ( COMMENT | NEWLINE )
							{
							// SayScript.g:528:12: ( WHITE )?
							int alt46=2;
							int LA46_0 = input.LA(1);
							if ( (LA46_0==WHITE) ) {
								alt46=1;
							}
							switch (alt46) {
								case 1 :
									// SayScript.g:528:12: WHITE
									{
									match(input,WHITE,FOLLOW_WHITE_in_script_set3080); 
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
							break loop47;
						}
					}

					pushFollow(FOLLOW_script_in_script_set3093);
					script(scriptset);
					state._fsp--;

					}
					break;

				default :
					if ( cnt48 >= 1 ) break loop48;
					EarlyExitException eee = new EarlyExitException(48, input);
					throw eee;
				}
				cnt48++;
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
		return scriptset;
	}
	// $ANTLR end "script_set"

	// Delegated rules



	public static final BitSet FOLLOW_RANGE_in_oper789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PATTERN_in_oper797 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATER_in_oper810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LESS_in_oper818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VAR_in_oper826 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOTVAR_in_oper834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMLEN_in_oper853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATBEGIN_in_oper860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATEXIT_in_oper867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATEPAST_RANGE_in_oper886 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATEFUT_RANGE_in_oper893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATEPAST_GREATER_in_oper913 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DATEFUT_GREATER_in_oper933 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ANYDATE_in_oper952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUTE_RANGE_in_oper960 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SECOND_RANGE_in_oper969 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_HOUR_RANGE_in_oper989 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YEAR_RANGE_in_oper997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPT_in_oper1005 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOTOPT_in_oper1025 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YEAR_PATTERN_in_oper1033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_oper_in_oper_list1047 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_oper_list1064 = new BitSet(new long[]{0x88280000003C1C00L,0x00000000035109B0L});
	public static final BitSet FOLLOW_oper_in_oper_list1068 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_NUM_in_arg1135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_arg1148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PAT_in_arg1161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAYAMOUNT_in_arg1173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_in_arglist1209 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_arglist1216 = new BitSet(new long[]{0x0040000000400000L,0x0000000000000240L});
	public static final BitSet FOLLOW_arg_in_arglist1220 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_LCURLY_in_file_var1262 = new BitSet(new long[]{0x0003FFFFF0000000L});
	public static final BitSet FOLLOW_FE_num_in_file_var1267 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_opt_in_file_var1272 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COLON_in_file_var1274 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_ID_in_file_var1278 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_length_in_file_var1288 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_sec_in_file_var1313 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_min_in_file_var1319 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_12hour_in_file_var1344 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_12hour2d_in_file_var1350 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_24hour_in_file_var1374 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_24hour2d_in_file_var1380 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_ampm_in_file_var1392 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_xm_in_file_var1417 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_cm_in_file_var1423 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_time_tz_in_file_var1429 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_date_dom_in_file_var1453 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_date_dow_in_file_var1459 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_date_month_in_file_var1484 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_date_dowstr_in_file_var1490 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_date_monthstr_in_file_var1515 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_date_year_in_file_var1522 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_date_century_in_file_var1535 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_date_decade_in_file_var1542 = new BitSet(new long[]{0x0100000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_LBRACK_in_file_var1574 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_playexpr_in_file_var1578 = new BitSet(new long[]{0x0000000000004000L,0x0000000000020000L});
	public static final BitSet FOLLOW_COLON_in_file_var1598 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_playexpr_in_file_var1602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_RBRACK_in_file_var1609 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_FE_timeval_in_file_var1636 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_RCURLY_in_file_var1642 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FE_Lsubr_in_subcall1679 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_ID_in_subcall1683 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COLON_in_subcall1693 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_OPT_in_subcall1695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_PATHCONST_in_subcall1699 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COLON_in_subcall1724 = new BitSet(new long[]{0x0200000008000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_PATHCONST_in_subcall1729 = new BitSet(new long[]{0x0200000008000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_file_var_in_subcall1762 = new BitSet(new long[]{0x0200000008000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_FE_Rsubr_in_subcall1770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PATHCONST_in_file_element1801 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_file_element1818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_file_var_in_file_element1834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subcall_in_file_element1852 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_file_element1870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_file_element1884 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_playexpr_in_file_element1888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_RPAR_in_file_element1891 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logicalOrExpr_in_playexpr1923 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
	public static final BitSet FOLLOW_QUESTION_in_playexpr1927 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_logicalOrExpr_in_playexpr1931 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_COLON_in_playexpr1934 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_logicalOrExpr_in_playexpr1938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logicalAndExpr_in_logicalOrExpr1965 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_LOG_OR_in_logicalOrExpr1969 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_logicalAndExpr_in_logicalOrExpr1973 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_equalityExpr_in_logicalAndExpr1999 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_LOG_AND_in_logicalAndExpr2003 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_equalityExpr_in_logicalAndExpr2007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relationalExpr_in_equalityExpr2033 = new BitSet(new long[]{0x0000000001000002L,0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_equalityExpr2039 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_relationalExpr_in_equalityExpr2049 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_additiveExpr_in_relationalExpr2078 = new BitSet(new long[]{0x0484000000000002L,0x0000000000008000L});
	public static final BitSet FOLLOW_set_in_relationalExpr2084 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_additiveExpr_in_relationalExpr2096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multiplyExpr_in_additiveExpr2130 = new BitSet(new long[]{0x0000000000020002L,0x0000000000002000L});
	public static final BitSet FOLLOW_set_in_additiveExpr2136 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_multiplyExpr_in_additiveExpr2144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unaryExpr_in_multiplyExpr2175 = new BitSet(new long[]{0x0000000000800002L,0x0000000000000003L});
	public static final BitSet FOLLOW_set_in_multiplyExpr2181 = new BitSet(new long[]{0x4240000004002000L,0x0000000000000440L});
	public static final BitSet FOLLOW_unaryExpr_in_multiplyExpr2192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BANG_in_unaryExpr2223 = new BitSet(new long[]{0x4240000004000000L,0x0000000000000440L});
	public static final BitSet FOLLOW_file_element_in_unaryExpr2227 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_file_element_in_unaryExpr2241 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COLON_in_file_silence2269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_file_silence2279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PERIOD_in_file_silence2289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEMICOLON_in_file_silence2299 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_file_element_in_file_expr2319 = new BitSet(new long[]{0x424000000400C002L,0x0000000000201440L});
	public static final BitSet FOLLOW_file_silence_in_file_expr2329 = new BitSet(new long[]{0x424000000400C002L,0x0000000000201440L});
	public static final BitSet FOLLOW_ID_in_varset2369 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_EQUALS_in_varset2371 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_varset2376 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_NUM_in_varset2401 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_COMMA_in_varset2448 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_ID_in_varset2452 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_EQUALS_in_varset2454 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_ID_in_varset2459 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_NUM_in_varset2489 = new BitSet(new long[]{0x0000000000008002L});
	public static final BitSet FOLLOW_ACT_DONE_in_action2595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACT_RANGE_in_action2606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACT_RESTART_in_action2617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACT_NEGATE_in_action2628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACT_CUT_in_action2640 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_LPAR_in_action2642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_NUM_in_action2646 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_RPAR_in_action2648 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACT_ZERO_in_action2659 = new BitSet(new long[]{0x4000000000000000L});
	public static final BitSet FOLLOW_LPAR_in_action2661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_NUM_in_action2665 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_RPAR_in_action2667 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHITE_in_statement2700 = new BitSet(new long[]{0x88280000003D1C00L,0x00000000035109B4L});
	public static final BitSet FOLLOW_oper_list_in_statement2705 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_WHITE_in_statement2708 = new BitSet(new long[]{0x0040000000420000L,0x0000000000000240L});
	public static final BitSet FOLLOW_arglist_in_statement2711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_DASH_in_statement2716 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_WHITE_in_statement2719 = new BitSet(new long[]{0x424000000402C000L,0x0000000000201440L});
	public static final BitSet FOLLOW_file_expr_in_statement2722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_DASH_in_statement2727 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_WHITE_in_statement2730 = new BitSet(new long[]{0x0040000000020000L});
	public static final BitSet FOLLOW_varset_in_statement2733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_DASH_in_statement2738 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_WHITE_in_statement2741 = new BitSet(new long[]{0x00000000000003F0L});
	public static final BitSet FOLLOW_action_in_statement2743 = new BitSet(new long[]{0x0000000000010000L,0x0000000000800004L});
	public static final BitSet FOLLOW_WHITE_in_statement2746 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_set_in_statement2749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_statement2760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statement_list2790 = new BitSet(new long[]{0x88280000003D1C02L,0x0000000003D109B4L});
	public static final BitSet FOLLOW_WHITE_in_header2805 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_LBRACK_in_header2808 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_ID_in_header2812 = new BitSet(new long[]{0x0000000000008000L,0x0000000000020000L});
	public static final BitSet FOLLOW_COMMA_in_header2822 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_ID_in_header2826 = new BitSet(new long[]{0x0000000000008000L,0x0000000000020000L});
	public static final BitSet FOLLOW_RBRACK_in_header2842 = new BitSet(new long[]{0x0000000000010000L,0x0000000000800004L});
	public static final BitSet FOLLOW_WHITE_in_header2844 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_set_in_header2847 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHITE_in_silence_statement2886 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_ID_in_silence_statement2891 = new BitSet(new long[]{0x0000000002000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_WHITE_in_silence_statement2893 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_EQUALS_in_silence_statement2896 = new BitSet(new long[]{0x0080000000020000L,0x0000000000800000L});
	public static final BitSet FOLLOW_WHITE_in_silence_statement2898 = new BitSet(new long[]{0x0080000000020000L});
	public static final BitSet FOLLOW_LANG_in_silence_statement2920 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_PATHCONST_in_silence_statement2924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_RANG_in_silence_statement2926 = new BitSet(new long[]{0x0080000000010000L,0x0000000000800004L});
	public static final BitSet FOLLOW_DASH_in_silence_statement2935 = new BitSet(new long[]{0x0000000000010000L,0x0000000000800004L});
	public static final BitSet FOLLOW_WHITE_in_silence_statement2938 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_set_in_silence_statement2941 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_silence_statement_in_silence_statement_list2963 = new BitSet(new long[]{0x0040000000000002L,0x0000000000800000L});
	public static final BitSet FOLLOW_WHITE_in_silence_header2976 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_LBRACK_in_silence_header2979 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_HDR_SILENCE_in_silence_header2981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_RBRACK_in_silence_header2983 = new BitSet(new long[]{0x0000000000010000L,0x0000000000800004L});
	public static final BitSet FOLLOW_WHITE_in_silence_header2985 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_set_in_silence_header2988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_header_in_script3025 = new BitSet(new long[]{0x88280000003D1C00L,0x0000000003D109B4L});
	public static final BitSet FOLLOW_statement_list_in_script3028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_silence_header_in_script3040 = new BitSet(new long[]{0x0040000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_silence_statement_list_in_script3042 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHITE_in_script_set3080 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
	public static final BitSet FOLLOW_set_in_script_set3083 = new BitSet(new long[]{0x0100000000010000L,0x0000000000800004L});
	public static final BitSet FOLLOW_script_in_script_set3093 = new BitSet(new long[]{0x0100000000010002L,0x0000000000800004L});
}
