package recursion.numbers;

public class SumlRecursion {
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return sum(n - 1) + n;

    }

    public static void main(String[] args) {

        System.out.println(sum(0));
    }
}
