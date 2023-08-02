
public class CNN {

    public MultiLayerNetwork buildNetwork(int height, int width, int channels, int numLabels) {
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .seed(123)
            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
            .weightInit(WeightInit.XAVIER)
            .updater(new Nesterovs(0.01, 0.9))
            .list()
            .layer(0, new ConvolutionLayer.Builder(5, 5)
                .nIn(channels)
                .stride(1, 1)
                .nOut(20)
                .activation(Activation.IDENTITY)
                .build())
            .layer(1, new DenseLayer.Builder().activation(Activation.RELU)
                .nOut(50).build())
            .layer(2, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                .nOut(numLabels)
                .activation(Activation.SOFTMAX)
                .build())
            .setInputType(InputType.convolutional(height, width, channels))
            .build();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();

        return model;
    }
}

