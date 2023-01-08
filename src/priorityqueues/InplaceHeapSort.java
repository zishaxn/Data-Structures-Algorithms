package priorityqueues;
import java.util.Arrays;

public class InplaceHeapSort {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        inplaceHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void inplaceHeapSort(int[] arr) {
        int n = arr.length;
        for (int i = (n/2)-1  ; i >= 0; i--) {
            downHeapify(arr, i, n);
        }

        for(int i = n-1;i>=0;i--){
            int temp = arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            downHeapify(arr,0,i);
        }

    }

    private static void downHeapify(int[] arr, int i, int n) {
        int parentIndex = i;
        int leftChildIndex = (2 * parentIndex) + 1;
        int rightChildIndex = (2 * parentIndex) + 2;
        while(leftChildIndex<n){
            int minIndex=parentIndex;
            if(arr[leftChildIndex]<arr[minIndex]){
                minIndex=leftChildIndex;
            }
            if(rightChildIndex<n && arr[rightChildIndex]<arr[minIndex]){
                minIndex=rightChildIndex;
            }
            if(minIndex==parentIndex){
                break;
            }
            int temp = arr[minIndex];
            arr[minIndex]=arr[parentIndex];
            arr[parentIndex]=temp;
            parentIndex=minIndex;
            leftChildIndex = (2 * parentIndex) + 1;
            rightChildIndex = (2 * parentIndex) + 2;
        }
    }
}
