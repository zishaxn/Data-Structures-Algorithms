package recursion.problems;
import java.util.*;
public class ZeroesCount {
    public static void main(String[] args) {
        System.out.println(count(0005004));
        System.out.println(countZerosRec(00005550210));
    }
    public static int countZerosRec(int num){
         if(num==0){
             return 1;
         }
         int count =0;
         if(num/10==0){
             return count;
         }
         if(num%10==0){
             count++;
         }
         return count + countZerosRec(num/10);

     }

    private static int count(int num) {
        if (num < 10) {
            if (num == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (num % 10 == 0) {
            return count(num / 10) + 1;
        } else {
            return count(num / 10);
        }

    }
}
