package recursion.problems;

public class CheckStringOrder {
    public static void main(String[] args) {
        String str1 = "abec";
        String target = "etc";
        System.out.println(checkSequence(str1, target));
        //System.out.println(target.length());
    }

    public static boolean checkSequence(String a, String b) {
        if(a.length()==0){
            return true;
        }
        else if(b.length()==0){
            return false;
        }

        if(a.charAt(0) == b.charAt(0))
            return checkSequence(a.substring(1), b.substring(1));
        else
            return checkSequence(a.substring(1), b);
    }
}
