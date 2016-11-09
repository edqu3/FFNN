package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Tuple {

    private ArrayList<Edge> edges = new ArrayList<>();
    private ArrayList<Bias> biases = new ArrayList<>();

    public Tuple(TupleDefinition def, BigDecimal... values) {

        for (int i = 0; i < def.getInputNodes(); i++) {

        }

        for (int i = def.getInputNodes(); i < def.getHiddenNodes(); i++) {

        }

        for (int i = def.getHiddenNodes(); i < def.getOuterNodes(); i++) {

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
