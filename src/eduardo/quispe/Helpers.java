package eduardo.quispe;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Helpers{

    // round up to nearest 1000th
    private final static MathContext MC   = new MathContext(3,RoundingMode.HALF_UP);

    private Helpers(){}

    // I_j=Σ_i w_ij O_i+θ_j
    public static BigDecimal calcWeight(ArrayList<BigDecimal> weights, ArrayList<BigDecimal> outputs, BigDecimal bias){

        BigDecimal bd = new BigDecimal(1);

        if (weights.size() != outputs.size()){
            return BigDecimal.valueOf(Long.MAX_VALUE);
        }

        for (int i = 0; i < weights.size() - 1; i++) {
            bd = weights.get(i).multiply(outputs.get(i));
        }

        for (BigDecimal weight: weights) {
            // mult weight*output

        }

        return null;
    }

    public static BigDecimal updateWeight(){
        return null;
    }

    public static BigDecimal updateBias(){
        return null;
    }

    public static BigDecimal calcBias(){
        return null;
    }

    public static BigDecimal calcOutput(){

        return null;
    }

    public static BigDecimal calcError(){
        // hidden node
        // Err_j=O_j (1-O_j ) Σ_k Err_k w_jk

        // output node
        // Err_k=O_k (1-O_k)(T_k-O_k)

        return null;
    }

}