package stack.problems;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedParenthesis {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
//        String expression = br.readLine().trim();
//        System.out.println(isBalanced(expression));
        String str = "(a+b{c+d})())";
        System.out.println(isBalanced(str));

    }

    public static boolean isBalanced(String expression) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char  curr = expression.charAt(i);
            if(isOpening(curr)){
                s.push(curr);
            }
            else if(isEnding(curr)) {
                if(s.isEmpty()){
                    return false;
                }
                else if(!isMatching(curr,s.peek())){
                    return false;
                }
                else {
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }

    private static boolean isOpening(char curr) {
        return curr == '{' || curr == '(' || curr == '[';
    }

    private static boolean isEnding(char curr) {
        return curr == '}' || curr == ')' || curr == ']';
    }
    private static boolean isMatching(char curr, char peek) {
        return peek=='(' && curr==')' ||peek=='{' && curr=='}' || peek=='[' && curr==']' ;
    }
}