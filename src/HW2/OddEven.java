package HW2;

public class OddEven {
    public ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode headOdd = head;
        ListNode headEven = headOdd.next;
        ListNode odd = headOdd;
        ListNode even = headEven;

        while (even != null){
            if(even.next != null){
                odd.next = even.next;
            } else {
                odd.next = headEven;
                return headOdd;
            }
            odd = odd.next;
            even.next = odd.next;
            even = even.next;

        }

        odd.next = headEven;
        return headOdd;

    }
}
