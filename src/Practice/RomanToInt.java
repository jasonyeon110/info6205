package Practice;

public class RomanToInt {
    public static int romanToInt(String s) {
        int res = 0;

        if(s != null){
            for (int i = 0; i < s.length()-1; i++) {
                if( getValue(s.charAt(i)) >= getValue(s.charAt(i + 1))){
                    res += getValue(s.charAt(i));
                }
            }
        }
    return res;
    }

    private static int getValue(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
