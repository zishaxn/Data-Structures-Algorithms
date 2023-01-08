package recursion.searchingalgorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,5,9,2};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int si = start;
        int ei = end;
        int mid = si + (ei - si) / 2;
        int pivot = arr[mid];

        while (si <= ei) {
            while (arr[si] < pivot) {
                si++;
            }
            while (arr[ei] > pivot) {
                ei--;
            }
            if(si<=ei){
                int temp = arr[ei];
                arr[ei]=arr[si];
                arr[si]=temp;
                si++;
                ei--;
            }
            quickSort(arr,start,ei);
            quickSort(arr,si,end);
        }
    }
}
