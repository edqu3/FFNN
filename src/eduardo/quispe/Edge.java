package eduardo.quispe;

import java.math.BigDecimal;

public abstract class Edge {

    BigDecimal value = new BigDecimal(0);

    public Edge(BigDecimal value){
        this.value = value;
    }

    public abstract BigDecimal getValue();

}
