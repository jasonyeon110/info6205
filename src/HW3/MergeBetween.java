package HW3;

public class MergeBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2){
        ListNode initNode = list1;
        ListNode byeNode = null;

        while(initNode.next.val != a){
            initNode = initNode.next;
        }

        byeNode = initNode;

        while(byeNode.val != b){
            byeNode = byeNode.next;
        }
        byeNode = byeNode.next;
        initNode.next = list2;

        while(list2.next != null){
            list2 = list2.next;
        }

        list2.next = byeNode;
        return list1;
    }
}
