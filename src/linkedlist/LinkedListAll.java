package linkedlist;

import java.util.Scanner;

public class LinkedListAll {

    //A simple  method for Beginner that is taking input and making connections.
    // it is just a function that already has inputs . This will explain how nodes are
    //connected and how next works.
    public static LinkedListNode<Integer> create() {

        LinkedListNode<Integer> n1 = new LinkedListNode<>(1);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(2);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(3);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(4);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(5);
        LinkedListNode<Integer> n6 = new LinkedListNode<>(6);
        // n6.next = n5;
        n5.next = n4;
        n4.next = n3;
        n3.next = n2;
        n2.next = n1;
        return n5;
    }

    // A Method that will display elements connected to next of each other.
    //this method will take a variable of LinkedListNode type and then will print all the elements
    //from that node till null encounter.
    public static void display(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    //This method will perform some operations on the data of linked list
    //This is an example that how pass by reference works in java.
    //here we passed head from main method as input to increments.and then
    //
    public static void increments(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            temp.data = head.data + 1;
            temp = temp.next;
        }
    }

    //recursive function for getting size of Linked list
    public static int lengthRecursive(LinkedListNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        return 1 + lengthRecursive(head.next);
    }

    //iterative function for getting size of Linked list
    public static int lengthLoop(LinkedListNode<Integer> head) {
        int size = 0;
        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    //A method that will take multiple inputs of linked list
    //Concept is take input till -1 is encountered
    //if head is null then head and tail will point to same LinkedListNode
    //if head is not null then tail will keep pointing to the LinkedListNode that is last inserted.
    public static LinkedListNode<Integer> takeInput() {
        LinkedListNode<Integer> head = null, tail = null;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Linked List Inputs");
        int data = s.nextInt();
        while (data != -1) {
            LinkedListNode<Integer> currNode = new LinkedListNode<>(data);
            if (head == null) {
                head = currNode;
                tail = currNode;
            } else {
                tail.next = currNode;
                tail = currNode;
            }
            data = s.nextInt();
        }
        return head;
    }


    //This Method Will insert elements at particular indexes.
    //Here We are changing head pointer so we are changing structures of linked list &
    //for that reason we need to have a return type where we will return new position of head.
    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int elem) {
        LinkedListNode<Integer> elemToInsert = new LinkedListNode<>(elem);
        if (pos == 0) {
            elemToInsert.next = head;
            head = elemToInsert;
            return head;
        } else {
            int count = 0;
            LinkedListNode<Integer> prev = head;

            while (count < pos - 1 && prev != null) {
                count++;
                prev = prev.next;
            }
            if (prev != null) {
                elemToInsert.next = prev.next;
                prev.next = elemToInsert;
            }

        }
        return head;
    }

    //This Method will Shift last n Elements to Start of LinkedListNode.
    public static LinkedListNode<Integer> Append(LinkedListNode<Integer> head, int n) {
        if (n == 0 || head == null) {
            return head;
        }
        int count = lengthLoop(head);
        if (count <= n) {
            return null;
        }
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        //  LinkedListNode<Integer> initialHead = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        LinkedListNode<Integer> temp = slow.next;
        slow.next = null;
        fast.next = head;
        head = temp;
        return head;
    }

    // This is Another Approach To Shift Last N elements To Start of NOde
    public static LinkedListNode<Integer> Append1(LinkedListNode<Integer> head, int n) {
        if (n == 0 || head == null) {
            return head;
        }
        int count = lengthLoop(head);
        if (count <= n) {
            return null;
        }
        int skip = count - n;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        while (skip > 0) {
            prev = curr;
            curr = curr.next;
            skip--;
        }
        assert prev != null;
        prev.next = null;
        LinkedListNode<Integer> tempHead = head;
        head = curr;
        while (curr.next != null)
            curr = curr.next;
        curr.next = tempHead;
        return head;
    }

