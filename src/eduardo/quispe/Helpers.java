package eduardo.quispe;

import helper.BigFunctions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Helpers {

    // round up to nearest 1000th
    private final static MathContext MC = new MathContext(3, RoundingMode.HALF_UP);
    // eulers number
    private final static BigDecimal E = new BigDecimal(2.7182818284590452353602874713527, MC);

    private Helpers() {
    }

    /**
     * calc node input and output
     *
     * @param prevNode
     * @param currNodes
     * @return
     */
    public static BigDecimal calcNetIO(ArrayList<? extends Node> prevNode, ArrayList<? extends Node> currNodes) {

        /* Hidden Nodes */
        for (int i = 0; i < currNodes.size(); i++) {
            BigDecimal netInput = new BigDecimal(0);
            ArrayList<? extends Edge> weights = currNodes.get(i).getWeights();

            for (int j = 0; j < weights.size(); j++) {
                BigDecimal pNode = prevNode.get(j).getOutputValue();
                BigDecimal weight = weights.get(j).getValue();
                System.out.println(pNode + " * " + weight);
                netInput = netInput.add(pNode.multiply(weight));
            }
            // final node input
            netInput = netInput.add(currNodes.get(i).bias);
            System.out.println(netInput);

            // calculate node output
            BigDecimal output = new BigDecimal(1);
            BigDecimal eToNetInput = BigFunctions.exp(BigFunctions.ln(E, MC.getPrecision()).multiply(netInput.negate()), MC.getPrecision());

            output = output.divide(new BigDecimal(1).add(eToNetInput), MC);
            System.out.println(output);
        }
        return null;
    }


}