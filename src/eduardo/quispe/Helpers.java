package eduardo.quispe;

import helper.BigFunctions;

import java.lang.reflect.Array;
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
     * @param prevNodes
     * @param currNodes
     * @return
     */
    public static void calcNetIO(ArrayList<? extends Node> prevNodes, ArrayList<? extends Node> currNodes) {

        for (Node node : currNodes) {
            BigDecimal netInput, output;
            netInput = calculateNodeInput(prevNodes, node);
            output = calculateNodeOutput(netInput);
            node.setOutputValue(output);
            System.out.println("Output: " + output);
        }

    }

    private static <T extends Node> BigDecimal calculateNodeOutput(BigDecimal netInput) {
        BigDecimal eToNetInput = BigFunctions.exp(BigFunctions.ln(E, MC.getPrecision()).multiply(netInput.negate()), MC.getPrecision());
        return new BigDecimal(1).divide(new BigDecimal(1).add(eToNetInput), MC);
    }

    private static <T extends Node> BigDecimal calculateNodeInput(ArrayList<? extends Node> previousNodes, T currentNode) {
        BigDecimal input = new BigDecimal(0);

        ArrayList<? extends Edge> weights = currentNode.getWeights();
        for (int i = 0; i < weights.size(); i++) {
            BigDecimal pNode = previousNodes.get(i).getOutputValue();
            BigDecimal weight = weights.get(i).getValue();
            System.out.println("prev Node value: " + pNode + " * weight: " + weight);
            input = input.add(pNode.multiply(weight, MC));
        }
        input = input.add(currentNode.getBias());
        System.out.println("net input: " + input);
        return input;
    }

    /*Err_k=O_k (1-O_k)(T_k-O_k)*/
    static void calcHiddenError(ArrayList<? extends Node> currentNodes, ArrayList<? extends Node> nextNodes, BigDecimal classifierValue) {

    }

    static void calcOutputError(ArrayList<? extends Node> currenNodes, BigDecimal classifierValue) {
//        calcHiddenError(currenNodes, null, classifierValue);

        for (int i = 0; i < currenNodes.size(); i++) {

            BigDecimal output = currenNodes.get(i).getOutputValue();

            // output node error calculation
            BigDecimal error = output.multiply(new BigDecimal(1).subtract(output), MC).multiply(classifierValue.subtract(output), MC);
            System.out.println("error " + error);
        }


    }
}