    //This method will delete Data on particular Index of Linked List
    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int index) {
        if (head == null) {
            return head;
        }
        if (index == 0) {
            head = head.next;
            return head;
        }
        int count = 0;
        LinkedListNode<Integer> prevOfPrev = head;
        while (prevOfPrev != null && count < index - 1) {
            count += 1;
            prevOfPrev = prevOfPrev.next;
        }
        if (prevOfPrev == null || prevOfPrev.next == null) {
            return head;
        } else {
            prevOfPrev.next = prevOfPrev.next.next;
        }
        return head;

    }

    //Delete Duplicate //need to work on this method why is it failing
    public static LinkedListNode<Integer> duplicateDelete(LinkedListNode<Integer> head) {
        if (head == null) {
            return head;
        }
        int count = 0;
        LinkedListNode<Integer> temp = head;
        while (temp.next != null) {
            count = count + 1;
            if (temp.next.data == temp.data) {
                temp = deleteNode(head, count++);
            }
            temp = temp.next;
        }
        return head;
    }

    // Delete Duplicate Nodes
    // Here Concept is To use a Curr and Temp Pointer where temp pointer will point to next Non-similar LinkedListNode
    //and then making curr.next to temp
    public static LinkedListNode<Integer> deleteDuplicate(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> curr = head;
        while (curr != null) {
            LinkedListNode<Integer> temp = curr;
            while (temp != null && temp.data.equals(curr.data)) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
        return head;
    }

    //Printing a Linked List In Reverse. Only print is needed not to actually do reverse of LL
    public static void printReverse(LinkedListNode<Integer> head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.data + " --> ");
    }

    ////Printing a Linked List In Reverse. Only print is needed not to actually do reverse of LL
    public static void reversePrintLL(LinkedListNode<Integer> head) {
        if (head == null)
            return;
        else
            System.out.print(head.data + " --> ");
        if (head.next == null) {
            System.out.println("END");
        }
        reversePrintLL(head.next);
    }

    //Inserting Recursively
    public static LinkedListNode<Integer> insertRecursion(LinkedListNode<Integer> head, int value, int index) {
        if (head == null) {
            return head;
        }
        if (index == 0) {
            LinkedListNode<Integer> node = new LinkedListNode<>(value);
            node.next = head;
            return node;
        } else {
            head.next = insertRecursion(head.next, value, index - 1);
        }
        return head;

    }


    //Delete a LinkedListNode Recursively
    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
        if (head == null) {
            return null;
        }
        if (pos == 0) {
            head = head.next;
            return head;
        }
        head.next = deleteNodeRec(head.next, pos - 1);
        return head;
    }


    // Reverse A Linked List
    public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
        if (head == null) {
            return head;
        }
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> present = head;
        LinkedListNode<Integer> next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    // Merge Two Sorted LinkedList in New LInked List
    //In This Approach We use a New LinkedListNode and Inserted nodoes by comparing.
    //here we used a temporary LinkedListNode to iterate over nodes
    public static LinkedListNode<Integer> mergeTwoLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        LinkedListNode<Integer> NewNode = new LinkedListNode<>();
        LinkedListNode<Integer> Start = NewNode;
        while (l1 != null && l2 != null) {
            if (l1.data > l2.data) {
                Start.next = l2;
                l2 = l2.next;
                Start = Start.next;
            } else {
                Start.next = l1;
                l1 = l1.next;
                Start = Start.next;
            }

        }

        if (l1 == null) {
            Start.next = l2;
        } else {
            Start.next = l1;
        }

        return NewNode.next;
    }


    // Merge Two Sorted LinkedList in New LInked List
    //Here We Merged in the same linked list i.e. one of the two linkedlist.
    public static LinkedListNode<Integer> mergeTwoListsInplace(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.data > l2.data) {
            LinkedListNode<Integer> temp = l1;
            l1 = l2;
            l2 = temp;
        }
        LinkedListNode<Integer> res = l1;
        while (l1 != null && l2 != null) {
            LinkedListNode<Integer> tempLast = null;
            while (l1 != null && l1.data <= l2.data) {
                tempLast = l1;
                l1 = l1.next;
            }
            assert tempLast != null;
            tempLast.next = l2;

            //swap
            LinkedListNode<Integer> tempSwap = l1;
            l1 = l2;
            l2 = tempSwap;
        }
        return res;
    }


    // Merge Two Sorted LinkedList in New LInked List
    //Here We use recursion
    public static LinkedListNode<Integer> mergeTwoListsRecursion(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        LinkedListNode<Integer> head;
        if (l1.data < l2.data) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        head.next = mergeTwoListsRecursion(l1, l2);
        return head;
    }


    //return mid-point of a LInked List
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //This Method Will Return if A Given Linked List Is Having a Loop Or Not .
    // We Will Us fast and Slow Pointer
    //If it is a Loop then at One Particular Time Both Pointers Will Meet and We Will Return True in that case else False.
    public static boolean hasCycle(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // This Method Will Return the Index of The LinkedListNode Where Cycle Starts,In linked List
    public static LinkedListNode<Integer> detectCycle(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> fast = head, slow = head, target = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (target != slow) {
                    target = target.next;
                    slow = slow.next;
                }
                return target;
            }
        }
        return null;
    }

    //This Method Will Return Length Of Cycle IN LInked List
    public static int lengthOfCycle(LinkedListNode<Integer> head) {
        int length = 0;
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                do {
                    length++;
                    slow = slow.next;
                } while (slow != fast);
                return length;
            }
        }
        return 0;
    }


    private static LinkedListNode<Integer> detectAndRemoveLoopInLinkedList(LinkedListNode<Integer> startNode) {
        LinkedListNode<Integer> slow = startNode;
        LinkedListNode<Integer> fast = startNode;
        LinkedListNode<Integer> previousPointer = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            previousPointer = fast.next; // For capturing just previous node of loop node for setting it to null for breaking loop.
            fast = fast.next.next;
            if (slow == fast) { // Loop identified.
                slow = startNode;
                //If loop start node is starting at the root LinkedListNode, then we slow pointer, fast pointer and head all point at same location.
                //we already capture previous node, just setting it to null will work in this case.
                if (slow == fast) {
                    previousPointer.next = (null);

                } else {
                    // We need to first identify the start of loop node and then by setting just previous node of loop node next to null.
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    fast.next = (null);
                }
            }
        }
        return startNode;
    }


    //Print linked list.
    private void printList(LinkedListNode<Integer> startNode) {
        while (startNode != null) {
            System.out.print(startNode.data + " ");
            startNode = startNode.next;
        }
    }

    //Happy Number
    public static boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = square(slow);
            fast = square(square(fast));

        } while (fast != slow);
        if (slow == 1) {
            return true;
        }
        return false;
    }

    private static int square(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10;
            rem *= rem;
            ans = ans + rem;
            number = number / 10;
        }
        return ans;

    }

    //Sort a Linked List Using Merge Sort Algorithm
    public static LinkedListNode<Integer> mergeSortLLRecursion(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer> fast = head, slow = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        LinkedListNode<Integer> l1 = mergeSortLL(head);
        LinkedListNode<Integer> l2 = mergeSortLL(slow);

        return mergeTwoLists(l1, l2);
    }

    //Sort a Linked List Using Merge Sort Algorithm without recursion
    public static LinkedListNode<Integer> mergeSortLL(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode<Integer> mid = midPoint(head);
        LinkedListNode<Integer> left = mergeSortLL(head);
        LinkedListNode<Integer> right = mergeSortLL(mid);
        return mergeTwoLists(left, right);

    }


    //Delete N nodes After Every M nodes. // Not Working Need TO work
    public static LinkedListNode<Integer> deleteNNodesSelf(LinkedListNode<Integer> head, int m, int n) {
        LinkedListNode<Integer> temp = head;
        int countNums = m;
        LinkedListNode<Integer> tempPrev = null;
        while (temp != null) {
            if (countNums == 0) {
                LinkedListNode<Integer> tempCurr = temp;
                int countDel = n;
                while (countDel > 0 && tempCurr.next != null) {
                    tempCurr = tempCurr.next;
                    countDel--;
                    countNums = m;
                }
                temp = tempPrev;
                tempPrev.next = tempCurr;
            } else {
                countNums--;
            }
        }
        return head;
    }

    //Delete N nodes After Every M Nodes.
    public static LinkedListNode<Integer> deleteNNodes(LinkedListNode<Integer> head, int m, int n) {
        LinkedListNode<Integer> curr = head, temp;
        int count;
        while (curr != null) {
            //Traversing n times // Skipping n times.
            for (count = 1; count < n && curr != null; count++) {
                curr = curr.next;
            }
            if (curr == null) {
                return head;
            }
            temp = curr.next;
            for (count = 1; count <= m && temp != null; count++) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = temp;
        }
        int cout = Math.max(5, 10);
        return head;
    }

    // K-Reverse // Not Working
    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int n) {
        if (head == null) {
            return null;
        }
        LinkedListNode<Integer> temp = head;
        while (temp != null && n > 0) {
            temp = temp.next;
            System.out.println(temp);
            n--;
        }
        head.next = kReverse(temp, n);
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> present = head;
        LinkedListNode<Integer> next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;

    }


    //k-Reverse // faraz

    //Helper Function For ReverseK group
    public static void reverse(LinkedListNode<Integer> head, LinkedListNode<Integer> end) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> present = head;
        LinkedListNode<Integer> next = head.next;
        while (prev != end) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null)
                next = next.next;
        }

    }

    //in this we reverse pair in k group and remaining node are left untouched
    //e.g 1-->2-->3-->4--5-->6-->-->7-->8-->null k=3 output  3-->2-->1-->6--5-->4-->7-->8-->null
    public static LinkedListNode<Integer> ReverseK(LinkedListNode<Integer> head, int n) {
        if (head == null || head.next == null || n == 1) {
            return head;
        }
        LinkedListNode<Integer> end = head;
        int inc = n - 1;
        while (inc > 0) {
            end = end.next;
            if (end == null) return head;
            inc--;
        }
        LinkedListNode<Integer> nextHead = ReverseK(end.next, n);
        reverse(head, end);
        head.next = nextHead;
        return end;
    }

    //Reverse
    //in this we reverse pair in k group and remaining node are also reversed
    //e.g 1-->2-->3-->4--5-->6-->-->7-->8-->null k=3 output  3-->2-->1-->6--5-->4-->8-->7-->null
    public static LinkedListNode<Integer> ReverseInPairs(LinkedListNode<Integer> head, int k) {
        if (head == null) {
            return null;
        }
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> next = curr.next;
        int count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (curr != null) {
            head.next = ReverseInPairs(next, k);
        }
        return prev;
    }


    //bubble sort
    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
        int len = lengthLoop(head);
        for (int i = 0; i < len - 1; i++) {
            LinkedListNode<Integer> prev = null;
            LinkedListNode<Integer> curr = head;
            for (int j = 0; j < len - i - 1; j++) {
                if (curr.data <= curr.next.data) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    if (prev == null) {
                        LinkedListNode<Integer> next = curr.next;
                        head = head.next;
                        curr.next = next.next;
                        next.next = curr;
                        prev = next;
                    } else {
                        LinkedListNode<Integer> next = curr.next;
                        prev.next = next;
                        curr.next = next.next;
                        next.next = curr;
                        prev = next;
                    }
                }
            }
        }
        return head;
    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null) {
            return true;
        }
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);
        slow = slow.next;
        while (slow != null) {
            if (head.data != slow.data) {
                return false;
            } else {
                slow = slow.next;
                head = head.next;
            }
        }
        return true;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        LinkedListNode<Integer> l1 = takeInput();
        System.out.println(isPalindrome(l1));


    }

}
