package stack.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeInput() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            return input;
        }

        String[] values = br.readLine().trim().split(" ");

        for(int i = 0; i < size; i++) {
            input[i] = Integer.parseInt(values[i]);
        }

        return input;
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] input = takeInput();

        int[] output = stockSpan(input);

        printArray(output);

    }

    private static int[] stockSpan(int[] input) {
        Stack<Integer> s = new Stack<>();
        int n = input.length;
        int[]output =new int[n];

        s.push(0);
        output[0]=1;
        for (int i = 1; i < n; ++i) {
            while (!s.isEmpty() && input[s.peek()] < input[i]){
                s.pop();
            }
            if(s.isEmpty()){
                output[i]=i+1;
            }
            else{
                output[i]=i-s.peek();
            }
            s.push(i);
        }
        return output;
    }
}
