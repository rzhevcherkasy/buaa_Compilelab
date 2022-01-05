import java.util.ArrayList;
import java.util.List;

public class Function {
    String name;
    String address;
    String returntype="";
    //List<param> params;
    int step=0;
    Block tempBlock=null;
    Varblock tempVarBlock;
    List<Varblock>varblocks=new ArrayList<>();
    List<Block>blocks=new ArrayList<>();
    List<Node> nodeList=new ArrayList<>();

    public Function(String name) {
        this.name = name;
    }
}
