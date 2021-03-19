package HW6;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode temp = head;
        ListNode next, prev;
        int count = k;
        while(count > 1 && temp != null){
            temp = temp.next;
            count--;
        }

        if(count == 1 && temp != null){
            temp.next = reverseKGroup(temp.next, k);
            temp = temp.next;
            prev = temp;
            while (current != temp){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
        return head;

    }
}
