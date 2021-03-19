package Practice;

public class ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        while (x > 0){
            int y = x%10;
            result += y;
            result *= 10;
            x /= 10;
        }
        result /= 10;
        return result;
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }
}
