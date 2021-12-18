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
	/**
	 * Enter a parse tree produced by {@link compileParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(compileParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(compileParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(compileParser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(compileParser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(compileParser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(compileParser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(compileParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(compileParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(compileParser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(compileParser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(compileParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(compileParser.UnaryOpContext ctx);
}