
import java.util.*;

public class Visitor extends labBaseVisitor{
   
//    List<wordinfo>func=new ArrayList<>();
//    List<block>curfuncblock.blocks=new ArrayList<>();
    List<wordinfo>globalwords=new ArrayList<>();
    funcblock curfuncblock;
    List<funcblock>funcblockList=new ArrayList<>();
    @Override
    public Object visitCompunit(labParser.CompunitContext ctx) {
        curfuncblock=new funcblock();
        curfuncblock.name="decl";
        funcblockList.add(curfuncblock);
        curfuncblock.blocks.add(new block());
        curfuncblock.nowblock=curfuncblock.blocks.get(0);
        curfuncblock.nowblock.end=0;
        curfuncblock.varblocks.add(new varblock());
        curfuncblock.curvarblock=curfuncblock.varblocks.get(0);
        curfuncblock.curvarblock.parvarblock=curfuncblock.curvarblock;
        curfuncblock.nowblock.type="decl";
        for(labParser.DeclContext a:ctx.decl())
        {
            visit(a);
        }
//
//

        for(labParser.FuncDefContext a:ctx.funcDef())
        {
            curfuncblock=new funcblock();
            funcblockList.add(curfuncblock);
            curfuncblock.blocks.add(new block());
            curfuncblock.nowblock=curfuncblock.blocks.get(0);
            curfuncblock.nowblock.type="func";
            curfuncblock.nowblock.set=false;
            curfuncblock.nowblock.end=0;
            curfuncblock.varblocks.add(new varblock());
            curfuncblock.curvarblock=curfuncblock.varblocks.get(0);

            visit(a);
        }
        System.out.println("declare void @putint(i32 )");
        System.out.println("declare void @memset(i32*, i32, i32)");
        System.out.println("declare i32 @getarray(i32*)");
        System.out.println("declare void @putarray(i32, i32*)");
        System.out.println("declare i32 @getint()");
        System.out.println("declare i32 @getch()");
        System.out.println("declare void @putch(i32)");
        for(funcblock aa:funcblockList) {
            for(int i=0;i<aa.blocks.size();i++)
            {
                block a=aa.blocks.get(i);
                if(i==aa.blocks.size()-1&&aa.returntype.equals("void"))
                {
                    a.output=a.output.concat("    ret void\n");
                }
                if(i!=0&&i!=1&&i!=aa.blocks.size()-1||i==aa.blocks.size()-1&&i!=1&&!a.output.equals("")&&i!=0)
                    System.out.println(a.start + ":");
                System.out.println(a.output);
                if(i==aa.blocks.size()-1&&!aa.name.equals("decl"))
                    System.out.println("}");
            }
        }
        return null;
//        return super.visitCompunit(ctx);
    }

    @Override
    public Object visitNumber(labParser.NumberContext ctx) {
        String number="";
        int count=0;
        for(int i=0;i<ctx.children.size();i++)
            number=number.concat(ctx.children.get(i).getText());
        if(number.length()==1)
        {
            count=Integer.valueOf(number);
        }
        else if(number.charAt(1)=='x'||number.charAt(1)=='X')
        {
            for(int i=2;i<number.length();i++) {
                char now=number.charAt(i);
                int a;
                if(now>'a'&&now<'z')
                    a=(now-'a'+10);
                else if(now>'A'&&now<'Z')
                    a=(now-'A'+10);
                else
                    a= now - '0';
                count = count * 16 + a;
            }

        }
        else if(number.charAt(0)=='0')
        {

            for(int i=0;i<number.length();i++)
                count=count*8+(number.charAt(i)-'0');
        }

        else
        {
            for(int i=0;i<number.length();i++)
                count=count*10+(number.charAt(i)-'0');
        }
//        System.out.print(count);
        return new nodeinfo("",count,"num","num");
//        return super.visitNumber(ctx);
//        return null;
    }

    @Override
    public Object visitFuncfparams(labParser.FuncfparamsContext ctx) {
        List<wordinfo>words=new ArrayList<>();
        for(labParser.FuncfparamContext a:ctx.funcfparam())
        {
            words.add((wordinfo)visit(a));
        }
        return words;
    }

    @Override
    public Object visitFuncfparam(labParser.FuncfparamContext ctx) {
        wordinfo word=new wordinfo();
        word.name=ctx.Ident().getText();
        int flag=1;
        curfuncblock.nowblock.type="decl";
        int total=0;
        for(int i=0;i<ctx.children.size();i++)
        {
            if(ctx.children.get(i).getText().equals("["))
                total+=1;
        }
        if(total>0&&ctx.exp().size()<total)
            word.numlist.add(0);
        for(int i=0;i<ctx.exp().size();i++)
        {
            flag=1;
            nodeinfo now= (nodeinfo) visit(ctx.exp(i));
            word.numlist.add(now.num);
        }
        if(word.numlist.size()>0) {
            word.type = "array";
        }
        else word.type="varword";
        word.address="%"+curfuncblock.step;
        curfuncblock.step+=1;
        return word;

    }

