package cal;

public class Add{
    public static int add(int a,int b){
        return a+b;
    }
    public static String DealParentheses(String in){
        char[] array = in.toCharArray();
        while(array[0]=='('){
            System.out.println("LPar");
            for(int i=1;i<array.length;i++){
                array[i-1]=array[i];
                array=java.util.Arrays.copyOf(array,array.length-1);
            }
        }
        if(array[array.length-1]==')'){
            System.out.println("RPar");
            array=java.util.Arrays.copyOf(array,array.length-1);
        }
        if(array[0]=='{'){
            System.out.println("LBrace");
            for(int i=1;i<array.length;i++){
                array[i-1]=array[i];
                array=java.util.Arrays.copyOf(array,array.length-1);
            }
        }
        if(array[array.length-1]=='}'){
            System.out.println("RBrace");
            array=java.util.Arrays.copyOf(array,array.length-1);
        }
        return new String(array);
    }
}
