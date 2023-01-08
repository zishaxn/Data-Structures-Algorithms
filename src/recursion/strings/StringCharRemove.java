package recursion.strings;


/// Given a string, compute recursively a new string where all 'x' chars have been removed.////


public class StringCharRemove {
    public static void main(String[] args) {
        String str = "dfszhgzy";
        char target = 'z';
        char replace = 'k';

        System.out.println(replace(str, target));
    }

    private static String replace(String str, char target) {
        if (str.length() == 0) {
            return str;
        }
        String tempOutput = replace(str.substring(1), target);
        if (str.charAt(0) == target) {
            return tempOutput;
        } else {
            return str.charAt(0) + tempOutput;
        }
    }
}
