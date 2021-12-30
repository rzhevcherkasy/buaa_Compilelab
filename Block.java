import java.util.ArrayList;
import java.util.List;

public class block {
        String type="func";
        String output="";
        block parblock;
        block destblock;
        int jump=-1;
        int stage=1;
        boolean set=true;
        int trueblock;
        int falseblock;
        int right;

        int start=0;
        int end;
        int flag=0;
        public block(){
        }
        public block(block parblock,int start) {
                this.start=start;
                this.parblock = parblock;
        }

}
