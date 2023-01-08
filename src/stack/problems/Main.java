package stack.problems;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] data = {1, 2, 3, 4, 5, 6};  //raw data

        //loop for inserting all elements
        for (int i : data) {
            stack.push(i); // here elements are inserted on top most index of stack
        }

        // insert element at particular index.
        stack.add(1, 50);

        //search and returns element at particular index // if not then -1.
        System.out.println(stack.search(10));

        //returns top-most(Latest) element in stack
        System.out.println(stack.peek());

        //Deleted top-most  element and returns deleted element.
        while (!stack.isEmpty()) {
            System.out.println("Size: "+stack.size()+ " Value: " + stack.pop());
        }


    }
}
