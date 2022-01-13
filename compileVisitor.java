// Generated from compile.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link compileParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface compileVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link compileParser#bType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBType(compileParser.BTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(compileParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(compileParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(compileParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(compileParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(compileParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#funcfparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncfparams(compileParser.FuncfparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#funcfparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncfparam(compileParser.FuncfparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(compileParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(compileParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(compileParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(compileParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(compileParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(compileParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(compileParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#constInitval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitval(compileParser.ConstInitvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(compileParser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(compileParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(compileParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#initval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitval(compileParser.InitvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(compileParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(compileParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(compileParser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#funcrparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncrparams(compileParser.FuncrparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(compileParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#lval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLval(compileParser.LvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(compileParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#relExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExp(compileParser.RelExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#eqExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExp(compileParser.EqExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#landExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLandExp(compileParser.LandExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#lorExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLorExp(compileParser.LorExpContext ctx);
}