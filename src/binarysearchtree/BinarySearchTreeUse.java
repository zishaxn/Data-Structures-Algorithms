package binarysearchtree;

public class BinarySearchTreeUse {
    public static void main(String[] args) {
        BinarySearchTree<Integer> b1 = new BinarySearchTree<>();
        b1.insert(50);
        b1.insert(40);
        b1.insert(60);
        b1.insert(30);
        b1.insert(45);
        b1.insert(55);
        b1.insert(75);
        b1.printTree();
        System.out.println();
        System.out.println(b1.getSize());
        System.out.println(b1.delete(60));
        System.out.println(b1.getSize());
        b1.printTree();


    }


}
