package HW3;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val){
            head = head.next;
        }

        ListNode pointer = head;

        while (pointer != null && pointer.next != null){
            while (pointer.next != null && pointer.next.val == val){
                pointer.next = pointer.next.next;
            }
            pointer = pointer.next;
        }
        return head;
    }
}
