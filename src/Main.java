import cal.Add;
import cal.StringIter;
import cal.Tokenizer;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int a,b;
        Scanner input = new Scanner(System.in);
        StringIter iter = new StringIter(input);
        Tokenizer tokenizer =new Tokenizer(iter);
        try {
            while (true) {
                boolean token = tokenizer.nextToken();
              //  System.out.println("token");
                if (token==false) {
                    break;
                }
            }
        } catch (Exception e) {
            // 遇到错误不输出，直接退出
            System.err.println(e);
            System.exit(0);
            return;
        }

    }
}
