package HW3;

public class SwapNode {
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null){
            return head;
        }

        int lengthOfList = 0;
        ListNode start = head;
        ListNode end = null;

        while(start.next != null){
            start = start.next;
            lengthOfList ++;
        }

        start = head;
        lengthOfList = lengthOfList - k + 1;
        end = head;

        while (k > 1){
            start = start.next;
            k--;
        }

        while (lengthOfList > 0){
            end = end.next;
            lengthOfList --;
        }

        int temp = start.val;
        start.val = end.val;
        end.val = temp;

        return head;


    }
}
