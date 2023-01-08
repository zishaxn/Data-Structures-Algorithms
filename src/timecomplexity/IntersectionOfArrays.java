package timecomplexity;

import java.util.Arrays;
public class IntersectionOfArrays {
    public static void main(String[] args) {
        int []arr1 = {5,4,3,2,1};
        int []arr2 = {9,8,5,7,1,2};
        intersection(arr1,arr2);
    }


    //Overall Time Complexity
    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);  //Time Complexity O(nlogn)
        Arrays.sort(arr2);
        int i = 0, j = 0;
        // Time complexity O(n)
        while (i <= arr1.length-1 && j <= arr2.length-1) {
            if (arr1[i] > arr2[j]) {
                j++;

            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
        }

    }
}