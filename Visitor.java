public class Visitor extends  compileBaseVisitor<Void> {
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
        visit(ctx.RET());
        System.out.print(whiteSpace+"ret i32 ");
        visit(ctx.Number());
        System.out.print(dealNum(ctx.Number().getText()));
        visit(ctx.Checkpoint());
        System.out.println("");
        return super.visitChildren(ctx);
    }

    /**
     */
    public int dealNum(String num){
        if(num.length()>=2&&num.charAt(0)=='0'){
            if(num.charAt(1)=='x'||num.charAt(1)=='X'){ 
                int sum = 0;	
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
            else{               
                int sum = 0;	
                char c[]=num.toCharArray();
                int n = c.length;
                for (int i = 0; i < n; i++){
                    sum+=((int)c[i]-'0')*Math.pow(8,n-i-1);
                }
                return sum;
            }
        }
        else{            
            return Integer.parseInt(num);
        }
    }

}
