class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Returns true if the given tree is perfect
    public boolean isPerfect(Node root) {
        // An empty tree is perfect
        if (root == null) {
            return true;
        }

        // Get the height of left and right sub-trees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // If the height of left and right sub-trees differ more than 1,
        // the tree is not perfect
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // If the left and right sub-trees are perfect and the current node
        // is a leaf node, the tree is perfect
        if (isPerfect(root.left) && isPerfect(root.right) && isLeaf(root)) {
            return true;
        }

        // If none of the above conditions are true, the tree is not perfect
        return false;
    }

    // Returns true if the given node is a leaf node
    public boolean isLeaf(Node node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    // Returns the height of the given tree
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}



// The isPerfect method takes the root of a binary tree as input and returns true if the tree is perfect, and false otherwise. It uses recursion to check if the tree is perfect by checking the following conditions:

// The left and right sub-trees have the same height
// The left and right sub-trees are perfect
// The current node is a leaf node
// The method uses two helper methods, isLeaf and height, to check if a node is a leaf node and to find the height of the tree respectively.

// The isLeaf method checks if a node is a leaf node by checking if it has no children.
// The height method finds the height of the tree by recursively calling the method on the left and right children of a node and returning the maximum height.

// This program uses a class `Node

