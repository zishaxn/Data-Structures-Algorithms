package queue.array;

public class QueueUsingArraysUsage {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        QueueUsingArray q = new QueueUsingArray(3);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);


        System.out.println(3%6);


    }
}
