package eduardo.quispe;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    private final static MathContext MC = new MathContext(3, RoundingMode.HALF_UP);

    public static void main(String[] args) {

        ArrayList<Tuple> tuples = new ArrayList<>();

        tuples.add(
                new Tuple(
                        new Classifier(new BigDecimal(1)),
                        new ArrayList<>(Arrays.asList(
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
                        new ArrayList<>(Collections.singletonList(
                                /* to output nodes */
                                new OutputNode(null, new ArrayList<>(Arrays.asList(
                                        new OutputWeight(new BigDecimal(-0.7, MC)),
                                        new OutputWeight(new BigDecimal(0.4, MC))
                                )), new Bias(new BigDecimal(0.3, MC)))
                        ))
                ));

        tuples.add(
                new Tuple(
                        new Classifier(new BigDecimal(1)),
                        new ArrayList<>(Arrays.asList(
                                new InputNode(new BigDecimal(0.0, MC), null),
                                new InputNode(new BigDecimal(0.3, MC), null),
                                new InputNode(new BigDecimal(0.0, MC), null)
                        )),
                        new ArrayList<>(Arrays.asList(
                                new HiddenNode(null, new ArrayList<>(Arrays.asList(
                                        /* to hidden Node 4*/
                                        new HiddenWeight(new BigDecimal(-0.1, MC)),
                                        new HiddenWeight(new BigDecimal(0.2, MC)),
                                        new HiddenWeight(new BigDecimal(0.8, MC))
                                )), new Bias(new BigDecimal(0.1, MC))),
                                new HiddenNode(null, new ArrayList<>(Arrays.asList(
                                        /* to hidden Node 5*/
                                        new HiddenWeight(new BigDecimal(-0.4, MC)),
                                        new HiddenWeight(new BigDecimal(-0.1, MC)),
                                        new HiddenWeight(new BigDecimal(0.7, MC))
                                )), new Bias(new BigDecimal(0.3, MC)))
                        )),
                        new ArrayList<>(Collections.singletonList(
                                /* to output nodes */
                                new OutputNode(null, new ArrayList<>(Arrays.asList(
                                        new OutputWeight(new BigDecimal(0.3, MC)),
                                        new OutputWeight(new BigDecimal(-0.3, MC))
                                )), new Bias(new BigDecimal(-0.5, MC)))
                        ))
                ));

        start(2, tuples);

    }

    static void start(int epochs, ArrayList<Tuple> tuples) {

        // declare temp variables
        for (int i = 0; i < epochs; i++) {
            System.out.println("Epoch " + i);
            for (Tuple tuple : tuples) {
                Helpers.calcNetIO(tuple.getInputNodes(), tuple.getHiddenNodes());
            }

            // finally update the weights/biases after all tuples processed
            // run until epochs end

        }

    }
}
