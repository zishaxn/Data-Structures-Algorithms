package timecomplexity;

import java.util.Arrays;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {1, 7, 1, 3, 7};
        System.out.println(unique(arr));
    }

    private static int unique(int[] arr) {

        //Time Complexity O(nlogn)//
        //Space Complexity O(1)

//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < arr.length - 1; i+=2) {
//            if (arr[i] != arr[i + 1]) {
//                return i;
//            }
//        }
//        return -1;


        //Time Complexity O(n)//
        //Space Complexity O(1)
        int XOR = 0;
        for (int j : arr) {
            XOR = XOR ^ j;
        }
        return XOR;
    }
}