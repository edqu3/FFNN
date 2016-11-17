package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

class OutputNode extends Node {

  OutputNode(BigDecimal value, ArrayList<Edge> weights, Bias bias) {

    super(value, weights, bias);
    this.error = new BigDecimal(0);
  }
}
