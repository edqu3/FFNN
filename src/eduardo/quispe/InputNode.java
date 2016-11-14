package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InputNode extends Node {

    public InputNode(BigDecimal value, ArrayList<Edge> weights) {
        super(value, weights, null);
    }

    @Override
    ArrayList<? extends Edge> getWeights() {
        /* input nodes do not have forward edges */
        return null;
    }

    @Override
    BigDecimal getNodeValue() {
        return super.value;
    }

    @Override
    void update(BigDecimal... newWeights) {
        super.value = newWeights[0];
    }

}
