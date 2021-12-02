// Main.java
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception { ;
        try{
            String input = "";
            String filePath = args[1];
            File file = new File(filePath);
            Reader in = null;
            // 一次读一个字节

            in = new InputStreamReader(new FileInputStream(file));
            int a;

            while ((a = in.read()) != -1) {
                String b=String.valueOf((char)a);
                input=input.concat(b);
            }
            in.close();
            int i=0;
            String inputnew="";
            while(i<input.length())
            {
                char now=input.charAt(i);
                if(i==input.length()-1) {
                    inputnew = inputnew.concat(String.valueOf(now));
                    break;
                }
                char next=input.charAt(i+1);
                if(now=='/'&&next=='*'){
                    i+=2;
                    while(i<input.length()-1)
                    {
                        char now1=input.charAt(i);
                        char next1=input.charAt(i+1);
                        if(now1=='*'&&next1=='/') {
                            i += 2;
                            break;
                        }
                        i+=1;
                    }
                }
                else if(now=='/'&&next=='/')
                {
                    i+=2;
                    while(i<input.length()-1)
                    {
                        char now1=input.charAt(i);
                        i+=1;
                        if(now1=='\n'||now1=='\r')
                            break;
                    }
                }
                else
                {
                    inputnew=inputnew.concat(String.valueOf(now));
                    i+=1;
                }

            }
            CharStream inputStream = CharStreams.fromString(inputnew);
            compileLexer lexer = new compileLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            compileParser parser = new compileParser(tokenStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
            parser.removeErrorListeners();
            parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
            ParseTree tree = parser.compUnit();
            //System.out.println(tree.toStringTree(parser)); // 打印字符串形式的语法树
            Visitor visitor = new Visitor();
            visitor.visit(tree);
        }
        catch (Exception e){
            System.exit(2333);
        }
    }
}
