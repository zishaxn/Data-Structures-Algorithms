package recursion.numbers;

public class SearchFirstIndexElementRecursion {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6};
        int target = 5;
        System.out.println(search(arr,target));
    }

    private static int search(int[] arr, int target) {
        if(arr.length==0){
            return -1;
        }
        if(arr[0]==target){
            return 0;
        }
        int []reducedArray = new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            reducedArray[i-1]=arr[i];
        }
       int recElement = search(reducedArray,target);
        if(recElement==-1)
            return -1;
        else return recElement+1;
    }
}
