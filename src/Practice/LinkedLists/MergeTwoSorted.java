package Practice.LinkedLists;

import java.util.LinkedList;

public class MergeTwoSorted {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        LinkedList<Integer> ll = new LinkedList<>();
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                res.next = new ListNode(l1.val);
                res = res.next;
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                res = res.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            res.next = new ListNode(l1.val);
            res = res.next;
            l1 = l1.next;
        }
        while (l2 != null){
            res.next = new ListNode(l2.val);
            res = res.next;
            l2 = l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
