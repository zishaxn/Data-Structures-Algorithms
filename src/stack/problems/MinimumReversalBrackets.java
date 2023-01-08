package stack.problems;

import stack.linkedlist.StackUsage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumReversalBrackets {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        System.out.println(countBracketReversals(br.readLine().trim()));

    }

    private static int countBracketReversals(String exp) {
        int n = exp.length();
        if (n == 0) return 0;
        if (n % 2 != 0) return -1;
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            char curr = exp.charAt(i);
            if (curr == '{') {
                s.push(curr);
            } else {
                if (!s.isEmpty() && s.peek() == '{') {
                    s.pop();
                } else {
                    s.push(curr);
                }
            }
        }
        int count =0;
        while(!s.isEmpty()){
            char c1= s.pop();
            char c2= s.pop();
            if(c1!=c2){
                count+=2;
            }
            else{
                count+=1;
            }
        }
        return count;
    }
}