package eduardo.quispe;

import java.util.ArrayList;

public class Tuple {
    private final ArrayList<? extends Node> hiddenNodes;
    private final ArrayList<? extends Node> outputNodes;
    private final ArrayList<? extends Node> inputNodes;

    @SafeVarargs
    Tuple(Classifier classifier, ArrayList<? extends Node>... nodes) {

        this.inputNodes = nodes[0];
        this.hiddenNodes = nodes[1];
        this.outputNodes = nodes[2];
    }

    public ArrayList<? extends Node> getHiddenNodes() {
        return hiddenNodes;
    }

    public ArrayList<? extends Node> getInputNodes() {
        return inputNodes;
    }

    public ArrayList<? extends Node> getOutputNodes() {
        return outputNodes;
    }

    static class TupleDefinition {

        private int inputNodes,
                hiddenNodes,
                outerNodes;


        public int getInputNodes() {
            return inputNodes;
        }

        public int getOuterNodes() {
            return outerNodes;
        }

        public int getHiddenNodes() {
            return hiddenNodes;
        }

        public int getNodeCount() {
            return inputNodes + hiddenNodes + outerNodes;
        }

        static TupleDefinition createTupleDefinition(int inputNodes, int hiddenNodes, int outerNodes) {
            return new TupleDefinition(inputNodes, hiddenNodes, outerNodes);
        }

        private TupleDefinition(int inputNodes, int hiddenNodes, int outerNodes) {
            this.inputNodes = inputNodes;
            this.hiddenNodes = hiddenNodes;
            this.outerNodes = outerNodes;
        }

    }

}
