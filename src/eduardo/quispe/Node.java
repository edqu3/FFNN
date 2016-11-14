package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

abstract class Node {

    BigDecimal output, bias;
    ArrayList<? extends Edge> weights = new ArrayList<>();

    Node(BigDecimal output, ArrayList<? extends Edge> weights, Bias bias) {
        this.bias = bias == null ? null : bias.getValue();
        this.output = output;
        this.weights = weights;
    }

    ArrayList<? extends Edge> getWeights(){
        return this.weights;
    }

    BigDecimal getOutputValue(){
        return this.output;
    }

    BigDecimal getBias(){
        return this.bias;
    }

    void setOutputValue(BigDecimal newOutput){
        this.output = newOutput;
    }

    abstract void update(BigDecimal... newWeights);

}
