package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

abstract class Node {

    BigDecimal output, bias, newBias, error;
    ArrayList<? extends Edge> weights = new ArrayList<>();

    Node(BigDecimal output, ArrayList<? extends Edge> weights, Bias bias) {
        this.bias = bias == null ? null : bias.getValue();
        this.output = output;
        this.weights = weights;
        this.newBias = new BigDecimal(0);
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

    public BigDecimal getNewBias() {
        return newBias;
    }

    // probably don't need this
    abstract void update(BigDecimal... newWeights);

    /**
     * * This value is added with the next tuples matching bias, then an average will be taken to create the new bias.
     *
     * TODO keep track of the sum here, then divide this value and finally update.
     * @param newBias
     */
    void addToBiasSum(BigDecimal newBias){
        this.newBias = newBias;
    }

}
