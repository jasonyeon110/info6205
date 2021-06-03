package Practice;

public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        String reverse = new StringBuilder().append(Math.abs(x)).reverse().toString();
        String origin = new StringBuilder().append(Math.abs(x)).toString();

        if(reverse.equals(origin)){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int x = 1233210;
        System.out.println(isPalindrome(x));
    }
}
