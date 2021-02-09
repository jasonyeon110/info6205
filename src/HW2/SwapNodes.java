package HW2;

public class SwapNodes {

    public ListNode swapPairs(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;

        swapPairs(head.next.next);

        return head;
    }


}
