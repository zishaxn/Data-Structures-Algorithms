package timecomplexity;

public class Fibonacci {
    public static void main(String[] args) {
        for(int i =0;i<11;i++){
            System.out.println(nthFibo(i));
        }
        System.out.println(nthFibo(4));
    }

     static int nthFibo(int num) {
       //return (int) (Math.pow(((1+Math.sqrt(5))/2),num)/Math.sqrt(5));
       return (int) Math.pow(1.6180,num);
    }
}
