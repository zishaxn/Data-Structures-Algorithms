package recursion.strings;

public class ReplacePi {
    public static void main(String[] args) {
        String str = "pippipppiipi";
        System.out.println(replace(str));
    }

    private static String replace(String str) {
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
            String tempOutput = replace(str.substring(2));
            return " 3.14 " + tempOutput;

        } else {
            String tempOutput = replace(str.substring(1));
            return str.charAt(0) + tempOutput;
        }
    }
}
