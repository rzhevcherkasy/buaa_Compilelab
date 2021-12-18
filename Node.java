public class Node {
    private int id;   //主键
    private int val;  //数值 num是本身，exp是%i
    private String type;  //类型 num,exp
    private int depth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDepth() {
        return depth;
    }

    public Node(int id, int val, String type, int depth) {
        this.id = id;
        this.val = val;
        this.type = type;
        this.depth = depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
