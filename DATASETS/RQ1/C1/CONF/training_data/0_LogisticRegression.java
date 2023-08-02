import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.apache.commons.math3.fitting.SimpleCurveFitter;
import org.apache.commons.math3.fitting.CurveFitter;
import org.apache.commons.math3.analysis.function.Logistic;

public class LogisticRegression {
    public static void main(String[] args) {
        // Generate some sample data
        WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(1, 0.1);
        obs.add(2, 0.2);
        obs.add(3, 0.3);
        obs.add(4, 0.4);
        obs.add(5, 0.5);

        // Fit the data to a logistic function
        CurveFitter<Logistic.Parametric> fitter = SimpleCurveFitter.create(new Logistic.Parametric(), obs.toList());
        double[] bestFit = fitter.fit();

        // Print the results
        System.out.println("a = " + bestFit[0]);
        System.out.println("b = " + bestFit[1]);
        System.out.println("c = " + bestFit[2]);
    }
}

