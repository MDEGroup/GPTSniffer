package ch_25.exercise25_02;


public class Exercise25_02 {

    public static void main(String[] args) {
        BST<Integer> test = new BST<>();
        test.insert(50);
        test.insert(40);
        test.insert(60);
        test.insert(30);
        test.insert(42);
        test.insert(54);
        test.insert(62);
        System.out.println(" The Binary Search Tree is " + (test.isFullBST() ? "full." : ""));
    }
}
