// Generated from lab.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class labParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		Hexadecimal_prefix=25, Decimal_const=26, Octal_const=27, Hexadecimal_const=28, 
		RET=29, Condop1=30, Condop2=31, CONTINUE=32, BREAK=33, Ident=34;
	public static final int
		RULE_btype = 0, RULE_functype = 1, RULE_unaryop = 2, RULE_compunit = 3, 
		RULE_number = 4, RULE_funcDef = 5, RULE_funcfparams = 6, RULE_funcfparam = 7, 
		RULE_block = 8, RULE_blockItem = 9, RULE_unaryexp = 10, RULE_stmt = 11, 
		RULE_decl = 12, RULE_constdecl = 13, RULE_constdef = 14, RULE_constinitval = 15, 
		RULE_constexp = 16, RULE_vardecl = 17, RULE_vardef = 18, RULE_initval = 19, 
		RULE_exp = 20, RULE_addexp = 21, RULE_mulexp = 22, RULE_funcrparams = 23, 
		RULE_primaryexp = 24, RULE_lval = 25, RULE_cond = 26, RULE_relexp = 27, 
		RULE_eqexp = 28, RULE_landexp = 29, RULE_lorexp = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"btype", "functype", "unaryop", "compunit", "number", "funcDef", "funcfparams", 
			"funcfparam", "block", "blockItem", "unaryexp", "stmt", "decl", "constdecl", 
			"constdef", "constinitval", "constexp", "vardecl", "vardef", "initval", 
			"exp", "addexp", "mulexp", "funcrparams", "primaryexp", "lval", "cond", 
			"relexp", "eqexp", "landexp", "lorexp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'void'", "'+'", "'-'", "'!'", "'('", "')'", "','", "'['", 
			"']'", "'{'", "'}'", "'return'", "';'", "'='", "'if'", "'else'", "'while'", 
			"'const'", "'*'", "'/'", "'%'", "'&&'", "'||'", null, null, null, null, 
			null, null, null, "'continue'", "'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "Hexadecimal_prefix", "Decimal_const", "Octal_const", "Hexadecimal_const", 
			"RET", "Condop1", "Condop2", "CONTINUE", "BREAK", "Ident"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "lab.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public labParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class BtypeContext extends ParserRuleContext {
		public BtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_btype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterBtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitBtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitBtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BtypeContext btype() throws RecognitionException {
		BtypeContext _localctx = new BtypeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_btype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctypeContext extends ParserRuleContext {
		public FunctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterFunctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitFunctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitFunctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctypeContext functype() throws RecognitionException {
		FunctypeContext _localctx = new FunctypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryopContext extends ParserRuleContext {
		public UnaryopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterUnaryop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitUnaryop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitUnaryop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryopContext unaryop() throws RecognitionException {
		UnaryopContext _localctx = new UnaryopContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_unaryop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompunitContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public CompunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compunit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterCompunit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitCompunit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitCompunit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompunitContext compunit() throws RecognitionException {
		CompunitContext _localctx = new CompunitContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_compunit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(70);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(68);
					decl();
					}
					break;
				case 2:
					{
					setState(69);
					funcDef();
					}
					break;
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__18))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode Decimal_const() { return getToken(labParser.Decimal_const, 0); }
		public TerminalNode Octal_const() { return getToken(labParser.Octal_const, 0); }
		public TerminalNode Hexadecimal_const() { return getToken(labParser.Hexadecimal_const, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public FunctypeContext functype() {
			return getRuleContext(FunctypeContext.class,0);
		}
		public TerminalNode Ident() { return getToken(labParser.Ident, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncfparamsContext funcfparams() {
			return getRuleContext(FuncfparamsContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			functype();
			setState(77);
			match(Ident);
			setState(78);
			match(T__5);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(79);
				funcfparams();
				}
			}

			setState(82);
			match(T__6);
			setState(83);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncfparamsContext extends ParserRuleContext {
		public List<FuncfparamContext> funcfparam() {
			return getRuleContexts(FuncfparamContext.class);
		}
		public FuncfparamContext funcfparam(int i) {
			return getRuleContext(FuncfparamContext.class,i);
		}
		public FuncfparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcfparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterFuncfparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitFuncfparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitFuncfparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncfparamsContext funcfparams() throws RecognitionException {
		FuncfparamsContext _localctx = new FuncfparamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcfparams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			funcfparam();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(86);
				match(T__7);
				setState(87);
				funcfparam();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncfparamContext extends ParserRuleContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public TerminalNode Ident() { return getToken(labParser.Ident, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncfparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcfparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterFuncfparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitFuncfparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitFuncfparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncfparamContext funcfparam() throws RecognitionException {
		FuncfparamContext _localctx = new FuncfparamContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcfparam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			btype();
			setState(94);
			match(Ident);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(95);
				match(T__8);
				setState(96);
				match(T__9);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(97);
					match(T__8);
					setState(98);
					exp();
					setState(99);
					match(T__9);
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__10);
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				blockItem();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const) | (1L << CONTINUE) | (1L << BREAK) | (1L << Ident))) != 0) );
			setState(114);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blockItem);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				decl();
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__10:
			case T__12:
			case T__13:
			case T__15:
			case T__17:
			case Decimal_const:
			case Octal_const:
			case Hexadecimal_const:
			case CONTINUE:
			case BREAK:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryexpContext extends ParserRuleContext {
		public PrimaryexpContext primaryexp() {
			return getRuleContext(PrimaryexpContext.class,0);
		}
		public UnaryopContext unaryop() {
			return getRuleContext(UnaryopContext.class,0);
		}
		public UnaryexpContext unaryexp() {
			return getRuleContext(UnaryexpContext.class,0);
		}
		public TerminalNode Ident() { return getToken(labParser.Ident, 0); }
		public FuncrparamsContext funcrparams() {
			return getRuleContext(FuncrparamsContext.class,0);
		}
		public UnaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterUnaryexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitUnaryexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitUnaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryexpContext unaryexp() throws RecognitionException {
		UnaryexpContext _localctx = new UnaryexpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unaryexp);
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				primaryexp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				unaryop();
				setState(122);
				unaryexp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(Ident);
				setState(125);
				match(T__5);
				setState(126);
				funcrparams();
				setState(127);
				match(T__6);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(labParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(labParser.CONTINUE, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stmt);
		int _la;
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(T__12);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const) | (1L << Ident))) != 0)) {
					{
					setState(132);
					exp();
					}
				}

				setState(135);
				match(T__13);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const) | (1L << Ident))) != 0)) {
					{
					setState(136);
					exp();
					}
				}

				setState(139);
				match(T__13);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				lval();
				setState(141);
				match(T__14);
				setState(142);
				exp();
				setState(143);
				match(T__13);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				match(T__15);
				setState(146);
				match(T__5);
				setState(147);
				cond();
				setState(148);
				match(T__6);
				setState(149);
				stmt();
				setState(152);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(150);
					match(T__16);
					setState(151);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(155);
				match(T__17);
				setState(156);
				match(T__5);
				setState(157);
				cond();
				setState(158);
				match(T__6);
				setState(159);
				stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(161);
				match(BREAK);
				setState(162);
				match(T__13);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(163);
				match(CONTINUE);
				setState(164);
				match(T__13);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public ConstdeclContext constdecl() {
			return getRuleContext(ConstdeclContext.class,0);
		}
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_decl);
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				constdecl();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				vardecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstdeclContext extends ParserRuleContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public List<ConstdefContext> constdef() {
			return getRuleContexts(ConstdefContext.class);
		}
		public ConstdefContext constdef(int i) {
			return getRuleContext(ConstdefContext.class,i);
		}
		public ConstdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterConstdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitConstdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitConstdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstdeclContext constdecl() throws RecognitionException {
		ConstdeclContext _localctx = new ConstdeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__18);
			setState(172);
			btype();
			setState(173);
			constdef();
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(174);
				match(T__7);
				setState(175);
				constdef();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstdefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(labParser.Ident, 0); }
		public ConstinitvalContext constinitval() {
			return getRuleContext(ConstinitvalContext.class,0);
		}
		public List<ConstexpContext> constexp() {
			return getRuleContexts(ConstexpContext.class);
		}
		public ConstexpContext constexp(int i) {
			return getRuleContext(ConstexpContext.class,i);
		}
		public ConstdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterConstdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitConstdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitConstdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstdefContext constdef() throws RecognitionException {
		ConstdefContext _localctx = new ConstdefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(Ident);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(184);
				match(T__8);
				setState(185);
				constexp();
				setState(186);
				match(T__9);
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
			match(T__14);
			setState(194);
			constinitval();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstinitvalContext extends ParserRuleContext {
		public ConstexpContext constexp() {
			return getRuleContext(ConstexpContext.class,0);
		}
		public List<ConstinitvalContext> constinitval() {
			return getRuleContexts(ConstinitvalContext.class);
		}
		public ConstinitvalContext constinitval(int i) {
			return getRuleContext(ConstinitvalContext.class,i);
		}
		public ConstinitvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constinitval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterConstinitval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitConstinitval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitConstinitval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstinitvalContext constinitval() throws RecognitionException {
		ConstinitvalContext _localctx = new ConstinitvalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constinitval);
		int _la;
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case Decimal_const:
			case Octal_const:
			case Hexadecimal_const:
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				constexp();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(T__10);
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__10) | (1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const) | (1L << Ident))) != 0)) {
					{
					setState(198);
					constinitval();
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(199);
						match(T__7);
						setState(200);
						constinitval();
						}
						}
						setState(205);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(208);
				match(T__11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstexpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ConstexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterConstexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitConstexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitConstexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstexpContext constexp() throws RecognitionException {
		ConstexpContext _localctx = new ConstexpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			addexp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclContext extends ParserRuleContext {
		public BtypeContext btype() {
			return getRuleContext(BtypeContext.class,0);
		}
		public List<VardefContext> vardef() {
			return getRuleContexts(VardefContext.class);
		}
		public VardefContext vardef(int i) {
			return getRuleContext(VardefContext.class,i);
		}
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitVardecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitVardecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_vardecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			btype();
			setState(214);
			vardef();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(215);
				match(T__7);
				setState(216);
				vardef();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(222);
			match(T__13);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(labParser.Ident, 0); }
		public List<ConstexpContext> constexp() {
			return getRuleContexts(ConstexpContext.class);
		}
		public ConstexpContext constexp(int i) {
			return getRuleContext(ConstexpContext.class,i);
		}
		public InitvalContext initval() {
			return getRuleContext(InitvalContext.class,0);
		}
		public VardefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterVardef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitVardef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitVardef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardefContext vardef() throws RecognitionException {
		VardefContext _localctx = new VardefContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_vardef);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(Ident);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(225);
					match(T__8);
					setState(226);
					constexp();
					setState(227);
					match(T__9);
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234);
				match(Ident);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(235);
					match(T__8);
					setState(236);
					constexp();
					setState(237);
					match(T__9);
					}
					}
					setState(243);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(244);
				match(T__14);
				setState(245);
				initval();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitvalContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<InitvalContext> initval() {
			return getRuleContexts(InitvalContext.class);
		}
		public InitvalContext initval(int i) {
			return getRuleContext(InitvalContext.class,i);
		}
		public InitvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterInitval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitInitval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitInitval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitvalContext initval() throws RecognitionException {
		InitvalContext _localctx = new InitvalContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_initval);
		int _la;
		try {
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case Decimal_const:
			case Octal_const:
			case Hexadecimal_const:
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				exp();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				match(T__10);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__10) | (1L << Decimal_const) | (1L << Octal_const) | (1L << Hexadecimal_const) | (1L << Ident))) != 0)) {
					{
					setState(250);
					initval();
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(251);
						match(T__7);
						setState(252);
						initval();
						}
						}
						setState(257);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(260);
				match(T__11);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public AddexpContext addexp() {
			return getRuleContext(AddexpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			addexp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddexpContext extends ParserRuleContext {
		public List<MulexpContext> mulexp() {
			return getRuleContexts(MulexpContext.class);
		}
		public MulexpContext mulexp(int i) {
			return getRuleContext(MulexpContext.class,i);
		}
		public AddexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterAddexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitAddexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitAddexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddexpContext addexp() throws RecognitionException {
		AddexpContext _localctx = new AddexpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_addexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			mulexp();
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(266);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__3) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(267);
				mulexp();
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulexpContext extends ParserRuleContext {
		public List<UnaryexpContext> unaryexp() {
			return getRuleContexts(UnaryexpContext.class);
		}
		public UnaryexpContext unaryexp(int i) {
			return getRuleContext(UnaryexpContext.class,i);
		}
		public MulexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterMulexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitMulexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitMulexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulexpContext mulexp() throws RecognitionException {
		MulexpContext _localctx = new MulexpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mulexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			unaryexp();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) {
				{
				{
				setState(274);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(275);
				unaryexp();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncrparamsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncrparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcrparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterFuncrparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitFuncrparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitFuncrparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncrparamsContext funcrparams() throws RecognitionException {
		FuncrparamsContext _localctx = new FuncrparamsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_funcrparams);
		int _la;
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case Decimal_const:
			case Octal_const:
			case Hexadecimal_const:
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(281);
				exp();
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(282);
					match(T__7);
					setState(283);
					exp();
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryexpContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public PrimaryexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterPrimaryexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitPrimaryexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitPrimaryexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryexpContext primaryexp() throws RecognitionException {
		PrimaryexpContext _localctx = new PrimaryexpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_primaryexp);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(T__5);
				setState(293);
				exp();
				setState(294);
				match(T__6);
				}
				break;
			case Decimal_const:
			case Octal_const:
			case Hexadecimal_const:
				enterOuterAlt(_localctx, 2);
				{
				setState(296);
				number();
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 3);
				{
				setState(297);
				lval();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(labParser.Ident, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterLval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitLval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitLval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalContext lval() throws RecognitionException {
		LvalContext _localctx = new LvalContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_lval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(Ident);
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(301);
				match(T__8);
				setState(302);
				exp();
				setState(303);
				match(T__9);
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public LorexpContext lorexp() {
			return getRuleContext(LorexpContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			lorexp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelexpContext extends ParserRuleContext {
		public List<AddexpContext> addexp() {
			return getRuleContexts(AddexpContext.class);
		}
		public AddexpContext addexp(int i) {
			return getRuleContext(AddexpContext.class,i);
		}
		public List<TerminalNode> Condop1() { return getTokens(labParser.Condop1); }
		public TerminalNode Condop1(int i) {
			return getToken(labParser.Condop1, i);
		}
		public RelexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterRelexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitRelexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitRelexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelexpContext relexp() throws RecognitionException {
		RelexpContext _localctx = new RelexpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_relexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			addexp();
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Condop1) {
				{
				{
				setState(313);
				match(Condop1);
				setState(314);
				addexp();
				}
				}
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqexpContext extends ParserRuleContext {
		public List<RelexpContext> relexp() {
			return getRuleContexts(RelexpContext.class);
		}
		public RelexpContext relexp(int i) {
			return getRuleContext(RelexpContext.class,i);
		}
		public List<TerminalNode> Condop2() { return getTokens(labParser.Condop2); }
		public TerminalNode Condop2(int i) {
			return getToken(labParser.Condop2, i);
		}
		public EqexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterEqexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitEqexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitEqexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqexpContext eqexp() throws RecognitionException {
		EqexpContext _localctx = new EqexpContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_eqexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			relexp();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Condop2) {
				{
				{
				setState(321);
				match(Condop2);
				setState(322);
				relexp();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LandexpContext extends ParserRuleContext {
		public List<EqexpContext> eqexp() {
			return getRuleContexts(EqexpContext.class);
		}
		public EqexpContext eqexp(int i) {
			return getRuleContext(EqexpContext.class,i);
		}
		public LandexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_landexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterLandexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitLandexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitLandexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LandexpContext landexp() throws RecognitionException {
		LandexpContext _localctx = new LandexpContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_landexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			eqexp();
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(329);
				match(T__22);
				setState(330);
				eqexp();
				}
				}
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LorexpContext extends ParserRuleContext {
		public List<LandexpContext> landexp() {
			return getRuleContexts(LandexpContext.class);
		}
		public LandexpContext landexp(int i) {
			return getRuleContext(LandexpContext.class,i);
		}
		public LorexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lorexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).enterLorexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof labListener ) ((labListener)listener).exitLorexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof labVisitor ) return ((labVisitor<? extends T>)visitor).visitLorexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LorexpContext lorexp() throws RecognitionException {
		LorexpContext _localctx = new LorexpContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_lorexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			landexp();
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(337);
				match(T__23);
				setState(338);
				landexp();
				}
				}
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u015b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\6\5I\n\5\r\5\16\5J\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\5\7S\n\7\3\7\3\7\3\7\3\b\3\b\3\b\7\b[\n\b\f\b\16\b^\13\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\7\th\n\t\f\t\16\tk\13\t\5\tm\n\t\3\n\3\n\6\nq\n"+
		"\n\r\n\16\nr\3\n\3\n\3\13\3\13\5\13y\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u0084\n\f\3\r\3\r\5\r\u0088\n\r\3\r\3\r\5\r\u008c\n\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009b\n\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a8\n\r\3\16\3\16\5\16\u00ac"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\7\17\u00b3\n\17\f\17\16\17\u00b6\13\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u00bf\n\20\f\20\16\20\u00c2\13"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u00cc\n\21\f\21\16\21"+
		"\u00cf\13\21\5\21\u00d1\n\21\3\21\5\21\u00d4\n\21\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\7\23\u00dc\n\23\f\23\16\23\u00df\13\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u00e8\n\24\f\24\16\24\u00eb\13\24\3\24\3\24\3\24"+
		"\3\24\3\24\7\24\u00f2\n\24\f\24\16\24\u00f5\13\24\3\24\3\24\5\24\u00f9"+
		"\n\24\3\25\3\25\3\25\3\25\3\25\7\25\u0100\n\25\f\25\16\25\u0103\13\25"+
		"\5\25\u0105\n\25\3\25\5\25\u0108\n\25\3\26\3\26\3\27\3\27\3\27\7\27\u010f"+
		"\n\27\f\27\16\27\u0112\13\27\3\30\3\30\3\30\7\30\u0117\n\30\f\30\16\30"+
		"\u011a\13\30\3\31\3\31\3\31\7\31\u011f\n\31\f\31\16\31\u0122\13\31\3\31"+
		"\5\31\u0125\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u012d\n\32\3\33\3"+
		"\33\3\33\3\33\3\33\7\33\u0134\n\33\f\33\16\33\u0137\13\33\3\34\3\34\3"+
		"\35\3\35\3\35\7\35\u013e\n\35\f\35\16\35\u0141\13\35\3\36\3\36\3\36\7"+
		"\36\u0146\n\36\f\36\16\36\u0149\13\36\3\37\3\37\3\37\7\37\u014e\n\37\f"+
		"\37\16\37\u0151\13\37\3 \3 \3 \7 \u0156\n \f \16 \u0159\13 \3 \2\2!\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\7\3\2"+
		"\3\4\3\2\5\7\3\2\34\36\3\2\5\6\3\2\26\30\2\u0167\2@\3\2\2\2\4B\3\2\2\2"+
		"\6D\3\2\2\2\bH\3\2\2\2\nL\3\2\2\2\fN\3\2\2\2\16W\3\2\2\2\20_\3\2\2\2\22"+
		"n\3\2\2\2\24x\3\2\2\2\26\u0083\3\2\2\2\30\u00a7\3\2\2\2\32\u00ab\3\2\2"+
		"\2\34\u00ad\3\2\2\2\36\u00b9\3\2\2\2 \u00d3\3\2\2\2\"\u00d5\3\2\2\2$\u00d7"+
		"\3\2\2\2&\u00f8\3\2\2\2(\u0107\3\2\2\2*\u0109\3\2\2\2,\u010b\3\2\2\2."+
		"\u0113\3\2\2\2\60\u0124\3\2\2\2\62\u012c\3\2\2\2\64\u012e\3\2\2\2\66\u0138"+
		"\3\2\2\28\u013a\3\2\2\2:\u0142\3\2\2\2<\u014a\3\2\2\2>\u0152\3\2\2\2@"+
		"A\7\3\2\2A\3\3\2\2\2BC\t\2\2\2C\5\3\2\2\2DE\t\3\2\2E\7\3\2\2\2FI\5\32"+
		"\16\2GI\5\f\7\2HF\3\2\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\t\3"+
		"\2\2\2LM\t\4\2\2M\13\3\2\2\2NO\5\4\3\2OP\7$\2\2PR\7\b\2\2QS\5\16\b\2R"+
		"Q\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\t\2\2UV\5\22\n\2V\r\3\2\2\2W\\\5\20"+
		"\t\2XY\7\n\2\2Y[\5\20\t\2ZX\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\17"+
		"\3\2\2\2^\\\3\2\2\2_`\5\2\2\2`l\7$\2\2ab\7\13\2\2bi\7\f\2\2cd\7\13\2\2"+
		"de\5*\26\2ef\7\f\2\2fh\3\2\2\2gc\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2"+
		"jm\3\2\2\2ki\3\2\2\2la\3\2\2\2lm\3\2\2\2m\21\3\2\2\2np\7\r\2\2oq\5\24"+
		"\13\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\16\2\2u\23"+
		"\3\2\2\2vy\5\32\16\2wy\5\30\r\2xv\3\2\2\2xw\3\2\2\2y\25\3\2\2\2z\u0084"+
		"\5\62\32\2{|\5\6\4\2|}\5\26\f\2}\u0084\3\2\2\2~\177\7$\2\2\177\u0080\7"+
		"\b\2\2\u0080\u0081\5\60\31\2\u0081\u0082\7\t\2\2\u0082\u0084\3\2\2\2\u0083"+
		"z\3\2\2\2\u0083{\3\2\2\2\u0083~\3\2\2\2\u0084\27\3\2\2\2\u0085\u0087\7"+
		"\17\2\2\u0086\u0088\5*\26\2\u0087\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u00a8\7\20\2\2\u008a\u008c\5*\26\2\u008b\u008a\3"+
		"\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u00a8\7\20\2\2\u008e"+
		"\u008f\5\64\33\2\u008f\u0090\7\21\2\2\u0090\u0091\5*\26\2\u0091\u0092"+
		"\7\20\2\2\u0092\u00a8\3\2\2\2\u0093\u0094\7\22\2\2\u0094\u0095\7\b\2\2"+
		"\u0095\u0096\5\66\34\2\u0096\u0097\7\t\2\2\u0097\u009a\5\30\r\2\u0098"+
		"\u0099\7\23\2\2\u0099\u009b\5\30\r\2\u009a\u0098\3\2\2\2\u009a\u009b\3"+
		"\2\2\2\u009b\u00a8\3\2\2\2\u009c\u00a8\5\22\n\2\u009d\u009e\7\24\2\2\u009e"+
		"\u009f\7\b\2\2\u009f\u00a0\5\66\34\2\u00a0\u00a1\7\t\2\2\u00a1\u00a2\5"+
		"\30\r\2\u00a2\u00a8\3\2\2\2\u00a3\u00a4\7#\2\2\u00a4\u00a8\7\20\2\2\u00a5"+
		"\u00a6\7\"\2\2\u00a6\u00a8\7\20\2\2\u00a7\u0085\3\2\2\2\u00a7\u008b\3"+
		"\2\2\2\u00a7\u008e\3\2\2\2\u00a7\u0093\3\2\2\2\u00a7\u009c\3\2\2\2\u00a7"+
		"\u009d\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\31\3\2\2"+
		"\2\u00a9\u00ac\5\34\17\2\u00aa\u00ac\5$\23\2\u00ab\u00a9\3\2\2\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\33\3\2\2\2\u00ad\u00ae\7\25\2\2\u00ae\u00af\5\2\2"+
		"\2\u00af\u00b4\5\36\20\2\u00b0\u00b1\7\n\2\2\u00b1\u00b3\5\36\20\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7\20\2\2\u00b8"+
		"\35\3\2\2\2\u00b9\u00c0\7$\2\2\u00ba\u00bb\7\13\2\2\u00bb\u00bc\5\"\22"+
		"\2\u00bc\u00bd\7\f\2\2\u00bd\u00bf\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf\u00c2"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7\21\2\2\u00c4\u00c5\5 \21\2\u00c5\37\3\2\2"+
		"\2\u00c6\u00d4\5\"\22\2\u00c7\u00d0\7\r\2\2\u00c8\u00cd\5 \21\2\u00c9"+
		"\u00ca\7\n\2\2\u00ca\u00cc\5 \21\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2"+
		"\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00d0\u00c8\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00d4\7\16\2\2\u00d3\u00c6\3\2\2\2\u00d3\u00c7\3\2\2\2\u00d4"+
		"!\3\2\2\2\u00d5\u00d6\5,\27\2\u00d6#\3\2\2\2\u00d7\u00d8\5\2\2\2\u00d8"+
		"\u00dd\5&\24\2\u00d9\u00da\7\n\2\2\u00da\u00dc\5&\24\2\u00db\u00d9\3\2"+
		"\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7\20\2\2\u00e1%\3\2\2\2"+
		"\u00e2\u00e9\7$\2\2\u00e3\u00e4\7\13\2\2\u00e4\u00e5\5\"\22\2\u00e5\u00e6"+
		"\7\f\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00f9\3\2\2\2\u00eb\u00e9\3\2"+
		"\2\2\u00ec\u00f3\7$\2\2\u00ed\u00ee\7\13\2\2\u00ee\u00ef\5\"\22\2\u00ef"+
		"\u00f0\7\f\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f2\u00f5\3\2"+
		"\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f6\u00f7\7\21\2\2\u00f7\u00f9\5(\25\2\u00f8\u00e2\3"+
		"\2\2\2\u00f8\u00ec\3\2\2\2\u00f9\'\3\2\2\2\u00fa\u0108\5*\26\2\u00fb\u0104"+
		"\7\r\2\2\u00fc\u0101\5(\25\2\u00fd\u00fe\7\n\2\2\u00fe\u0100\5(\25\2\u00ff"+
		"\u00fd\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2"+
		"\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u00fc\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0108\7\16\2\2\u0107\u00fa\3"+
		"\2\2\2\u0107\u00fb\3\2\2\2\u0108)\3\2\2\2\u0109\u010a\5,\27\2\u010a+\3"+
		"\2\2\2\u010b\u0110\5.\30\2\u010c\u010d\t\5\2\2\u010d\u010f\5.\30\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111-\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0118\5\26\f\2\u0114\u0115"+
		"\t\6\2\2\u0115\u0117\5\26\f\2\u0116\u0114\3\2\2\2\u0117\u011a\3\2\2\2"+
		"\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119/\3\2\2\2\u011a\u0118\3"+
		"\2\2\2\u011b\u0120\5*\26\2\u011c\u011d\7\n\2\2\u011d\u011f\5*\26\2\u011e"+
		"\u011c\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0125\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0125\3\2\2\2\u0124"+
		"\u011b\3\2\2\2\u0124\u0123\3\2\2\2\u0125\61\3\2\2\2\u0126\u0127\7\b\2"+
		"\2\u0127\u0128\5*\26\2\u0128\u0129\7\t\2\2\u0129\u012d\3\2\2\2\u012a\u012d"+
		"\5\n\6\2\u012b\u012d\5\64\33\2\u012c\u0126\3\2\2\2\u012c\u012a\3\2\2\2"+
		"\u012c\u012b\3\2\2\2\u012d\63\3\2\2\2\u012e\u0135\7$\2\2\u012f\u0130\7"+
		"\13\2\2\u0130\u0131\5*\26\2\u0131\u0132\7\f\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u012f\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\65\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\5> \2\u0139\67\3"+
		"\2\2\2\u013a\u013f\5,\27\2\u013b\u013c\7 \2\2\u013c\u013e\5,\27\2\u013d"+
		"\u013b\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2"+
		"\2\2\u01409\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0147\58\35\2\u0143\u0144"+
		"\7!\2\2\u0144\u0146\58\35\2\u0145\u0143\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148;\3\2\2\2\u0149\u0147\3\2\2\2"+
		"\u014a\u014f\5:\36\2\u014b\u014c\7\31\2\2\u014c\u014e\5:\36\2\u014d\u014b"+
		"\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"=\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0157\5<\37\2\u0153\u0154\7\32\2\2"+
		"\u0154\u0156\5<\37\2\u0155\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155"+
		"\3\2\2\2\u0157\u0158\3\2\2\2\u0158?\3\2\2\2\u0159\u0157\3\2\2\2&HJR\\"+
		"ilrx\u0083\u0087\u008b\u009a\u00a7\u00ab\u00b4\u00c0\u00cd\u00d0\u00d3"+
		"\u00dd\u00e9\u00f3\u00f8\u0101\u0104\u0107\u0110\u0118\u0120\u0124\u012c"+
		"\u0135\u013f\u0147\u014f\u0157";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}