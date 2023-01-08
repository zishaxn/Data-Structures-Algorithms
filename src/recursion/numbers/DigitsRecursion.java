package recursion.numbers;

public class DigitsRecursion {

    public static void main(String[] args) {
        System.out.println(count(222));

    }

    private static int count(int n) {
        if(n==0){
            return 0;
        }
        int small = count(n/10);
       return small +1;
    }
}
