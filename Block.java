import java.util.ArrayList;
import java.util.List;

public class Block {
    int block_id; //用于生成名字的
    String name;  //"a"+block_id
    List<String> blockOutput=new ArrayList<>();   //输出
    Block true_Block;   //正确的去向
    Block false_Block;   //错误的去向
    Block father_Block;   //来的Block
    Node check;    //真正影响判断的语句
    boolean set=true;
    String type="func";
    String output="";  //输出
    Block parblock;
    Block destblock;
    int jump=-1;
    int stage=1;
    int trueblock;
    int falseblock;
    int right;

    int start=0;
    int end;
    int flag=0;
    public Block(){
    }
    public Block(Block parblock,int start) {
        this.start=start;
        this.parblock = parblock;
    }

    public Block(int block_id, String name) {
        this.block_id = block_id;
        this.name = name;
        this.blockOutput=new ArrayList<>();
    }


    public int getBlock_id() {
        return block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBlockOutput() {
        return blockOutput;
    }

    public void setBlockOutput(List<String> blockOutput) {
        this.blockOutput = blockOutput;
    }

    public Block getTrue_Block() {
        return true_Block;
    }

    public void setTrue_Block(Block true_Block) {
        this.true_Block = true_Block;
    }

    public Block getFalse_Block() {
        return false_Block;
    }

    public void setFalse_Block(Block false_Block) {
        this.false_Block = false_Block;
    }

    public Block getFather_Block() {
        return father_Block;
    }

    public void setFather_Block(Block father_Block) {
        this.father_Block = father_Block;
    }




    public Node getCheck() {
        return check;
    }

    public void setCheck(Node check) {
        this.check = check;
    }
}
