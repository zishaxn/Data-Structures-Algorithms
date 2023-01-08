package recursion.numbers;

public class SortedArrayCheckRecursion {
    static boolean isSorted(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        if (arr[0] > arr[1]) {
            return false;
        }
        int[] reducedArray=new int[arr.length-1];
        System.arraycopy(arr, 1, reducedArray, 0, arr.length - 1);
        boolean isSorted = isSorted(reducedArray);
        return isSorted;
    }

    public static void main(String[] args) {
        int[]arr={1,2,3,4};
        System.out.println(isSorted(arr));
    }
}
