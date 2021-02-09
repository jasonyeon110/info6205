package HW2;

public class OddEven {
    public ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode temp;

        while (head.next != null){

            temp = head.next;
            head = head.next;
        }

        oddEvenList(head.next);

        return
    }
}
