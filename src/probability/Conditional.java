package probability;

import java.util.HashMap;
import java.util.Map;

public class Conditional {

    public void getConditional(char[] event, double char1, double char2 ) {
        System.out.println("P(" + event[0] + "|" + event[1] + ") = (" + char1 + "/" + char2 + ") = " + char1 / char2);
    }


}
