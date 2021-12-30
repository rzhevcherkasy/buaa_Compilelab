import java.util.ArrayList;
import java.util.List;

public class funcblock {
    String name;
    String address;
    String returntype="";
    List<wordinfo>params;
    int step=0;
    block nowblock=null;
    varblock curvarblock;
    List<varblock>varblocks=new ArrayList<>();
    List<block>blocks=new ArrayList<>();
}
