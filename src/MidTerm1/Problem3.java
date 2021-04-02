package MidTerm1;

public class Problem3 {

    public static int getMaxConsecutiveOnes(int[] nums){
        int count = 0;
        int output = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count ++;
            } else {
                output = Math.max(count, output);
                count = 0;
            }
        }
        return Math.max(count, output);
    }

    public static void main(String[] args) {
        int[] test = {0,0,0,1,1,0,0,0,1,1,1,1,1,1};

        System.out.println(getMaxConsecutiveOnes(test));
    }

    /**
     * time complexity is O(n) because going through all the values of array
     * space complexity is just O(1) because not using any space to hold the objects
     */
}
