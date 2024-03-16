import java.util.*;public class BST {        public static void main(String[] args) {        Scanner scanner = new Scanner(System.in);        System.out.println("This program stores 10 integers in a binary search tree and displays them in inorder traversal.");                ArrayList<Integer> inputList = new ArrayList<>();                for (int i = 0; i < 10; i++) {            System.out.print("Please enter integer number " + (i + 1) + ": ");            int num = scanner.nextInt();            inputList.add(num);        }                TreeNode root = createBinarySearchTree(inputList);        System.out.println("Inorder traversal of the binary search tree:");        inorderTraversal(root);    }    static class TreeNode {        int value;        TreeNode left;        TreeNode right;        TreeNode(int value) {            this.value = value;        }    }    public static TreeNode createBinarySearchTree(ArrayList<Integer> elements) {        TreeNode root = null;        for (int element : elements) {            root = insertElement(root, element);        }        return root;    }    public static TreeNode insertElement(TreeNode root, int element) {        if (root == null) {            return new TreeNode(element);        }        if (element < root.value) {            root.left = insertElement(root.left, element);        } else if (element > root.value) {            root.right = insertElement(root.right, element);        }        return root;    }    public static void inorderTraversal(TreeNode root) {        Stack<TreeNode> stack = new Stack<>();        TreeNode current = root;                while (current != null || !stack.isEmpty()) {            while (current != null) {                stack.push(current);                current = current.left;            }            current = stack.pop();            System.out.print(current.value + " ");            current = current.right;        }    }}