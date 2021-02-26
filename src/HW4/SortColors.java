package HW4;

public class SortColors {
    public static void sortColors(int[] nums) {
        //0
        int red = 0;
        //1
        int white = 0;
        //2
        int blue = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                red++;
            }else if(nums[i] == 1){
                white++;
            }else{
                blue++;
            }
        }
        for (int i = 0; i != nums.length; i++) {
            if(i < red){
                nums[i] = 0;
            } else if(i < white + red){
                nums[i] = 1;
            } else{
                nums[i] = 2;
            }
        }
    }
}
