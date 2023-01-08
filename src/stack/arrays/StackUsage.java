package stack.arrays;

public class StackUsage {
    public static void main(String[] args) throws StackFullException,StackEmptyException {
        StackUsingArrays stack = new StackUsingArrays(5);
       int[]arr = {1,2,3,4,5,6};
       for(int i : arr ){
           stack.push(i);
       }
       while(!stack.isEmpty()){
           System.out.println(stack.pop());
       }


    }
}
