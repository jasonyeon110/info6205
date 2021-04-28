package Practice.Arrays;

public class FindMaxConsec {

//    Input: nums = [1,1,0,1,1,1,0,1]
//    Output: 3
//    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
    public static int findMaxConsecutiveOnes(int[] nums) {
        int result  = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                result++;
            } else {
                if(result > max){
                    max = result;
                }
                result = 0;
            }
        }

        if(result > max){
            max = result;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,0,1};

        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
