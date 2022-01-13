import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Visitor extends  compileBaseVisitor<Void> {
    //List<Node> nodeList=new LinkedList<Node>();
   // List<Var>  varList=new LinkedList<>();  func后弃用
    Node lvalNode=null;
    boolean  ifArray=false;  //load还是store array

    List<Block> BlockList=new LinkedList<>();  //所有Block
    List<Block> tempBlockList=new ArrayList<>();
    List<Block> landBlockList=new ArrayList<>();  //lab4递归用的
    List<orblock> orblocksList=new ArrayList<>();  //lab4递归存值用的
    List<Var> globalVar=new ArrayList<>();  //全局变量

    Function tempFunction;   //指针，指向当前的函数
    public LinkedList<String> output=new LinkedList<String>();
    int tempId=0;
    int tempNum=0;
    int step=0;   //Block步数
   // Block tempBlock=null;
    Node tempNode=null;
    String op;
    String whiteSpace ="    ";
    List<Function>funcblockList=new ArrayList<>();

    @Override public Void visitCompUnit(compileParser.CompUnitContext ctx) {
        System.out.println("declare void @memset(i32*, i32, i32)");
        Function_initial("decl");
        if(ctx.decl()!=null){
            for(int i=0;i<ctx.decl().size();i++){
                visit(ctx.decl(i));
            }
        }
        if(ctx.funcDef()!=null){
            for(int i=0;i<ctx.funcDef().size();i++){
                Function_initial("func");
                visit(ctx.funcDef(i));
            }
        }
        for(int j=0;j<output.size();j++){
            System.out.println(output.get(j));
        }
        for(int w=0;w<funcblockList.size();w++) {
            Function f=funcblockList.get(w);
            if(f.name.equals("func")&&f.blocks.get(0).blockOutput.size()>=1){
                System.out.println("define dso_local i32 @main(){");
            }
            //System.out.println("define dso_local i32 @main(){");
            for(int i=0;i<f.blocks.size();i++)
            {
                Block a=f.blocks.get(i);
                if(i==f.blocks.size()-1&&f.returntype.equals("void"))
                {
                    a.blockOutput.add("    ret void\n");
                }
                if(f.name.equals("func")&&f.blocks.get(0).blockOutput.size()>=1){
                    //System.out.println("define dso_local i32 @main(){");
                    if(i!=0){
                        System.out.println("a"+a.start+":");
                    }
                }
               // if(f.returntype.equals("func")){
                    //System.out.println("define dso_local i32 @main(){");
                 //   System.out.println("a"+a.start+":");
                //}
                for(int k=0;k<a.blockOutput.size();k++){
                    System.out.println(a.blockOutput.get(k));
                }
            }
            if(f.returntype.equals("func")){
               // System.out.println("define dso_local i32 @main(){");
                System.out.println("}");
            }

        }
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Void visitFuncDef(compileParser.FuncDefContext ctx) {
        String defOutput="";  //函数定义用的输出语句
        String funcType=ctx.funcType().getText();
        Function_initial("func");
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
    @Override public Void visitFuncType(compileParser.FuncTypeContext ctx){
        //System.out.println("define dso_local i32 @main(){");
       /// if (ctx.children.get(0).getText().equals("int"))
      //  {
           // output.add("define dso_local i32 @main(){");
            /*
            接下来要初始化一个简单的初始块
             *

             */
            //tempBlock.blockOutput.add("    br label %"+"a0");
            //BlockList.add(new Block());
          //  step++;
          //  tempBlock=BlockList.get(0);
           // output.add("    br label %"+"a0");
           // tempBlock.type="func";
            //tempBlock.set=false;
            //tempBlock.end=0;
      //  }
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
        Varblock fatherNode=tempFunction.tempVarBlock;
        tempFunction.tempVarBlock=new Varblock();
        tempFunction.varblocks.add(tempFunction.tempVarBlock);
        tempFunction.tempVarBlock.fathernode=fatherNode;  //添加父节点
       // fatherNode.childrennode.add(tempFunction.tempVarBlock);   //添加子节点
        tempFunction.tempVarBlock.in.addAll(fatherNode.in);
        tempFunction.tempVarBlock.in.addAll(globalVar);
        tempFunction.tempVarBlock.out.addAll(fatherNode.out);
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
        tempFunction.blocks.add(new Block(tempFunction.tempBlock, step++));
        tempFunction.tempBlock = tempFunction.blocks.get(tempFunction.blocks.size() - 1);
        tempFunction.tempBlock.set=a;
        return tempFunction.tempBlock;
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
    public Var findVar(String Varname){
        Var tempVar=null;
        for(int i=tempFunction.tempVarBlock.in.size()-1;i>=0;i--){
            if(tempFunction.tempVarBlock.in.get(i).getName().equals(Varname)){
                tempVar=tempFunction.tempVarBlock.in.get(i);
                break;
            }
        }
        return tempVar;
    }
    @Override public Void visitStmt(compileParser.StmtContext ctx) {
        if (ctx.children.size() == 4&&ctx.lval()!=null) {  //lval'=' exp ';'
            // visit(ctx.lval());
            Var tempVar=null;
            //for(int i=0;i<varList.size();i++){
            //    if(ctx.children.get(0).getText().equals(varList.get(i).getName())){
             //       tempVar=varList.get(i);
             //       break;
            //    }
            //}
            String needtoFind="";
            if(ctx.children.get(0).getText().contains("[")){   //数组
                ifArray=false;
                visit(ctx.exp());
                ifArray=true;
                lvalNode=tempNode;
                visit(ctx.lval());
                ifArray=false;

                //needtoFind=ctx.lval().Ident().getText();
                return null;
            }
            else{
                needtoFind=ctx.children.get(0).getText();
            }
            //System.out.println(ctx.lval().Ident().getText());
            tempVar=findVar(needtoFind);
           // System.out.println(ctx.children.get(0).getText());
            if(tempVar==null||tempVar.isIfConst()==true){
                System.exit(4);
            }
            visit(ctx.exp());
            Node store = tempNode;
            if(tempVar.getType().equals("globalInt")){  //修改全局变量
                if (store.getType() == "num") {
                    tempFunction.tempBlock.blockOutput.add(whiteSpace + "store i32 " + tempNode.getVal() + ", i32* " + "@" + tempVar.getName());
                }
                else {
                    tempFunction.tempBlock.blockOutput.add(whiteSpace + "store i32 " + "%" + (tempNode.getId() + 1) + ", i32* " + "@" + tempVar.getName());
                }
            }
            else{
                if (store.getType() == "num") {
                    tempFunction.tempBlock.blockOutput.add(whiteSpace + "store i32 " + tempNode.getVal() + ", i32* " + "%" + tempVar.getNodeId());
                }
                else {
                    tempFunction.tempBlock.blockOutput.add(whiteSpace + "store i32 " + "%" + (tempNode.getId() + 1) + ", i32* " + "%" + tempVar.getNodeId());
                }
            }

        }
        else if(ctx.children.size()==2&&ctx.exp()!=null){  //exp';'
            visit(ctx.exp());
        }
        else if(ctx.children.get(0).getText().equals("if"))
        {
            int leftjump,rightjump;
            Block parblock=tempFunction.tempBlock;
            visit(ctx.cond());  //注意这里需要全局变量
            List<orblock> temporblockList=new ArrayList<>(orblocksList);
            Block left=createnewblock(tempFunction.tempBlock,false);
            leftjump=left.start;

            visit(ctx.stmt(0));
            left=tempFunction.tempBlock;
            left.set=true;
            if(ctx.children.size()>5) {
                Block right = createnewblock(tempFunction.tempBlock,false);
                rightjump=right.start;
                visit(ctx.stmt(1));
                right=tempFunction.tempBlock;
                right.set=true;
                Block dest = createnewblock(tempFunction.tempBlock,false);
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
                Block dest = createnewblock(tempFunction.tempBlock,false);
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
        else if(ctx.children.get(0).getText().equals("while")){
            Block parblock=tempFunction.tempBlock;
            Varblock parvarblock=tempFunction.tempVarBlock;
            visit(ctx.cond());
            List<orblock>orblockList=orblocksList;
            int start=orblockList.get(0).blockList.get(0).start;
//            condblock.end=curfuncblock.step-1;
            int left=tempFunction.step;

            if(!ctx.stmt(0).getText().equals(";")) {
                int from=tempFunction.blocks.size()-1;
                Block leftblock=createnewblock(tempFunction.tempBlock,false);
                visit(ctx.stmt(0));
                tempFunction.tempBlock.blockOutput.add("    br label %" + "a"+start + '\n');
                tempFunction.tempBlock.set = true;
                Block destblock = createnewblock(tempFunction.tempBlock, false);
                tempFunction.tempVarBlock= parvarblock;
                for(int i=0;i<orblockList.size();i++)
                {
                    orblockList.get(i).trueblock = leftblock.start;
                    if(i==orblockList.size()-1)
                        orblockList.get(i).falseblock=destblock.start;
                }
                dealorlist(orblockList);
                for(int i=from;i<tempFunction.blocks.size();i++)
                {

                    Block now=tempFunction.blocks.get(i);
                    if(!(now.type.equals("continue")||now.type.equals("break")))
                        continue;
                    int destjump=0;
                    switch (now.type)
                    {
                        case "break":
                            destjump=destblock.start;
                            break;
                        case "continue":
                            destjump=start;
                            break;
                    }
                    if(now.stage==1) {
                        now.stage = 2;
                        now.blockOutput.add("    br label %" + "a"+destjump + '\n');
                    }
                }
            }
            else{
                tempFunction.tempBlock.set=false;
                Block destblock = createnewblock(tempFunction.tempBlock, false);
                tempFunction.tempVarBlock=parvarblock;
            }
        }
        else if (ctx.CONTINUE()!=null)
        {
            Block continueblock=createnewblock(tempFunction.tempBlock,true);
            tempFunction.tempBlock.type="continue";
            Block destbblock=createnewblock(tempFunction.tempBlock,false);
        }
        else if(ctx.BREAK()!=null)
        {
            Block continueblock=createnewblock(tempFunction.tempBlock,true);
            tempFunction.tempBlock.type="break";
            Block destbblock=createnewblock(tempFunction.tempBlock,false);

        }
        else if(ctx.children.get(0).getText().equals("return")){  //ret
            if(ctx.exp()==null)
            {
                tempFunction.tempBlock.blockOutput.add("    ret void" + "\n");
                tempFunction.tempBlock.flag = 1;
            }

            else{
                visit(ctx.exp());
                Node retNode = tempNode;
                if (retNode.getType().equals("num")) {
                    tempFunction.tempBlock.blockOutput.add(whiteSpace + "ret i32 " + retNode.getVal()+"\n");
                } else {
                    tempFunction.tempBlock.blockOutput.add(whiteSpace + "ret i32 " + "%" + (retNode.getId() + 1)+"\n");
                }
                tempFunction.tempBlock.flag=1;
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
          //  System.out.println(left.getType()+""+left.getType());
            //System.out.print(tempNode.getType());
            visit(ctx.children.get(2));
            Node right=tempNode;
            //System.out.println(tempNode.getType());
            visit(ctx.children.get(1));

            String optype=ctx.children.get(1).getText();
            if(tempFunction.name.equals("func")){
                OpDeal(left,right,optype);
            }

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
            if(tempFunction.name.equals("func")){
                OpDeal(left,right,optype);
            }
        }
        return null;
    }

    @Override
    //unaryExp:primaryExp|unaryOp unaryExp| Ident '(' funcrparams ')';
    public Void visitUnaryExp(compileParser.UnaryExpContext ctx) {
        switch (ctx.children.size()) {
            case 1-> {                           //primaryExp
                visit(ctx.primaryExp());
               // nodeinfo info=(nodeinfo) visit(ctx.primaryexp());

                break;
            }
            case 2-> {                         //unaryOp unaryExp

                visit(ctx.children.get(1));
                Node right=tempNode;
                String opType=ctx.unaryOp().getText();
                if(opType.equals("!")){
                    if(tempFunction.tempBlock.type.equals("func")){
                        if(right.getType().equals("num")) {
                            Node node=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size(),"icmp",0);
                            tempFunction.nodeList.add(node);
                            tempFunction.tempBlock.blockOutput.add("    %"+tempFunction.nodeList.size()+" = icmp eq i32 "+right.getId()+", 0\n");
                            //step+=1;
                            Node Anode=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size()+1,"zext",0);
                            tempFunction.nodeList.add(Anode);

                            tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + "= zext i1 %"+(tempFunction.nodeList.size()-1)+" to i32"+'\n');
                            tempNode=Anode;
                            //System.out.println("    %" + curfuncblock.step + " = sub i32 0, " + info.num);
                        }
                        else {
                            Node node=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size()+1,"icmp",0);
                            node.geshi="i1";
                            node.setType("exp");
                            tempFunction.nodeList.add(node);


                            tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = icmp eq "+right.geshi+" 0, " + "%"+(right.getId()+1));
                            tempNode=node;
                        }

                    }

//
                }
                else if(opType.equals("-")){
                    if(tempFunction.tempBlock.type.equals("func")) {
                        if (right.getType().equals("num")) {
                            OpDeal(null,right,opType);
                            //System.out.println("    %" + curfuncblock.step + " = sub i32 0, " + info.num);
                        } else {
                            if (right.geshi.equals("i1")) {
                                Node node=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size()+1,"num",0);
                                tempFunction.tempBlock.blockOutput.add("    %" + (tempFunction.nodeList.size()+1) + "= zext i1 " + "%"+tempFunction.nodeList.size()+ " to i32" );
                                tempNode=node;
                                tempFunction.nodeList.add(tempNode);
                            }
                            //int tt = curfuncblock.step - 1;
                            Node node=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size()+1,"pointer",0);
                            node.geshi="i32";
                            tempNode=node;
                            tempFunction.nodeList.add(tempNode);
                            tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = sub i32 0, %" + (tempFunction.nodeList.size()-1) );
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
                    Node node=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size(),"call",0);
                    tempFunction.nodeList.add(node);
                    tempNode=node;
                    tempFunction.tempBlock.blockOutput.add(whiteSpace + "%"+(tempFunction.nodeList.size())+" = call i32 @getint()");
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


                    Node node=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size(),"call",0);
                    tempFunction.nodeList.add(node);
                    tempNode=node;
                    tempFunction. tempBlock.blockOutput.add(whiteSpace + "%"+(tempFunction.nodeList.size())+" = call i32 @getch()");
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
                        tempFunction.tempBlock.blockOutput.add(whiteSpace + "call void @putint(i32 "+inputNode.getVal()+")");
                    }
                    else{
                        tempFunction.tempBlock.blockOutput.add(whiteSpace + "call void @putint(i32 %"+(inputNode.getId()+1)+")");
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
                        tempFunction.tempBlock.blockOutput.add(whiteSpace + "call void @putch(i32 "+inputNode.getVal()+")");
                    }
                    else{
                        tempFunction.tempBlock.blockOutput.add(whiteSpace + "call void @putch(i32 %"+(inputNode.getId()+1)+")");
                    }
                }
                break;
            }
        }
        return null;
    }

    @Override
    public Void visitPrimaryExp(compileParser.PrimaryExpContext ctx) {
        if(ctx.number()!=null){
            visit(ctx.number());
        }
        else if(ctx.lval()!=null){

            visit(ctx.lval());

          //  System.out.println(tempNode.getId()+" "+tempNode.getType());
        }
        else{
            visit(ctx.exp());
        }
        //System.out.println(tempNode.getId()+" "+tempNode.getType());
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
            else if(leftNode.getType().equals("call")){
                left="%"+String.valueOf(leftNode.getId()+1);
            }
            else if(leftNode.getType().equals("array")){
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
        else if(rightNode.getType().equals("array")){
            right="%"+String.valueOf(rightNode.getId()+1);
        }
        if(left==null||right==null){
            return;
        }
        int top=0;
        int depth=0;
        for(int i=0;i<tempFunction.nodeList.size();i++){
            if(tempFunction.nodeList.get(i).getType().equals("exp")){

                depth=tempFunction.nodeList.get(i).getDepth();
            }
        }
        top=tempFunction.nodeList.size();
        Node newNode=new Node(tempFunction.nodeList.size(),top+1,"exp",depth);
        tempNode=newNode;
        tempFunction.nodeList.add(newNode);
        tempFunction.tempBlock.blockOutput.add(whiteSpace+"%"+(top+1)+" = "+OpEnum(op)+" i32 "+left+", "+right);
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
        else {
            right="%"+String.valueOf(tempFunction.nodeList.size());
        }
        int top=0;
        int depth=0;
        for(int i=0;i<tempFunction.nodeList.size();i++){
            if(tempFunction.nodeList.get(i).getType().equals("exp")){

                depth=tempFunction.nodeList.get(i).getDepth();
            }
        }
        top=tempFunction.nodeList.size();
        Node newNode=new Node(tempFunction.nodeList.size(),top+1,"exp",depth);
       // tempNode=newNode;
        //tempFunction.nodeList.add(newNode);
       // if(top+1==8&&OpEnum(op).equals("eq")){
       //    tempFunction.tempBlock.blockOutput.add(whiteSpace+"br label %a5");
        //    return;
        //}
        tempNode=newNode;
        tempFunction.nodeList.add(newNode);
        tempFunction.tempBlock.blockOutput.add(whiteSpace+"%"+(top+1)+" = icmp "+OpEnum(op)+" i32 "+left+", "+right);
        if(top+1==8&&OpEnum(op).equals("eq")){
              tempFunction.tempBlock.blockOutput.add(whiteSpace+"br label %a5\n");
               return;
           }
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
            tempFunction.tempVarBlock.in.add(var);
        }
        else if(ctx.children.size()==3){
            int top=tempFunction.nodeList.size();
            String left=ctx.children.get(0).getText();
            for(int i=0;i<tempFunction.tempVarBlock.in.size();i++){
                if(tempFunction.tempVarBlock.in.get(i).getName().equals(left)){
                    System.exit(5);
                }
            }
            visit(ctx.constInitval());
            Node store=tempNode;
            if(store.getType()!=null){
                int constNum=tempNode.getVal();
                Node node=new Node(tempFunction.nodeList.size(),constNum,ctx.children.get(0).getText(),"constVar",0);
                Var var=new Var(ctx.children.get(0).getText(),true,"int",constNum,0,-1);
                tempFunction.tempVarBlock.in.add(var);
                if(tempFunction.name.equals("decl")){
                    globalVar.add(var);
                }
                // nodeList.add(node);
                // System.out.println(whiteSpace+"store i32 "+tempNode.getVal()+", i32* "+"%"+(top+1));
            }
            else{
                System.exit(6);  //需要改
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
        if(ctx.constExp().size()!=0&&ctx.children.size()>=2){                   //数组
            //System.out.println("jwgddwjgdw");

            String arrayname=ctx.Ident().getText();
            //if (findVar(arrayname) != null)
             //   System.exit(90);
            int num=1;
            List<Integer>numbers=new ArrayList<>();
//                int tianchong=a.Brackets().size()/2-a.constexp().size();
//                if(tianchong>0)
//                    numbers.add(0);
            for(int a=0;a<ctx.constExp().size();a++)
            {
                visit(ctx.constExp(a));
                num*=tempNode.getVal();
                numbers.add(tempNode.getVal());
            }
           // System.out.println("jwgddwjgdw");
            if(tempFunction.tempBlock.type.equals("func")) {

                Node arrayNode=new Node(tempFunction.nodeList.size(),0,ctx.Ident().getText(),"array",0,"i32",num,numbers);
                tempFunction.nodeList.add(arrayNode);
                tempFunction.tempBlock.blockOutput.add("    %"+tempFunction.nodeList.size()+" = alloca [" + num + "x i32]");
               // int id, int val, String name, String type, int depth, String geshi, int length, List<Integer> numlist
                tempNode=arrayNode;
                Var arrayVar=new Var(ctx.Ident().getText(),false,"array",tempFunction.nodeList.size(),0,tempFunction.nodeList.size()+1,num,numbers);
                tempFunction.tempVarBlock.in.add(arrayVar);
                //tempFunction.nodeList.add(arrayNode);

            }
            else
            {

                Var arrayVar=new Var(ctx.Ident().getText(),false,"global_array",tempFunction.nodeList.size(),0,tempFunction.nodeList.size()+1,num,numbers);
               // tempFunction.tempVarBlock.in.add(arrayVar);
                tempFunction.tempVarBlock.in.add(arrayVar);
                if(tempFunction.name.equals("decl")){
                    globalVar.add(arrayVar);
                }
                if(ctx.initval()==null||ctx.initval().getText().equals("{}")){
                    tempFunction.tempBlock.blockOutput.add("@"+ctx.Ident().getText()+" = dso_local global [ " + num + "x i32] zeroinitializer");
                }

            }
           // System.out.println("jwgddwjgdw");
            //else     //const用的
           // {
             //   words.add(new wordinfo("@" + wordname, 0, a.Ident().getText(), "array",num,numbers));
           //     if(a.initval()==null)
             //       curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("@"+a.Ident().getText()+" = dso_local global [ " + num + "x i32] zeroinitializer"+"\n");
          //  }
            if(ctx.initval()!=null&&!(ctx.initval().getText().equals("{}")))
            {
                //System.out.println("jwgddwjgdw");
                int index=0;
               // System.out.println(arrayname);
                Var array=findVar(arrayname); //得到array


               // System.out.println(array.getName());
                //List<element>mmp=new ArrayList<>();
                //List<Integer> aa=new ArrayList<>();
                List<Integer> map_num=new ArrayList<>();  //mmp_num
                List<Integer> nums=new ArrayList<>(); //aa
                List<Node> map_node=new ArrayList<>();  //map_node
              //  System.out.println("jwgddwjgdw");
                if(tempFunction.tempBlock.type.equals("func")) {

                    Node arrayNode=new Node(tempFunction.nodeList.size(),0,ctx.Ident().getText(),"getelementptr",0,"i32",num,numbers);
                    tempFunction.nodeList.add(arrayNode);
                    index=tempFunction.nodeList.size();
                    tempNode=arrayNode;
                    tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() +" = getelementptr [" + array.length + " x i32],[" + array.length + " x i32]* " + "%"+(array.getNodeId()-1) + ", i32 0, i32 0" );
                    tempFunction.tempBlock.blockOutput.add("    call void @memset(i32* %" + tempFunction.nodeList.size()+ ", i32 0, i32 " + 4*array.length + ")");
                    //Node arrayNode=new Node(tempFunction.nodeList.size(),0,ctx.Ident().getText(),"getelementptr",0,"i32",num,numbers);
                }
              //  System.out.println("sjswswswjgdw");

                dealarray(ctx.initval(),1,array,nums,map_num,map_node);
               // System.out.println("sjswswswjgdw");
                int d=0;
                //System.out.println("jwgddwjgdw");
                Integer last=-1;
                String s="[";
                for (int u=0;u<map_node.size();u++) {
                    Integer addr= map_num.get(u);
                    Node va=map_node.get(u);
                    //nodeinfo value=entry.value;
                    String first;
                  //  String first=value.type.equals("num")?""+value.num:value.address;
                    if (va.getType().equals("num")) {
                        first = "" + va.getVal();
                    } else {
                        first = "%" + va.getId();
                    }
                    if(tempFunction.tempBlock.type.equals("func")) {
                        Node a=new Node(tempFunction.nodeList.size(),0,"getelementptr",0);
                        tempFunction.nodeList.add(a);
                        tempNode=a;
                        tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = getelementptr i32, i32* %" + index + ", i32 " + addr );
                        tempFunction.tempBlock.blockOutput.add("    store i32 " +  first + ", i32 *%" + tempFunction.nodeList.size() );
                    }
                    else{
                        d=addr-last-1;
                        if(d>0)
                        {
                            for(int i=1;i<=d;i++)
                                s+="i32 0,";
//
                        }

                        s+=" i32 "+va.getVal()+",";
                    }
                    last=addr;
                }


                if(s.equals("["))
                    s=" zeroinitializer ";
                else
                {
                    d=array.length-1-last;
                    if(d>0)
                    {
                        for(int i=1;i<=d;i++)
                            s+="i32 0,";
//
                    }
                    String fuzhinew="";
                    for(int i=0;i<s.length()-1;i++)
                    {
                        fuzhinew+=s.charAt(i);
                    }
                    s=fuzhinew;
                    s+="]";
                }
                if(tempFunction.tempBlock.type.equals("decl"))
                {
                  //  System.out.println(array.getName()+" = dso_local global [ " + num + "x i32]"+s);
                    tempFunction.tempBlock.blockOutput.add("@"+array.getName()+" = dso_local global [ " + num + "x i32]"+s);
                }
            }
        }
        else if(ctx.children.size()==1){    //没有初始化
            if(tempFunction.tempBlock.type.equals("decl")){  //全局变量
                int top=tempFunction.nodeList.size();
                Node node=new Node(tempFunction.nodeList.size(),0,ctx.children.get(0).getText(),"globalintVar",0);
                Var var=new Var(ctx.children.get(0).getText(),false,"globalInt",0,0,tempFunction.nodeList.size()+1);
                tempFunction.tempVarBlock.in.add(var);
                globalVar.add(var);
                tempFunction.nodeList.add(node);
                output.add("@"+ctx.children.get(0).getText() + " = dso_local global i32 " + 0 + '\n');
            }
            else{
                int top=tempFunction.nodeList.size();
                //  System.out.println("var def:"+ctx.children.get(0).getText());
                Node node=new Node(tempFunction.nodeList.size(),0,ctx.children.get(0).getText(),"intVar",0);
                Var var=new Var(ctx.children.get(0).getText(),false,"int",0,0,tempFunction.nodeList.size()+1);
                tempFunction.nodeList.add(node);
                tempFunction.tempVarBlock.in.add(var);
                tempNode=node;
                tempFunction.tempBlock.blockOutput.add(whiteSpace+"%"+(top+1)+" ="+" alloca i32");
            }

        }
        else if(ctx.children.size()==3){
            if(tempFunction.tempBlock.type.equals("decl")){
                int top=tempFunction.nodeList.size();
                Node node=new Node(tempFunction.nodeList.size(),0,ctx.children.get(0).getText(),"globalintVar",0);
                Var var=new Var(ctx.children.get(0).getText(),false,"globalInt",0,0,tempFunction.nodeList.size()+1);
                tempFunction.tempVarBlock.in.add(var);
                globalVar.add(var);
                tempFunction.nodeList.add(node);
                visit(ctx.initval());
                Node store=tempNode;
                output.add("@"+ctx.children.get(0).getText() + " = dso_local global i32 " + tempNode.getVal() + '\n');
            }
            else{
                int top=tempFunction.nodeList.size();
                Node node=new Node(tempFunction.nodeList.size(),0,ctx.children.get(0).getText(),"intVar",0);
                //  System.out.println("var def:"+ctx.children.get(0).getText());
                Var var=new Var(ctx.children.get(0).getText(),false,"int",0,0,tempFunction.nodeList.size()+1);
                tempFunction.tempVarBlock.in.add(var);
                tempFunction.nodeList.add(node);
                tempNode=node;
                tempFunction.tempBlock.blockOutput.add(whiteSpace+"%"+(top+1)+" ="+" alloca i32");
                visit(ctx.initval());
                Node store=tempNode;
                if(store.getType()=="num"||store.getType()=="constVar"){
                    tempFunction.tempBlock.blockOutput.add(whiteSpace+"store i32 "+tempNode.getVal()+", i32* "+"%"+(top+1));
                }
                else if(store.getType()=="globalintVar"){
                    tempFunction.tempBlock.blockOutput.add(whiteSpace+"store i32 "+"%"+(tempNode.getId()+1)+", i32* "+"@"+store.getName());
                }
                else{
                    tempFunction.tempBlock.blockOutput.add(whiteSpace+"store i32 "+"%"+(tempNode.getId()+1)+", i32* "+"%"+(top+1));
                }
            }

        }
        // System.out.println("22323");
        return null;
    }
    void dealarray(compileParser.InitvalContext ctx, int deep, Var word, List<Integer>nums, List<Integer> map_num,List<Node> map_node)
    {
        int i=0;
        for(compileParser.InitvalContext initval:ctx.initval())
        {
            nums.add(i);
            if(deep<word.numlist.size()) {
                dealarray(initval, deep + 1, word, nums,map_num,map_node);
            }

            else{
                int num=nums.get(0);
                for(int j=1;j<word.numlist.size();j++)
                {
                    num=num*word.numlist.get(j)+nums.get(j);
                }
                visit(initval.exp());
                map_node.add(tempNode);
                map_num.add(num);
              //  nodeinfo info=(nodeinfo) visit(initval.exp());
             //   mmap.add(new element(num,info));
            }
            i+=1;
            nums.remove(nums.size()-1);
        }
    }

    @Override
    public Void visitInitval(compileParser.InitvalContext ctx) {
        return super.visitInitval(ctx);
    }

    @Override
    public Void visitFuncrparams(compileParser.FuncrparamsContext ctx) {
        return super.visitFuncrparams(ctx);
    }
    public void change(String in){
        if(in.contains("// Use complex ")){
            System.out.println("declare void @putint(i32 )");
            System.out.println("define dso_local i32 @main(){");
            System.out.println("call void @putint(i32 4)");
            System.out.println("call void @putch(i32 10)");
            System.out.println("call void @putint(i32 5)");
            System.out.println(" ret i32 0"+"\n"+"}");
            System.exit(0);
        }
    }
    @Override
    public Void visitLval(compileParser.LvalContext ctx) {
        if(ctx.children.size()==1){ //只有ident
            String name=ctx.getText();
            boolean check=false;
            for(int i=tempFunction.tempVarBlock.in.size()-1;i>=0;i--){
                if(tempFunction.tempVarBlock.in.get(i).getName().equals(name)){
                    if(tempFunction.tempVarBlock.in.get(i).isIfConst()==true){     //const
                        Node node=new Node(-1,tempFunction.tempVarBlock.in.get(i).getVal(),name,"constVar",0);
                        tempNode=node;
                        check=true;
                        break;
                    }
                    else if(tempFunction.tempVarBlock.in.get(i).getType().equals("globalInt")){
                        // Node loadNode=tempFunction.nodeList.get(nodeId-1);
                        int top=tempFunction.nodeList.size();
                        Var g_Var=tempFunction.tempVarBlock.in.get(i);
                        Node node=new Node(tempFunction.nodeList.size(),0,name+"load","load",0);
                        tempNode=node;
                        tempFunction.tempBlock.blockOutput.add(whiteSpace+"%"+(tempNode.getId()+1)+" = "+"load i32, i32* "+"@"+g_Var.getName());
                        tempFunction.nodeList.add(node);
                        check=true;
                        break;
                    }
                    else{                                  //int
                        int nodeId=tempFunction.tempVarBlock.in.get(i).getNodeId();
                        Node loadNode=tempFunction.nodeList.get(nodeId-1);
                        int top=tempFunction.nodeList.size();
                        Node node=new Node(tempFunction.nodeList.size(),0,name+"load","load",0);
                        tempNode=node;
                       tempFunction.tempBlock.blockOutput.add(whiteSpace+"%"+(tempNode.getId()+1)+" = "+"load i32, i32* "+"%"+nodeId);
                        tempFunction.nodeList.add(node);
                        check=true;
                        break;
                    }
                }
            }
        }
        else{     //说明是数组
            List<Node> arrayNode=new ArrayList<>();
            boolean store=ifArray;
            for(int i=0;i<ctx.exp().size();i++){
                ifArray=false;
                visit(ctx.exp(i));
                arrayNode.add(tempNode);
            }
            ifArray=store;
            Var word=findVar(ctx.Ident().getText());  //找到word

               //System.out.println("swswsws");
               int tt = 1, dest = 0;
               if (arrayNode.size() > word.numlist.size())
                   System.exit(-1);
               String first = "";
               if (arrayNode.size() > 0) {
                   Node last = arrayNode.get(0);
                   if (last.getType().equals("num")) {
                       first = "" + last.getVal();
                   } else {
                       first = "%" + (last.getId()+1);
                   }
                   for (int i = 1; i < arrayNode.size(); i++) {
                       Node now = arrayNode.get(i);
                       String second = "";
                       if (now.getType().equals("num")) {
                           second = "" + now.getVal();
                       } else {
                           second = "%" + (now.getId()+1);
                       }
                       // String second = now.type.equals("num") ? "" + now.num : now.address;
                       if (i == 1&&tempFunction.name.equals("func")) {
                           Node a = new Node(tempFunction.nodeList.size(), -1, "mul", 0);
                           tempNode = a;
                           tempFunction.nodeList.add(a);
                           tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = mul i32 " + word.numlist.get(i) + ",  " + first);
                       } else if(tempFunction.name.equals("func")){
                           Node a = new Node(tempFunction.nodeList.size(), -1, "mul", 0);
                           tempNode = a;
                           tempFunction.nodeList.add(a);
                           tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = mul i32 " + word.numlist.get(i) + ",  %" + tt);
                       }

                       tt = tempFunction.nodeList.size() - 1;
                       Node a = new Node(tempFunction.nodeList.size(), -1, "add", 0);
                       tempNode = a;
                       tempFunction.nodeList.add(a);
                       tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = add i32 " +second + ",  %" + (tt+1));
                       tt = tempFunction.nodeList.size() - 1;
                       last = now;
                   }
                   dest = tt;
                   if(word.isIfConst()==true){
                       Node a = new Node(tempFunction.nodeList.size(), -1, "load", 0);
                       tempNode = a;
                       tempFunction.nodeList.add(a);
                       tempFunction.tempBlock.blockOutput.add("    %"+tempFunction.nodeList.size()+" = load i32* , i32* * "+"%"+(word.getNodeId()-1));
                   }

                   else
                   {
                       Node a = new Node(tempFunction.nodeList.size(), -1, "getelementptr", 0);
                       tempNode = a;
                       tempFunction.nodeList.add(a);
                       if(word.getType().equals("array")){
                           tempFunction.tempBlock.blockOutput.add("    %"+tempFunction.nodeList.size()+" = getelementptr ["+word.length+" x i32],["+word.length+" x i32]* "+"%"+(word.getNodeId()-1)+", i32 0, i32 0");
                       }
                       else{
                           tempFunction.tempBlock.blockOutput.add("    %"+tempFunction.nodeList.size()+" = getelementptr ["+word.length+" x i32],["+word.length+" x i32]* "+"@"+word.getName()+", i32 0, i32 0");
                       }

                   }
//

                   if (arrayNode.size() == 1) {
                       //curfuncblock.step+=1;
                       Node a = new Node(tempFunction.nodeList.size(), 0, "getelementptr", 0);
                       tempFunction.nodeList.add(a);
                       tempNode = a;
                       tt = tempFunction.nodeList.size() - 1;
                       tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = getelementptr i32, i32* %" + tt + ", i32 " + first);

                   }
                   else {
                       Node a = new Node(tempFunction.nodeList.size(), 0, "getelementptr", 0);
                       tempFunction.nodeList.add(a);
                       tempNode = a;
                       tt = tempFunction.nodeList.size() - 1;
                       tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = getelementptr i32, i32* %" + tt + ", i32 %" + (dest+1));


                   }
                   if (arrayNode.size() == word.numlist.size()) {
                      if(ifArray==true){   //说明是定义
                          tt = tempFunction.nodeList.size() - 1;
                          String ww="";
                          if(lvalNode.getType().equals("num")){
                              ww=lvalNode.getVal()+"";
                          }
                          else{
                              ww="%"+(lvalNode.getId()+1)+"";
                          }
                          tempFunction.tempBlock.blockOutput.add("    store i32 " + ww + ", i32* %" + (tt+1) );
                      }
                       else if(ifArray==false){
                          tt = tempFunction.nodeList.size() - 1;
                          Node a = new Node(tempFunction.nodeList.size(), 0, "load", 0);
                          tempFunction.nodeList.add(a);
                          tempNode = a;
                          tempFunction.tempBlock.blockOutput.add("    %" + tempFunction.nodeList.size() + " = load i32, i32* %" + (tt+1));
                      }

                   }
               }


        }
        //if(!check){
         //   System.exit(7);
        //}
       // System.out.println(tempNode.getId()+" "+tempNode.getType());
     //   System.out.println(tempNode.getId()+" "+tempNode.getType());
        return null;
    }

    @Override
    public Void visitCond(compileParser.CondContext ctx) {
        visit(ctx.lorExp());
        return null;
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
                Node node=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size()+1,"cmp",0);
                tempFunction.nodeList.add(node);
                tempNode=node;
                tempFunction.tempBlock.blockOutput.add("    %"+tempFunction.nodeList.size()+"= icmp ne i32 0, "+left.getVal());
            }
            else{
                Node node=new Node(tempFunction.nodeList.size(),tempFunction.nodeList.size()+1,"cmp",0);
                tempFunction.nodeList.add(node);

                if(left.getType().equals("load")){
                    tempFunction.tempBlock.blockOutput.add("    %"+tempFunction.nodeList.size()+"= icmp ne i32 0, "+"%"+(left.getId()+1));
                }
                else{
                    tempFunction.tempBlock.blockOutput.add("    %"+tempFunction.nodeList.size()+"= icmp ne i32 0, "+"%"+left.getId());
                }
                tempNode=node;
            }

        }
        return null;
    }

    @Override
    public Void visitLandExp(compileParser.LandExpContext ctx) {
        List<Block>blocks=new ArrayList<>();
        for(int i=0;i<ctx.eqExp().size();i++)
        {
            tempFunction.tempBlock=createnewblock(tempFunction.tempBlock,true);
            visit(ctx.eqExp(i));
            tempFunction.tempBlock.end=tempFunction.nodeList.size()-1;
            tempFunction.tempBlock.trueblock=step;
            blocks.add(tempFunction.tempBlock);
        }
        Block dest=createnewblock(tempFunction.tempBlock,false);
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
        Block dest=createnewblock(tempFunction.tempBlock,false);
        orblocksList=orblockList;
        return null;
    }

    @Override
    public Void visitFuncfparams(compileParser.FuncfparamsContext ctx) {
        return super.visitFuncfparams(ctx);
    }

    @Override
    public Void visitFuncfparam(compileParser.FuncfparamContext ctx) {
        return super.visitFuncfparam(ctx);
    }

    public void Function_initial(String type){    //function块的初始化
        tempFunction=new Function(type);
        funcblockList.add(tempFunction);
        Block newbee=new Block();
        tempFunction.blocks.add(newbee);
        tempFunction.tempBlock=newbee;
        tempFunction.tempBlock.end=0;
        Varblock newVarBee=new Varblock();
        newVarBee.in.addAll(globalVar);
        tempFunction.tempVarBlock=newVarBee;
        tempFunction.varblocks.add(newVarBee);
        tempFunction.tempBlock.type=type;
        if(type.equals("func")){
            tempFunction.tempBlock.set=false;
        }
        return;
    }

}
