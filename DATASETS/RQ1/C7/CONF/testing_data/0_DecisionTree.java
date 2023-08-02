
public class DecisionTree {
    private Node root;

    public DecisionTree(Node root) {
        this.root = root;
    }

    public int predict(Map<String, Object> input) {
        Node current = root;
        while (current.getClassification() == null) {
            String feature = current.getFeature();
            Object value = input.get(feature);
            current = current.getChild(value);
        }
        return current.getClassification();
    }

    private static class Node {
        private String feature;
        private Map<Object, Node> children;
        private Integer classification;

        public Node(String feature, Map<Object, Node> children, Integer classification) {
            this.feature = feature;
            this.children = children;
            this.classification = classification;
        }

        public String getFeature() {
            return feature;
        }

        public Node getChild(Object value) {
            return children.get(value);
        }

        public Integer getClassification() {
            return classification;
        }
    }
}

