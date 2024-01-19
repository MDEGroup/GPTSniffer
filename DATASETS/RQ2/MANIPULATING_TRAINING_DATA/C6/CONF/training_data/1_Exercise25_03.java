



import java.util.Scanner;


public class Node{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten integers: ");
        BST<Integer> binarySearchTree = new BST<>();
        String[] line = input.nextLine().split(" ");

        for (String str : line) {
            binarySearchTree.insert(Integer.valueOf(str));
        }
        System.out.println("Root is: " + binarySearchTree.root.element);
        binarySearchTree.inorder();

    }
}
