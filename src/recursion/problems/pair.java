package recursion.problems;

public class pair {
    public static void main(String[] args) {

        System.out.println(conver("ccollo"));
    }

    private static String conver(String s) {
        if (s.length() == 1) {
            return s;
        }

        String x = conver(s.substring(1));
        char y = s.charAt(0);
        if (x.charAt(0) == y) {
            return y +"*"+ x;
        }
        return y+x;
    }
}
