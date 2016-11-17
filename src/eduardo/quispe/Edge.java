package eduardo.quispe;

import java.math.BigDecimal;

abstract class Edge {

    private BigDecimal value;
    private BigDecimal newValue = new BigDecimal(0);

    Edge(BigDecimal value) {
        this.value = value;
    }

    BigDecimal getValue() {
        return this.value;
    }

    /**
     * This value is added with the next tuples matching weight, then an average will be taken to create the new weight.
     *
     * @param newVal
     */
    void newValue(BigDecimal newVal) {
        this.newValue = newVal;
    }

    public BigDecimal getNewValue() {
        return newValue;
    }

    void updateValue() {
        this.value = this.newValue;
    }

}
