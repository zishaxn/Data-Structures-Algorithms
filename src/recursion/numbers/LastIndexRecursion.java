package recursion.numbers;

public class LastIndexRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2,1,3};
        int target = 1;
        System.out.println(lastIndex(arr, target));
        ;
    }

    public static int lastIndex(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        int[] reducedArray = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            reducedArray[i - 1] = arr[i];
        }
        int k = lastIndex(reducedArray, target);
        if (k != -1) {
            return k + 1;
        } else {
            if (arr[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

    }
}
