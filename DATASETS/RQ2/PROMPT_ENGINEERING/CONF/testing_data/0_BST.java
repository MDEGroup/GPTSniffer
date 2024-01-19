import java.util.*;

public class BinarySearchTree {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 10 integers:");
        ArrayList<Integer> inputList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int num = scanner.nextInt();
            inputList.add(num);
        }
        
        TreeNode root = createBST(inputList);
        System.out.println("Inorder traversal of the tree:");
        inorderTraversal(root);
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static TreeNode createBST(ArrayList<Integer> elements) {
        TreeNode root = null;
        for (int element : elements) {
            root = insert(root, element);
        }
        return root;
    }

    public static TreeNode insert(TreeNode root, int element) {
        if (root == null) {
            return new TreeNode(element);
        }
        if (element < root.value) {
            root.left = insert(root.left, element);
        } else if (element > root.value) {
            root.right = insert(root.right, element);
        }
        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }
}