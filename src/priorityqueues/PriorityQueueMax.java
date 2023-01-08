package priorityqueues;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueueMax<T> {
    private ArrayList<Element<T>> heap;

    public PriorityQueueMax() {
        heap = new ArrayList<>();
    }

    //Method To Insert Element in Heap
    public void insert(T value, int priority) {
        Element<T> elem = new Element<>(value, priority);
        heap.add(elem);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0) {
            if (heap.get(childIndex).priority > heap.get(parentIndex).priority) {
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

    //Method that will remove the Max Element;
    public T remove(){
        T removed = heap.get(0).value;
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int parentIndex = 0;
        int leftChildIndex = (2*parentIndex)+1;
        int rightChildIndex = (2*parentIndex)+2;
        while (leftChildIndex< heap.size()){
            int maxIndex=parentIndex;
            if(heap.get(leftChildIndex).priority>heap.get(maxIndex).priority){
                maxIndex=leftChildIndex;
            }
            if(rightChildIndex<heap.size() &&heap.get(rightChildIndex).priority>heap.get(maxIndex).priority){
                maxIndex=leftChildIndex;
            }
            if(maxIndex==parentIndex){
                break;
            }
            Element<T>temp = heap.get(parentIndex);
            heap.set(parentIndex,heap.get(maxIndex));
            heap.set(maxIndex,temp);
            parentIndex=maxIndex;
            leftChildIndex=(2*parentIndex)+1;
            rightChildIndex = (2*parentIndex)+2;
        }
        return removed;
    }

    //Method To check if Heap is Empty.
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    //Method that returns the size .
    public int getSize() {
        return heap.size();
    }

    //Method That Will return Max Element.
    public T getMax() {
//        if (heap.isEmpty()) {
//            throw new PriorityQueueException();
//        }
        return heap.get(0).value;
    }
}
