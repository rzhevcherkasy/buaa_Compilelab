import java.util.LinkedList;
import java.util.List;

public class Visitor extends  compileBaseVisitor<Void> {
    List<Node> nodeList=new LinkedList<Node>();
    int tempId=0;
    int tempNum=0;
    String op;
    String whiteSpace ="    ";
    @Override public Void visitCompUnit(compileParser.CompUnitContext ctx) {
        return super.visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Void visitFuncDef(compileParser.FuncDefContext ctx) {
        visit(ctx.funcType());
        visit(ctx.ident());
        visit(ctx.LPAREN());
        System.out.print("(");
        visit(ctx.RPAREN());
        System.out.print(")");
        visit(ctx.block());
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Void visitFuncType(compileParser.FuncTypeContext ctx) {
        visit(ctx.INT());
        if (ctx.INT().getText().equals("int"))
        {
            System.out.print("define dso_local i32 ");
        }
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Void visitIdent(compileParser.IdentContext ctx) {
        if (ctx.MAIN().getText().equals("main"))
        {
            System.out.print("@main");
        }
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Void visitBlock(compileParser.BlockContext ctx) {
        visit(ctx.Lbrace());
        System.out.println("{");
        visit(ctx.stmt());
        visit(ctx.Rbrace());
        System.out.println("}");
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Void visitStmt(compileParser.StmtContext ctx) {
        visit(ctx.exp());
        visit(ctx.RET());
        System.out.print(whiteSpace+"ret i32 "+"%"+tempId);
      //  System.out.print(dealNum(ctx.Number().getText()));
        visit(ctx.Checkpoint());
        System.out.println(";");
        return null;
    }

    /**
     处理数字转化
     */
    public int dealNum(String num){
        if(num.length()>=2&&num.charAt(0)=='0'){
            if(num.charAt(1)=='x'||num.charAt(1)=='X'){ //十六进制
                int sum = 0;	//数据范围上，不超过8位的十六进制数，所以计算总和的sum应该声明为long型，而不是int型，否则会出错。
                char c[]=num.toCharArray();
                int n = c.length;
                for (int i = 2; i < n; i++) {
                    if((c[i]>='a'&&c[i]<='f')||(c[i]>='A'&&c[i]<='F')){
                        if(c[i]=='A'||c[i]=='a')
                            sum+=10*Math.pow(16,n-i-1);
                        else if(c[i]=='B'||c[i]=='b')
                            sum+=11*Math.pow(16,n-i-1);
                        else if(c[i]=='C'||c[i]=='c')
                            sum+=12*Math.pow(16,n-i-1);
                        else if(c[i]=='D'||c[i]=='d')
                            sum+=13*Math.pow(16,n-i-1);
                        else if(c[i]=='E'||c[i]=='e')
                            sum+=14*Math.pow(16,n-i-1);
                        else if(c[i]=='F'||c[i]=='f')
                            sum+=15*Math.pow(16,n-i-1);
                    }
                    else{
                        sum+=((int)c[i]-'0')*Math.pow(16,n-i-1);
                    }
                }
                return sum;
            }
            else{               //八进制
                int sum = 0;	//数据范围上，不超过8位的十六进制数，所以计算总和的sum应该声明为long型，而不是int型，否则会出错。
                char c[]=num.toCharArray();
                int n = c.length;
                for (int i = 0; i < n; i++){
                    sum+=((int)c[i]-'0')*Math.pow(8,n-i-1);
                }
                return sum;
            }
        }
        else{            //十进制
            return Integer.parseInt(num);
        }
    }


    @Override
    public Void visitExp(compileParser.ExpContext ctx) {

        return super.visitExp(ctx);
    }

    @Override
    public Void visitAddExp(compileParser.AddExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.mulExp());
        }
        else{
            
        }
        return null;
    }

    @Override
    public Void visitMulExp(compileParser.MulExpContext ctx) {
        return super.visitMulExp(ctx);
    }

    @Override
    public Void visitUnaryExp(compileParser.UnaryExpContext ctx) {
        switch (ctx.children.size()) {
            case 1-> {
                visit(ctx.primaryExp());
                break;
            }
            case 2-> {
                visit(ctx.unaryExp());

                int leftId=-1;
                int rightId=tempId;
                if(rightId==0){
                    rightId=-1;
                    String opType=ctx.unaryOp().getText();
                    tempId=OpDeal(-1,-1,opType,0,tempNum);
                }
                else{
                    String opType=ctx.unaryOp().getText();
                    tempId=OpDeal(-1,rightId,opType,0,0);
                }
                visit(ctx.unaryOp());
                break;
            }

        }
        return null;
    }

    @Override
    public Void visitPrimaryExp(compileParser.PrimaryExpContext ctx) {
        if(ctx.children.size()==1){
            tempNum=dealNum(ctx.Number().getText());
            visit(ctx.Number());
        }
        else{
            visit(ctx.LPAREN());
            visit(ctx.exp());
            visit(ctx.RPAREN());
        }
        return null;
    }

    @Override
    public Void visitUnaryOp(compileParser.UnaryOpContext ctx) {
        return super.visitUnaryOp(ctx);
    }

    public int OpDeal(int leftId,int rightId,String op,int leftNum,int rightNum){
        //System.out.println("222");
        if(op.equals("-")){
            tempId++;
            Node leftNode=null;
            Node rightNode=null;
            if(leftId==-1&&rightId==-1){
                //rightNode=nodeList.get(rightId);
                int val=leftNum-rightNum;
                nodeList.add(new Node(tempId,val,"number",0));
                //System.out.println("222");
                System.out.println(whiteSpace+"%"+tempId+" = sub i32 "+leftNum+", "+rightNum);
            }
            else if(leftId==-1){
                rightNode=nodeList.get(rightId-1);
                int val=0-rightNode.getVal();
                nodeList.add(new Node(tempId,val,"number",0));
                //System.out.println("222");
                System.out.println(whiteSpace+"%"+tempId+" = sub i32 "+leftNum+", "+"%"+rightNode.getId());
            }
            else if(rightId==-1){
                leftNode=nodeList.get(leftId-1);
                int val=leftNode.getVal()-rightNum;
                nodeList.add(new Node(tempId,val,"number",0));
                //System.out.println("222");
                System.out.println(whiteSpace+"%"+tempId+" = sub i32 "+"%"+leftNode.getId()+", "+rightNum);
            }
            else{
                leftNode=nodeList.get(leftId-1);
                rightNode=nodeList.get(rightId-1);
                int val=leftNode.getVal()-rightNode.getVal();
                nodeList.add(new Node(tempId,val,"number",0));
                //System.out.println("222");
                System.out.println(whiteSpace+"%"+tempId+" = sub i32 "+"%"+leftNode.getId()+", "+"%"+rightNode.getId());
            }
        }
        return tempId;
    }

}
