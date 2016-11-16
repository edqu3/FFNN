package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

class OutputNode extends Node {

    OutputNode(BigDecimal value, ArrayList<Edge> weights, Bias bias) {

        super(value, weights, bias);
        setError(new BigDecimal(0));
    }

    @Override
    void update(BigDecimal... newWeights) {
        if (newWeights.length == super.weights.size()) {
            ArrayList<HiddenWeight> hiddenWeights = new ArrayList<>();
            for (BigDecimal w : newWeights) {
                hiddenWeights.add(new HiddenWeight(w));
            }
            super.weights = hiddenWeights;
        }
    }
}
