package eduardo.quispe;

import java.math.BigDecimal;

abstract class Edge {

    private BigDecimal value = new BigDecimal(0);

    

    private BigDecimal cumulativeValue = new BigDecimal(0);

    Edge(BigDecimal value){
        this.value = value;
    }

    BigDecimal getValue(){
        return this.value;
    }

    void newValue(BigDecimal newVal){
        this.cumulativeValue = newVal;
    }

    void updateValue(){
        this.value = this.cumulativeValue;
    }

}
