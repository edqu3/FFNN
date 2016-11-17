package eduardo.quispe;

import helper.BigFunctions;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

class Helpers {

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
  static void calcNetIO(ArrayList<? extends Node> prevNodes, ArrayList<? extends Node> currNodes) {

    for (Node node : currNodes) {
      BigDecimal netInput, output;
      netInput = calculateNodeInput(prevNodes, node);
      output = calculateNodeOutput(netInput);
      node.setOutputValue(output);
      System.out.println("Output: " + output);
      System.out.println();
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
      System.out.println("prev node output: " + pNode + " * weight: " + weight);
      input = input.add(pNode.multiply(weight, MC));
    }
    System.out.println("bias: " + currentNode.getBias());
    input = input.add(currentNode.getBias());
    System.out.println("net input: " + input);
    return input;
  }


  /* Err_j=O_j (1-O_j ) ?_k Err_k w_jk */
  static void calcHiddenError(ArrayList<? extends Node> currentNodes, ArrayList<? extends Node> nextNodes) {

    for (int i = 0; i < currentNodes.size(); i++) {
      BigDecimal outputValue = currentNodes.get(i).getOutputValue();
      BigDecimal err = outputValue.multiply(new BigDecimal(1).subtract(outputValue), MC);
      BigDecimal errSum = new BigDecimal(0);
            /* for each output node... */
      for (int j = 0; j < nextNodes.size(); j++) {
        OutputNode oNode = (OutputNode) nextNodes.get(j);
        errSum = errSum.add(oNode.getError().multiply(oNode.getWeights().get(i).getValue()), MC);
//        System.out.println("error Sum: " + errSum);
      }
      err = err.multiply(errSum, MC);
      currentNodes.get(i).setError(err);
      System.out.println("Hidden node error: " + err);
    }
    System.out.println();
  }

  /*Err_k=O_k (1-O_k)(T_k-O_k)*/
  static void calcOutputError(ArrayList<? extends Node> currentNodes, BigDecimal classifierValue) {
    for (int i = 0; i < currentNodes.size(); i++) {
      BigDecimal output = currentNodes.get(i).getOutputValue();
      BigDecimal error = output.multiply(new BigDecimal(1).subtract(output), MC).multiply(classifierValue.subtract(output), MC);
      currentNodes.get(i).setError(error);
      System.out.println("Output node error " + error);
      System.out.println();
    }
  }

  static void calcNewEdges(Tuple tuple) {

    ArrayList<? extends Node> inputNodes = tuple.getInputNodes();
    ArrayList<? extends Node> hiddenNodes = tuple.getHiddenNodes();
    ArrayList<? extends Node> outputNodes = tuple.getOutputNodes();

    ArrayList<Node> nodes = new ArrayList<>();
    nodes.addAll(hiddenNodes);
    nodes.addAll(outputNodes);

    for (int i = 0; i < nodes.size(); i++) {
      Node currentNode = nodes.get(i);
      ArrayList<? extends Edge> weights = currentNode.getWeights();
      BigDecimal bias = currentNode.getBias();
      BigDecimal newBias = bias.add(tuple.getLearningRate().multiply(currentNode.getError()), MC);
      for (int j = 0; j < weights.size(); j++) {
        Edge w = weights.get(j);
        BigDecimal newW = new BigDecimal(0);
        if (currentNode.getClass().equals(HiddenNode.class)) {
          System.out.println("hidden node");
          newW = w.getValue().add(tuple.getLearningRate().multiply(currentNode.getError(), MC).multiply(inputNodes.get(j).getOutputValue()), MC);
        } else if (nodes.get(i).getClass().equals(OutputNode.class)) {
          System.out.println("output node");
          newW = w.getValue().add(tuple.getLearningRate().multiply(currentNode.getError(), MC).multiply(hiddenNodes.get(j).getOutputValue()), MC);
        } else {
          System.out.println("???");
        }
        w.setNewValue(newW);
        System.out.println("old weight: " + w.getValue());
        System.out.println("new weight: " + newW);
      }
      currentNode.setNewBias(newBias);
      System.out.println("old bias: " + bias);
      System.out.println("new bias: " + newBias);
    }
  }
}