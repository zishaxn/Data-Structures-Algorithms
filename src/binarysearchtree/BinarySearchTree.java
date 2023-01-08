package binarysearchtree;

import binarytree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T> {
    private int size;

    private BinaryTreeNode<Integer> root;

    //--------------------------------------------------------------------------------------------------//
    //This Method will return true if given element is present in tree
    public boolean isPresent(int data) {
        return isPresentHelper(root, data);
    }

    //Helper function for isPresent Method.
    private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        if (node.data > data) {
            //call on left side
            return isPresentHelper(node.left, data);
        } else {
            //call on right side
            return isPresentHelper(node.right, data);
        }
    }

    //--------------------------------------------------------------------------------------------------//
    //This Method will Create a node with given element.
    // And Insert the Node with Element in the tree according to the BST logic.
    public void insert(int data) {
        root = insertHelper(root, data);
        size++;
    }

    //Helper Function for inserting an Element in BST.
    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
            return newRoot;
        }
        if (root.data < x) {
            root.right = insertHelper(root.right, x);
        } else {
            root.left = insertHelper(root.left, x);
        }
        return root;
    }

    //--------------------------------------------------------------------------------------------------//
    //This Method will Delete the Given Node and return false if element not present.
    public boolean delete(int data) {
        BinaryTreeNode<Integer> newRoot = deleteHelper(root, data);
        root = newRoot;
        if(!isPresent(data)){
            size--;
            return true;
        }
        else{
            return false;
        }
    }

    private static BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> node, int x) {
        if (node == null) return null;
        if (node.data == x) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            int max = maximum(node);
            node.data = max;
            node.right = deleteHelper(node.right, max);
            return node;
        } else if (node.data > x) {
            node.left = deleteHelper(node.left, x);
        } else {
            node.right = deleteHelper(node.right, x);
        }
        return node;
    }

    private static int maximum(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int maxLeft = maximum(node.left);
        int maxRight = maximum(node.right);
        return Math.max(node.data, Math.max(maxLeft, maxRight));
    }

    //--------------------------------------------------------------------------------------------------//
    //This Method will return size of tree
    public int getSize() {
        return size;
    }

    //--------------------------------------------------------------------------------------------------//
    //This Method will print Current tree In Level Order Traversal.
    public void printTree() {
        printHelper(root);
    }

    //This is a Helper Function for Printing Tree
    public static void printHelper(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);
        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.print(front.data + ":");
            if (front.left != null) {
                System.out.print("L:" + front.left.data + ",");
                pendingChildren.add(front.left);
            } else {
                System.out.print("L:-1");
            }
            if (front.right != null) {
                System.out.print("R:" + front.right.data);
                pendingChildren.add(front.right);
            } else {
                System.out.print("R:-1");
            }
            System.out.println();
        }
    }

    //--------------------------------------------------------------------------------------------------//

}
