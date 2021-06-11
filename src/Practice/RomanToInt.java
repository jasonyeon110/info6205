package Practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))){
                int a = map.get(s.charAt(i));
                res += a;
            } else {
             res  += (map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
            }
            res += map.get(s.charAt(s.length()-1));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
