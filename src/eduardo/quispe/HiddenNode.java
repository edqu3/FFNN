package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

class HiddenNode extends Node {

    private BigDecimal error;

    HiddenNode(BigDecimal value, ArrayList<HiddenWeight> weights, Bias bias) {
        super(value, weights, bias);
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

    void setError(BigDecimal error) {
        this.error = error;
    }

    BigDecimal getError() {
        if (error != null)
            return error;
        return null;
    }
}
