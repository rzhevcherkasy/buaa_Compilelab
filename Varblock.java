import java.util.ArrayList;
import java.util.List;

public class Varblock {   //变量树
    Varblock fathernode;  //父节点
   // List<Varblock> childrennode;  //子节点
    List<Var> in=new ArrayList<>();
    List<Var> out=new ArrayList<>();
}
