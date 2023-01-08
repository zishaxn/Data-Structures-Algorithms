package stack.linkedlist;

import stack.arrays.StackEmptyException;

public class StackUsage<T> {
    private Node<T> head;
    private int size;

    //constructor

    public StackUsage() {
        this.head = null;
        this.size = 0;
    }

    //Getting the size of Stack
    public int size() {
        return size;
    }

    //Inserting an Element at the Top of Stack
    public void push(T elem) {
        Node<T> node = new Node<>(elem);
        node.next = head;
        head = node;
        size++;
    }

    //display Current Element in stack
    public T top()throws StackEmptyException {
        if(head==null){
            throw new StackEmptyException();
        }
        return head.data;
    }

    //Delete top element or current element from stack
    public T pop() throws StackEmptyException {
        if(head==null){
            throw new StackEmptyException();
        }
       T temp =  head.data;
       head=head.next;
       size--;
       return temp;
    }

    //Returns true if stack is empty
    public boolean isEmpty() {
        return head==null;
    }


    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
