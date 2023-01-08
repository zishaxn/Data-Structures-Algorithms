package recursion.strings;

public class StringCharReplace {
    public static void main(String[] args) {
        String str = "zishan";
        char target = 'z';
        char replace = 'k';

        System.out.println(replace(str, target,replace));
    }

    private static String replace(String str, char target,char replace) {
        if (str.length() == 0) {
            return str;
        }
        String tempOutput = replace(str.substring(1), target,replace);
        if (str.charAt(0) == target) {
            return replace+ tempOutput;
        } else {
            return str.charAt(0) + tempOutput;
        }
    }
}
