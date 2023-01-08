package recursion.numbers;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int disk = 4;
        towerOfHanoi(disk,"S","H","D");

    }

    private static void towerOfHanoi(int n, String src, String helper, String dest) {
        if(n==1){
            System.out.println("Transfer Disk "+n+" From "+src + " to "+ dest);
            return;
        }
        towerOfHanoi(n-1,src,dest,helper);
        System.out.println("Transfer Disk "+n+" From "+src + " to "+ dest);
        towerOfHanoi(n-1,helper,src,dest);
    }
}