    @Override
    public Object visitFuncDef(labParser.FuncDefContext ctx) {
//        return super.visitFuncDef(ctx);
        String first=ctx.functype().getText().equals("int")?"i32":"void";
        String second = "";
        curfuncblock.returntype=first;
        if(ctx.funcfparams()!=null) {
            List<wordinfo> params = (List<wordinfo>) visit(ctx.funcfparams());
            curfuncblock.params=params;

            for (int i=0;i<params.size();i++) {
                wordinfo word=params.get(i);
                if (word.type.equals("varword")) second += "i32 " + word.address ;
                else second += "i32 *" + word.address ;
                if(i< params.size()-1)
                    second+=',';
            }
        }

        curfuncblock.name=ctx.Ident().getText();
        curfuncblock.address="@"+curfuncblock.name;
        curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("define dso_local "+first+" @"+ctx.Ident()+"("+second+"){\n");
        curfuncblock.nowblock=new block(curfuncblock.nowblock,curfuncblock.step++);
        curfuncblock.blocks.add(curfuncblock.nowblock);
        curfuncblock.nowblock.type="func";
        curfuncblock.nowblock.set=false;
        if(curfuncblock.params!=null)
            for(int j=0;j<curfuncblock.params.size();j++)
            {
                wordinfo word=curfuncblock.params.get(j);
                if(word.type.equals("array"))
                {

                    curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = alloca i32* \n");

                    wordinfo a=new wordinfo("    %"+curfuncblock.step,word.num,word.name,"array");
                    a.fuzhi="i32*";
                    curfuncblock.curvarblock.words.add(a);
                    a.numlist=word.numlist;
                    curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    store i32*  "+word.address+", i32* * %"+curfuncblock.step+'\n');
                    curfuncblock.step+=1;
                }
                else
                {
                    curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = alloca i32 \n");
                    curfuncblock.curvarblock.words.add(new wordinfo("    %"+curfuncblock.step,word.num,word.name,"varword"));
                    curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    store i32  "+word.address+", i32*  %"+curfuncblock.step+'\n');
                    curfuncblock.step+=1;

                }
            }
        visit(ctx.block());
//        curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("}");
        //System.out.println("}");

        return null;
    }

    @Override
    public Object visitBlock(labParser.BlockContext ctx) {
        varblock parvarblock=curfuncblock.curvarblock;
        curfuncblock.curvarblock=new varblock();
        curfuncblock.varblocks.add(curfuncblock.curvarblock);
        curfuncblock.curvarblock.parvarblock=parvarblock;

        curfuncblock.curvarblock.outsidewords.addAll(parvarblock.words);
        curfuncblock.curvarblock.outsidewords.addAll(parvarblock.outsidewords);
        int i=0;

        while(i<ctx.children.size())
        {
            Object a=ctx.children.get(i);
            visit((ParseTree) a);
            i++;
        }
//

        return null;
    }

