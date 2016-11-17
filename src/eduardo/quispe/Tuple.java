package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

class Tuple {
    private final ArrayList<? extends Node> hiddenNodes;
    private final ArrayList<? extends Node> outputNodes;
    private final ArrayList<? extends Node> inputNodes;
    private final Classifier classifier;
    private final BigDecimal learningRate;

    private final ArrayList<Node> nodeList;

    @SafeVarargs
    Tuple(Classifier classifier, BigDecimal learningRate, ArrayList<? extends Node>... nodes) {
        this.learningRate = learningRate;
        this.inputNodes = nodes[0];
        this.hiddenNodes = nodes[1];
        this.outputNodes = nodes[2];
        nodeList = new ArrayList<>();
        nodeList.addAll(this.hiddenNodes);
        nodeList.addAll(this.outputNodes);
        this.classifier = classifier;
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
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

    static void updateEdges(ArrayList<Tuple> tuples) {
        BigDecimal newBiases = new BigDecimal(0);
        BigDecimal newWeights = new BigDecimal(0);

        for (Tuple tuple : tuples) {
            ArrayList<Node> nodeList = tuple.getNodeList();
            for (int i = 0; i < nodeList.size(); i++) {
                Node node = nodeList.get(i);
                // sum up biases differences
                newBiases = newBiases.add(node.getNewBias());
                // sum up weights differences
                ArrayList<? extends Edge> weights = node.getWeights();
                for (int j = 0; j < weights.size() ; j++) {
                    newWeights = newWeights.add(weights.get(j).getNewValue());
                }


            }

        }

        BigDecimal newBias = newBiases.divide(newBiases, tuples.size());
        BigDecimal newWeight = newWeights.divide(newWeights, tuples.size());

    }
}
