package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

class HiddenNode extends Node {

  HiddenNode(BigDecimal value, ArrayList<HiddenWeight> weights, Bias bias) {
    super(value, weights, bias);
  }

}
