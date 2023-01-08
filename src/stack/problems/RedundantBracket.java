package stack.problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RedundantBracket {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String expression = br.readLine().trim();

        System.out.println(checkRedundantBrackets(expression));
    }

    private static boolean checkRedundantBrackets(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length() ; i++) {
            char curr = str.charAt(i);
            if(curr==')' ||curr== '}' ||curr== ']'){
                if(s.peek()=='('||s.peek()=='{'||s.peek()=='['){
                    return true;
                }
                else{
                    while (s.peek()!='{'|| s.peek()!='[' || s.peek()!='{'){
                        s.pop();
                    }
                    s.pop();
                }
            }
            else{
                s.push(curr);
            }

        }
        return false;
    }
}