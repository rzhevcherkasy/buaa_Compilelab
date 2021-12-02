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
	 * Visit a parse tree produced by {@link compileParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(compileParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(compileParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(compileParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(compileParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(compileParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link compileParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(compileParser.StmtContext ctx);
}