package Practice;

import java.util.HashMap;

public class RomanToInt {
    public static int romanToInt(String s) {
        HashMap<String, Integer> romanInt = new HashMap<>();
        romanInt.put("I", 1);
        romanInt.put("V", 5);
        romanInt.put("X", 10);
        romanInt.put("L", 50);
        romanInt.put("C", 100);
        romanInt.put("D", 500);
        romanInt.put("M", 1000);
        int res = 0;

        if(s != null){
            for (int i = 0; i < s.length(); i++) {
                System.out.println(romanInt.keySet());
            }
        }
    return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
