package recursion.searchingalgorithms;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;
        System.out.println(search(arr, target, 0, arr.length - 1));
    }

    private static int search(int[] arr, int target, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;
        if (arr[mid] > target) {
            return search(arr, target, si, mid - 1);
        } else if (arr[mid] < target) {
            return search(arr, target, mid + 1, ei);
        } else {
            return mid;
        }
    }
}

