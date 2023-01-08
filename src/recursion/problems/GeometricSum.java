package recursion.problems;
// https://classroom.codingninjas.com/app/classroom/me/19853/content/395329/offering/5626213/problem/35
public class GeometricSum {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(GeoSum(n));

    }

    private static double GeoSum(int n) {
        if (n == 0) {
            return 1;
        }
        return 1 / (double) Math.pow(2, n) + GeoSum(n - 1);
    }

}