    @Override
    public Object visitStmt(labParser.StmtContext ctx) {
        if(ctx.children.get(0).getText().equals("return")) {
            if(ctx.exp()==null)
            {
                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    ret void" + "\n");
                curfuncblock.nowblock.flag = 1;
            }

                else{
                nodeinfo info = (nodeinfo) visit(ctx.exp());
                if (info.type.equals("num")) {
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    ret i32 " + info.num + "\n");
                    curfuncblock.nowblock.flag = 1;

                } else if (info.type.equals("pointer")) {
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    ret i32 " + info.address + "\n");
                    curfuncblock.nowblock.flag = 1;
                } else {
                    int tt = curfuncblock.step - 1;
                    //System.out.println("    ret i32 %" + tt);
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    ret i32 %" + tt + "\n");
                }
            }
        }
        else if(ctx.children.get(0).getText().equals("if"))
        {
            int leftjump,rightjump;
            block parblock=curfuncblock.nowblock;
            varblock parvarblock=curfuncblock.curvarblock;

            List<orblock>orblockList=(List<orblock>)visit(ctx.cond());
            block left=createnewblock(curfuncblock.nowblock,false);
            leftjump=left.start;

            visit(ctx.stmt(0));
            left=curfuncblock.nowblock;
            left.set=true;
            if(ctx.children.size()>5) {
                block right = createnewblock(curfuncblock.nowblock,false);
                rightjump=right.start;
                visit(ctx.stmt(1));
                right=curfuncblock.nowblock;
                right.set=true;
                block dest = createnewblock(curfuncblock.nowblock,false);
                left.jump = dest.start;
                right.jump = dest.start;
                if(right.flag==0)
                right.output= right.output.concat("    br label %"+right.jump+'\n');
                if(left.flag==0)
                left.output= left.output.concat("    br label %"+left.jump+'\n');
                for(int i=0;i<orblockList.size();i++)
                {
                        orblockList.get(i).trueblock = leftjump;
                    if(i==orblockList.size()-1)
                        orblockList.get(i).falseblock=rightjump;
                }
                dealorlist(orblockList);
            }
            else
            {
                left.set=true;
                block dest = createnewblock(curfuncblock.nowblock,false);
                curfuncblock.curvarblock=parvarblock;
                if(left.flag==0)
                    left.output= left.output.concat("    br label %"+dest.start+'\n');
                for(int i=0;i<orblockList.size();i++)
                {
                    orblockList.get(i).trueblock = leftjump;
                    if(i==orblockList.size()-1)
                        orblockList.get(i).falseblock=dest.start;
                }
                dealorlist(orblockList);
        }}
        else if(ctx.children.get(0).getText().equals("while"))
        {

            block parblock=curfuncblock.nowblock;
            varblock parvarblock=curfuncblock.curvarblock;
//            curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    br label %"+curfuncblock.step+'\n');
//            block condblock=createnewblock(curfuncblock.nowblock,true);
            List<orblock>orblockList=(List<orblock>)visit(ctx.cond());
            int start=orblockList.get(0).blockList.get(0).start;
//            condblock.end=curfuncblock.step-1;
            int left=curfuncblock.step;

            if(!ctx.stmt(0).getText().equals(";")) {
                int from=curfuncblock.blocks.size()-1;
                block leftblock=createnewblock(curfuncblock.nowblock,false);
                visit(ctx.stmt(0));
                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    br label %" + start + '\n');
                curfuncblock.nowblock.set = true;
                block destblock = createnewblock(curfuncblock.nowblock, false);
                curfuncblock.curvarblock = parvarblock;
                for(int i=0;i<orblockList.size();i++)
                {
                    orblockList.get(i).trueblock = leftblock.start;
                    if(i==orblockList.size()-1)
                        orblockList.get(i).falseblock=destblock.start;
                }
                dealorlist(orblockList);
                for(int i=from;i<curfuncblock.blocks.size();i++)
                {

                    block now=curfuncblock.blocks.get(i);
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
                        now.output = now.output.concat("    br label %" + destjump + '\n');
                    }
                }
            }
            else{
                curfuncblock.nowblock.set=false;
                block destblock = createnewblock(curfuncblock.nowblock, false);
                curfuncblock.curvarblock=parvarblock;
            }


        }
        else if (ctx.CONTINUE()!=null)
        {
            block continueblock=createnewblock(curfuncblock.nowblock,true);
            curfuncblock.nowblock.type="continue";
            block destbblock=createnewblock(curfuncblock.nowblock,false);
        }
        else if(ctx.BREAK()!=null)
        {
            block continueblock=createnewblock(curfuncblock.nowblock,true);
            curfuncblock.nowblock.type="break";
            block destbblock=createnewblock(curfuncblock.nowblock,false);

        }
        else if(ctx.block()!=null)
        {
            visit(ctx.block());
            curfuncblock.curvarblock=curfuncblock.curvarblock.parvarblock;

        }
        else if(ctx.lval()!=null)
        {
            List<wordinfo>words=initword();
            nodeinfo word= (nodeinfo) visit(ctx.lval());
            nodeinfo exp=(nodeinfo)visit(ctx.exp());
            wordinfo aaa=findword(words,word.name);
//            String type=aaa.type.equals("constword")&&aaa.fuzhi.equals("num")?"num":"pointer";
            nodeinfo info=new nodeinfo("%"+curfuncblock.step,aaa.num,"pointer",aaa.name);
            String first=exp.type.equals("pointer")?exp.address:""+exp.num;
            if(!aaa.type.equals("array"))
                curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    store i32 " + first + ", i32* " + aaa.address + '\n');
            else{
                int tt=1,dest;
                info=word;
                nodeinfo last=info.addresslist.get(0);
                String first1=last.type.equals("num")?last.num+"":last.address;
                for(int i=1;i<info.addresslist.size();i++)
                {

                    nodeinfo now=info.addresslist.get(i);
                    String second=now.type.equals("num")?""+now.num:now.address;
                    if(i==1)
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = mul i32 "+aaa.numlist.get(i)+",  "+first1+"\n");
                    else
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = mul i32 "+aaa.numlist.get(i)+",  %"+tt+"\n");
                    curfuncblock.step+=1;
                    tt=curfuncblock.step-1;
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = add i32 "+second+",  %"+tt+"\n");
                    curfuncblock.step+=1;
                    tt=curfuncblock.step-1;
                    last=now;
                }
                dest=tt;
                if(aaa.fuzhi.equals("i32*"))
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = load i32* , i32* * "+aaa.address+"\n");
                else
                {
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = getelementptr ["+aaa.length+" x i32],["+aaa.length+" x i32]* "+aaa.address+", i32 0, i32 0"+"\n");
                }
                curfuncblock.step+=1;
                tt=curfuncblock.step-1;
                if(aaa.numlist.size()==1)
                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = getelementptr i32, i32* %"+tt+", i32 "+first1+"\n");
                else
                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = getelementptr i32, i32* %"+tt+", i32 %"+dest+"\n");
                if(aaa.numlist.size()==info.addresslist.size())
                {
                    curfuncblock.step += 1;
                    tt = curfuncblock.step - 1;
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    store i32 " + first + ", i32* %" + tt + '\n');
                }
//                curfuncblock.step+=1;
                info.type="pointer";
                info.address="%"+curfuncblock.step;

            }
            return info;

            }

