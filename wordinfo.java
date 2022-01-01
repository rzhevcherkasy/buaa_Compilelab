import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wordinfo {
    int step;
    int num;
    String name;
    String type;
    String fuzhi="";
    String address;
    int length;
    List<Integer>numlist=new ArrayList<>();
    public wordinfo(String address, int num, String name,String type) {
        this.address=address;
        this.num = num;
        this.name = name;
        this.type=type;
    }
    public wordinfo(String address, int num, String name,String type,int length,List<Integer>numlist) {
        this.address=address;
        this.num = num;
        this.name = name;
        this.type=type;
        this.length=length;
        this.numlist=numlist;
    }
    public wordinfo(){}
}
