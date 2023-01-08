package recursion.numbers;

import java.util.Scanner;

public class SearchLastIndexElementRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2};
        int target = 2;
        System.out.println(lastIndex(arr, target));
    }

    private static int lastIndex(int[] arr, int target) {
        return lastIndex1(arr, target, arr.length - 1);
    }
    public static int lastIndex1(int[] arr, int target, int startIndex) {
        if (startIndex == 0) {
            return -1;
        }
        if (arr[startIndex] == target) {
            return startIndex;
        }
        return lastIndex1(arr, target, startIndex - 1);

    }
}
