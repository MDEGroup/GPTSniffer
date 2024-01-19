class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public boolean isFullBinaryTree(Node node) {
        // If the tree is empty, it is a full binary tree
        if (node == null) {
            return true;
        }

        // If both the left and right subtrees are null, it is a leaf node
        if (node.left == null && node.right == null) {
            return true;
        }

        // If either the left or right subtree is null, it is not a full binary tree
        if (node.left == null || node.right == null) {
            return false;
        }

        // Recursively check if both the left and right subtrees are full binary trees
        return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        if (tree.isFullBinaryTree(tree.root)) {
            System.out.println("The tree is a full binary tree.");
        } else {
            System.out.println("The tree is not a full binary tree.");
        }
    }
}