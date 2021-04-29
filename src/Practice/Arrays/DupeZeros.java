package Practice.Arrays;

import java.util.Arrays;

public class DupeZeros {
//    Input: [1,0,2,3,0,4,5,0]
//    Output: null
//    Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

    public static void duplicateZeros(int[] arr) {
        int countZero = 0;
        int length = arr.length - 1;

        for (int i = 0; i <= length - countZero; i++) {
            if(arr[i] == 0) {
                if (i == length - countZero) {
                    arr[length] = 0;
                    length -= 1;
                    break;
                }
                countZero++;
            }
        }
        int last = length - countZero;

        for (int i = last; i >= 0 ; i--) {
            if(arr[i] == 0 ){
                arr[i + countZero] = 0;
                countZero --;
                arr[i + countZero] = 0;
            } else {
                arr[i + countZero] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));

    }


    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
    }

}
