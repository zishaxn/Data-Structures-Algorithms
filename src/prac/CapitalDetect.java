package prac;

public class CapitalDetect {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ZishaN"));

    }

    public static boolean detectCapitalUse(String word) {

        //Checking if first character is Capital.
        if (Character.isUpperCase(word.charAt(0))) {
            //Checking if all characters are capital;
            if (Character.isUpperCase(word.charAt(1))) {
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
            //Checking if first character is capital and rest are small.
            else {
                for (int i = 1; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        // Check if all letters are not capital
        else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