        else if(ctx.exp()!=null)
        {
            visit(ctx.exp());
        }
        return null;
    }

    @Override
    public Object visitExp(labParser.ExpContext ctx) {
        return (nodeinfo)visit(ctx.addexp());
    }

    @Override
    public Object visitAddexp(labParser.AddexpContext ctx) {

        nodeinfo a=null,b=null;
        String symbol="";
        List<nodeinfo> exps= new ArrayList<>();
        List<String>symbols= new ArrayList<>();
        for(int i=0;i<ctx.children.size();i++)
        {
            Object a1=ctx.children.get(i);
            String c=ctx.children.get(i).getText();
            if(a1 instanceof labParser.MulexpContext)
            {a=(nodeinfo)visit((labParser.MulexpContext)a1);
                exps.add(a);
            }
            else if(c.equals("+")||c.equals("-"))
            {
                symbol=((ParseTree) a1).getText();
                symbols.add(symbol);
            }
        }
        nodeinfo last=exps.get(0);
        if(exps.size()==1)
            return last;
        for(int i=1;i<exps.size();i++)
        {
            symbol=symbols.get(i-1);
            nodeinfo now=exps.get(i);
            last=deal(last,now,symbol);
            if(curfuncblock.nowblock.type.equals("func"))
            curfuncblock.step+=1;
        }
        return last;
    }

    @Override
    public Object visitMulexp(labParser.MulexpContext ctx) {
        nodeinfo a=null,b=null;
        String symbol="";
        List<nodeinfo> exps= new ArrayList<>();
        List<String>symbols= new ArrayList<>();
        for(int i=0;i<ctx.children.size();i++)
        {
            Object a1=ctx.children.get(i);
            String c=ctx.children.get(i).getText();
            if(a1 instanceof labParser.UnaryexpContext)
            {a=(nodeinfo)visit((labParser.UnaryexpContext)a1);
                exps.add(a);
            }
            else if(c.equals("/")||c.equals("*")||c.equals("%"))
            {
                symbol=((ParseTree) a1).getText();
                symbols.add(symbol);
            }
        }
        nodeinfo last=exps.get(0);
        if(exps.size()==1)
            return last;
        for(int i=1;i<exps.size();i++)
        {
            symbol=symbols.get(i-1);
            nodeinfo now=exps.get(i);
            last=deal(last,now,symbol);
            if(curfuncblock.nowblock.type.equals("func"))
            curfuncblock.step+=1;
        }
//        //System.out.println("    value="+ last.num);
        return last;
    }

    @Override
    public Object visitUnaryexp(labParser.UnaryexpContext ctx) {
        if(ctx.unaryexp()!=null)
        {
            nodeinfo info=(nodeinfo)visit(ctx.unaryexp());

            if(ctx.unaryop().getText().equals("-"))
            {
                if(curfuncblock.nowblock.type.equals("func")) {
                    if (info.type.equals("num")) {
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = sub i32 0, " + info.num + '\n');
                        //System.out.println("    %" + curfuncblock.step + " = sub i32 0, " + info.num);
                    } else {
                        if (info.geshi.equals("i1")) {
                            curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + "= zext i1 " + info.address + " to i32" + '\n');
                            curfuncblock.step += 1;
                        }
                        int tt = curfuncblock.step - 1;
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = sub i32 0, %" + tt + '\n');
                    }
                    info.address = "%" + curfuncblock.step;
                    info.num = -info.num;
                    info.geshi = "i32";
                    curfuncblock.step += 1;

                    info.type = "pointer";
                }
                else
                {
                    info.num = -info.num;
                    info.type = "pointer";

                }

//                //System.out.println("    value="+ info.num);
                return info;
            }
            else if(ctx.unaryop().getText().equals("!"))
            {
                if(info.type.equals("num")) {
                    curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = icmp eq i32 "+info.num+", 0\n");
                    curfuncblock.step+=1;
                    int tt=curfuncblock.step-1;
                    curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + "= zext i1 %"+tt+" to i32"+'\n');
                    //System.out.println("    %" + curfuncblock.step + " = sub i32 0, " + info.num);
                }
                else {
                    curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = icmp eq "+info.geshi+" 0, " + info.address+'\n');



                }
                info.address="%"+curfuncblock.step;
                info.num=-info.num;
                curfuncblock.step+=1;
                info.geshi="i1";
                info.type="texp";
//                //System.out.println("    value="+ info.num);
                return info;

            }
            return info;
        }
        else if(ctx.Ident()!=null)
        {
            String wordname=ctx.Ident().getText();
            List<nodeinfo>nodes=new ArrayList<>();
            String second=null;
            nodeinfo info=null;
            boolean flag=true;
            funcblock func=findfunc(wordname);
            if(ctx.funcrparams()!=null)
                nodes=(List<nodeinfo>) visit(ctx.funcrparams());
            if(func==null) {
                switch (wordname) {
                    case "getint":
                    case "getch":
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = call i32 @" + wordname + "()" + '\n');
                        break;
                    case "putint":
                    case "putch":
                        info = nodes.get(0);
                        if (info.type.equals("num")) {
                            curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    call void @" + wordname + "(i32 " + info.num + ")" + '\n');
                        } else {
                            curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    call void @" + wordname + "(i32 " + info.address + ")" + '\n');

                        }
                        curfuncblock.step -= 1;
                        break;
                    case "putarray":
                        String first=nodes.get(0).type.equals("num")?""+nodes.get(0).num:nodes.get(0).address;
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    call void @" + wordname + "("+"i32 "+first+",i32* "+nodes.get(1).address+")" + '\n');
                        curfuncblock.step -= 1;
                        break;
                    case "getarray":

                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = call i32 @" + wordname + "("+"i32*"+nodes.get(0).address+")" + '\n');
                        break;
                }
                curfuncblock.step+=1;
            }
            else
            {
                String params="";
                if(nodes==null) {
                    if(func.returntype.equals("i32")) {
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + "call " + func.returntype + func.name + "()" + '\n');
                        curfuncblock.step += 1;
                    }
                    else
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    call " + func.returntype + func.name + "()" + '\n');

                }
                else
                {
                    if(func.params!=null&&nodes.size()!=func.params.size())
                        System.exit(-1);

                    for(int i=0;i<nodes.size();i++)
                    {
                        String params2=nodes.get(i).type.equals("num")?""+nodes.get(i).num:nodes.get(i).address;
                        List<wordinfo>words=initword();
                        wordinfo word=findword(words,nodes.get(i).name);
                        String params1=func.params.get(i).type.equals("varword")?"i32":"i32*";
                        if(params1.equals("i32*"))
                        if((word.numlist.size()-nodes.get(i).addresslist.size())!=func.params.get(i).numlist.size()&&params1.equals("i32*"))
                            System.exit(-1);
                        params+=params1+" "+params2;
                        if(i<nodes.size()-1)
                            params+=',';
                    }
                    if(func.returntype.equals("i32")) {
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + "=call " + func.returntype + func.address + "(" + params + ")" + '\n');
                        curfuncblock.step += 1;
                    }
                    else
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("     call " + func.returntype + func.address + "(" + params + ")" + '\n');


//                    curfuncblock.step+=1;
                }

            }
            int tt=curfuncblock.step-1;
            nodeinfo newinfo = new nodeinfo("%" + tt, 0, "pointer", wordname);

            return newinfo;
        }
        else
        {
            nodeinfo info=(nodeinfo) visit(ctx.primaryexp());
            if(info.type.equals("num"))
                return  info;
            List<wordinfo>words=initword();
            wordinfo word=findword(words,info.name);
            if(word==null)
                return info ;
            if(!word.type.equals("array"))
            {
                wordinfo aaa=word;
                info.type=aaa.type.equals("constword")&&aaa.fuzhi.equals("num")?"num":"pointer";
                info.address=aaa.address;
                info.num=aaa.num;
                info.address="%"+curfuncblock.step;

                if(aaa.type.equals("varword")&&curfuncblock.nowblock.type.equals("func")) {
                    curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = load i32, i32* " + aaa.address+'\n');
                    curfuncblock.step+=1;
                }
            }
            else if(word.type.equals("array"))
            {
                int tt=1,dest=0;
                if(info.addresslist.size()>word.numlist.size())
                    System.exit(-1);
                String first="";
                if(info.addresslist.size()>0) {
                    nodeinfo last = info.addresslist.get(0);
                   first = last.type.equals("num") ? "" + last.num : last.address;
                    for (int i = 1; i < info.addresslist.size(); i++) {
                        nodeinfo now = info.addresslist.get(i);
                        String second = now.type.equals("num") ? "" + now.num : now.address;
                        if (i == 1)
                            curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = mul i32 " + word.numlist.get(i) + ",  " + first + "\n");
                        else
                            curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = mul i32 " + word.numlist.get(i) + ",  %" + tt + "\n");
                        curfuncblock.step += 1;
                        tt = curfuncblock.step - 1;
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = add i32 " + second + ",  %" + tt + "\n");
                        curfuncblock.step += 1;
                        tt = curfuncblock.step - 1;
                        last = now;
                    }
                    dest = tt;
                }
                if(word.fuzhi.equals("i32*"))
                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = load i32* , i32* * "+word.address+"\n");
                else
                {
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = getelementptr ["+word.length+" x i32],["+word.length+" x i32]* "+word.address+", i32 0, i32 0"+"\n");
                }
//

                if(info.addresslist.size()==1) {
                    curfuncblock.step+=1;
                    tt=curfuncblock.step-1;
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = getelementptr i32, i32* %" + tt + ", i32 " + first + "\n");
                }
                else if(info.addresslist.size()>1) {
                    curfuncblock.step+=1;
                    tt=curfuncblock.step-1;
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = getelementptr i32, i32* %" + tt + ", i32 %" + dest + "\n");
                }
                if(info.addresslist.size()==word.numlist.size()) {
                    curfuncblock.step += 1;
                    tt = curfuncblock.step - 1;
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = load i32, i32* %" + tt + '\n');
                }
                info.type="pointer";
                info.address="%"+curfuncblock.step;
                curfuncblock.step+=1;


            }
            return info;
        }
    }

    @Override
    public Object visitPrimaryexp(labParser.PrimaryexpContext ctx)  {
        if(ctx.number()!=null)
            return (nodeinfo)visit(ctx.number());
        else if(ctx.lval()!=null)
            return (nodeinfo)visit(ctx.lval());
        else
            return (nodeinfo)visit(ctx.exp());
    }
    nodeinfo deal(nodeinfo a,nodeinfo b,String c)
    {
        nodeinfo info=new nodeinfo("%"+curfuncblock.step,0,"pointer","null");
        String wei="i32";
        String symbol="",first,second;
        if(c.equals("+")) {
            symbol = "add";
            info.num=a.num+b.num;
        }
        else if(c.equals("-")) {
            symbol = "sub";
            info.num=a.num-b.num;
        }
        else if(c.equals("*")) {
            symbol = "mul";
            info.num=a.num*b.num;
        }
        else if(c.equals("%")) {

            symbol = "srem";
            if(curfuncblock.nowblock.type.equals("decl"))
            info.num=(int)a.num%b.num;
        }
        else if(c.equals("/")) {
            symbol = "sdiv";
            if(curfuncblock.nowblock.type.equals("decl"))
            info.num=(int)a.num/b.num;
        }
        else if(c.equals("&&")) {

            wei="i1";
            symbol = "and";
        }
        else if(c.equals("||")){
            wei="i1";
            symbol="or";
        }
        if(a.type.equals("num"))
            first=String.valueOf(a.num);
        else first=String.valueOf(a.address);
        if(b.type.equals("num"))
            second=String.valueOf(b.num);
        else second=String.valueOf(b.address);
        if(curfuncblock.nowblock.type.equals("func"))
        curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = "+symbol+" "+wei+" "+first+", "+second+'\n');
        return info;
    }


    @Override
    public Object visitLval(labParser.LvalContext ctx) {
        if(ctx.children.size()>1)
        {
            nodeinfo info=new nodeinfo("",0,"array",ctx.Ident().getText());
            for(int i=0;i<ctx.exp().size();i++)
            {
                nodeinfo now= (nodeinfo) visit(ctx.exp(i));
                info.addresslist.add(now);
            }
            return info;
        }
        else
            return new nodeinfo("",0,"word",ctx.Ident().getText());
    }

    @Override
    public Object visitBlockItem(labParser.BlockItemContext ctx) {
        return super.visitBlockItem(ctx);
    }

    @Override
    public Object visitDecl(labParser.DeclContext ctx) {
        return super.visitDecl(ctx);
    }

    @Override
    public Object visitConstdecl(labParser.ConstdeclContext ctx) {
        List<wordinfo>words=null;
        switch (curfuncblock.nowblock.type)
        {
            case "func":
                words=curfuncblock.curvarblock.words;
                break;
            case "decl":
                words=globalwords;
                break;
        }
        for(labParser.ConstdefContext a:ctx.constdef()) {
            if(a.constexp().size()==0) {
                String wordname = a.Ident().getText();
                if (findword(words, wordname) != null)
                    System.exit(-1);
                words.add(new wordinfo("@" + wordname, 0, wordname, "constword"));
                if (a.constinitval() != null) {
                    nodeinfo fuzhi = (nodeinfo) visit(a.constinitval());
                    wordinfo aaa = findword(words, wordname);
                    aaa.fuzhi = fuzhi.type.equals("num") ? "num" : "pointer";
                    aaa.num = fuzhi.num;
                    aaa.address = fuzhi.address;
                }
            }
            else{
                String wordname=a.Ident().getText();
                if (findword(words, wordname) != null)
                    System.exit(-1);
                int num=1;
                List<Integer>numbers=new ArrayList<>();
                for(labParser.ConstexpContext address:a.constexp())
                {
                    nodeinfo add=(nodeinfo) visit(address);
                    num*=add.num;
                    numbers.add(add.num);
                }
                if(curfuncblock.nowblock.type.equals("func")) {
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = alloca [" + num + "x i32]"+"\n");
                    words.add(new wordinfo("%" + curfuncblock.step, 0, a.Ident().getText(), "array",num,numbers));
                    curfuncblock.step+=1;
                }
                else
                {
                    words.add(new wordinfo("@" + wordname, 0, a.Ident().getText(), "array",num,numbers));
                    if(a.constinitval()==null)
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("@"+a.Ident().getText()+" = dso_local constant [ " + num + "x i32]"+"\n");
                }
                if(a.constinitval()!=null)
                {
                    wordinfo array=findword(words,wordname);
                    List<element>mmp=new ArrayList<>();
                    List<Integer> aa=new ArrayList<>();
                    int index=0;
                    if(curfuncblock.nowblock.type.equals("func")) {
                        index=curfuncblock.step;
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = getelementptr [" + array.length + " x i32],[" + array.length + " x i32]* " + array.address + ", i32 0, i32 0" + "\n");
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    call void @memset(i32* %" + curfuncblock.step + ", i32 0, i32 " + 4*array.length + ")" + '\n');
                        curfuncblock.step+=1;
                    }
                    dealconstarray(a.constinitval(),1,array,aa,mmp);
                    int d=0;
                    Integer last=-1;
                    String fuzhi="[";
                    for (element entry : mmp) {
                        Integer addressnum=entry.addressnum;
                        nodeinfo value=entry.value;
                        String first=value.type.equals("num")?""+value.num:value.address;
                        if(curfuncblock.nowblock.type.equals("func")) {
                            if (addressnum != 0) {
                                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = getelementptr i32, i32* %" + index + ", i32 " + addressnum + '\n');
                                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    store i32 " + first + ", i32* %" + curfuncblock.step + '\n');
                                curfuncblock.step++;
                            }
                        }
                        else{
                            d=addressnum-last-1;
                            if(d>0)
                            {
                             for(int i=1;i<=d;i++)
                                 fuzhi+=" i32 0,";
//                             fuzhi+="["+d+"x i32]zeroinitializer,";
                            }
                            fuzhi+=" i32 "+value.num+",";
                        }
                        last=addressnum;
                    }


                    if(fuzhi.equals("["))
                        fuzhi=" zeroinitializer ";
                    else
                    {
                        d=array.length-last-1;
                        if(d>0)
                        {
                            for(int i=1;i<=d;i++)
                                fuzhi+=" i32 0,";
//                             fuzhi+="["+d+"x i32]zeroinitializer,";
                        }
//
//                            fuzhi+="["+d+"x i32]zeroinitializer ,";

                        String fuzhinew="";
                        for(int i=0;i<fuzhi.length()-1;i++)
                        {
                            fuzhinew+=fuzhi.charAt(i);
                        }
                        fuzhi=fuzhinew;
                        fuzhi+="]";
                    }
                    if(curfuncblock.nowblock.type.equals("decl"))
                    {
                        curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat(array.address+" = dso_local constant [ " + num + "x i32]"+fuzhi+'\n');
                    }
                }

            }
          }
       return null;
    }

    @Override
    public Object visitBtype(labParser.BtypeContext ctx) {
        return super.visitBtype(ctx);
    }

    @Override
    public Object visitConstdef(labParser.ConstdefContext ctx) {
        return super.visitConstdef(ctx);
    }

    @Override
    public Object visitConstinitval(labParser.ConstinitvalContext ctx) {
        if(ctx.constexp()!=null)
            return (nodeinfo)visit(ctx.constexp());
        else
        {
            return null;
        }
    }

    @Override
    public Object visitConstexp(labParser.ConstexpContext ctx) {
        return super.visitConstexp(ctx);
    }

    @Override
    public Object visitVardecl(labParser.VardeclContext ctx) {
        List<wordinfo>words= curfuncblock.nowblock.type.equals("decl")?globalwords:curfuncblock.curvarblock.words;
        for(labParser.VardefContext a:ctx.vardef()) {
            if (a.constexp().size()==0) {
                String wordname = a.Ident().getText();
                if (findword(words, wordname) != null)
                    System.exit(-1);
                switch (curfuncblock.nowblock.type) {
                    case "func":
                        words.add(new wordinfo("%" + curfuncblock.step, 0, a.Ident().getText(), "varword"));
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = alloca i32\n");
                        curfuncblock.step++;
                        break;
                    case "decl":
                        words.add(new wordinfo("@" + a.Ident(), 0, a.Ident().getText(), "varword"));
                        if (a.initval() == null)
                            curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("@" + wordname + " = dso_local global i32 0" + '\n');
                        break;
                }
                if (a.initval() != null) {
                    nodeinfo fuzhi = (nodeinfo) visit(a.initval());
                    wordinfo aaa = findword(words, wordname);
                    aaa.num = fuzhi.num;
                    String first = fuzhi.type.equals("num") ? "" + fuzhi.num : fuzhi.address;
                    switch (curfuncblock.nowblock.type) {
                        case "func":
                            curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    store i32 " + first + ", i32* " + aaa.address + '\n');
                            break;
                        case "decl":
                            curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat(aaa.address + " = dso_local global i32 " + fuzhi.num + '\n');
                            break;
                    }
                }
            }
            else{
                String wordname=a.Ident().getText();
                if (findword(words, wordname) != null)
                    System.exit(-1);
                int num=1;
                List<Integer>numbers=new ArrayList<>();
//                int tianchong=a.Brackets().size()/2-a.constexp().size();
//                if(tianchong>0)
//                    numbers.add(0);
                for(labParser.ConstexpContext address:a.constexp())
                {
                    nodeinfo add=(nodeinfo) visit(address);
                    num*=add.num;
                    numbers.add(add.num);
                }
                if(curfuncblock.nowblock.type.equals("func")) {
                    curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+" = alloca [" + num + "x i32]"+"\n");
                    words.add(new wordinfo("%" + curfuncblock.step, 0, a.Ident().getText(), "array",num,numbers));
                    curfuncblock.step+=1;
                }
                else
                {
                    words.add(new wordinfo("@" + wordname, 0, a.Ident().getText(), "array",num,numbers));
                    if(a.initval()==null)
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("@"+a.Ident().getText()+" = dso_local global [ " + num + "x i32] zeroinitializer"+"\n");
                }
                if(a.initval()!=null)
                {
                    int index=0;
                    wordinfo array=findword(words,wordname);
                    List<element>mmp=new ArrayList<>();
                    List<Integer> aa=new ArrayList<>();
                    if(curfuncblock.nowblock.type.equals("func")) {
                        index=curfuncblock.step;
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = getelementptr [" + array.length + " x i32],[" + array.length + " x i32]* " + array.address + ", i32 0, i32 0" + "\n");
                        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    call void @memset(i32* %" + curfuncblock.step+ ", i32 0, i32 " + 4*array.length + ")" + '\n');
                        curfuncblock.step+=1;
                    }
                    dealarray(a.initval(),1,array,aa,mmp);
                    int d=0;
                    Integer last=-1;
                    String fuzhi="[";
                    for (element entry : mmp) {
                        Integer addressnum=entry.addressnum;
                        nodeinfo value=entry.value;
                        String first=value.type.equals("num")?""+value.num:value.address;
                        if(curfuncblock.nowblock.type.equals("func")) {
                                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = getelementptr i32, i32* %" + index + ", i32 " + addressnum + '\n');
                                curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    store i32 " + first + ", i32 *%" + curfuncblock.step + '\n');
                                curfuncblock.step++;
                        }
                        else{
                            d=addressnum-last-1;
                            if(d>0)
                            {
                                for(int i=1;i<=d;i++)
                                    fuzhi+="i32 0,";
//                                fuzhi+="["+d+"x i32]zeroinitializer,";
                            }

                                fuzhi+=" i32 "+value.num+",";
                        }
                        last=addressnum;
                    }


                    if(fuzhi.equals("["))
                        fuzhi=" zeroinitializer ";
                    else
                    {
                        d=array.length-1-last;
                        if(d>0)
                        {
                            for(int i=1;i<=d;i++)
                                fuzhi+="i32 0,";
//                            fuzhi+="["+d+"x i32]zeroinitializer,";
                        }
                        String fuzhinew="";
                        for(int i=0;i<fuzhi.length()-1;i++)
                        {
                            fuzhinew+=fuzhi.charAt(i);
                        }
                        fuzhi=fuzhinew;
                        fuzhi+="]";
                    }
                    if(curfuncblock.nowblock.type.equals("decl"))
                    {
                        curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat(array.address+" = dso_local global [ " + num + "x i32]"+fuzhi+'\n');
                    }
                }

            }
        }
        return null;
    }

    @Override
    public Object visitVardef(labParser.VardefContext ctx) {
        return (nodeinfo)super.visitVardef(ctx);
    }

    @Override
    public Object visitInitval(labParser.InitvalContext ctx) {
        if(ctx.exp()!=null)
        return (nodeinfo)visit(ctx.exp());
        else
            return null;
    }

    @Override
    public Object visitFuncrparams(labParser.FuncrparamsContext ctx) {
        List<nodeinfo>nodes=new ArrayList<>();
        for(labParser.ExpContext a:ctx.exp())
            nodes.add((nodeinfo)visit(a));
        return nodes;
    }

    @Override
    public Object visitCond(labParser.CondContext ctx) {
        return (List<orblock>)visit(ctx.lorexp());
    }

    @Override
    public Object visitRelexp(labParser.RelexpContext ctx) {
        nodeinfo last=(nodeinfo) visit(ctx.addexp(0));
        for(int i=1;i<ctx.addexp().size();i++)
        {
            nodeinfo now=(nodeinfo)visit(ctx.addexp(i));
            String symbol=ctx.Condop1(i-1).getText();
            deal2(last,now,symbol);
            last=now;
            last.address="%"+curfuncblock.step;
            last.type="texp";
            curfuncblock.step+=1;
        }
//        //System.out.println("    value="+ last.num);

        return last;
    }

    @Override
    public Object visitEqexp(labParser.EqexpContext ctx) {
      nodeinfo last=(nodeinfo) visit(ctx.relexp(0));
        for(int i=1;i<ctx.relexp().size();i++)
        {
            nodeinfo now=(nodeinfo)visit(ctx.relexp(i));
            String symbol=ctx.Condop2(i-1).getText();
            deal2(last,now,symbol);
            last=now;
            last.address="%"+curfuncblock.step;
            last.type="texp";
            curfuncblock.step+=1;
        }
        if(!last.type.equals("texp"))
        {
            String second=last.type.equals("num")?""+last.num:last.address;
            curfuncblock.nowblock.output=curfuncblock.nowblock.output.concat("    %"+curfuncblock.step+"= icmp ne i32 0, "+second+"\n");
            last.address="%"+curfuncblock.step;
            curfuncblock.step++;
            last.type="texp";
        }

        return last;
    }

    @Override
    public Object visitLandexp(labParser.LandexpContext ctx) {
//        nodeinfo last;
        List<block>blocks=new ArrayList<>();
        for(int i=0;i<ctx.eqexp().size();i++)
        {

            curfuncblock.nowblock=createnewblock(curfuncblock.nowblock,true);
            nodeinfo now=(nodeinfo)visit(ctx.eqexp(i));
            curfuncblock.nowblock.end=curfuncblock.step-1;
            curfuncblock.nowblock.trueblock=curfuncblock.step;
            blocks.add(curfuncblock.nowblock);
        }
        block dest=createnewblock(curfuncblock.nowblock,false);
        for(block a:blocks)
            a.falseblock=dest.start;
        return blocks;
    }
