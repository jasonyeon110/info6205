package ClassNotes.Feb04;

public class LinkList <T>{
    public Node<T> head;
    public LinkList(){

    }


    public void addHead(T data){
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    public void addTail(T data){
        Node<T> node = new Node<>(data);
        //If the list is empty
        if(head == null){
            head = node;
            return;
        }

        //create temp node to last node
        Node<T> temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
    }

    public Node<T> getTailNode(){
        if(head == null || head.next == null){
            return head;
        }
        Node<T> temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    public void printList(){
        Node<T> temp = head;
        while (temp != null){
            System.out.printf(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int size(){
        int size = 0;
        Node<T> temp = head;
        while (temp != null){
            temp = temp.next;
            size++;
        }
        return size;

    }

    public void reverse(){
        if (head == null || head.next == null){
            return;
        }
        Node<T> back = null;
        Node<T> mid = head;
        Node<T> front = head.next;

        while (front != null){
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
        }
        mid.next = back;
        head = mid;
    }

    public Node<T> reverse(Node<T> node){
        if (head == null || head.next == null){
            return null;
        }
        Node<T> back = null;
        Node<T> mid = node;
        Node<T> front = node.next;

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



    public Node<T> findKthFromEnd(int k){
        if(k < 0 || head == null){
            return null;
        }

        Node<T> front = head;
        Node<T> back = head;

        //putting front to the Kth from the beginning location
        for(int i = 0; i < k; i ++){
            if(front == null){
                return null;
            }
            front = front.next;
        }
        //move back and front by one until front reaches null
        while (front != null){
            back = back.next;
            front = front.next;
        }

        //back should be k steps behind front
        return back;
    }



    //cycle LinkList part
    public boolean isCyclic(){
        if(head == null || head.next == null){
            return false;
        }

        Node<T> back = head;
        Node<T> front = head;

        while (front != null){
            front = front.next;
            if (front == null){
                return false;
            }

            front = front.next;
            back = back.next;

            if (front == back){
                return true;
            }
        }
        return false;
    }

    public Node<T> findStartOfCycle(){
        if(head == null || head.next == null){
            return null;
        }

        Node<T> back = head;
        Node<T> front = head;

        while (front != null){
            front = front.next;
            if (front == null){
                return null;
            }

            front = front.next;
            back = back.next;

            //found out this LinkList is cyclic, break out of the while loop
            if (front == back){
                break;
            }
        }
        if (front == null) {
            return null;
        }

        //we know there is a cycle
        //front and back are k steps away from the start of cycle
        //where k = distance from the head to start of cycle
        //we move either front of back to head;
        front = head;

        //move front and back by one
        while (front != back){
            front = front.next;
            back = back.next;
        }
        return front;
    }

    public Node<T> breakListInHalf(){
        if(head == null || head.next == null){
            return null;
        }

        Node front = head;
        Node back =  head;

        while (front.next != null){
            front = front.next;
            if(front.next != null){
                front = front.next;
                back = back.next;
            }

        }
        Node temp = back.next;
        back.next = null;

        return temp;
    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return true;
        }

        Node<T> secondHalf = breakListInHalf();
        secondHalf = reverse(secondHalf);

        Node temp1 = head;
        Node temp2 = secondHalf;
        boolean bPalindrome = true;

        while (temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                bPalindrome = false;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        //put the list back together
        secondHalf = reverse(secondHalf);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = secondHalf;

        return bPalindrome;
    }


    public void rotateList(int k){
        k = k % size();
        if(k <= 0 || head == null || head.next == null){
            return;
        }

        Node<T> secondHalf = findKthFromEnd(k + 1);
        Node<T> firstHalf = secondHalf.next;

        secondHalf.next = null;

        Node<T> temp = firstHalf;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        head = firstHalf;
    }

    public void removeDuplicates(){
        if(head == null || head.next == null){
            return;
        }

        Node<T> temp = head;
        while (temp.next != null){
            while (temp.next != null && temp.next.data == temp.data){
                temp.next = temp.next.next;
            }

            temp = temp.next;

            if(temp == null){
                break;
            }
        }
    }






}























