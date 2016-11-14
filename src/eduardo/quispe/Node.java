package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Node {

    BigDecimal value, bias;
    ArrayList<? extends Edge> weights = new ArrayList<>();

    public Node(BigDecimal value, ArrayList<? extends Edge> weights, Bias bias) {
        this.bias = bias == null ? null : bias.getValue();
        this.value = value;
        this.weights = weights;
    }

    abstract ArrayList<? extends Edge> getWeights();

    abstract BigDecimal getNodeValue();

    public BigDecimal getBias(){
        return this.bias;
    }

    abstract void update(BigDecimal... newWeights);

}
