package recursion.numbers;

public class CheckNumberRecursion {
    public static void main(String[] args) {
        int[]arr = {5,87,56,2,1,3};
        int x = 7;
        System.out.println(present(arr,x));
    }

    private static boolean present(int[] input, int x) {
        if(input.length==0)
            return false;
        if(input[0]==x)
            return true;
        int []reducedArray = new int[input.length-1];
        for (int i = 1; i < input.length; i++) {
            reducedArray[i-1]=input[i];
        }
        boolean isPresent = present(reducedArray,x);
        return isPresent;
    }
}
