package HW6;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            int k = nums.length-1;
            int j = i+1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[k]);
                    j++;
                    k--;
                    if(!set.contains(list1)){
                        result.add(list1);
                    }
                    set.add(list1);
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    j++;
                }

            }
        }

        return result;

    }
}
