package HW3;

public class DeleteNnodeAfterMnode {

    public ListNode deleteNodes(ListNode head, int m, int n){

        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode temp = preHead;

        while (temp != null && temp.next != null){
            for (int i = 1; i <= m ; i++) {
                temp = temp.next;
            }
            for (int i = 1; i <= n ; i++) {
                temp.next = temp.next.next;
            }
        }
        return head;
    }

}
