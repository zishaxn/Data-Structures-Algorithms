package prac;

public class DeleteToSort {
    public static void main(String[] args) {

    }

    public int minDeletionSize(String[] str) {
        int count = 0;
        for (int i = 0; i < str[0].length(); i++) {
            for (int j = 1; j < str.length; j++) {
                if (str[j - 1].charAt(i) > str[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
