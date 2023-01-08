package recursion.numbers;

public class SumOfArrayRecursion {
    public static void main(String[] args) {
        int []arr={1,2,3,4};
        System.out.println(sum(arr));
    }

    private static int sum(int[] arr) {
        if(arr.length==1){
            return arr[arr.length-1];
        }
        int []reducedArray = new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            reducedArray[i-1]=arr[i];
        }
        return arr[0]+sum(reducedArray);
    }
}
