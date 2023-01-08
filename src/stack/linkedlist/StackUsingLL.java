package stack.linkedlist;

import stack.arrays.StackEmptyException;

public class StackUsingLL {
    public static void main(String[] args)throws StackEmptyException {
        StackUsage<Integer> s = new StackUsage<>();
        int[] data = {1,2,3,4,5,6};
        for (int i : data) {
            s.push(i);
        }

        while(!s.isEmpty()){
            System.out.println("Size is: "+s.size());
            System.out.println(s.pop());
            System.out.println(s.top());
        }

    }


}