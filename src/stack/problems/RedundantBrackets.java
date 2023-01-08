package stack.problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RedundantBrackets {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        String expression = "(a+b)";
                //= br.readLine().trim();

        System.out.println(isRedundant(expression));

    }

    private static boolean isRedundant(String str) {
        Stack<Character> s = new Stack<>();

        char[] ss = str.toCharArray();  //String to character array
        for (char ch : ss) {
            if (ch == ')') {
                char top = s.peek();
                s.pop();

                boolean flag = true;

                while (top != '(') {
                    if (top == '+' || top == '-' || top == '/' || top == '*') {
                        flag = false;
                    }
                    top = s.peek();
                    s.pop();
                }
                if (flag) {
                    return true;
                }
            } else {
                s.push(ch);
            }
        }
        return false;
    }
}
