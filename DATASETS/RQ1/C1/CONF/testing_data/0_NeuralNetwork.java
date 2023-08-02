import java.util.Arrays;

public class NeuralNetwork {
    // Number of input, hidden, and output neurons
    private final int inputSize;
    private final int hiddenSize;
    private final int outputSize;
    // Weights and biases
    private final double[][] weightsInputHidden;
    private final double[] biasesHidden;
    private final double[][] weightsHiddenOutput;
    private final double[] biasesOutput;

    public NeuralNetwork(int inputSize, int hiddenSize, int outputSize) {
        this.inputSize = inputSize;
        this.hiddenSize = hiddenSize;
        this.outputSize = outputSize;
        // Initialize weights and biases with random values
        this.weightsInputHidden = new double[inputSize][hiddenSize];
        for (int i = 0; i < inputSize; i++) {
            for (int j = 0; j < hiddenSize; j++) {
                this.weightsInputHidden[i][j] = Math.random();
            }
        }
        this.biasesHidden = new double[hiddenSize];
        Arrays.fill(this.biasesHidden, Math.random());
        this.weightsHiddenOutput = new double[hiddenSize][outputSize];
        for (int i = 0; i < hiddenSize; i++) {
            for (int j = 0; j < outputSize; j++) {
                this.weightsHiddenOutput[i][j] = Math.random();
            }
        }
        this.biasesOutput = new double[outputSize];
        Arrays.fill(this.biasesOutput, Math.random());
    }

    public double[] predict(double[] inputs) {
        // Perform the feedforward calculation
        double[] hidden = new double[hiddenSize];
        for (int i = 0; i < hiddenSize; i++) {
            for (int j = 0; j < inputSize; j++) {
                hidden[i] += inputs[j] * weightsInputHidden[j][i];
            }
            hidden[i] += biasesHidden[i];
            // Apply the activation function
            hidden[i] = sigmoid(hidden[i]);
        }
        double[] output = new double[outputSize];
        for (int i = 0; i < outputSize; i++) {
            for (int j = 0; j < hiddenSize; j++) {
                output[i] += hidden[j] * weightsHiddenOutput[j][i];
            }
            output[i] += biasesOutput[i];
            // Apply the activation function
            output[i] = sigmoid(output[i]);
        }
        return output;
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }
}

