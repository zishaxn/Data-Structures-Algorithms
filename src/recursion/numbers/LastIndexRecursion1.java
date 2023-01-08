package recursion.numbers;

public class LastIndexRecursion1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2,1,3};
        int target = 1;
        System.out.println(lastIndex(arr, target,0));
    }

    public static int lastIndex(int[] arr, int target,int startIndex) {
        if (startIndex == arr.length) {
            return -1;
        }

        int k = lastIndex(arr, target,startIndex+1);
        if (k != -1) {
            return k;
        } else {
            if (arr[startIndex] == target) {
                return startIndex;
            } else {
                return -1;
            }
        }

    }
}
