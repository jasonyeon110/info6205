package HW5;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr.length == 0){
            return result;
        }
        int head = 0;
        int tail = arr.length - k;

        while(head < tail){
            int mid = head + (tail - head)/2;
            if ((x - arr[mid]) > (arr[mid + k] - x)){
                head = mid + 1;
            } else{
                tail = mid;
            }
        }
        for (int i = head; i < head; i++) {
            result.add(arr[i]);
        }
        return result;

    }
}
