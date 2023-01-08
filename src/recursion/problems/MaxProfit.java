package recursion.problems;

import java.util.Arrays;

public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = {12, 10, 15, 25, 50, 45};
        System.out.println(max(arr));
    }

    private static int max(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length - 1;
        int max = arr[n];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] * (arr.length- i) > max) {
               int ma = arr[i] * (arr.length - i);
                max = arr[i] * (arr.length - i);
            }
        }
        return max;
    }
}
