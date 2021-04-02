package MidTerm1;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    public static boolean areConverging(ListNode n1, ListNode n2){
        ListNode top = n1;
        ListNode bottom = n2;
        Set set = new HashSet<>();

        if(n1 == null || n2 == null){
            return false;
        }

        while(top != null){
            set.add(top);
            top = top.next;
        }
        while(bottom != null){
            if(set.contains(bottom)){
                return true;
            }
            set.add(bottom);
            bottom = bottom.next;
        }
        return false;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        n1.next = new ListNode(1);
        n1.next.next = new ListNode(8);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(1);
        n2.next.next.next = new ListNode(8);
        n2.next.next.next.next = new ListNode(4);
        n2.next.next.next.next.next = new ListNode(5);

        System.out.println(areConverging(n1, n2));
    }
/**
 * Time complexity is O(n) because it has to iterate once for n1;
 * space complexity is O(n) because we need to store all n1 values;
 */

}
