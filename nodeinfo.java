import java.util.ArrayList;
import java.util.List;

public class nodeinfo {
    String address;
    int num;
    boolean value=true;
    String name;
    String type;
    String fuzhi;
    String geshi="i32";
    List<nodeinfo>addresslist=new ArrayList<>();
    public nodeinfo(String address, int num, String type,String name) {
        this.address = address;
        this.num = num;
        this.type = type;
        this.name = name;
    }
}
