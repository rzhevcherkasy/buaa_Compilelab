// Main.java
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
            String input = "" ;
            File infile = new File(args[0]);
            try{
                Scanner sc = new Scanner(infile);
                while(sc.hasNextLine()){
                    input +=sc.nextLine()+'\n';
                    //System.out.println(input);
                }
                sc.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
            String inputnew="";
            int i=0;
           // System.out.println(input);
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
        //System.out.println(inputnew);
            CharStream inputStream = CharStreams.fromString(inputnew);
            compileLexer lexer = new compileLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            compileParser parser = new compileParser(tokenStream);
            lexer.removeErrorListeners();
            lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
            parser.removeErrorListeners();
            parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
            ParseTree tree = parser.compUnit();

            Visitor visitor = new Visitor();
            visitor.visit(tree);
    }
}
