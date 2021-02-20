package HW3;

public class DoubleLinkList {
    public Node head;

    public void addToHead(){
        Node node = new Node();
        node.next = head;
        head = node;
    }

    public void addToTail(){
        Node node = new Node();
        if(head == null){
            head = node;
            return;
        }
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.val + " => ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int size(){
        int size = 0;
        Node temp = head;

        while (temp != null){
            size ++;
            temp = temp.next;
        }

        return size;
    }

}



