package recursion.numbers;

public class SearchFirstIndexElementRecursion1 {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5,6};
        int target = 6;
        System.out.println(search(arr,target,0));
    }

    private static int search(int[] arr, int target,int startIndex) {
        if(startIndex==arr.length){
            return -1;
        }
        if(arr[startIndex]==target){
            return startIndex;
        }

       return search(arr,target,startIndex+1);
    }
}
