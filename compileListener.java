// Generated from compile.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link compileParser}.
 */
public interface compileListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link compileParser#bType}.
	 * @param ctx the parse tree
	 */
	void enterBType(compileParser.BTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#bType}.
	 * @param ctx the parse tree
	 */
	void exitBType(compileParser.BTypeContext ctx);
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
	 * Enter a parse tree produced by {@link compileParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(compileParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(compileParser.UnaryOpContext ctx);
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
	 * Enter a parse tree produced by {@link compileParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(compileParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(compileParser.NumberContext ctx);
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
	 * Enter a parse tree produced by {@link compileParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(compileParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(compileParser.BlockItemContext ctx);
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
	 * Enter a parse tree produced by {@link compileParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(compileParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(compileParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(compileParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(compileParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(compileParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(compileParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#constInitval}.
	 * @param ctx the parse tree
	 */
	void enterConstInitval(compileParser.ConstInitvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#constInitval}.
	 * @param ctx the parse tree
	 */
	void exitConstInitval(compileParser.ConstInitvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(compileParser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(compileParser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(compileParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(compileParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(compileParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(compileParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#initval}.
	 * @param ctx the parse tree
	 */
	void enterInitval(compileParser.InitvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#initval}.
	 * @param ctx the parse tree
	 */
	void exitInitval(compileParser.InitvalContext ctx);
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
	 * Enter a parse tree produced by {@link compileParser#funcrparams}.
	 * @param ctx the parse tree
	 */
	void enterFuncrparams(compileParser.FuncrparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#funcrparams}.
	 * @param ctx the parse tree
	 */
	void exitFuncrparams(compileParser.FuncrparamsContext ctx);
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
	 * Enter a parse tree produced by {@link compileParser#lval}.
	 * @param ctx the parse tree
	 */
	void enterLval(compileParser.LvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#lval}.
	 * @param ctx the parse tree
	 */
	void exitLval(compileParser.LvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(compileParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(compileParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#relExp}.
	 * @param ctx the parse tree
	 */
	void enterRelExp(compileParser.RelExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#relExp}.
	 * @param ctx the parse tree
	 */
	void exitRelExp(compileParser.RelExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void enterEqExp(compileParser.EqExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#eqExp}.
	 * @param ctx the parse tree
	 */
	void exitEqExp(compileParser.EqExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#landExp}.
	 * @param ctx the parse tree
	 */
	void enterLandExp(compileParser.LandExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#landExp}.
	 * @param ctx the parse tree
	 */
	void exitLandExp(compileParser.LandExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compileParser#lorExp}.
	 * @param ctx the parse tree
	 */
	void enterLorExp(compileParser.LorExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compileParser#lorExp}.
	 * @param ctx the parse tree
	 */
	void exitLorExp(compileParser.LorExpContext ctx);
}