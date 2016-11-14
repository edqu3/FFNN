package eduardo.quispe;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Helpers {

    // round up to nearest 1000th
    private final static MathContext MC = new MathContext(3, RoundingMode.HALF_UP);

    private Helpers() {
    }

    // I_j= w_ij O_i+θ_j
    public static BigDecimal calcNetIO(ArrayList<? extends Node> prevNode, ArrayList<? extends Node> currNodes) {
        
            for (int i = 0; i < currNodes.size(); i++) {
                BigDecimal netInput = new BigDecimal(0);
                ArrayList<? extends Edge> weights = currNodes.get(i).getWeights();

                for (int j = 0; j < weights.size(); j++) {
                    BigDecimal pNode = prevNode.get(j).getNodeValue();
                    BigDecimal weight = weights.get(j).getValue();
                    System.out.println(pNode + " * " + weight);

                    netInput = netInput.add(pNode.multiply(weight));

                    // calculate node output
                }
                netInput = netInput.add(currNodes.get(i).bias);
                System.out.println(netInput);
            }
        return null;
    }


}