package FinalExam;

public class Problem2 {

    public static int fib(int n){
        if(n < 0){
            return Integer.MIN_VALUE;
        }
        if(n <=1){
            return n;
        }

        return fib(n-1) + fib (n -2);
    }

    public static void main(String[] args) {
        //time complexity: O(n)
        //space complexity: O(1)
        System.out.println(fib(3));
    }
}
