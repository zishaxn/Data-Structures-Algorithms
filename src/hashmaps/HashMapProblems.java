package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class HashMapProblems {
    public static void main(String[] args) {

       String str = "ZishanZishan";
       String ans = uniqueChar(str);
        System.out.println(ans);

    }


    public static void arrange(int[] arr, int n) {
        //Your code goes here
    }

    //--------------------------------------------------------------------------------------------//
    /* Given a string S, you need to remove all the duplicates.
    That means, the output string should contain each character only once.
    The respective order of characters should remain same, as in the input string.*/
    /*
    Time Complexity: O(N ^ 2)
    Space Complexity: O(1)

    where N is the length of the string.
*/



        public static String uniqueChar(String str)
        {
            String ans = "";

            for(int i = 0; i < str.length(); i++)
            {
                boolean hasOccurred = false;

                for(int j = 0; j < i; j++)
                {
                    if(str.charAt(j) == str.charAt(i))
                    {
                        // If the number has occured, then store True.
                        hasOccurred = true;
                        break;
                    }
                }

                if(!hasOccurred)
                {
                    ans += str.charAt(i);
                }
            }

            return ans;
        }



















    //----------------------------------------------------------------------------------//

    public static int PairSum(int[] input) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
         for(int key : input){
         	if(map.containsKey(key)){
         		int freq = map.get(key);
         		freq++;
         		map.put(key,freq);
         	}
         	else{
         		map.put(key,1);
         	}
         }
        for(Entry<Integer,Integer>val : map.entrySet()){
            int currKey = val.getKey();
            if(currKey!=0 && map.get(-currKey)!=null){
                count+=map.get(-currKey)*val.getValue();
            }
        }

        if(map.get(0)!=null){
            int f = map.get(0);
            count+=(f*(f-1));
        }
        return count/2;
    }


    //----------------------------------------------------------------------------------//
    /* You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively.
    You need to print their intersection; An intersection for this problem can be defined when
    both the arrays/lists contain a particular value or to put it in other words,
    when there is a common value that exists in both the arrays/lists.*/

    public static void printIntersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : arr1) {
            if (map.containsKey(key)) {
                int freq = map.get(key);
                freq++;
                map.put(key, freq);

            } else {
                map.put(key, 1);
            }
        }
        for (int j : arr2) {
            if (map.containsKey(j)) {
                if (map.get(j) != 0) {
                    System.out.println(j);

                    map.put(j, map.get(j) - 1);
                }
            }
        }
    }

    //----------------------------------------------------------------------------------//
    /* You are given an array of integers that contain numbers in random order.
     Write a program to find and return the number which occurs the maximum times in the given input.
     If two or more elements contend for the maximum frequency,
     return the element which occurs in the array first.*/
    public static int maxFrequencyNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : arr) {      //Adding Element in HashMap
            if (map.containsKey(key)) {    // checking if present or not
                int freq = map.get(key);  //Increasing freqency
                freq++;
                map.put(key, freq);       //replacing
            } else {
                map.put(key, 1);          //Adding if not presnt
            }
        }

        int maxCount = 0;
        int res = -1;
        //This Method Might Throw Wrong answers in few test cases as
//        for (Entry<Integer, Integer> val : map.entrySet()) {   // Here it will traverse on each val
//            if (maxCount < val.getValue()) {      //checking if given element is having max frequency than previous one.
//                res = val.getKey();               // Assigning new element with max frequency
//                maxCount = val.getValue();
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            if (maxCount < map.get(arr[i])) {
                maxCount = map.get(arr[i]);
                res = arr[i];
            }
        }
        return res;
    }


    //------------------------------------------------------------------------------//
    /* This Method Will Remove Duplicate Elements from The given Array and Return
     * New Array list */
    public static ArrayList<Integer> removeDuplicates(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (int j : arr) {
            if (map.containsKey(j)) {  //Checking if Element is Already Present in hashMap .
                continue;             // skipping if already contains
            }
            output.add(j); //else adding in arraylist
            map.put(j, true); //also adding in hashmap.
        }
        return output;
    }
}
