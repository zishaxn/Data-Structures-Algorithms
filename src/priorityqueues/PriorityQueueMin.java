package priorityqueues;

import java.util.ArrayList;

//Class for Implementing Priority Queues.
public class PriorityQueueMin<T> {
    private ArrayList<Element<T>> heap; //Arraylist for Maintaining Heaps.

    public PriorityQueueMin() {
        heap = new ArrayList<>();
    }

    //Method To Insert Element in Heap
    public void insert(T value, int priority) {
        Element<T> elem = new Element<>(value, priority);  //Creating an object of Element class .
        heap.add(elem);                                    //Adding in Arraylist
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    //Method to remove Minimum Element from Heap.
    public T removeMin() throws PriorityQueueException {
        if (heap.isEmpty()) {
            throw new PriorityQueueException();
        }
        //  Element<T> removed =
        T removedValue = heap.get(0).value;
        //removed.value;
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int parentIndex = 0;
        //(2*parentIndex)+1,2
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while (leftChildIndex < heap.size()) {
            int minIndex = parentIndex;
            if (heap.get(leftChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).priority < heap.get(minIndex).priority) {
                minIndex = rightChildIndex;
            }
            if (minIndex == parentIndex) {
                break;
            }
            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = minIndex;
            leftChildIndex = (2 * parentIndex) + 1;
            rightChildIndex = (2 * parentIndex) + 2;
        }
        return removedValue;
    }

    //Method to return Minimum Element.
    public T getMin() throws PriorityQueueException {
        if (heap.isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0).value;
    }

    //Returns Size of Heap.
    public int getSize() {
        return heap.size();
    }

    //Checks if Heap is Empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

}
