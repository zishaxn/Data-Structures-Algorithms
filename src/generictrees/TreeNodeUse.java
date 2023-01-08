package generictrees;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;


public class TreeNodeUse {
    public static void main(String[] args) {
        TreeNode<Integer> root = create();
        printLevelWise(root);
        System.out.println();

     printLevelWise(removeLeafNodes(root));
    }

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root)
    { if(root==null){ return null;}// if root is null return null
        if(root.children.size()==0){// if root itself is leaf return null
            return null;}
        // if root.children is a leaf node
        // then delete it from children vector
        for (int i = 0; i < root.children.size(); i++) {

            TreeNode<Integer> child= root.children.get(i);

            // if it is a leaf
            if (child.children.size() == 0) {

                // shifting the vector to left
                // after the point i
                for (int j = i; j < root.children.size() - 1; j++)
                    root.children.set(j, root.children.get(j + 1));

                // delete the last element
                root.children.remove(root.children.size()-1);

                i--;
            }
        }

        // Remove all leaf node
        // of children of root
        for (int i = 0;
             i < root.children.size();
             i++) {

            // call function for root.children
            root.children.set(i,removeLeafNodes(root.children.get(i)));
        }
        return root;
    }












    //---------------------------------------------------------------------------------//
    /*Given a generic tree, count and return the number of leaf nodes present in the given tree.*/
    public static int countLeafNodes(TreeNode<Integer> root) {
        if (root.children.size() == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < root.children.size(); i++) {
            count += countLeafNodes(root.children.get(i));
        }
        return count;
    }

    /* Given a generic tree, find and return the node with second-largest value in given tree.
    Return NULL if no node with required value is present.*/
    //---------------------------------------------------------------------------------//
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        if (root.children.size() == 0) {
            return null;
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        TreeNode<Integer> fl = root, sl = null;
        int data = 0;
        queue.add(root);
        //queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode<Integer> frontNode = queue.poll();
//             if(frontNode == null){
//                 if(queue.isEmpty()){
//                     break;
//                 }

//                 queue.add(null);
//             }
//             else{
            for (int i = 0; i < frontNode.children.size(); i++) {
                queue.add(frontNode.children.get(i));
            }

            if (frontNode.data > data) {
                if (frontNode.data > fl.data) {
                    sl = fl;
                    data = fl.data;
                    fl = frontNode;
                } else if (frontNode.data < fl.data) {
                    sl = frontNode;
                    data = sl.data;
                }
            }
            // if(fl.data<frontNode.data)
            // {
            //     sl=fl;
            //  fl=frontNode;
            // }
            // else if(sl.data<frontNode.data){
            //     sl=frontNode;
            // }


        }
        return sl;
    }


    //---------------------------------------------------------------------------------//
    /*Given a generic tree and an integer n.
     Find and return the node with next larger element in the Tree i.e.
    find a node with value just greater than n.*/
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        if (root == null) {
            return null;
        }
        if (root.data > n) {
            return root;
        }
        while (pendingNodes.size() != 0) {
            TreeNode<Integer> front = pendingNodes.poll();
            for (int i = 0; i < front.children.size(); i++) {
                pendingNodes.add(front.children.get(i));
                if (front.children.get(i).data > n) {
                    return front.children.get(i);
                }
            }
        }
        return null;
    }

    //---------------------------------------------------------------------------------//
    /* Given two Generic trees, return true if they are structurally identical i.e.
    they are made of nodes with the same values arranged in the same way.*/
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if (root1.children.size() != root2.children.size()) {
            return false;
        }
        if (!Objects.equals(root1.data, root2.data)) {
            return false;
        }
        for (int i = 0; i < root1.children.size(); i++) {
            boolean isIdentical = checkIdentical(root1.children.get(i), root2.children.get(i));
            if (!isIdentical) {
                return false;
            }
        }
        return Objects.equals(root1.data, root2.data);

    }

    //---------------------------------------------------------------------------------//
    /* Given a tree, find and return the node for which sum of data of all children and the node itself is maximum.
     In the sum, data of node itself and data of immediate children is to be taken.*/

    public static maxNodePair<Integer> maxSumNodeBetter(TreeNode<Integer> root) {
        if (root == null) {
            maxNodePair<Integer> ans = new maxNodePair<>();
            ans.node = null;
            ans.sum = Integer.MIN_VALUE;
            return ans;
        }
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            sum += root.children.get(i).data;
        }
        maxNodePair<Integer> ans = new maxNodePair<>();
        ans.sum = sum;
        ans.node = root;
        for (int i = 0; i < root.children.size(); i++) {
            maxNodePair<Integer> child = maxSumNodeBetter(root.children.get(i));
            if (child.sum > ans.sum) {
                ans = child;
            }
        }
        return ans;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        // Write your code here
        return maxSumNode(root,0);
    }

    // Helper class for implementing above function
    static class maxNodePair<T> {
        int sum;
        TreeNode<Integer> node;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root, int maxSum) {

        if (root.children.size() == 0) {
            return null;

        }

        TreeNode<Integer> maxNode = null;
        int tempSum = root.data;
        for (int i = 0; i < root.children.size(); ++i) {
            tempSum += root.children.get(i).data;
        }
        if (tempSum > maxSum) {
            maxSum = tempSum;
            maxNode = root;

        }
        //  System.out.println("MaxNum now for "+root.data+" is: "+ maxSum);

        for (int i = 0; i < root.children.size(); ++i) {
            TreeNode<Integer> temp = maxSumNode(root.children.get(i), maxSum);
            if (temp == null) {
                continue;
            }
            maxNode = temp;
        }
        return maxNode;
    }

    //---------------------------------------------------------------------------------//
    /*Given a generic tree and an integer x, check if x is present in the given tree or not.
    Return true if x is present, return false otherwise.*/
    public static boolean checkIfContainsX(TreeNode<Integer> node, int x) {
        if (node.data == x) {
            return true;
        }
        for (int i = 0; i < node.children.size(); i++) {
            boolean isPresent = checkIfContainsX(node.children.get(i), x);
            if (isPresent) {
                return true;
            }
        }
        return false;
    }

    //---------------------------------------------------------------------------------//
   /* Given a generic tree, print the post-order traversal of given tree.
    The post-order traversal is: visit child nodes first and then root node.*/
    public static void printPostOrder(TreeNode<Integer> root) {
        for (int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data + " ");
    }


    //---------------------------------------------------------------------------------//
    /* Given a generic tree, print the input tree in level wise order.
    That is, print the elements at same level in one line (separated by space).
    Print different levels in different lines.*/
    public static void printLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);
        while (!pendingChildren.isEmpty()) {
            int childCount = pendingChildren.size();
            while (childCount > 0) {
                TreeNode<Integer> front = pendingChildren.poll();
                assert front != null;
                System.out.print(front.data + " ");
                childCount--;
                pendingChildren.addAll(front.children);
            }
            System.out.println();
        }
    }

    //---------------------------------------------------------------------------------//
    /* Given a tree and an integer x, find and return number of Nodes which are greater than x.*/
    public static int numNodeGreater(TreeNode<Integer> root, int x) {
        if (root == null)
            return 0;

        int count = 0;

        // If current root is greater
        // than x increment count
        if (root.data > x)
            count++;

        // Recursively calling for every
        // child of current root

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            count += numNodeGreater(child, x);
        }

        // Return the count
        return count;

    }


    //---------------------------------------------------------------------------------//
    /* This Method Will Return Height Of Tree.*/
    public static int getHeight(TreeNode<Integer> root) {
        int height = 0;
        if (root == null) return 0;
        if (root.children.size() == 0) return 1;
        for (int i = 0; i < root.children.size(); i++) {
            int temp = getHeight(root.children.get(i));
            if (temp > height) {
                height = temp;
            }
        }
        return height + 1;
    }

    //---------------------------------------------------------------------------------//
    /* This Method Will Take Input for Tree in Level Wise Manner.*/
    public static TreeNode<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        Queue<TreeNode<Integer>> pendingChildren = new LinkedList<>();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        pendingChildren.add(root);
        while (!pendingChildren.isEmpty()) {
            TreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter Number Of Children of " + front.data);
            int nums = s.nextInt();
            for (int i = 0; i < nums; i++) {
                System.out.println("Enter " + i + "th child of " + front.data);
                int childData = s.nextInt();
                TreeNode<Integer> child = new TreeNode<>(childData);
                front.children.add(child);
                pendingChildren.add(child);
            }
        }
        return root;
    }

    //---------------------------------------------------------------------------------//
    /* Given a generic tree, count and return the sum of all nodes present in the given tree.*/
    public static int sumOfAllNode(TreeNode<Integer> root) {
        int sum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            int countChildren = sumOfAllNode(root.children.get(i));
            sum += countChildren;
        }
        return sum;

    }

    //---------------------------------------------------------------------------------//
    /* This Method Will Return No Of Nodes In a Given Tree.*/
    public static int numOfNodes(TreeNode<Integer> root) {
        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            int countChildren = numOfNodes(root.children.get(i));
            count += countChildren;
        }
        return count;
    }

    //---------------------------------------------------------------------------------//
    /* This Method Will Print Tree In MOre Specific Way */
    public static void printTreeSpecific(TreeNode<Integer> root) {
        if (root == null) return;
        System.out.print(root.data + ":");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTreeSpecific(child);
        }
    }


    //---------------------------------------------------------------------------------//
    /*This Method Will Print Tree In Preorder*/
    public static void printTree(TreeNode<Integer> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }


    //---------------------------------------------------------------------------------//
    /*Simple Method That Has Returns the root of PreDefined Tree.
     * It Has root and all its Children
     */
    public static TreeNode<Integer> create() {
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> node1 = new TreeNode<>(20);
        TreeNode<Integer> node2 = new TreeNode<>(30);
        TreeNode<Integer> node3 = new TreeNode<>(40);
        TreeNode<Integer> node4 = new TreeNode<>(22);
        TreeNode<Integer> node5 = new TreeNode<>(80);
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);
        return root;
    }


}
