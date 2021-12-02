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
		Rbrace=19, RET=20, Checkpoint=21, WHITE_SPACE=22;
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
			"RET", "Checkpoint", "WHITE_SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "'('", "')'", 
			"'+'", "'-'", "'*'", "'/'", "'int'", "'main'", "'{'", "'}'", "'return'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Number", "Decimal_const", "Octal_const", "Hexadecimal_const", 
			"Hexadecimal_prefix", "Nonzero_digit", "Octal_digit", "Digit", "Hexadecimal_digit", 
			"LPAREN", "RPAREN", "ADD", "SUB", "MUL", "DIV", "INT", "MAIN", "Lbrace", 
			"Rbrace", "RET", "Checkpoint", "WHITE_SPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0080\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\5"+
		"\2\63\n\2\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\4\3\4\7\4>\n\4\f\4\16\4"+
		"A\13\4\3\5\3\5\3\5\7\5F\n\5\f\5\16\5I\13\5\3\6\3\6\3\6\3\6\5\6O\n\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\5\tW\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\4\5\2\62;"+
		"CHch\5\2\13\f\17\17\"\"\2\u0086\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\3\62\3\2\2\2\5\64\3\2\2\2\7;\3\2\2\2\tB\3\2\2\2"+
		"\13N\3\2\2\2\rP\3\2\2\2\17R\3\2\2\2\21V\3\2\2\2\23X\3\2\2\2\25Z\3\2\2"+
		"\2\27\\\3\2\2\2\31^\3\2\2\2\33`\3\2\2\2\35b\3\2\2\2\37d\3\2\2\2!f\3\2"+
		"\2\2#j\3\2\2\2%o\3\2\2\2\'q\3\2\2\2)s\3\2\2\2+z\3\2\2\2-|\3\2\2\2/\63"+
		"\5\5\3\2\60\63\5\7\4\2\61\63\5\t\5\2\62/\3\2\2\2\62\60\3\2\2\2\62\61\3"+
		"\2\2\2\63\4\3\2\2\2\648\5\r\7\2\65\67\5\21\t\2\66\65\3\2\2\2\67:\3\2\2"+
		"\28\66\3\2\2\289\3\2\2\29\6\3\2\2\2:8\3\2\2\2;?\7\62\2\2<>\5\17\b\2=<"+
		"\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\b\3\2\2\2A?\3\2\2\2BC\5\13\6\2"+
		"CG\5\23\n\2DF\5\23\n\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\n\3\2"+
		"\2\2IG\3\2\2\2JK\7\62\2\2KO\7z\2\2LM\7\62\2\2MO\7Z\2\2NJ\3\2\2\2NL\3\2"+
		"\2\2O\f\3\2\2\2PQ\4\63;\2Q\16\3\2\2\2RS\4\629\2S\20\3\2\2\2TW\7\62\2\2"+
		"UW\5\r\7\2VT\3\2\2\2VU\3\2\2\2W\22\3\2\2\2XY\t\2\2\2Y\24\3\2\2\2Z[\7*"+
		"\2\2[\26\3\2\2\2\\]\7+\2\2]\30\3\2\2\2^_\7-\2\2_\32\3\2\2\2`a\7/\2\2a"+
		"\34\3\2\2\2bc\7,\2\2c\36\3\2\2\2de\7\61\2\2e \3\2\2\2fg\7k\2\2gh\7p\2"+
		"\2hi\7v\2\2i\"\3\2\2\2jk\7o\2\2kl\7c\2\2lm\7k\2\2mn\7p\2\2n$\3\2\2\2o"+
		"p\7}\2\2p&\3\2\2\2qr\7\177\2\2r(\3\2\2\2st\7t\2\2tu\7g\2\2uv\7v\2\2vw"+
		"\7w\2\2wx\7t\2\2xy\7p\2\2y*\3\2\2\2z{\7=\2\2{,\3\2\2\2|}\t\3\2\2}~\3\2"+
		"\2\2~\177\b\27\2\2\177.\3\2\2\2\t\2\628?GNV\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}