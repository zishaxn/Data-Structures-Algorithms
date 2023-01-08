package linkedlist;

import java.util.Scanner;

public class LinkedList {

    //A simple  method for Beginner that is taking input and making connections.
    // it is just a function that already has inputs . This will explain how nodes are
    //connected and how next works.
    public static LinkedListNode<Integer> create() {
        LinkedListNode<Integer> n1 = new LinkedListNode<>(5);
        LinkedListNode<Integer> n2 = new LinkedListNode<>(4);
        LinkedListNode<Integer> n3 = new LinkedListNode<>(3);
        LinkedListNode<Integer> n4 = new LinkedListNode<>(2);
        LinkedListNode<Integer> n5 = new LinkedListNode<>(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
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
        LinkedListNode<Integer> initialHead = head;
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
    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
        if (head == null) {
            return head;
        }
        if (pos == 0) {
            head = head.next;
            return head;
        } else {
            int count = 0;
            LinkedListNode<Integer> prev = head;
            while (prev != null && count < pos - 1) {
                count++;
                prev = prev.next;
            }
            if (prev == null) {
                return head;
            }
            if (prev.next != null) {
                prev.next = prev.next.next;
            }
            if (prev.next == null) {
                return head;
            }

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

    // MAIN FUNCTION
    public static void main(String[] args) {
      LinkedListNode<Integer> head =   create();
       display(head);

    }

}

