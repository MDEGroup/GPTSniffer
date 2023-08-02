import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.ComputationGraphConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.ConvolutionLayer;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;

public class ConvolutionalNeuralNetwork {

    public static void main(String[] args) throws Exception {
        int nChannels = 1;
        int outputNum = 10;
        int batchSize = 64;
        int nEpochs = 1;
        int iterations = 1;

        MnistDataSetIterator mnistTrain = new MnistDataSetIterator(batchSize, true, 12345);
        MnistDataSetIterator mnistTest = new MnistDataSetIterator(batchSize, false, 12345);

        ComputationGraphConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(12345)
                .iterations(iterations)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .learningRate(0.1)
                .updater(Updater.NESTEROVS)
                .list()
                .layer(0, new ConvolutionLayer.Builder(5, 5)
                        .nIn(nChannels)
                        .stride(1, 1)
                        .nOut(20)
                        .activation(Activation.RELU)
                        .build())
                .layer(1, new DenseLayer.Builder()
                        .nOut(500)
                        .activation(Activation.RELU)
                        .build())
                .layer(2, new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD)
                        .nOut(outputNum)
                        .activation(Activation.SOFTMAX)
                        .build())
                .setInputType(InputType.convolutionalFlat(28, 28, 1))
                .backprop(true).pretrain(false).build();

        ComputationGraph model = new ComputationGraph(conf);
        model.init();
        model.setListeners(new ScoreIterationListener(1));

        for (int i = 0; i < nEpochs; i++) {
            while (mnistTrain.hasNext()) {
                DataSet trainData = mnistTrain.next();
                model.fit(trainData);
            }
            mnistTrain.reset();
        }

        // Evaluate the model on the test set
        Evaluation eval = new Evaluation(outputNum);
        while (mnistTest.hasNext()) {
            DataSet testData = mnistTest.next();
            INDArray features = testData.getFeatures();
            INDArray labels = testData.getLabels();
            INDArray predicted = model.outputSingle(features);
            eval.eval(labels, predicted);
        }
        mnistTest.reset();
        System.out.println(eval.stats());
    }
}

