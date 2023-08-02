import org.apache.commons.math3.fitting.SimpleCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class LinearRegression {
    public static void main(String[] args) {
        // create some sample data
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 6, 8, 10};
        
        // create a fitter
        SimpleCurveFitter fitter = SimpleCurveFitter.create(new org.apache.commons.math3.fitting.PolynomialCurveFitter.Order(1));
        
        // add data
        WeightedObservedPoints obs = new WeightedObservedPoints();
        for (int i = 0; i < x.length; i++) {
            obs.add(x[i], y[i]);
        }
        
        // fit the data
        double[] bestFit = fitter.fit(obs.toList());
        
        // get the coefficients
        double slope = bestFit[1];
        double intercept = bestFit[0];
        
        // print the results
        System.out.println("Slope: " + slope);
        System.out.println("Intercept: " + intercept);
    }
}

