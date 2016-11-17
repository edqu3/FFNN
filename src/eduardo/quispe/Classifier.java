package eduardo.quispe;

import java.math.BigDecimal;

class Classifier {

  private BigDecimal value;

  Classifier(BigDecimal value) {
    this.value = value;
  }

  BigDecimal getValue() {
    return value;
  }
}
