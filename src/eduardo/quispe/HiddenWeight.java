package eduardo.quispe;


import java.math.BigDecimal;

public class HiddenWeight extends Edge {

    HiddenWeight(BigDecimal edgeValue) {
        super(edgeValue);

    }

    @Override
    public BigDecimal getValue() {
        return super.value;
    }
}
