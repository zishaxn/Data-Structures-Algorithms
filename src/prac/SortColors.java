package prac;

import java.util.Arrays;


public class SortColors {
    public static void main(String[] args) {
        int[]arr = {1,0,2,1,0,2,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
            else if (num == 1) {
                oneCount++;
            }
            else  {
                twoCount++;
            }
        }
        int k =0;
        for (int i = 0; i < zeroCount; i++) {
            nums[k] = 0;
            k++;
        }
        for (int i = 0; i < oneCount; i++) {
            nums[k] = 1;
            k++;
        }
        for (int i = 0; i < twoCount; i++) {
            nums[k] = 2;
            k++;
        }
        Arrays.sort(nums);
    }
}
