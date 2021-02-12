package ClassNotes.Feb11;

public class AddTwoNum {

    public Node<Integer> addTwoNumbers(Node<Integer> node1, Node<Integer> node2){
        node1 = reverse(node1);
        node2 = reverse(node2);

        int carry = 0;

        Node<Integer> temp1 = node1;
        Node<Integer> temp2 = node2;
        Node<Integer> result = null;

        while(temp1 != null || temp2 != null){
            int sum = carry;
            if(temp1 != null){
                sum += temp1.data;
            }
            if(temp2 != null){
                sum += temp2.data;
            }

            if (sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else{
                carry = 0;
            }

            if(temp1 != null){
                temp1 = temp1.next;
            }
            if(temp2 != null){
                temp2 = temp2.next;
            }


            Node<Integer> node = new Node<>(sum);
            node.next = result;
            result = node;
        }

        return result;
    }

    public static Node<Integer> reverse(Node<Integer> node){
        if (node == null || node.next == null){
            return null;
        }
        Node<Integer> back = null;
        Node<Integer> mid = node;
        Node<Integer> front = node.next;

        while (front != null){
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
        }
        mid.next = back;
        node = mid;
        return node;
    }
}
