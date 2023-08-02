
class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BST {
    Node root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public void inorder() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}

public class TestBST {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = input.nextInt();
        }
        BST bst = new BST();
        for (int num : nums) {
            bst.insert(num);
        }
        System.out.print("Inorder traversal: ");
        bst.inorder();
    }
}
