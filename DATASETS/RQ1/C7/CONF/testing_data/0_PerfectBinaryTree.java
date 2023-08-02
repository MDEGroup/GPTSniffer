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

    
    public boolean isPerfect(Node root) {
        
        if (root == null) {
            return true;
        }

        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        
        
        if (isPerfect(root.left) && isPerfect(root.right) && isLeaf(root)) {
            return true;
        }

        
        return false;
    }

    
    public boolean isLeaf(Node node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    
    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}















