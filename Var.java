import java.util.ArrayList;
import java.util.List;

public class Var {
    private String name;  //名字
    private boolean ifConst;  //是否是const
    private String type;  //int,globalInt,array
    private int val; //实际的数值
    private int block; //在哪个块里
    private int nodeId; //寄存器什么位置
    public int length; //数组用的
    public List<Integer>numlist=new ArrayList<>(); //数组用的

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIfConst() {
        return ifConst;
    }

    public void setIfConst(boolean ifConst) {
        this.ifConst = ifConst;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public Var(String name, boolean ifConst, String type, int val, int block, int nodeId) {
        this.name = name;
        this.ifConst = ifConst;
        this.type = type;
        this.val = val;
        this.block = block;
        this.nodeId = nodeId;
    }

    public Var(String name, boolean ifConst, String type, int val, int block) {
        this.name = name;
        this.ifConst = ifConst;
        this.type = type;
        this.val = val;
        this.block = block;
    }

    public Var(String name, boolean ifConst, String type, int val, int block, int nodeId, int length, List<Integer> numlist) {
        this.name = name;
        this.ifConst = ifConst;
        this.type = type;
        this.val = val;
        this.block = block;
        this.nodeId = nodeId;
        this.length = length;
        this.numlist = numlist;
    }
}
