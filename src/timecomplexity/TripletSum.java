package timecomplexity;

import java.util.Arrays;

public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 6, 2, 1, 3};
        int num = 6;
        System.out.println(sum(arr, num));
    }

    private static int sum(int[] arr, int num) {
        int si, ei, count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            si = i + 1;
            ei = arr.length - 1;
            while (si < ei) {
                if (arr[i] + arr[si] + arr[ei] == num) {
                    count++;
                    si++;
                    ei--;
                } else if (arr[i] + arr[si] + arr[ei] < num) {
                    si++;
                } else { // (arr[i] + arr[si] + arr[ei] > num)
                    ei--;
                }
            }
        }
        return count;
    }

}
