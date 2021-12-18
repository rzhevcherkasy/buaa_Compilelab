// Generated from compile.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class compileLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Number=1, Decimal_const=2, Octal_const=3, Hexadecimal_const=4, Hexadecimal_prefix=5, 
		Nonzero_digit=6, Octal_digit=7, Digit=8, Hexadecimal_digit=9, LPAREN=10, 
		RPAREN=11, ADD=12, SUB=13, MUL=14, DIV=15, INT=16, MAIN=17, Lbrace=18, 
		Rbrace=19, Percent=20, RET=21, Checkpoint=22, WHITE_SPACE=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Number", "Decimal_const", "Octal_const", "Hexadecimal_const", "Hexadecimal_prefix", 
			"Nonzero_digit", "Octal_digit", "Digit", "Hexadecimal_digit", "LPAREN", 
			"RPAREN", "ADD", "SUB", "MUL", "DIV", "INT", "MAIN", "Lbrace", "Rbrace", 
			"Percent", "RET", "Checkpoint", "WHITE_SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "'('", "')'", 
			"'+'", "'-'", "'*'", "'/'", "'int'", "'main'", "'{'", "'}'", "'%'", "'return'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Number", "Decimal_const", "Octal_const", "Hexadecimal_const", 
			"Hexadecimal_prefix", "Nonzero_digit", "Octal_digit", "Digit", "Hexadecimal_digit", 
			"LPAREN", "RPAREN", "ADD", "SUB", "MUL", "DIV", "INT", "MAIN", "Lbrace", 
			"Rbrace", "Percent", "RET", "Checkpoint", "WHITE_SPACE"
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


	public compileLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "compile.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0084\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\5\2\65\n\2\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\4\3\4\7\4@\n\4\f"+
		"\4\16\4C\13\4\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\6\3\6\3\6\3\6\5\6"+
		"Q\n\6\3\7\3\7\3\b\3\b\3\t\3\t\5\tY\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\3\2\4\5\2\62;CHch\5\2\13\f\17\17\"\"\2\u008a\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\64\3\2\2\2\5"+
		"\66\3\2\2\2\7=\3\2\2\2\tD\3\2\2\2\13P\3\2\2\2\rR\3\2\2\2\17T\3\2\2\2\21"+
		"X\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27^\3\2\2\2\31`\3\2\2\2\33b\3\2\2\2"+
		"\35d\3\2\2\2\37f\3\2\2\2!h\3\2\2\2#l\3\2\2\2%q\3\2\2\2\'s\3\2\2\2)u\3"+
		"\2\2\2+w\3\2\2\2-~\3\2\2\2/\u0080\3\2\2\2\61\65\5\5\3\2\62\65\5\7\4\2"+
		"\63\65\5\t\5\2\64\61\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\65\4\3\2\2\2"+
		"\66:\5\r\7\2\679\5\21\t\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\6"+
		"\3\2\2\2<:\3\2\2\2=A\7\62\2\2>@\5\17\b\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2"+
		"AB\3\2\2\2B\b\3\2\2\2CA\3\2\2\2DE\5\13\6\2EI\5\23\n\2FH\5\23\n\2GF\3\2"+
		"\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\n\3\2\2\2KI\3\2\2\2LM\7\62\2\2MQ\7"+
		"z\2\2NO\7\62\2\2OQ\7Z\2\2PL\3\2\2\2PN\3\2\2\2Q\f\3\2\2\2RS\4\63;\2S\16"+
		"\3\2\2\2TU\4\629\2U\20\3\2\2\2VY\7\62\2\2WY\5\r\7\2XV\3\2\2\2XW\3\2\2"+
		"\2Y\22\3\2\2\2Z[\t\2\2\2[\24\3\2\2\2\\]\7*\2\2]\26\3\2\2\2^_\7+\2\2_\30"+
		"\3\2\2\2`a\7-\2\2a\32\3\2\2\2bc\7/\2\2c\34\3\2\2\2de\7,\2\2e\36\3\2\2"+
		"\2fg\7\61\2\2g \3\2\2\2hi\7k\2\2ij\7p\2\2jk\7v\2\2k\"\3\2\2\2lm\7o\2\2"+
		"mn\7c\2\2no\7k\2\2op\7p\2\2p$\3\2\2\2qr\7}\2\2r&\3\2\2\2st\7\177\2\2t"+
		"(\3\2\2\2uv\7\'\2\2v*\3\2\2\2wx\7t\2\2xy\7g\2\2yz\7v\2\2z{\7w\2\2{|\7"+
		"t\2\2|}\7p\2\2},\3\2\2\2~\177\7=\2\2\177.\3\2\2\2\u0080\u0081\t\3\2\2"+
		"\u0081\u0082\3\2\2\2\u0082\u0083\b\30\2\2\u0083\60\3\2\2\2\t\2\64:AIP"+
		"X\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}