package HW4;

import java.util.Arrays;

public class FindNthSmallest {
    public static int findNthSmallest(int[] arr, int n){
        Arrays.sort(arr);
        return arr[n - 1];
    }


    public static void findNthSmallest2(int[] arr, int n, int low, int high){
        if(n > 0){
            int position = partition(arr, low, high);
            if(position == arr.length-1){
                System.out.println(arr[position]);
                return;
            }
            findNthSmallest2(arr, n, position+1, high);
            findNthSmallest2(arr, n, low, position - 1);
        }

    }



    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int wall = low-1;

        for (int i = low; i < high; i++) {
            if(arr[i] < pivot){
                wall++;
                swap(arr, i, wall);
            }
        }
        //we will put the pivot value at the wall position
        wall++;
        swap(arr, high, wall);
        return wall;
    }
    private static void swap(int[] arr, int i, int j) {
        if(arr == null || arr.length < 2 || i < 0 || j < 0 || i >= arr.length || j >= arr.length){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
