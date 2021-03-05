package HW5;

public class CountNumOfOnes {
    public static int countNumOne(int[] arr, int low, int high){
        if(low > high){
            return 0;
        }

        if(high >= low){
            int mid = (low + high) / 2;

            if((mid == high || arr[mid + 1] == 0) && (arr[mid] == 1)){
                return mid + 1;
            }

            if(arr[mid] == 1){
                return countNumOne(arr, mid+1, high);
            }
            return countNumOne(arr, low, mid- 1);
        }
        return 0;
    }
}
