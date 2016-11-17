package eduardo.quispe;

import java.math.BigDecimal;

abstract class Edge {

  private BigDecimal value = new BigDecimal(0);

  Edge(BigDecimal value) {
    this.value = value;
  }

  BigDecimal getValue() {
    return this.value;
  }

  void setNewValue(BigDecimal newValue) {
    this.value = newValue;
  }
}
