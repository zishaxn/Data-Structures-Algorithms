package binarytree;

import generictrees.TreeNode;
import linkedlist.LinkedListNode;

import java.util.*;

public class BinaryTreeUse {


    //Main Method
    public static void main(String[] args) {
       int []arr = {0,1,2,3};
        System.out.println(missingNumber(arr));


    }


    public static int missingNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i =0;i<nums.length;i++) {
            map.put(nums[i],1);
        }
        for(int i =1;i<=nums.length;i++) {
            if(!map.containsKey(i)) {
                return i;
            }
        }
        return -1;
    }


    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root) {
// If root is null means there
        // is no binary tree so
        // return an empty vector
        if (root == null) {
            ArrayList<Integer> output = new ArrayList<>();
            return output;
        }

        // Recursive call on root.right
        ArrayList<Integer> right = longestRootToLeafPath(root.right);

        // Recursive call on root.left
        ArrayList<Integer> left = longestRootToLeafPath(root.left);

        // Compare the size of the two ArrayList
        // and insert current node accordingly
        if (right.size() < left.size()) {
            left.add(root.data);
        } else {
            right.add(root.data);
        }

        // Return the appropriate ArrayList
        return (left.size() >
                right.size() ? left : right);
    }


    /* Given the binary Tree and two nodes say ‘p’ and ‘q’.
    Determine whether the two nodes are cousins of each other or not.
    Two nodes are said to be cousins of each other
    if they are at same level of the Binary Tree and have different parents.*/
    public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
        //We Will Check if Both Nodes Are at The Same Depth .
        int depthP = findDepth(root, p);
        int depthQ = findDepth(root, q);
        return depthQ == depthP;
    }

    //Depth of a Node In Binary Tree.
    private static int findDepth(BinaryTreeNode<Integer> root, int x) {
        // Base case
        if (root == null)
            return -1;

        // Initialize distance as -1
        int dist = -1;

        // Check if x is current node=
        if ((root.data == x) || (dist = findDepth(root.left, x)) >= 0 || (dist = findDepth(root.right, x)) >= 0) {
            // Return depth of the node
            return dist + 1;
        }

        return dist;
    }


    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        return largestBSTBT(root)[2];
    }

    private static int[] largestBSTBT(BinaryTreeNode<Integer> root) {
        // Base cases : When tree is empty or it has one
        // child.
        if (root == null)
            return new int[]{Integer.MAX_VALUE,
                    Integer.MIN_VALUE, 0};
        if (root.left == null && root.right == null)
            return new int[]{root.data, root.data, 1};

        // Recur for left subtree and right subtrees
        int[] left = largestBSTBT(root.left);
        int[] right = largestBSTBT(root.right);

        // Create a return variable and initialize its size.
        int[] ans = new int[3];

        // If whole tree rooted under current root is BST.
        if ((left[1] < root.data)
                && (right[0] > root.data)) {
            ans[0] = Math.min(
                    left[0], Math.min(right[0], root.data));
            ans[1] = Math.max(right[1],
                    Math.max(left[1], root.data));

            // Update answer for tree rooted under current
            // 'root'
            ans[2] = 1 + left[2] + right[2];
            return ans;
        }

        // If whole tree is not BST, return maximum of left
        // and right subtrees
        ans[0] = Integer.MIN_VALUE;
        ans[1] = Integer.MAX_VALUE;
        ans[2] = Math.max(left[2], right[2]);

        return ans;
    }


    /*Given a binary tree, write code to create a separate linked list for each level.
     You need to return the array which contains head of each level linked list.*/
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {

        ArrayList<LinkedListNode<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedListNode<Integer> level = new LinkedListNode<>(0);
            LinkedListNode<Integer> head = null;
            while (size-- > 0) {
                BinaryTreeNode<Integer> temp = q.poll();
                assert temp != null;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
                if (head == null) {
                    LinkedListNode<Integer> newNode = new LinkedListNode<>(temp.data);
                    level = newNode;
                    head = newNode;
                } else {
                    LinkedListNode<Integer> newNode = new LinkedListNode<>(temp.data);
                    level.next = newNode;
                    level = level.next;
                }
            }
            ans.add(head);
        }
        return ans;
    }


    private static BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> node, int x) {
        if (node == null) return node;
        if (node.data == x) {
            if (node.left == null && node.right == null) {
                node = null;
                return node;
            }
            if (node.left == null) {
                BinaryTreeNode<Integer> tempRight = node.right;
                node = node.right;
                node.right = tempRight;
                return node;
            }
            if (node.right == null) {
                BinaryTreeNode<Integer> tempLeft = node.left;
                node = node.left;
                node.left = tempLeft;
                return node;
            }
            BinaryTreeNode<Integer> tempLeft = node.left;
            node = node.right;
            node.left = tempLeft;
            return node;

        } else if (node.data > x) {
            node.left = deleteHelper(node.left, x);
        } else {
            node.right = deleteHelper(node.right, x);
        }
        return node;
    }


    //This Method Will Insert An Element in the Binary Tree.It will add according to the BST logic.
    public static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
            return newRoot;
        }
        if (root.data <= x) {
            root.right = insert(root.right, x);
        } else {
            root.left = insert(root.left, x);
        }
        return root;
    }


    //Print Path to a given node in tree
    public static ArrayList<Integer> pathToK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) return null;

        if (root.data == k) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> left = pathToK(root.left, k);
        if (left != null) {
            left.add(root.data);
            return left;
        }
        ArrayList<Integer> right = pathToK(root.right, k);
        if (right != null) {
            right.add(root.data);
            return right;
        }
        return null;
    }

    public static void printNums(BinaryTreeNode<Integer> root, int k, int l) {
        if (root == null) return;
        if (root.data >= k && root.data <= l) {
            System.out.print(root.data + " ");
        }
        printNums(root.left, k, l);
        printNums(root.right, k, l);
    }

    //You are given a Binary Tree of type integer, a target node, and an integer value K.
    //Print the data of all nodes that have a distance K from the target node.
    // The order in which they would be printed will not matter.
    // https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626447/problem/81
    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        print(root, node, k);
    }

    public static void printatdepthk(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.data);
            return;
        }
        printatdepthk(root.left, k - 1);
        printatdepthk(root.right, k - 1);
    }

    public static int print(BinaryTreeNode<Integer> root, int node, int k) {
        //Your code goes here
        if (root == null) {
            return -1;
        }
        if (root.data == node) {
            printatdepthk(root, k);
            return 0;
        }
        int ld = print(root.left, node, k);
        if (ld != -1) {
            if (ld + 1 == k) {
                System.out.println(root.data);
            } else {
                printatdepthk(root.right, k - ld - 2);
            }
            return ld + 1;
        }
        int rd = print(root.right, node, k);
        if (rd != -1) {
            if (rd + 1 == k) {
                System.out.println(root.data);
            } else {
                printatdepthk(root.left, k - rd - 2);
            }
            return rd + 1;
        }
        return -1;
    }


    //For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list,
    // create the binary tree using the given two arrays/lists.
    // You just need to construct the tree and return the root.
    public static BinaryTreeNode<Integer> buildTreeInOrderPostOrder(int[] postOrder, int[] inOrder) {
        if (inOrder == null || postOrder == null || inOrder.length != postOrder.length) return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            hm.put(inOrder[i], i);
        }
        return buildTreeHelperInOrderPostOrder(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, hm);
    }

    private static BinaryTreeNode<Integer> buildTreeHelperInOrderPostOrder(int[] inOrder, int is, int ie, int[] postOrder, int ps, int pe, HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(postOrder[pe]);
        int inRoot = hm.get(postOrder[pe]);
        int numsLeft = inRoot - is;
        root.left = buildTreeHelperInOrderPostOrder(inOrder, is, inRoot - 1, postOrder, ps, ps + numsLeft - 1, hm);
        root.right = buildTreeHelperInOrderPostOrder(inOrder, inRoot + 1, ie, postOrder, ps + numsLeft, pe - 1, hm);
        return root;
    }

    //Build Tree Using InOrder and PostOrder ,without using hashMaps !!
    public static BinaryTreeNode<Integer> buildTreePostOrderInOrder(int[] postOrder, int[] inOrder) {
        return buildTreeHelperPostOrderInOrder(inOrder, postOrder, 0, inOrder.length - 1, 0, postOrder.length - 1);
    }

    private static BinaryTreeNode<Integer> buildTreeHelperPostOrderInOrder(int[] inOrder, int[] postOrder, int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) {
            return null;
        }
        int rootData = postOrder[postOrderEnd];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int rootIndex = -1;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) {
            return null;
        }
        int rightInOrderStart = rootIndex + 1;
        int rightInOrderEnd = inOrderEnd;
        int rightPostOrderEnd = postOrderEnd - 1;
        int rightPostOrderStart = rightInOrderStart - rightInOrderEnd + rightPostOrderEnd;


        int leftInOrderStart = inOrderStart;
        int leftInOrderEnd = rootIndex - 1;
        int leftPostOrderStart = postOrderStart;
        int leftPostOrderEnd = rightPostOrderStart - 1;

        root.left = buildTreeHelperPostOrderInOrder(inOrder, postOrder, leftInOrderStart, leftInOrderEnd, leftPostOrderStart, leftPostOrderEnd);
        root.right = buildTreeHelperPostOrderInOrder(inOrder, postOrder, rightInOrderStart, rightInOrderEnd, rightPostOrderStart, rightPostOrderEnd);
        return root;
    }


    //For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list,
    // create the binary tree using the given two arrays/lists.
    // You just need to construct the tree and return the root.
    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626443/problem/100
    private static BinaryTreeNode<Integer> buildTreeInOrderPreOrder(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }
        BinaryTreeNode<Integer> root = buildTreeHelperInorderPreOrder(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inMap);
        return root;
    }

    private static BinaryTreeNode<Integer> buildTreeHelperInorderPreOrder(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[preStart]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;
        root.left = buildTreeHelperInorderPreOrder(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, inRoot - 1, inMap);
        root.right = buildTreeHelperInorderPreOrder(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, inMap);
        return root;
    }


    //Build Tree Using InOrder and PreOrder ,without using hashMaps !!
    public static BinaryTreeNode<Integer> buildTreePreOrderInOrder(int[] preOrder, int[] inOrder) {
        return buildTreeHelperPreOrderInOrder(inOrder, preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1);
    }

    private static BinaryTreeNode<Integer> buildTreeHelperPreOrderInOrder(int[] inOrder, int[] preOrder, int inOrderStart, int inOrderEnd, int preOrderStart, int preOrderEnd) {
        if (inOrderStart > inOrderEnd) {
            return null;
        }
        int rootData = preOrder[preOrderStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        int rootIndex = -1;
        for (int i = inOrderStart; i <= inOrderEnd; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) {
            return null;
        }
        int leftInOrderStart = inOrderStart;
        int leftInOrderEnd = rootIndex - 1;
        int leftPreOrderStart = preOrderStart + 1;
        int leftPreOrderEnd = leftInOrderEnd - leftInOrderStart + leftPreOrderStart;
        int rightInOrderStart = rootIndex + 1;
        int rightInOrderEnd = inOrderEnd;
        int rightPreOrderStart = leftPreOrderEnd + 1;
        int rightPreOrderEnd = preOrderEnd;

        root.left = buildTreeHelperPreOrderInOrder(inOrder, preOrder, leftInOrderStart, leftInOrderEnd, leftPreOrderStart, leftPreOrderEnd);
        root.right = buildTreeHelperPreOrderInOrder(inOrder, preOrder, rightInOrderStart, rightInOrderEnd, rightPreOrderStart, rightPreOrderEnd);
        return root;
    }

    /*For a given Binary Tree of type integer and a number K,
    print out all root-to-leaf paths where the sum of all the node data along the path is equal to K.*/
    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626447/problem/107
    public static void rootToLeafPathsSumToKBetter(BinaryTreeNode<Integer> root, int k) {
        rootToLeafPathsSumToKBetter(root, k, "", 0);
    }

    private static void rootToLeafPathsSumToKBetter(BinaryTreeNode<Integer> root, int k, String path, int currSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            currSum += root.data;
            if (currSum == k) {
                System.out.println(path + root.data + " ");
            }

            return;
        }
        rootToLeafPathsSumToKBetter(root.left, k, (path + root.data + " "), (currSum + root.data));
        rootToLeafPathsSumToKBetter(root.right, k, (path + root.data + " "), (currSum + root.data));
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

    //For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
    //Return the output as an object of Pair class, which is already created.
    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626447/problem/1567
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        if (root == null) {
            Pair<Integer, Integer> ans = new Pair<>(Integer.MAX_VALUE, Integer.MIN_VALUE);
            return ans;
        }
        Pair<Integer, Integer> leftNode = getMinAndMax(root.left);
        Pair<Integer, Integer> rightNode = getMinAndMax(root.right);
        Pair<Integer, Integer> ans = new Pair<>(Math.min(root.data, Math.min(leftNode.minimum, rightNode.minimum)), Math.max(root.data, Math.max(leftNode.maximum, rightNode.maximum)));
        return ans;
    }

    private static int minNode(BinaryTreeNode<Integer> root) {
        if (root == null) return Integer.MAX_VALUE;
        int left = minNode(root.left);
        int right = minNode(root.right);
        return Math.min(root.data, Math.min(left, right));
    }

    private static int maxNode(BinaryTreeNode<Integer> root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = maxNode(root.left);
        int right = maxNode(root.right);
        return Math.max(root.data, Math.max(left, right));
    }

    //For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
    //The root will remain the same. So you just need to insert nodes in the given Binary Tree.
    //Don't forget to store address of node's left you are going to replace.so that you can attach it for later
    //Complexity : Time : O(n) ,Space : O(h)
    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626447/problem/512
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        insertDuplicateNode(root.left);
        insertDuplicateNode(root.right);
        BinaryTreeNode<Integer> oldLeft = root.left;
        BinaryTreeNode<Integer> newLeftNode = new BinaryTreeNode<>(root.data);
        root.left = newLeftNode;
        root.left.left = oldLeft;
    }

    //This Method Will print Tree Elements in Level-Wise
    //Complexity : Time : O(n) ,Space : O(n)
    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626440/problem/1568
    public static void printLevelWiseSpecific(BinaryTreeNode<Integer> root) {
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

    //This Method will take Input level-wise
    //Time Complexity --> O(n) & Space Complexity --> O(n)
    //Refer to Notes for Understanding.
    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data");
        int rootData = s.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);
        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter left data of " + front.data);
            int left = s.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }
            System.out.println("Enter right data of " + front.data);
            int right = s.nextInt();
            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }
        }
        return root;
    }


    //For a given Binary of type integer, find and return the ‘Diameter’.//
    /* The diameter of a tree can be defined as the maximum distance between two leaf nodes.
    Here, the distance is measured in terms of the total number of nodes present along
    the path of the two leaf nodes, including both the leaves.*/
