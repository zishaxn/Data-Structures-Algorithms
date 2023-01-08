package binarysearchtree;


import binarytree.BinaryTreeNode;
import linkedlist.LinkedListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


public class BSTUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = treeInput();
        printLevelWiseSimple(root);
        System.out.println(getLCA(root, 30, 0));


    }

    /*Given a BST, convert it into a sorted linked list. You have to return the head of LL.*/
    public static BinaryTreeNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        // Array to store inorder traversal
        ArrayList<Integer> inorderArray = new ArrayList<Integer>();

        inorder(root, inorderArray);

        // Create a pointer called newRoot, and store the first value of the array in it.
        BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(inorderArray.get(0));

        // Create a pointer called curr and store the newRoot in it.
        BinaryTreeNode<Integer> curr = newRoot;

        for (int i = 1; i < inorderArray.size(); i++) {

            // Create a new node.
            BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(inorderArray.get(i));

            // Make the left child of curr as NULL and right child as the temp. And make curr = temp.
            curr.left = null;
            curr.right = temp;
            curr = temp;
        }

        // Make both the left and the right child of the last node as NULL.
        curr.left = null;
        curr.right = null;

        return newRoot;
    }

    public static void inorder(BinaryTreeNode<Integer> root, ArrayList<Integer> inorderArray) {
        if (root == null) {
            return;
        }

        // Recur for left sub-tree
        inorder(root.left, inorderArray);

        // Add current node data to array
        inorderArray.add(root.data);

        // Recur for right sub-tree
        inorder(root.right, inorderArray);
    }


    //Given a binary search tree and data of two nodes, find 'LCA' (The Lowest Common Ancestor) of the given two nodes in the BST.
    //LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants.

    //Here we will Return Node
    public static BinaryTreeNode<Integer> lowestCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q) {
        if (root == null) return null;
        if (Objects.equals(root.data, p.data) || Objects.equals(root.data, q.data)) {
            return root;
        }
        if (root.data > p.data && root.data > q.data) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.data < p.data && root.data < q.data) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    //In this we will return Integer Value of Ancestor.
    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if (root == null) return -1;
        if (root.data == a || root.data == b) {
            return root.data;
        }
        if (root.data > a && root.data > b) {
            return getLCA(root.left, a, b);
        }
        if (root.data < a && root.data < b) {
            return getLCA(root.right, a, b);
        } else return root.data;
    }


    /*Given a sorted integer array A of size n, which contains all unique elements.
     *You need to construct a balanced BST from this input array. Return the root of constructed BST.
     *Note: If array size is even, take first mid as root.
     */
    public static BinaryTreeNode<Integer> SortedArrayToBSTNotWorking(int[] arr, int n) {
        if (arr.length == 0) return null;
        int mid = (n - 1) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
        int[] leftArr = new int[arr.length / 2];
        System.arraycopy(arr, 0, leftArr, 0, arr.length / 2);
        int[] rightArr = new int[arr.length / 2];
        System.arraycopy(arr, mid + 1, rightArr, 0, arr.length / 2);
        BinaryTreeNode<Integer> leftNode = SortedArrayToBSTNotWorking(leftArr, leftArr.length);
        BinaryTreeNode<Integer> rightNode = SortedArrayToBSTNotWorking(rightArr, rightArr.length);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) return null;  //It means that we have reached end of left/right side,so we return null.

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);

        /*Using recursion making the left subtree and attaching it to left of root*/
        root.left = SortedArrayToBST(arr, start, mid - 1);
        /*Using recursion making the right subtree and attaching it to left of root*/
        root.right = SortedArrayToBST(arr, mid + 1, end);
        return root;
    }

    /* Given a binary tree with N number of nodes,
     * check if that input tree is BST (Binary Search Tree).
     *If yes, return true, return false otherwise.
     */
    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE); //helper function
    }

    private static boolean isBST(BinaryTreeNode<Integer> root, long minValue, long maxValue) {
        if (root == null) return true; //it means that all nodes that are checked are fine.
        if (root.data >= maxValue || root.data <= minValue) return false;
        return isBST(root.left, minValue, root.data) && //Here max val is root data because on left side all elements needs to be smaller than the root node.
                isBST(root.right, root.data, maxValue); //Here maximum can be anything but node should be greater than minimum anyhow.
    }

    //Given a Binary Search Tree and two integers k1 and k2,
    // find and print the elements which are in range k1 and k2 (both inclusive).
    // Print the elements in increasing order.

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> node, int k1, int k2) {
        if (node == null) {
            return;
        }
        /* Since the desired o/p is sorted, recurse for left subtree first
         If root->data is greater than k1, then only we can get o/p keys
         in left subtree */
        if (k1 < node.data) {
            elementsInRangeK1K2(node.left, k1, k2);
        }
        /* if root's data lies in range, then prints root's data */
        if (k1 <= node.data && k2 >= node.data) {
            System.out.print(node.data + " ");
        }
        /* recursively call the right subtree  */
        elementsInRangeK1K2(node.right, k1, k2);
    }


    //Given a BST and an integer k. Find if the integer k is present in given BST or not.
    // You have to return true, if node with data k is present, return false otherwise.
    //Note: Assume that BST contains all unique elements.
    //Time Complexity O(H) where H is Height.
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return false; //it means that we have reached till end of tree, and we haven't found node.
        }
        if (root.data == k) {
            return true;
        }
        if (root.data < k) { //it means that given k will maybe on right side .
            return searchInBST(root.right, k);
        }
        return searchInBST(root.left, k);
    }

    //print level wise simple
    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626447/problem/353
    public static void printLevelWiseSimple(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        Queue<BinaryTreeNode<Integer>> pendingChildNodes = new LinkedList<>();
        pendingChildNodes.add(root);
        while (!pendingChildNodes.isEmpty()) {
            int nodeCount = pendingChildNodes.size();
            while (nodeCount > 0) {
                BinaryTreeNode<Integer> front = pendingChildNodes.poll();
                assert front != null;
                System.out.print(front.data + " ");
                if (front.left != null) {
                    pendingChildNodes.add(front.left);
                }
                if (front.right != null) {
                    pendingChildNodes.add(front.right);
                }
                nodeCount--;
            }
            System.out.println();
        }
    }

    public static BinaryTreeNode<Integer> treeInput() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(40);  //Creating Root of the tree
        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(30);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(50);
        root.left = rootLeft;  //making connections
        root.right = rootRight;
        BinaryTreeNode<Integer> rootLeftChildRight = new BinaryTreeNode<>(35);
        BinaryTreeNode<Integer> rootLeftChildLeft = new BinaryTreeNode<>(25);
        BinaryTreeNode<Integer> rootRightChildRight = new BinaryTreeNode<>(60);
        BinaryTreeNode<Integer> rootRightChildLeft = new BinaryTreeNode<>(45);
        rootLeft.right = rootLeftChildRight;
        rootLeft.left = rootLeftChildLeft;
        rootRight.right = rootRightChildRight;
        rootRight.left = rootRightChildLeft;
        return root;
    }
}
