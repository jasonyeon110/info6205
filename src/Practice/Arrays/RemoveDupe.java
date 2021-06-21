package Practice.Arrays;

public class RemoveDupe {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i ++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3,3,4,4,4,5};
        System.out.println(removeDuplicates(a));
    }
}
