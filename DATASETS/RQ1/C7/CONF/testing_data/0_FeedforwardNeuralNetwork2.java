
public class FeedForwardNeuralNetwork {

    public static void main(String[] args) throws Exception {
        int nIn = 784;
        int nOut = 10;
        int batchSize = 64;
        int nEpochs = 1;
        int iterations = 1;

        MnistDataSetIterator mnistTrain = new MnistDataSetIterator(batchSize, true, 12345);
        MnistDataSetIterator mnistTest = new MnistDataSetIterator(batchSize, false, 12345);

        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
                .seed(12345)
                .iterations(iterations)
                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
                .learningRate(0.1)
                .updater(Updater.NESTEROVS)
                .list()
                .layer(0, new DenseLayer.Builder()
                        .nIn(nIn)
                        .nOut(500)
                        .activation(Activation.RELU)
                        .build())
                .layer(1, new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD)
                        .nIn(500)
                        .nOut(nOut)
                        .activation(Activation.SOFTMAX)
                        .build())
                .backprop(true).pretrain(false).build();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        model.setListeners(new ScoreIterationListener(1));

        for (int i = 0; i < nEpochs; i++) {
            while (mnistTrain.hasNext()) {
                DataSet trainData = mnistTrain.next();
                model.fit(trainData);
            }
            mnistTrain.reset();
        }

        
        Evaluation eval = new Evaluation(nOut);
        while (mnistTest.hasNext()) {
            DataSet testData = mnistTest.next();
            INDArray features = testData.getFeatures();
            INDArray labels = testData.getLabels();
            INDArray predicted = model.output(features, false);
            eval.eval(labels, predicted);
        }
        mnistTest.reset();
        System.out.println(eval.stats());
    }
}