//%7 = icmp sle i32 %5, %6
//    br i1 %7,label %8, label %10
    @Override
    public Object visitLorexp(labParser.LorexpContext ctx) {
        List<orblock>orblockList=new ArrayList<>();
        for(int i=0;i<ctx.landexp().size();i++)
        {
            orblock aaa=new orblock();
            aaa.blockList=(List<block>) visit(ctx.landexp(i));
            orblockList.add(aaa);
        }
        block dest=createnewblock(curfuncblock.nowblock,false);
        return orblockList;
    }
    nodeinfo deal2(nodeinfo a,nodeinfo b,String c) {
        nodeinfo info = new nodeinfo("%"+curfuncblock.step, 0, "pointer", "null");
        String symbol = "", first, second;
        switch (c) {
            case "<=":
                symbol = "sle";
                break;
            case "<":
                symbol = "slt";
                break;
            case ">":
                symbol = "sgt";
                break;
            case ">=":
                symbol = "sge";
                break;
            case "==":
                symbol = "eq";
                break;
            case "!=":
                symbol = "ne";
                break;
        }
        if (a.type.equals("num"))
            first = String.valueOf(a.num);
        else first = a.address;
        if (b.type.equals("num"))
            second = String.valueOf(b.num);
       else second = b.address;
       if(curfuncblock.nowblock.type.equals("func"))
        curfuncblock.nowblock.output = curfuncblock.nowblock.output.concat("    %" + curfuncblock.step + " = icmp " + symbol + " i32 " + first + ", " + second + '\n');

        return info;
    }
    wordinfo findword(List<wordinfo>words,String a)
    {
        for(wordinfo aa: words)
        {
            if(aa.name.equals(a))
                return aa;
        }
        return null;
    }
    block createnewblock(block parblock,boolean a) {
        if(!parblock.set)
            parblock.output=parblock.output.concat("    br label %"+curfuncblock.step+'\n');
        curfuncblock.blocks.add(new block(curfuncblock.nowblock, curfuncblock.step++));
        curfuncblock.nowblock = curfuncblock.blocks.get(curfuncblock.blocks.size() - 1);
        curfuncblock.nowblock.set=a;
        return curfuncblock.nowblock;
    }
    void dealarray(labParser.InitvalContext ctx, int deep, wordinfo word, List<Integer>nums, List<element>mmap)
    {
        int i=0;
        for(labParser.InitvalContext initval:ctx.initval())
        {
            nums.add(i);
            if(deep<word.numlist.size()) {
                dealarray(initval, deep + 1, word, nums,mmap);
            }
            else{
                int num=nums.get(0);
                for(int j=1;j<word.numlist.size();j++)
                {
                    num=num*word.numlist.get(j)+nums.get(j);
                }
                nodeinfo info=(nodeinfo) visit(initval.exp());
                mmap.add(new element(num,info));
            }
            i+=1;
            nums.remove(nums.size()-1);
        }
    }
    void dealconstarray(labParser.ConstinitvalContext ctx, int deep, wordinfo word, List<Integer>nums, List<element>mmap)
    {
        int i=0;
        for(labParser.ConstinitvalContext initval:ctx.constinitval())
        {
            nums.add(i);
            if(deep<word.numlist.size()) {
                dealconstarray(initval, deep + 1, word, nums,mmap);
            }
            else{
                int num=nums.get(0);
                for(int j=1;j<word.numlist.size();j++)
                {
                    num=num*word.numlist.get(j)+nums.get(j);
                }
                nodeinfo info=(nodeinfo) visit(initval.constexp());
                mmap.add(new element(num,info));
            }
            i+=1;
            nums.remove(nums.size()-1);
        }
    }
    List<wordinfo>initword()
    {
        List<wordinfo>words=new ArrayList<>();
        words.addAll(curfuncblock.curvarblock.words);
        words.addAll(curfuncblock.curvarblock.outsidewords);
        words.addAll(globalwords);
        return  words;
    }

    funcblock findfunc(String name)
    {
        for(funcblock a:funcblockList)
            if(a.name.equals(name))
                return a;
        return null;
    }
    void dealorlist(List<orblock>orblockList)
    {
        for(int i=0;i<orblockList.size();i++)
        {
            List<block>blocks=orblockList.get(i).blockList;
            for(int j=0;j<blocks.size();j++)
            {
                block now=blocks.get(j);
                if(j==blocks.size()-1)
                {
                    now.trueblock=orblockList.get(i).trueblock;

                }
                if(i==orblockList.size()-1)
                    now.falseblock=orblockList.get(i).falseblock;
                now.output=now.output.concat("    br i1 %" + now.end + ",label %" + now.trueblock + ", label %" + now.falseblock + "\n");
            }
        }
    }
}

