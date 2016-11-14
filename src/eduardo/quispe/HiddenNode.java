package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

public class HiddenNode extends Node {

    public HiddenNode(BigDecimal value, ArrayList<HiddenWeight> weights, Bias bias) {
        super(value, weights, bias);
    }

    @Override
    ArrayList<? extends Edge> getWeights() {
        return super.weights;
    }

    @Override
    BigDecimal getOutputValue() {
        /* hidden nodes do not have node values*/
        return null;
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
