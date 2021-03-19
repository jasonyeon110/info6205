package Practice;

public class JustTest {
    public static void main(String[] args) {
        int x = 123;
        int result = 0;
        while (x > 0){
            int y = x%10;
            result += y;
            result *= 10;
            x /= 10;
        }
        result /= 10;
    }
}
