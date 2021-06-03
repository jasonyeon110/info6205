package Practice;

public class ReverseInteger {
    public static int reverse(int x) {
        String res = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try{
            return (x < 0) ? Integer.parseInt(res) * -1 : Integer.parseInt(res);
        }catch(NumberFormatException e){
            return 0;
        }
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverse(x));
    }
}