//    https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626437/problem/1157
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int curr = height(root.left) + height(root.right) + 1;
        return Math.max(curr, Math.max(leftDiameter, rightDiameter));
    }

    //Checks if given tree is balanced.said to be balance only if [height(leftSubTree)-height(rightSubtree)<=1]
    //this condition should be met at every level.
    //we have optimized code here for --> Time Complexity --> O(n) & Space complexity--> O(h) height of tree for recursion
    //Check Notebook for reference
    public static IsBalancedBinaryNode isBalancedBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            IsBalancedBinaryNode ans = new IsBalancedBinaryNode();
            ans.height = 0;
            ans.isBalanced = true;
            return ans;
        }
        IsBalancedBinaryNode leftOutput = isBalancedBetter(root.left);
        IsBalancedBinaryNode rightOutput = isBalancedBetter(root.right);
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);
        boolean isBal = true;
        if (Math.abs(leftOutput.height - rightOutput.height) > 1) {
            isBal = false;
        }
        if (!leftOutput.isBalanced || !rightOutput.isBalanced) {
            isBal = false;
        }

        IsBalancedBinaryNode ans = new IsBalancedBinaryNode();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }

    //Checks if given tree is balanced.said to be balance only if [height(leftSubTree)-height(rightSubtree)<=1]
    //this condition should be met at every level.
    //logic is to check at first root then if passes their then move down
    //after root go to left and right and if both are true then only return true else false
    //Time Complexity --> O(n*h) or O(n2) or O(nlogn) as ,Space complexity--> O(h) height of tree for recursion

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) return true;   //null tree is also true.

        //finding left & right height
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        //we will move forward only if diff of L & R height is less than or equal to 1 .
        //Here we used a method that will return absolute value i.e.true in both cases if left is bigger or right.
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        //As root is balanced now will look for left and right via recursion.
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        //return true only if both are true.
        return isLeftBalanced && isRightBalanced;

    }

    /*  For a given Binary Tree of type integer, update it with its corresponding mirror image */
    /* Only Logic we have here is we link left of root to right of root via "left.right =left" .*/
    /* We will Traverse till end of both sides and simply return nodes and then link with other side*/
    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395340/offering/5626432/problem/580

    public static void mirrorBinaryTree1(BinaryTreeNode<Integer> root) {
        mirror(root);
    }

    public static BinaryTreeNode<Integer> mirror(BinaryTreeNode<Integer> node) {
        if (node == null)
            return node;

        /* do the subtrees */
        BinaryTreeNode<Integer> left = mirror(node.left);
        BinaryTreeNode<Integer> right = mirror(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }


    //This Method Removes The Leaf LinkedListNode and Returns the Root of Modified Tree.
    //Time Complexity --> O(n) as ,Space complexity--> O(h) height of tree for recursion
    public static BinaryTreeNode<Integer> removeLeafRoot(BinaryTreeNode<Integer> root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeafRoot(root.left);
        root.right = removeLeafRoot(root.right);
        return root;
    }

    //For a given Binary Tree of type integer, print all the nodes without any siblings.
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null) return;

        if (root.left != null && root.right != null) {
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
        } else if (root.right != null) {
            System.out.println(root.right.data + " ");
            printNodesWithoutSibling(root.right);

        } else if (root.left != null) {
            System.out.println(root.left.data + " ");
            printNodesWithoutSibling(root.left);
        }
    }

    //For a given a Binary Tree of integers, replace each of its data with the depth of the tree.
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        replaceNodesWithDepth(root, 0);
        postOrder(root);
    }

    private static void replaceNodesWithDepth(BinaryTreeNode<Integer> root, int depthLevel) {
        if (root == null) {
            return;
        }
        root.data = depthLevel;
        replaceNodesWithDepth(root.left, depthLevel + 1);
        replaceNodesWithDepth(root.right, depthLevel + 1);
    }


    //Root is Present
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {  // if our root itself is Equal to Element
            return true;
        }

        //We didn't find value from root ,so now we will look in left side of root.
        boolean leftSide = isNodePresent(root.left, x);
        if (leftSide) return true;     //this will execute only if left side of root has value

        //We didn't find value from left side of root ,so now we will look in right side of root.
        boolean rightSide = isNodePresent(root.right, x);
        return rightSide;
    }

    //Print Nodes at K depth
    public static void printKDepthNodes(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.data + " ");
        }
        printKDepthNodes(root.left, k - 1);
        printKDepthNodes(root.right, k - 1);

    }

    //Number of Leaf Nodes.
    public static int numOfLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return numOfLeafNodes(root.left) + numOfLeafNodes(root.right);

    }

    //Length of Binary Tree
    //After base condition count (1+length of right ) & (1+length of left ) & then return Max.
    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395339/offering/5626424/problem/1564
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;
        int leftHeight = 1 + height(root.left);
        int rightHeight = 1 + height(root.right);
        return Math.max(leftHeight, rightHeight);
    }

    //Number of Nodes Greater than number X .
    //First We Will Check then perform Recursion
    // https://classroom.codingninjas.com/app/classroom/me/19853/content/395339/offering/5626421/problem/1155
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }
        if (root.data > x) {
            return 1 + countNodesGreaterThanX(root.left, x) + countNodesGreaterThanX(root.right, x);
        } else {
            return countNodesGreaterThanX(root.left, x) + countNodesGreaterThanX(root.right, x);
        }
    }

    //Largest LinkedListNode in the Tree
    //simple only difference return Max of 3 Numbers
    public static int largestNodeElement(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }
        int leftLargest = largestNodeElement(root.left);
        int rightLargest = largestNodeElement(root.right);
        return Math.max(root.data, Math.max(leftLargest, rightLargest));
    }


    //https://classroom.codingninjas.com/app/classroom/me/19853/content/395339/offering/5626415/problem/351
    //Sum of All The Elements in a LinkedListNode.
    //We will add root Data to results received from sum of left and right nodes
    public static int getSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return root.data + leftSum + rightSum;
    }


    //Counts And Returns Number Of Nodes in Tree.
    //we will add 1 to results received from leftNoOfNodes & rightNoOfNodes
    public static int numNodes(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;  //base case

        int numLeft = numNodes(root.left);  //this will return count of all left nodes
        int numRight = numNodes(root.right); //this will return count of all right nodes
        return 1 + numLeft + numRight;  //We will add to returned numbers (1 for the root node in a particular call)
    }


    //Take Input but in Better Way.
    public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter Root Data");
        } else {
            if (isLeft) {
                System.out.println("Enter Left Data of " + parentData);
            } else {
                System.out.println("Enter Right Data of " + parentData);
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        if (rootData == -1) return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> rootLeft = takeInputBetter(false, rootData, true);
        BinaryTreeNode<Integer> rootRight = takeInputBetter(false, rootData, false);
        root.left = rootLeft;
        root.right = rootRight;
        return root;
    }


    //This Method Will take Binary Tree Input
    public static BinaryTreeNode<Integer> takeTreeInput() {
        System.out.println("Enter Root Data");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    //Level Wise Binary Tree Print.
    public static void levelWise(BinaryTreeNode<Integer> root) {

    }

    //postOrder Binary Tree Print.
    public static void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //In-order Binary Tree Print
    public static void inOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);

    }

    //Preorder Binary Tree Print
    public static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //This Method Prints Elements but in a specific way i.e. also the left and right of a root
    //It prints root and also their left and right node along with them.
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) return;
        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("L" + root.left.data + ",");
        }
        if (root.right != null) {
            System.out.print("R" + root.right.data);
        }
        System.out.println("");
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);

    }

    // Predefined Tree Input Method
    //In This Method I have  already Created A binary tree with 6 Nodes
    public static BinaryTreeNode<Integer> treeInput() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);  //Creating Root of the tree
        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(20);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(30);
        root.left = rootLeft;  //making connections
        root.right = rootRight;
        BinaryTreeNode<Integer> rootLeftChildRight = new BinaryTreeNode<>(50);
        BinaryTreeNode<Integer> rootLeftChildLeft = new BinaryTreeNode<>(40);
        BinaryTreeNode<Integer> rootRightChildRight = new BinaryTreeNode<>(60);
        rootLeft.right = rootLeftChildRight;
        rootLeft.left = rootLeftChildLeft;
        rootRight.right = rootRightChildRight;
        return root;
    }
}