// Generated from lab.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link labParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface labVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link labParser#btype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBtype(labParser.BtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#functype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctype(labParser.FunctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#unaryop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryop(labParser.UnaryopContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#compunit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompunit(labParser.CompunitContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(labParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(labParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#funcfparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncfparams(labParser.FuncfparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#funcfparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncfparam(labParser.FuncfparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(labParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(labParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#unaryexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryexp(labParser.UnaryexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(labParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(labParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#constdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstdecl(labParser.ConstdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#constdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstdef(labParser.ConstdefContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#constinitval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstinitval(labParser.ConstinitvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#constexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstexp(labParser.ConstexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#vardecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(labParser.VardeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#vardef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardef(labParser.VardefContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#initval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitval(labParser.InitvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(labParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#addexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddexp(labParser.AddexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#mulexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulexp(labParser.MulexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#funcrparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncrparams(labParser.FuncrparamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#primaryexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryexp(labParser.PrimaryexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#lval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLval(labParser.LvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(labParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#relexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelexp(labParser.RelexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#eqexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqexp(labParser.EqexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#landexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLandexp(labParser.LandexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link labParser#lorexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLorexp(labParser.LorexpContext ctx);
}