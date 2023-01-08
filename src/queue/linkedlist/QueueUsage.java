package queue.linkedlist;

import queue.array.QueueEmptyException;

public class QueueUsage {
    public static void main(String[] args) throws QueueEmptyException {
        QueueUsingLL<Integer> q = new QueueUsingLL<>();
        q.enqueue(10);
        System.out.println(q.dequeue());
    }
}
