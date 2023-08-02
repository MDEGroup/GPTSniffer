



public class BERTClassifier {

    public static void main(String[] args) throws IOException {

        
        BERT bert = BERT.fromPretrained("bert-base-uncased");
        
        List<String> dataset = Arrays.asList("This is a positive review.", "This is a negative review.");

        
        TokenizerFactory tokenizerFactory = new DefaultTokenizerFactory();
        tokenizerFactory.setTokenPreProcessor(new CommonPreprocessor());

        
        bert.prepareForClassification();

        
        for (String text : dataset) {
            
            List<String> tokens = tokenizerFactory.create(text).getTokens();
            
            INDArray input = bert.getWordEmbeddings(tokens).getFirst();
            
            INDArray output = bert.classify(input);
            
            System.out.println(output);
        }
    }

