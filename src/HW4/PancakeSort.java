package HW4;

import java.util.ArrayList;
import java.util.List;

public class PancakeSort {
    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();

        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = findMax(arr, i);
            if(maxIndex == -1){
                continue;
            }
            flip(arr, maxIndex);
            result.add(maxIndex + 1);

            flip(arr, i);
            result.add(i + 1);
        }
        return result;


    }

    private static void flip(int[] arr, int k) {
        int left = 0;
        int right = 0;
        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static int findMax(int[] arr, int num) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            if(maxIndex < arr[i]){
                maxIndex = i;
                maxValue = arr[i];
            }
        }
        return maxIndex;
    }
}
