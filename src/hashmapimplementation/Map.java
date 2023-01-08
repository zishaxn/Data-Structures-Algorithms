package hashmapimplementation;

import java.util.ArrayList;
import java.util.HashMap;

public class Map<K, V> {
    ArrayList<HashMapNode<K, V>> buckets;
    int count;
    int numOfBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numOfBuckets = 20;
        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(null);
        }
    }




    //--------------------------------------------------------------------------------------------//
    /* This Method Will Take Key & value and add it to a respective index in the array list(HashMap).
     * Each Index in ArrayList is in itself a LinkedList*/
    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashMapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        HashMapNode<K, V> newNode = new HashMapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        count++;
    }


    //This Method Will Return Index In Array Where The New Node Has To Be Inserted.
    private int getBucketIndex(K key) {
        int hc = key.hashCode();
        int index = hc % numOfBuckets;
        return index;
    }

}
