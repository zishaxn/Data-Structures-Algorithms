package queue.array;

public class QueueUsingArray {
    private int[] data;
    private int front; // Index of Element at the front.
    private int rear;  // Index of Element at the Rear.

    private int size;

    public QueueUsingArray() {
        data = new int[5];
        front = -1;
        rear = -1;
    }

    public QueueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size() {
        return size;
    }

    // if Queue is empty or not
    public boolean isEmpty() {
        return size == 0;
    }

    // Insert an Element at front
    public void enqueue(int elem)  {
        if (size == data.length) {
           // throw new QueueFullException();
           doubleCapacity(data);
        }
        if (size == 0) {
            front = 0;
        }
//        rear++;
//        if(rear== data.length){
//            rear=0;
//        }
        rear = (rear + 1) % data.length;
        data[rear] = elem;
        size++;

    }

    private void doubleCapacity(int[]arr) {
        System.out.println("double");
        int[]temp = data;
        data=new int[2*temp.length];
        System.arraycopy(temp,0,data,0,temp.length);
    }

    //Delete element
    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int temp = data[front];
        //front++;
//        if(front== data.length){
//            front=0;
//        }

        front = (front + 1) % data.length;

        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }

    //return element at front
    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[0];
    }


}