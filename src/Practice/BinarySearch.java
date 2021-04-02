package Practice;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        //index
        int left = 0;
        int right = nums.length - 1;


        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 3,4,7,8,9,11,13};

        System.out.println(search(arr, 11));
    }
}
