package tries;

public class DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("UsssA"));

    }

    public static boolean detectCapitalUse(String s) {
        for(int i =0;i<s.length()-1;i++) {
            if(s.charAt(i)>='A' && s.charAt(i)<='Z' && s.charAt(i+1)>='A' && s.charAt(i+1)<='Z') {
                for(int j =i+1;j<s.length();j++) {
                    if(!(s.charAt(j)>='A' && s.charAt(j)<='Z')) {
                        return false;
                    }
                }
                return true;
            }

            else if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
                for(int j =i+1;j<s.length();j++) {
                    if( s.charAt(j)<='Z' && s.charAt(j)>='A') {
                        return true;
                    }
                }
                return false;
            }
            else if (s.charAt(i)>='A'){
                for(int j =i+1;j<s.length();j++) {
                    if((s.charAt(j)>='A' && s.charAt(j)<='Z')) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
}
