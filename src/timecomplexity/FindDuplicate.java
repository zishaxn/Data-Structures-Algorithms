package timecomplexity;

import java.util.Arrays;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 1};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] arr) {

        //Time Complexity O(nlogn)//
        //Space Complexity O(1)
        //        Arrays.sort(arr);
//        for (int i = arr.length - 1; i > 1; i--) {
//            if (arr[i] == arr[i - 1])
//                return arr[i];
//        }
//        return 0;


        //Time Complexity O(n)//
        //Space Complexity O(1)
        int sumOfNminusOne = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sumOfNminusOne += i;
        }
        int sumOfElements = 0;
        for (int j : arr) {
            sumOfElements += j;
        }
        return sumOfElements - sumOfNminusOne;
    }

}
