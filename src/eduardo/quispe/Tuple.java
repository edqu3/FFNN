package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

class Tuple {
    private final ArrayList<? extends Node> hiddenNodes;
    private final ArrayList<? extends Node> outputNodes;
    private final ArrayList<? extends Node> inputNodes;
    private final Classifier classifier;
    private final BigDecimal learningRate;

    @SafeVarargs
    Tuple(Classifier classifier, BigDecimal learningRate, ArrayList<? extends Node>... nodes) {
        this.learningRate = learningRate;
        this.inputNodes = nodes[0];
        this.hiddenNodes = nodes[1];
        this.outputNodes = nodes[2];
        this.classifier = classifier;
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
