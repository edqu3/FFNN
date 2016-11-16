package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

abstract class Node {

    BigDecimal output, bias, cumulativeBias, error;
    ArrayList<? extends Edge> weights = new ArrayList<>();

    Node(BigDecimal output, ArrayList<? extends Edge> weights, Bias bias) {
        this.bias = bias == null ? null : bias.getValue();
        this.output = output;
        this.weights = weights;
        this.cumulativeBias = new BigDecimal(0);
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

    void setError(BigDecimal error) {
        this.error = error;
    }

    BigDecimal getError(){
        if (error != null) {
            return error;
        }
        return null;
    }

    // probably dont need this
    abstract void update(BigDecimal... newWeights);

    /**
     * add the new bias to the cumulative bias.
     * @param newBias
     */
    void addToBiasSum(BigDecimal newBias){
        this.cumulativeBias = cumulativeBias.add(newBias);
    }

}
