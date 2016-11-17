package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

class Tuple {
  private ArrayList<? extends Node> hiddenNodes;
  private ArrayList<? extends Node> outputNodes;
  private ArrayList<? extends Node> inputNodes;
  private final Classifier classifier;
  private final BigDecimal learningRate;

  private static ArrayList<Tuple> tuples = new ArrayList<>();
  private static int tupleIndex = 0;

  @SafeVarargs
  Tuple(Classifier classifier, BigDecimal learningRate, ArrayList<? extends Node>... nodes) {
    this.classifier = classifier;
    this.learningRate = learningRate;
    this.inputNodes = nodes[0];
    if (nodes.length > 1) {
      this.hiddenNodes = nodes[1];
      this.outputNodes = nodes[2];
    }
    tuples.add(this);
  }

  static void passWeightsToNextTuple() {
    Tuple oldTuple = tuples.get(tupleIndex++);
    tupleIndex = tupleIndex % tuples.size();
    Tuple newTuple = tuples.get(tupleIndex);
    newTuple.hiddenNodes = oldTuple.hiddenNodes;
    newTuple.outputNodes = oldTuple.outputNodes;
  }

  BigDecimal getLearningRate() {
    return learningRate;
  }

  ArrayList<? extends Node> getHiddenNodes() {
    return hiddenNodes;
  }

  ArrayList<? extends Node> getInputNodes() {
    return inputNodes;
  }

  ArrayList<? extends Node> getOutputNodes() {
    return outputNodes;
  }

  BigDecimal getClassifierValue() {
    return this.classifier.getValue();
  }

}
