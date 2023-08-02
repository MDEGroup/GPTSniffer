
public class LinearRegression {
    public static void main(String[] args) {
        
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {2, 4, 6, 8, 10};
        
        
        SimpleCurveFitter fitter = SimpleCurveFitter.create(new org.apache.commons.math3.fitting.PolynomialCurveFitter.Order(1));
        
        
        WeightedObservedPoints obs = new WeightedObservedPoints();
        for (int i = 0; i < x.length; i++) {
            obs.add(x[i], y[i]);
        }
        
        
        double[] bestFit = fitter.fit(obs.toList());
        
        
        double slope = bestFit[1];
        double intercept = bestFit[0];
        
        
        System.out.println("Slope: " + slope);
        System.out.println("Intercept: " + intercept);
    }
}

