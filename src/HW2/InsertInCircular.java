package HW2;

//public class ListNode {
//
//    int val;
//    ListNode next;
//
//    ListNode(){
//    }
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    public ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
public class InsertInCircular {
    public ListNode insertInCircular(ListNode head, int insertVal) {

        if (head == null) {
            head = new ListNode(insertVal, null);
            head.next = head;
            return head;
        }

        ListNode current = head;
        while (true) {
            if (current.val < current.next.val) {
                if (current.val <= insertVal && insertVal <= current.next.val) {
                    current.next = new ListNode(insertVal, current.next);
                    break;
                } else if (current.val > current.next.val) {
                    if (current.val <= insertVal || insertVal <= current.next.val) {
                        current.next = new ListNode(insertVal, current.next);
                        break;
                    }
                } else {
                    if (current.next == head) {
                        current.next = new ListNode(insertVal, head);
                        break;
                    }
                }
            }
            current = current.next;
        }
        return head;
    }

}
