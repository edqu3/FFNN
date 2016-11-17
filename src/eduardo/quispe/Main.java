package eduardo.quispe;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  private final static MathContext MC = new MathContext(3, RoundingMode.HALF_UP);

  public static void main(String[] args) {

    final ArrayList<Tuple> tuples = new ArrayList<>();
    final BigDecimal learningRate = new BigDecimal(0.7, MC);

    tuples.add(
        new Tuple(
            new Classifier(new BigDecimal(1)),
            learningRate, new ArrayList<>(Arrays.asList(
            /* Input nodes */
            new InputNode(new BigDecimal(0.5, MC), null),
            new InputNode(new BigDecimal(0.0, MC), null),
            new InputNode(new BigDecimal(0.2, MC), null)
        )),
            new ArrayList<>(Arrays.asList(
                new HiddenNode(null, new ArrayList<>(Arrays.asList(
                    /* to hidden Node 4*/
                    new HiddenWeight(new BigDecimal(0.3, MC)),
                    new HiddenWeight(new BigDecimal(0.1, MC)),
                    new HiddenWeight(new BigDecimal(-0.8, MC))
                )), new Bias(new BigDecimal(0.2, MC))),
                new HiddenNode(null, new ArrayList<>(Arrays.asList(
                    /* to hidden Node 5*/
                    new HiddenWeight(new BigDecimal(-0.5, MC)),
                    new HiddenWeight(new BigDecimal(0.3, MC)),
                    new HiddenWeight(new BigDecimal(0.2, MC))
                )), new Bias(new BigDecimal(-0.1, MC)))
            )),
            new ArrayList<>(Arrays.asList(
                /* to output nodes */
                new OutputNode(null, new ArrayList<>(Arrays.asList(
                    new OutputWeight(new BigDecimal(-0.7, MC)),
                    new OutputWeight(new BigDecimal(0.4, MC))
                )), new Bias(new BigDecimal(0.3, MC)))
            ))
        ));

    tuples.add(
        new Tuple(
            new Classifier(BigDecimal.ONE),
            learningRate,
            new ArrayList<Node>(Arrays.asList(
                /* Input Nodes */
                new InputNode(new BigDecimal(0.0, MC), null),
                new InputNode(new BigDecimal(0.3, MC), null),
                new InputNode(new BigDecimal(0.0, MC), null)
            ))
        )
    );

    start(2, tuples);

  }

  private static void start(int epochs, ArrayList<Tuple> tuples) {

    // declare temp variables
    for (int i = 0; i < epochs; i++) {
      System.out.println("Start Epoch " + (i + 1) + "/" + epochs);
      for (int j = 0; j < tuples.size(); j++) {
        System.out.println("Start Tuple " + (j + 1) + "/" + tuples.size());
        System.out.println();
        // calculate and update inputs and outputs
        Helpers.calcNetIO(tuples.get(j).getInputNodes(), tuples.get(j).getHiddenNodes());
        Helpers.calcNetIO(tuples.get(j).getHiddenNodes(), tuples.get(j).getOutputNodes());

        // errors
        Helpers.calcOutputError(tuples.get(j).getOutputNodes(), tuples.get(j).getClassifierValue());
        Helpers.calcHiddenError(tuples.get(j).getHiddenNodes(), tuples.get(j).getOutputNodes());

        // calculate new weights/biases
        Helpers.calcNewEdges(tuples.get(i));
        // update weights/biases
        Tuple.passWeightsToNextTuple();
        System.out.println();
        System.out.println("End of Tuple " + (j+1));
      }
      System.out.println("\nEnd of Epoch " + (i+1));
    }
  }

}
