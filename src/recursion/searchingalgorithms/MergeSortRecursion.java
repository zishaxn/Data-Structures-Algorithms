package recursion.searchingalgorithms;

import java.util.Arrays;

public class MergeSortRecursion {
    public static void main(String[] args) {
        int []arr= {4,3,2};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    private static int[] mergeSort(int[] arr) {
        if(arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[]left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[]right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i=0,j=0,k=0;
        int[]temp = new int[left.length+ right.length];
        while(i< left.length && j < right.length){
            if(left[i]<right[j]){
                temp[k]=left[i];
                i++;
            }
            else{
                temp[k]=right[j];
                j++;
            }
            k++;
        }
        while(i< left.length){
            temp[k]=left[i];
            i++;
            k++;
        }
        while(j< right.length){
            temp[k]=right[j];
            j++;
            k++;
        }
        return temp;
    }
}
