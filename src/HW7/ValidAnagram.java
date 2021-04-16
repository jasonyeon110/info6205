package HW7;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s ==null || t== null || s.length() != t.length()){
            return false;
        }

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();

        Arrays.sort(arrS);
        Arrays.sort(arrT);

        for (int i = 0; i < arrS.length; i++) {
            if(arrS[i] != arrT[i]){
                return false;
            }
        }
        return true;
    }
}
