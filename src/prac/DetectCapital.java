package prac;

public class DetectCapital {
    public static void main(String[] args) {
        System.out.println( detectCapitalUse("SAaaas"));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(0))) {
            if (Character.isUpperCase(word.charAt(1))) {
                // Check if all letters are capital
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
            } else {
                // Check if first letter is capital and rest are not capital
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
        } else {
            // Check if all letters are not capital
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }


}
