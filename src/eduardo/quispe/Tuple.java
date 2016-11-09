package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Tuple {

    private ArrayList<Edge> edges = new ArrayList<>();
    private ArrayList<Bias> biases = new ArrayList<>();
    private final TupleDefinition TP;

    public Tuple(TupleDefinition tp, BigDecimal[] biases, BigDecimal... weights) {
        this.TP = tp;

        for (int i = 0; i < TP.getInputNodes(); i++) {

        }

        for (int i = TP.getInputNodes(); i < TP.getHiddenNodes(); i++) {

        }

        for (int i = TP.getHiddenNodes(); i < TP.getOuterNodes(); i++) {

        }

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

        public int getNodeCount() { return inputNodes + hiddenNodes + outerNodes; }

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
