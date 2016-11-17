package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

class InputNode extends Node {

  InputNode(BigDecimal value, ArrayList<Edge> weights) {
    super(value, weights, null);
  }

}
