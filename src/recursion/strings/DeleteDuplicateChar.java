package recursion.strings;

public class DeleteDuplicateChar {
    public static void main(String[] args) {
        String s = "ijkjik";
        System.out.println(delete(s));
    }

    private static String delete(String s) {
        if (s.length() == 1) {
            return s;
        }
        String temp = delete(s.substring(1));
        if (s.charAt(0) == temp.charAt(0)) {
            return temp;
        } else
            return s.charAt(0) + temp;

    }
}

