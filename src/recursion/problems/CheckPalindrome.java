package recursion.problems;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "geag";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        return palindrome(s, 0, s.length() - 1);
    }

    private static boolean palindrome(String s, int si, int ei) {
        if (si >= ei) {
            return true;
        }
        if (s.charAt(si) != s.charAt(ei)) {
            return false;
        }
            return palindrome(s, si + 1, ei - 1);
    }
}
