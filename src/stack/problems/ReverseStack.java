package stack.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ReverseStack {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Stack<Integer> takeInput() throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        Stack<Integer> input = new Stack<>();

        if (size == 0) {
            return input;
        }

        String[] values = br.readLine().trim().split(" ");

        for(int i = 0; i < size; i++) {
            input.push(Integer.parseInt(values[i]));
        }

        return input;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Stack<Integer> input = takeInput();
        Stack<Integer> empty = new Stack<>();

        reverseStackRecursion(input, empty);

        while(!input.isEmpty()) {
            System.out.print(input.pop() + " ");
        }

    }

    private static void reverseStack(Stack<Integer> input, Stack<Integer> empty) {
        Stack<Integer> s = new Stack<>();
        while(!input.isEmpty()){
            empty.push(input.pop());
        }
        while(!empty.isEmpty()){
            s.push(empty.pop());
        }
        while(!s.isEmpty()){
            input.push(s.pop());
        }
    }
    private static void reverseStackRecursion(Stack<Integer> input, Stack<Integer> empty) {
        if(input.size()<=1){
            return;
        }
        int lastElement = input.pop();
        reverseStackRecursion(input,empty);
        while (!input.isEmpty()){
            empty.push(input.pop());
        }

        input.push(lastElement);
        while (!empty.isEmpty()){
            input.push(empty.pop());
        }
    }
}