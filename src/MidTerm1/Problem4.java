package MidTerm1;

public class Problem4 {
    //[2,4,4,4,6,7,7,7,8,9,9,9,] & x = 7 , the result should be 5.
    public static int getIndex(int[] nums, int x){
        return getIndex(nums, x,0, nums.length-1);
    }

    public static int getIndex(int[] nums, int x, int low, int high){
        if(low > high || nums[low] > x || nums[high] < x){
            return -1;
        }
        if(nums[low] == x){
            return low;
        }


        int mid = (low + high)/2;

        if(nums[mid] < x){
            return getIndex(nums, x, mid +1, high);
        } else if(nums[mid] > x ){
            return getIndex(nums, x, low, mid -1);
        } else {
            return getIndex(nums ,x ,low, mid);
        }
    }

    public static void main(String[] args) {
        int[] test = {2,4,4,4,6,7,7,7,8,9,9,9};
        System.out.println(getIndex(test, 7));
    }

    /**
     * time complexity is Olog(n)
     * space complexity is O(n)
     */
}
