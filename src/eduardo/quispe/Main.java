package eduardo.quispe;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Tuple.TupleDefinition tupleDefintion = Tuple.TupleDefinition.createTupleDefinition(3, 2, 1);
        ArrayList<Tuple> tuples = new ArrayList<>();

        tuples.add(new Tuple(
                tupleDefintion,
                new BigDecimal(0.5),
                new BigDecimal(0),
                new BigDecimal(0.2),
                new BigDecimal(0.3),
                new BigDecimal(-0.5),
                new BigDecimal(0.1),
                new BigDecimal(0.3),
                new BigDecimal(-0.8),
                new BigDecimal(0.2),
                new BigDecimal(-0.7),
                new BigDecimal(0.4),
                new BigDecimal(1)   // class
        ));

    }

    static void start(int epochs, ArrayList<Tuple> tuples) {

        // decalre temp variables
        for (int i = 0; i < epochs; i++) {

            for (Tuple tuple : tuples) {

                // run algorithm,

                // sum in variables

            }
            // finally update the weights/biases after all tuples processed
            // run until epochs end

        }

    }

}
