package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null){
            return new int[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<Integer>();

        int one = 0;
        int two = 0;

        while (one < nums1.length && two < nums2.length){
            if(nums1[one] < nums2[two]){
                ++one;
            } else if(nums1[one] > nums2[two]){
                ++two;
            } else{
                result.add(nums1[one]);
                ++one;
                ++two;
            }

        }
        int[]  answer = new int[result.size()];
        int k = 0;
        for (int x: result) {
            answer[k++] = x;
        }
        return answer;

    }
}
