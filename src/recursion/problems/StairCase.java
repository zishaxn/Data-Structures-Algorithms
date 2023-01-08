package recursion.problems;

public class StairCase {
    public static void main(String[] args) {
        System.out.println(ways(4));
    }

    private static int ways(int steps) {
       if(steps<0){
           return 0;
       }
       if(steps==0){
           return 1;
       }
        return ways(steps-1)+ways(steps-2)+ways(steps-3);
    }
}
