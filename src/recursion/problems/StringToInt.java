package recursion.problems;

public class StringToInt {
    public static void main(String[] args) {
        System.out.println(conver("00045420125"));
    }

    private static int conver(String s) {
        if (s.length() == 1) {
            return s.charAt(0) - '0';
        }

        double x = conver(s.substring(1));
        double y = s.charAt(0) - '0';

        y = y * Math.pow(10, s.length() - 1) + x;
        return (int) y;
    }
}
