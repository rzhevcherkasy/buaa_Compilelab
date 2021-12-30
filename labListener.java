// Generated from lab.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link labParser}.
 */
public interface labListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link labParser#btype}.
	 * @param ctx the parse tree
	 */
	void enterBtype(labParser.BtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#btype}.
	 * @param ctx the parse tree
	 */
	void exitBtype(labParser.BtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#functype}.
	 * @param ctx the parse tree
	 */
	void enterFunctype(labParser.FunctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#functype}.
	 * @param ctx the parse tree
	 */
	void exitFunctype(labParser.FunctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#unaryop}.
	 * @param ctx the parse tree
	 */
	void enterUnaryop(labParser.UnaryopContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#unaryop}.
	 * @param ctx the parse tree
	 */
	void exitUnaryop(labParser.UnaryopContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#compunit}.
	 * @param ctx the parse tree
	 */
	void enterCompunit(labParser.CompunitContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#compunit}.
	 * @param ctx the parse tree
	 */
	void exitCompunit(labParser.CompunitContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(labParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(labParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(labParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(labParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#funcfparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncfparams(labParser.FuncfparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#funcfparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncfparams(labParser.FuncfparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#funcfparam}.
	 * @param ctx the parse tree
	 */
	void enterFuncfparam(labParser.FuncfparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#funcfparam}.
	 * @param ctx the parse tree
	 */
	void exitFuncfparam(labParser.FuncfparamContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(labParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(labParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(labParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(labParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#unaryexp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryexp(labParser.UnaryexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#unaryexp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryexp(labParser.UnaryexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(labParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(labParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(labParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(labParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#constdecl}.
	 * @param ctx the parse tree
	 */
	void enterConstdecl(labParser.ConstdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#constdecl}.
	 * @param ctx the parse tree
	 */
	void exitConstdecl(labParser.ConstdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#constdef}.
	 * @param ctx the parse tree
	 */
	void enterConstdef(labParser.ConstdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#constdef}.
	 * @param ctx the parse tree
	 */
	void exitConstdef(labParser.ConstdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#constinitval}.
	 * @param ctx the parse tree
	 */
	void enterConstinitval(labParser.ConstinitvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#constinitval}.
	 * @param ctx the parse tree
	 */
	void exitConstinitval(labParser.ConstinitvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#constexp}.
	 * @param ctx the parse tree
	 */
	void enterConstexp(labParser.ConstexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#constexp}.
	 * @param ctx the parse tree
	 */
	void exitConstexp(labParser.ConstexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(labParser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(labParser.VardeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#vardef}.
	 * @param ctx the parse tree
	 */
	void enterVardef(labParser.VardefContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#vardef}.
	 * @param ctx the parse tree
	 */
	void exitVardef(labParser.VardefContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#initval}.
	 * @param ctx the parse tree
	 */
	void enterInitval(labParser.InitvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#initval}.
	 * @param ctx the parse tree
	 */
	void exitInitval(labParser.InitvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(labParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(labParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#addexp}.
	 * @param ctx the parse tree
	 */
	void enterAddexp(labParser.AddexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#addexp}.
	 * @param ctx the parse tree
	 */
	void exitAddexp(labParser.AddexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#mulexp}.
	 * @param ctx the parse tree
	 */
	void enterMulexp(labParser.MulexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#mulexp}.
	 * @param ctx the parse tree
	 */
	void exitMulexp(labParser.MulexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#funcrparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncrparams(labParser.FuncrparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#funcrparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncrparams(labParser.FuncrparamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#primaryexp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryexp(labParser.PrimaryexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#primaryexp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryexp(labParser.PrimaryexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#lval}.
	 * @param ctx the parse tree
	 */
	void enterLval(labParser.LvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#lval}.
	 * @param ctx the parse tree
	 */
	void exitLval(labParser.LvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(labParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(labParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#relexp}.
	 * @param ctx the parse tree
	 */
	void enterRelexp(labParser.RelexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#relexp}.
	 * @param ctx the parse tree
	 */
	void exitRelexp(labParser.RelexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#eqexp}.
	 * @param ctx the parse tree
	 */
	void enterEqexp(labParser.EqexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#eqexp}.
	 * @param ctx the parse tree
	 */
	void exitEqexp(labParser.EqexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#landexp}.
	 * @param ctx the parse tree
	 */
	void enterLandexp(labParser.LandexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#landexp}.
	 * @param ctx the parse tree
	 */
	void exitLandexp(labParser.LandexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link labParser#lorexp}.
	 * @param ctx the parse tree
	 */
	void enterLorexp(labParser.LorexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link labParser#lorexp}.
	 * @param ctx the parse tree
	 */
	void exitLorexp(labParser.LorexpContext ctx);
}