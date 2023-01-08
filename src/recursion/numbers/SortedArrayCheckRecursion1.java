package recursion.numbers;

public class SortedArrayCheckRecursion1 {
    static boolean isSorted(int[] arr,int startIndex) {
        if (startIndex== arr.length) {
            return true;
        }
        if (arr[startIndex] > arr[startIndex+1]) {
            return false;
        }

        return isSorted(arr,startIndex+1);
    }

    public static void main(String[] args) {
        int[]arr={4,5,6,7,8,1};
        System.out.println(isSorted(arr,0));
    }
}
