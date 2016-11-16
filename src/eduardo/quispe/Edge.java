package eduardo.quispe;

import java.math.BigDecimal;

abstract class Edge {

    private BigDecimal value = new BigDecimal(0);

    private BigDecimal cumulativeValue = new BigDecimal(0);

    Edge(BigDecimal value) {
        this.value = value;
    }

    BigDecimal getValue() {
        return this.value;
    }

    /**
     * add to cumulative weight sum
     *
     * @param newVal
     */
    void addToValSum(BigDecimal newVal) {
        this.cumulativeValue = this.cumulativeValue.add(newVal);
    }

    void updateValue() {
        this.value = this.cumulativeValue;
    }

}
