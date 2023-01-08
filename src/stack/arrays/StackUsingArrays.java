package stack.arrays;

public class StackUsingArrays {


    // Creating Reference to an Array to Be used AS Stack.
    private int[] data;

    //index at which new Element will be inserted.
    private int topIndex;

    //Constructor
    public StackUsingArrays(int size) {
        data = new int[size]; //stack(Array size initialize)
        topIndex=-1; //initializing topIndex as -1; because if we kept it 0 then if someone tryied to
                    // view element at zeroth index might thorw an error.
    }

    //Inserting an Element at The Top of Stack
    public void push(int elem) {
        //if stack is full i.e.  array length is achieved.
        if(topIndex== data.length-1){
          doubleCapacity();
        }

        data[++topIndex] = elem; //preIncrement operator

    }

    private void doubleCapacity() {
        System.out.println("DOUBLE");
        int[]temp = data;
        data=new int[2* temp.length];
        System.arraycopy(temp, 0, data, 0, temp.length);

    }

    public int size() {
        return topIndex+1; // as indexing starts from zero so adding 1 to give size;
    }

    public int pop() throws StackEmptyException {
        if(topIndex==-1){
            //throw exception
            throw new StackEmptyException();
        }
        int temp = data[topIndex];
        topIndex--;
        return temp;

    }

    public int top() throws StackEmptyException{
        if(topIndex==-1){
            //throw exception
            throw new StackEmptyException();
        }
        return data[topIndex];

    }

    public boolean isEmpty() {
        return topIndex==-1;
    }
}
