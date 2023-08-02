import org.deeplearning4j.graph.api.IGraph;
import org.deeplearning4j.graph.api.Vertex;
import org.deeplearning4j.graph.data.GraphLoader;
import org.deeplearning4j.graph.iterators.GraphWalkIterator;
import org.deeplearning4j.graph.model.GraphVec;
import org.deeplearning4j.graph.model.GraphVec.GraphVecHelper;
import org.deeplearning4j.graph.vertexfactory.StringVertexFactory;
import org.nd4j.linalg.api.ndarray.INDArray;

public class GNNExample {

    public static void main(String[] args) {
        
        IGraph<String, String> graph = GraphLoader.loadGraphEdgeListFile("path/to/graph.txt", true, new StringVertexFactory());

        
        int dimensions = 128;
        
        
        GraphVec<String, String> graphVec = new GraphVec<>(graph, dimensions);
        
        
        graphVec.fit(new GraphWalkIterator<>(graph, 3, false));
        
        
        INDArray nodeEmbeddings = graphVec.getVertexVectors();
        
        
        INDArray edgeEmbeddings = graphVec.getEdgeVectors();
        
        
        
    }
}

