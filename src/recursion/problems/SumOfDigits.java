package recursion.problems;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(555));
    }

    private static int sum(int num) {
        if(num/10==0) {
            return num;
        }
        int rem = num%10;
        return rem+sum(num/10);
    }
}
