// Generated from compile.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link compileParser}.
 */
public interface compileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link compileParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(compileParser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(compileParser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(compileParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(compileParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(compileParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(compileParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#ident}.
	 * @param ctx the parse tree
	 */
	void enterIdent(compileParser.IdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#ident}.
	 * @param ctx the parse tree
	 */
	void exitIdent(compileParser.IdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(compileParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(compileParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(compileParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(compileParser.StmtContext ctx);
}