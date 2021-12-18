import java.util.LinkedList;
import java.util.List;

public class Visitor extends  compileBaseVisitor<Void> {
    List<Node> nodeList=new LinkedList<Node>();
    int tempId=0;
    int tempNum=0;
    Node tempNode=null;
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
        tempId=nodeList.get(nodeList.size()-1).getVal();
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
            visit(ctx.children.get(0));
            Node left=tempNode;
            visit(ctx.children.get(2));
            Node right=tempNode;
            visit(ctx.children.get(1));
            String optype=ctx.children.get(1).getText();
            OpDeal(left,right,optype);
        }
        return null;
    }

    @Override
    public Void visitMulExp(compileParser.MulExpContext ctx) {
        if(ctx.children.size()==1){
            visit(ctx.unaryExp());
        }
        else{
            visit(ctx.children.get(0));
            Node left=tempNode;
            visit(ctx.children.get(2));
            Node right=tempNode;
            visit(ctx.children.get(1));
            String optype=ctx.children.get(1).getText();
            OpDeal(left,right,optype);
        }
        return null;
    }

    @Override
    public Void visitUnaryExp(compileParser.UnaryExpContext ctx) {
        switch (ctx.children.size()) {
            case 1-> {
                visit(ctx.primaryExp());
                break;
            }
            case 2-> {
                visit(ctx.children.get(1));
                Node right=tempNode;
                String opType=ctx.unaryOp().getText();
                OpDeal(null,right,opType);
                break;
            }
        }
        return null;
    }

    @Override
        public Void visitPrimaryExp(compileParser.PrimaryExpContext ctx) {
        if(ctx.children.size()==1){      //遇到number了
            Node node=new Node(-1,dealNum(ctx.Number().getText()),"num",0);
            tempNode=node;
           // nodeList.add(node);
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

    public String OpEnum(String op){
        if(op.equals("*")){
            return "mul";
        }
        else if(op.equals("+")){
            return "add";
        }
        else if(op.equals("-")){
            return "sub";
        }
        else if(op.equals("/")){
            return "sdiv";
        }
        else if(op.equals("%")){
            return "srem";
        }
        return null;
    }
    public void OpDeal(Node leftNode,Node rightNode,String op){
        String left=null;
        String right=null;
        String opType;
        if(leftNode==null){
            left="0";
        }
        else{
            if(leftNode.getType().equals("num")){
                left=String.valueOf(leftNode.getVal());
            }
            else if(leftNode.getType().equals("exp")){
                left="%"+String.valueOf(leftNode.getVal());
            }
        }
        if(rightNode.getType().equals("num")){
            right=String.valueOf(rightNode.getVal());
        }
        else if(rightNode.getType().equals("exp")){
            right="%"+String.valueOf(rightNode.getVal());
        }
        int top=0;
        int depth=0;
        for(int i=0;i<nodeList.size();i++){
            if(nodeList.get(i).getType().equals("exp")){
                top=nodeList.get(i).getVal();
                depth=nodeList.get(i).getDepth();
            }
        }
        Node newNode=new Node(nodeList.size(),top+1,"exp",depth);
        tempNode=newNode;
        nodeList.add(newNode);
        System.out.println(whiteSpace+"%"+(top+1)+" = "+OpEnum(op)+" i32 "+left+", "+right);
        return;
    }


}
