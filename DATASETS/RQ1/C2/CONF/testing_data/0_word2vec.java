import org.deeplearning4j.models.embeddings.WeightLookupTable;
import org.deeplearning4j.models.embeddings.inmemory.InMemoryLookupTable;
import org.deeplearning4j.models.embeddings.learning.impl.elements.CBOW;
import org.deeplearning4j.models.embeddings.loader.VectorsConfiguration;
import org.deeplearning4j.models.sequencevectors.SequenceVectors;
import org.deeplearning4j.models.sequencevectors.iterators.AbstractSequenceIterator;
import org.deeplearning4j.models.sequencevectors.transformers.impl.SentenceTransformer;
import org.deeplearning4j.models.word2vec.VocabWord;
import org.deeplearning4j.models.word2vec.wordstore.VocabCache;
import org.deeplearning4j.models.word2vec.wordstore.inmemory.AbstractCache;
import org.deeplearning4j.text.sentenceiterator.BasicLineIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;

import java.io.File;
import java.util.Collection;

public class Word2Vec {

    public static void main(String[] args) throws Exception {
        // Setup SentenceIterator
        SentenceIterator iter = new BasicLineIterator(new File("text_file.txt"));

        // Setup Tokenizer
        TokenizerFactory t = new DefaultTokenizerFactory();
        t.setTokenPreProcessor(new CommonPreprocessor());

        // Build VocabCache
        VocabCache<VocabWord> cache = new AbstractCache<>();

        // Build WeightLookupTable
        WeightLookupTable<VocabWord> table = new InMemoryLookupTable.Builder<VocabWord>()
                .vectorLength(100)
                .useAdaGrad(false)
                .cache(cache)
                .lr(0.025f).build();

        // Build SequenceVectors
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

        // Start training
        vectors.fit();

        // Get word vectors
        double[] wordVector = vectors.getWordVector("word");
    }
}

