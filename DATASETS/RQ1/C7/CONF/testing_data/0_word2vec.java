

public class Word2Vec {

    public static void main(String[] args) throws Exception {
        
        SentenceIterator iter = new BasicLineIterator(new File("text_file.txt"));

        
        TokenizerFactory t = new DefaultTokenizerFactory();
        t.setTokenPreProcessor(new CommonPreprocessor());

        
        VocabCache<VocabWord> cache = new AbstractCache<>();

        
        WeightLookupTable<VocabWord> table = new InMemoryLookupTable.Builder<VocabWord>()
                .vectorLength(100)
                .useAdaGrad(false)
                .cache(cache)
                .lr(0.025f).build();

        
        SequenceVectors<VocabWord> vectors = new SequenceVectors.Builder<VocabWord>(new VectorsConfiguration())
                .minWordFrequency(5)
                .iterations(1)
                .epochs(1)
                .layerSize(100)
                .lookupTable(table)
                .stopWords(new ArrayList<String>())
                .vocabCache(cache)
                .windowSize(5)
                .iterate(iter)
                .tokenizerFactory(t)
                .build();

        
        vectors.fit();

        
        double[] wordVector = vectors.getWordVector("word");
    }
}

