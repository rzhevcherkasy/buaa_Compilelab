import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Visitor extends  compileBaseVisitor<Void> {
    List<Node> nodeList=new LinkedList<Node>();
    List<Var>  varList=new LinkedList<>();

    List<Block> BlockList=new LinkedList<>();  //所有Block
    List<Block> tempBlockList=new ArrayList<>();
    List<Block> landBlockList=new ArrayList<>();  //lab4递归用的
    List<orblock> orblocksList=new ArrayList<>();  //lab4递归存值用的

    public LinkedList<String> output=new LinkedList<String>();
    int tempId=0;
    int tempNum=0;
    int step=0;   //Block步数
    Block tempBlock=null;
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
        if (ctx.children.get(0).getText().equals("int"))
        {
            output.add("define dso_local i32 @main(){");
            /*
            接下来要初始化一个简单的初始块
             *

             */
            //tempBlock.blockOutput.add("    br label %"+"a0");
            BlockList.add(new Block());
            step++;
            tempBlock=BlockList.get(0);
           // output.add("    br label %"+"a0");
            tempBlock.type="func";
            tempBlock.set=false;
            tempBlock.end=0;
        }
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /**
     *  @Override public Void visitIdent(compileParser.IdentContext ctx) {
    if (ctx.MAIN().getText().equals("main"))
    {
    System.out.print("@main");
    }
    return null;
    }*/
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Void visitBlock(compileParser.BlockContext ctx) {
        // System.out.println("{");
        for(int i=0;i<ctx.children.size();i++){
            visit(ctx.children.get(i));
        }
        //visit(ctx.children.get(1));
        // System.out.println("}");
        //tempBlock.blockOutput.add("}");
        return null;
    }
    Block createnewblock(Block parblock,boolean a) {
        if(!parblock.set)
            parblock.blockOutput.add("    br label %"+"a"+step+'\n');
        BlockList.add(new Block(tempBlock, step++));
        tempBlock = BlockList.get(BlockList.size() - 1);
        tempBlock.set=a;
        return tempBlock;
    }
    void dealorlist(List<orblock>orblockList)
    {
        for(int i=0;i<orblockList.size();i++)
        {
            List<Block>blocks=orblockList.get(i).blockList;
            for(int j=0;j<blocks.size();j++)
            {
                Block now=blocks.get(j);
                if(j==blocks.size()-1)
                {
                    now.trueblock=orblockList.get(i).trueblock;

                }
                if(i==orblockList.size()-1)
                    now.falseblock=orblockList.get(i).falseblock;
                now.blockOutput.add("    br i1 %" + (now.end+1) + ",label %" + "a"+now.trueblock + ", label %" + "a"+now.falseblock + "\n");
            }
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Void visitStmt(compileParser.StmtContext ctx) {
        if (ctx.children.size() == 4) {
            // visit(ctx.lval());
            Var tempVar=null;
            for(int i=0;i<varList.size();i++){
                if(ctx.children.get(0).getText().equals(varList.get(i).getName())){
                    tempVar=varList.get(i);
                    break;
                }
            }
            if(tempVar==null||tempVar.isIfConst()==true){
                System.exit(3);
            }
            visit(ctx.exp());
            Node store = tempNode;
            if (store.getType() == "num") {
                tempBlock.blockOutput.add(whiteSpace + "store i32 " + tempNode.getVal() + ", i32* " + "%" + tempVar.getNodeId());
            } else {
                tempBlock.blockOutput.add(whiteSpace + "store i32 " + "%" + (tempNode.getId() + 1) + ", i32* " + "%" + tempVar.getNodeId());
            }
        }
        else if(ctx.children.size()==2){  //exp';'
            visit(ctx.exp());
        }
        else if(ctx.children.get(0).getText().equals("if"))
        {
            int leftjump,rightjump;
            Block parblock=tempBlock;
            visit(ctx.cond());  //注意这里需要全局变量
            List<orblock> temporblockList=new ArrayList<>(orblocksList);
            Block left=createnewblock(tempBlock,false);
            leftjump=left.start;

            visit(ctx.stmt(0));
            left=tempBlock;
            left.set=true;
            if(ctx.children.size()>5) {
                Block right = createnewblock(tempBlock,false);
                rightjump=right.start;
                visit(ctx.stmt(1));
                right=tempBlock;
                right.set=true;
                Block dest = createnewblock(tempBlock,false);
                left.jump = dest.start;
                right.jump = dest.start;
                if(right.flag==0)
                    right.blockOutput.add("    br label %"+"a"+right.jump+'\n');
                if(left.flag==0)
                    left.blockOutput.add("    br label %"+"a"+left.jump+'\n');
                for(int i=0;i<temporblockList.size();i++)
                {
                    temporblockList.get(i).trueblock = leftjump;
                    if(i==temporblockList.size()-1)
                        temporblockList.get(i).falseblock=rightjump;
                }
                dealorlist(temporblockList);
            }
            else
            {
                left.set=true;
                Block dest = createnewblock(tempBlock,false);
                if(left.flag==0)
                    left.blockOutput.add("    br label %"+"a"+dest.start+'\n');
                for(int i=0;i<temporblockList.size();i++)
                {
                    temporblockList.get(i).trueblock = leftjump;
                    if(i==temporblockList.size()-1)
                        temporblockList.get(i).falseblock=dest.start;
                }
                dealorlist(temporblockList);
            }}
        else if(ctx.block()!=null){  //block
            visit(ctx.block());
            return null;
        }
        else {
            if(ctx.exp()==null)
            {
                tempBlock.blockOutput.add("    ret void" + "\n");
                tempBlock.flag = 1;
            }

            else{
                visit(ctx.exp());
                Node retNode = tempNode;
                if (retNode.getType().equals("num")) {
                    tempBlock.blockOutput.add(whiteSpace + "ret i32 " + retNode.getVal()+"\n");
                } else {
                    tempBlock.blockOutput.add(whiteSpace + "ret i32 " + "%" + (retNode.getId() + 1)+"\n");
                }
                tempBlock.flag=1;
            }

            //  System.out.print(dealNum(ctx.Number().getText()));
            //  System.out.println(";");
        }

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
                if(opType.equals("!")){

                    if(right.getType().equals("num")) {
                        Node node=new Node(nodeList.size(),nodeList.size(),"icmp",0);
                        nodeList.add(node);
                        tempBlock.blockOutput.add("    %"+nodeList.size()+" = icmp eq i32 "+right.getId()+", 0\n");
                        //step+=1;
                        Node Anode=new Node(nodeList.size(),nodeList.size()+1,"zext",0);
                        nodeList.add(Anode);
                        tempBlock.blockOutput.add("    %" + nodeList.size() + "= zext i1 %"+(nodeList.size()-1)+" to i32"+'\n');
                        tempNode=Anode;
                        //System.out.println("    %" + curfuncblock.step + " = sub i32 0, " + info.num);
                    }
                    else {
                        Node node=new Node(nodeList.size(),nodeList.size()+1,"icmp",0);
                        node.geshi="i1";
                        node.setType("exp");
                        nodeList.add(node);
                        tempBlock.blockOutput.add("    %" + nodeList.size() + " = icmp eq "+right.geshi+" 0, " + "%"+(right.getId()+1));
                        tempNode=node;
                    }

//
                }
                else if(opType.equals("-")){
                    if(tempBlock.type.equals("func")) {
                        if (right.getType().equals("num")) {
                            OpDeal(null,right,opType);
                            //System.out.println("    %" + curfuncblock.step + " = sub i32 0, " + info.num);
                        } else {
                            if (right.geshi.equals("i1")) {
                                Node node=new Node(nodeList.size(),nodeList.size()+1,"num",0);
                                tempBlock.blockOutput.add("    %" + (nodeList.size()+1) + "= zext i1 " + "%"+nodeList.size()+ " to i32" );
                                tempNode=node;
                                nodeList.add(tempNode);
                            }
                            //int tt = curfuncblock.step - 1;
                            Node node=new Node(nodeList.size(),nodeList.size()+1,"pointer",0);
                            node.geshi="i32";
                            tempNode=node;
                            nodeList.add(tempNode);
                            tempBlock.blockOutput.add("    %" + nodeList.size() + " = sub i32 0, %" + (nodeList.size()-1) );
                        }
                       // info.address = "%" + curfuncblock.step;
                        tempNode.setVal(-right.getVal());
                        tempNode.geshi = "i32";

                        tempNode.setType( "pointer");
                    }
                    else
                    {
                        right.setVal(-right.getVal());
                        right.setType( "pointer");

                    }
                }
                else{
                    OpDeal(null,right,opType);
                }
                break;
            }
            case 4->{               //自定义函数
                visit(ctx.funcrparams());
                String linkFunction=ctx.children.get(0).getText();
                if(linkFunction.equals("getint")){
                    boolean check=false;
                    for(int i=0;i<output.size();i++){
                        if(output.get(i).equals("declare i32 @getint()")){
                            check=true;
                            break;
                        }
                    }
                    if(!check){
                        output.addFirst("declare i32 @getint()");
                    }
                    Node node=new Node(nodeList.size(),nodeList.size(),"call",0);
                    nodeList.add(node);
                    tempNode=node;
                    tempBlock.blockOutput.add(whiteSpace + "%"+(nodeList.size())+" = call i32 @getint()");
                }
                else if(linkFunction.equals("getch")){
                    boolean check=false;
                    for(int i=0;i<output.size();i++){
                        if(output.get(i).equals("declare i32 @getch()")){
                            check=true;
                            break;
                        }
                    }
                    if(!check){
                        output.addFirst("declare i32 @getch()");
                    }


                    Node node=new Node(nodeList.size(),nodeList.size(),"call",0);
                    nodeList.add(node);
                    tempNode=node;
                    tempBlock.blockOutput.add(whiteSpace + "%"+(nodeList.size())+" = call i32 @getch()");
                }
                else if(linkFunction.equals("putint")){
                    boolean check=false;
                    for(int i=0;i<output.size();i++){
                        if(output.get(i).equals("declare void @putint(i32)")){
                            check=true;
                            break;
                        }
                    }
                    if(!check){
                        output.addFirst("declare void @putint(i32)");
                    }

                    //output.addFirst("declare void @putint(i32)");
                    Node inputNode=tempNode;
                    // Node node=new Node(nodeList.size(),nodeList.size(),"call",0);
                    //nodeList.add(node);
                    // tempNode=node;
                    if(inputNode.getType()=="num"||inputNode.getType()=="constVar"){
                        tempBlock.blockOutput.add(whiteSpace + "call void @putint(i32 "+inputNode.getVal()+")");
                    }
                    else{
                        tempBlock.blockOutput.add(whiteSpace + "call void @putint(i32 %"+(inputNode.getId()+1)+")");
                    }
                }
                else if(linkFunction.equals("putch")){
                    boolean check=false;
                    for(int i=0;i<output.size();i++){
                        if(output.get(i).equals("declare void @putch(i32)")){
                            check=true;
                            break;
                        }
                    }
                    if(!check){
                        output.addFirst("declare void @putch(i32)");
                    }
                    // output.addFirst("declare void @putch(i32)");
                    Node inputNode=tempNode;
                    // Node node=new Node(nodeList.size(),nodeList.size(),"call",0);
                    // nodeList.add(node);
                    // tempNode=node;
                    if(inputNode.getType()=="num"||inputNode.getType()=="constVar"){
                        tempBlock.blockOutput.add(whiteSpace + "call void @putch(i32 "+inputNode.getVal()+")");
                    }
                    else{
                        tempBlock.blockOutput.add(whiteSpace + "call void @putch(i32 %"+(inputNode.getId()+1)+")");
                    }
                }
                break;
            }
        }
        return null;
    }

    @Override
    public Void visitPrimaryExp(compileParser.PrimaryExpContext ctx) {
        if(ctx.children.size()==1){      //number/lval
            visit(ctx.children.get(0));
        }
        else{
            visit(ctx.exp());
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
        else if(op.equals("<=")){
            return "sle";
        }
        else if(op.equals("<")){
            return "slt";
        }
        else if(op.equals(">")){
            return "sgt";
        }
        else if(op.equals(">=")){
            return "sge";
        }
        else if(op.equals("==")){
            return "eq";
        }
        else if(op.equals("!=")){
            return "ne";
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
            else if(leftNode.getType().equals("constVar")){
                left=String.valueOf(leftNode.getVal());
            }
            else if(leftNode.getType().equals("intVar")){
                left="%"+String.valueOf(leftNode.getId()+1);
            }
            else if(leftNode.getType().equals("load")){
                left="%"+String.valueOf(leftNode.getId()+1);
            }
        }
        if(rightNode.getType().equals("num")){
            right=String.valueOf(rightNode.getVal());
        }
        else if(rightNode.getType().equals("exp")){
            right="%"+String.valueOf(rightNode.getVal());
        }
        else if(rightNode.getType().equals("intVar")){
            right="%"+String.valueOf(rightNode.getId());
        }
        else if(rightNode.getType().equals("constVar")){
            right=String.valueOf(rightNode.getVal());
        }
        else if(rightNode.getType().equals("load")){
            right="%"+String.valueOf(rightNode.getId()+1);
        }
        if(left==null||right==null){
            return;
        }
        int top=0;
        int depth=0;
        for(int i=0;i<nodeList.size();i++){
            if(nodeList.get(i).getType().equals("exp")){

                depth=nodeList.get(i).getDepth();
            }
        }
        top=nodeList.size();
        Node newNode=new Node(nodeList.size(),top+1,"exp",depth);
        tempNode=newNode;
        nodeList.add(newNode);
        tempBlock.blockOutput.add(whiteSpace+"%"+(top+1)+" = "+OpEnum(op)+" i32 "+left+", "+right);
        return;
    }

    public void CondDeal(Node leftNode,Node rightNode,String op){
        if(OpEnum(op)==null){
            return;
        }
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
            else if(leftNode.getType().equals("constVar")){
                left=String.valueOf(leftNode.getVal());
            }
            else if(leftNode.getType().equals("intVar")){
                left="%"+String.valueOf(leftNode.getId()+1);
            }
            else if(leftNode.getType().equals("load")){
                left="%"+String.valueOf(leftNode.getId()+1);
            }
        }
        if(rightNode.getType().equals("num")){
            right=String.valueOf(rightNode.getVal());
        }
        else if(rightNode.getType().equals("exp")){
            right="%"+String.valueOf(rightNode.getVal());
        }
        else if(rightNode.getType().equals("intVar")){
            right="%"+String.valueOf(rightNode.getId());
        }
        else if(rightNode.getType().equals("constVar")){
            right=String.valueOf(rightNode.getVal());
        }
        else if(rightNode.getType().equals("load")){
            right="%"+String.valueOf(rightNode.getId()+1);
        }
        int top=0;
        int depth=0;
        for(int i=0;i<nodeList.size();i++){
            if(nodeList.get(i).getType().equals("exp")){

                depth=nodeList.get(i).getDepth();
            }
        }
        top=nodeList.size();
        Node newNode=new Node(nodeList.size(),top+1,"exp",depth);
        tempNode=newNode;
        nodeList.add(newNode);
        tempBlock.blockOutput.add(whiteSpace+"%"+(top+1)+" = icmp "+OpEnum(op)+" i32 "+left+", "+right);
        return;
    }
    @Override
    public Void visitBType(compileParser.BTypeContext ctx) {
        return super.visitBType(ctx);
    }

    @Override
    public Void visitNumber(compileParser.NumberContext ctx) {
        Node node=new Node(-1,dealNum(ctx.getText()),"num",0);
        tempNode=node;
        return super.visitNumber(ctx);
    }

    @Override
    public Void visitBlockItem(compileParser.BlockItemContext ctx) {
        return super.visitBlockItem(ctx);
    }

    @Override
    public Void visitDecl(compileParser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    @Override
    public Void visitConstDecl(compileParser.ConstDeclContext ctx) {
        return super.visitConstDecl(ctx);
    }

    @Override
    public Void visitConstDef(compileParser.ConstDefContext ctx) {
        if(ctx.children.size()==1){    //没有初始化
            int constNum=dealNum(ctx.children.get(0).getText());
            // Node node=new Node(nodeList.size(),0,ctx.children.get(0).getText(),"constVar",0);
            //nodeList.add(node);
            // System.out.println(whiteSpace+"%"+(top+1)+" ="+" alloca i32");
            Var var=new Var(ctx.children.get(0).getText(),true,"int",constNum,0,-1);
            varList.add(var);
        }
        else if(ctx.children.size()==3){
            int top=nodeList.size();
            String left=ctx.children.get(0).getText();
            for(int i=0;i<varList.size();i++){
                if(varList.get(i).getName().equals(left)){
                    System.exit(3);
                }
            }
            visit(ctx.constInitval());
            Node store=tempNode;
            if(store.getType()!=null){
                int constNum=tempNode.getVal();
                Node node=new Node(nodeList.size(),constNum,ctx.children.get(0).getText(),"constVar",0);
                Var var=new Var(ctx.children.get(0).getText(),true,"int",constNum,0,-1);
                varList.add(var);
                // nodeList.add(node);
                // System.out.println(whiteSpace+"store i32 "+tempNode.getVal()+", i32* "+"%"+(top+1));
            }
            else{
                System.exit(3);  //需要改
            }
        }
        // System.out.println("22323");
        return super.visitConstDef(ctx);
    }

    @Override
    public Void visitConstInitval(compileParser.ConstInitvalContext ctx) {
        return super.visitConstInitval(ctx);
    }

    @Override
    public Void visitConstExp(compileParser.ConstExpContext ctx) {
        return super.visitConstExp(ctx);
    }

    @Override
    public Void visitVarDecl(compileParser.VarDeclContext ctx) {
        return super.visitVarDecl(ctx);
    }

    @Override
    public Void visitVarDef(compileParser.VarDefContext ctx) {
        if(ctx.children.size()==1){    //没有初始化
            int top=nodeList.size();
            //  System.out.println("var def:"+ctx.children.get(0).getText());
            Node node=new Node(nodeList.size(),0,ctx.children.get(0).getText(),"intVar",0);
            Var var=new Var(ctx.children.get(0).getText(),false,"int",0,0,nodeList.size()+1);
            nodeList.add(node);
            varList.add(var);
            tempBlock.blockOutput.add(whiteSpace+"%"+(top+1)+" ="+" alloca i32");
        }
        else if(ctx.children.size()==3){
            int top=nodeList.size();
            Node node=new Node(nodeList.size(),0,ctx.children.get(0).getText(),"intVar",0);
            //  System.out.println("var def:"+ctx.children.get(0).getText());
            Var var=new Var(ctx.children.get(0).getText(),false,"int",0,0,nodeList.size()+1);
            varList.add(var);
            nodeList.add(node);
            tempBlock.blockOutput.add(whiteSpace+"%"+(top+1)+" ="+" alloca i32");
            visit(ctx.initval());
            Node store=tempNode;
            if(store.getType()=="num"||store.getType()=="constVar"){
                tempBlock.blockOutput.add(whiteSpace+"store i32 "+tempNode.getVal()+", i32* "+"%"+(top+1));
            }
            else{
                tempBlock.blockOutput.add(whiteSpace+"store i32 "+"%"+(tempNode.getId()+1)+", i32* "+"%"+(top+1));
            }

        }
        // System.out.println("22323");
        return null;
    }

    @Override
    public Void visitInitval(compileParser.InitvalContext ctx) {
        return super.visitInitval(ctx);
    }

    @Override
    public Void visitFuncrparams(compileParser.FuncrparamsContext ctx) {
        return super.visitFuncrparams(ctx);
    }

    @Override
    public Void visitLval(compileParser.LvalContext ctx) {
        String name=ctx.getText();
        boolean check=false;
        for(int i=0;i<varList.size();i++){
            if(varList.get(i).getName().equals(name)){
                if(varList.get(i).isIfConst()==true){     //const
                    Node node=new Node(-1,varList.get(i).getVal(),name,"constVar",0);
                    tempNode=node;
                    check=true;
                    break;
                }
                else{                                  //int
                    int nodeId=varList.get(i).getNodeId();
                    Node loadNode=nodeList.get(nodeId-1);
                    int top=nodeList.size();
                    Node node=new Node(nodeList.size(),0,name+"load","load",0);
                    tempNode=node;
                    tempBlock.blockOutput.add(whiteSpace+"%"+(tempNode.getId()+1)+" = "+"load i32, i32* "+"%"+nodeId);
                    nodeList.add(node);
                    check=true;
                    break;
                }
            }
        }
        if(!check){
            System.exit(3);
        }
        return super.visitLval(ctx);
    }

    @Override
    public Void visitCond(compileParser.CondContext ctx) {
        return super.visitCond(ctx);
    }

    @Override
    public Void visitRelExp(compileParser.RelExpContext ctx) {
        if(ctx.children.size()>1){
            visit(ctx.children.get(0));
            Node left=tempNode;
            visit(ctx.children.get(2));
            Node right=tempNode;
            //visit(ctx.children.get(1));
            String optype=ctx.children.get(1).getText();
            CondDeal(left,right,optype);
            tempNode.setType("exp");
            //step++;
        }
        else if(ctx.children.size()==1){
            visit(ctx.addExp(0));
        }
        return null;
        //return super.visitRelExp(ctx);
    }

    @Override
    public Void visitEqExp(compileParser.EqExpContext ctx) {
        visit(ctx.relExp(0));
        Node left=tempNode;


        boolean check=true;
        for(int i=1;i<ctx.relExp().size();i++)
        {
            visit(ctx.relExp(i));
            Node right=tempNode;
            String symbol=ctx.Condop2(i-1).getText();
            CondDeal(left,right,symbol);
            left=right;
            check=false;
            tempNode.setType("exp");
            //step++;
        }
        if(check&&tempNode.getType()!="exp"){
            check=false;
            if(left.getType()=="num"||left.getType()=="constVar"){
                Node node=new Node(nodeList.size(),nodeList.size()+1,"cmp",0);
                nodeList.add(node);
                tempNode=node;
                tempBlock.blockOutput.add("    %"+nodeList.size()+"= icmp ne i32 0, "+left.getVal());
            }
            else{
                Node node=new Node(nodeList.size(),nodeList.size()+1,"cmp",0);
                nodeList.add(node);
                tempNode=node;
                tempBlock.blockOutput.add("    %"+nodeList.size()+"= icmp ne i32 0, "+"%"+left.getId());
            }

        }
        return null;
    }

    @Override
    public Void visitLandExp(compileParser.LandExpContext ctx) {
        List<Block>blocks=new ArrayList<>();
        for(int i=0;i<ctx.eqExp().size();i++)
        {
            tempBlock=createnewblock(tempBlock,true);
            visit(ctx.eqExp(i));
            tempBlock.end=nodeList.size()-1;
            tempBlock.trueblock=step;
            blocks.add(tempBlock);
        }
        Block dest=createnewblock(tempBlock,false);
        for(Block i:blocks)
            i.falseblock=dest.start;
        landBlockList=blocks;
        return null;
    }

    @Override
    public Void visitLorExp(compileParser.LorExpContext ctx) {
        List<orblock>orblockList=new ArrayList<>();
        for(int i=0;i<ctx.landExp().size();i++)
        {
            orblock orblock_List=new orblock();
            visit(ctx.landExp(i));
            orblock_List.blockList= landBlockList;
            orblockList.add(orblock_List);
        }
        Block dest=createnewblock(tempBlock,false);
        orblocksList=orblockList;
        return null;
    }



}
