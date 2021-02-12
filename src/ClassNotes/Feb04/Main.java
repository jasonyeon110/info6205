package ClassNotes.Feb04;

public class Main {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        createCycle(list);
        System.out.println(list.isCyclic()); // true
        Node<Integer> startOfCycle = list.findStartOfCycle();



    }

    //not complete
    public static NodeRand<Integer> getRandomList(){
        NodeRand<Integer> one = new NodeRand<>(1);
        NodeRand<Integer> two = new NodeRand<>(2);
        NodeRand<Integer> three = new NodeRand<>(3);
        NodeRand<Integer> four = new NodeRand<>(4);

        one.rand = three;
        two.rand = two;
        three.rand = four;
        four.rand = two;

        return one;
    }

    //Not complete,,,,,,,,,
    public static NodeRand<Integer> createCopyOfRandomList(NodeRand<Integer> orig){
        NodeRand<Integer> tempOrig = orig;
        //create coyp inside of the Original one

        while (tempOrig != null){
            NodeRand<Integer> add = new NodeRand<>(tempOrig.data);
            add.next = tempOrig.next;
            tempOrig.next = add;
            tempOrig = tempOrig.next.next;
        }
        tempOrig = orig;
        NodeRand<Integer> tempDup = orig.next;

        while (tempOrig != null){
            tempDup.rand = tempOrig.rand.next;
            tempOrig =tempOrig.next.next;
            tempDup = tempDup.next.next;
        }

        NodeRand<Integer> duplicate = orig.next;
        tempOrig = orig;
        tempDup = duplicate;

        //this sould break out the orig and duplicate
        while (tempOrig != null){
            tempOrig.next = tempOrig.next.next;
            tempDup.next = tempDup.next.next;
        }

        return duplicate;
    }


    private static void createCycle(LinkList<Integer> list){

        list.addTail(1);
        list.addTail(2);
        list.addTail(3);
        list.addTail(4);

        //node 5
        Node<Integer> startPoint = list.head.next.next.next.next;

        Node<Integer> tailNode = list.getTailNode();
        tailNode.next = startPoint;
    }

    public static Node<Integer> sortedMerge(Node<Integer> node1, Node<Integer> node2){
        Node result = null;

        if(node1 == null) {
            return node2;
        }

        if (node2 == null){
            return node1;
        }

        if(node1.data <= node2.data){
            result = node1;
            result.next = sortedMerge(node1.next, node2);
        } else{
            result = node2;
            result.next = sortedMerge(node1.next, node2.next);
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

    public static Node<Integer> zipMerge(LinkList<Integer> list){
        Node<Integer> second = list.breakListInHalf();
        second = reverse(second);

        return zipMerge(list.head, second, true);

    }

    private static Node<Integer> zipMerge(Node<Integer> node1, Node<Integer> node2, boolean bSwitch){
        Node<Integer> result = null;

        if(node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }

        if(bSwitch == true){
            result = node1;
            result.next = zipMerge(node1.next, node2, false);
        } else {
            result = node2;
            result.next = zipMerge(node1, node2.next, true);
        }
        return result;
    }

    public static Node<Integer> partitionAroundX(Node<Integer> node, int x){
        if (node == null || node.next == null){
            return null;
        }

        Node<Integer> smaller = null;
        Node<Integer> larger = null;

        Node<Integer> temp = node;

        while (temp != null){
            if (temp.data < x){
                Node<Integer> add = temp;
                temp = temp.next;
                add.next = smaller;
                smaller = add;
            } else {
                Node<Integer> add = temp;
                temp = temp.next;
                add.next = larger;
                larger = add;
            }

        }

        smaller = reverse(smaller);
        larger = reverse(larger);

        node = smaller;

        while (smaller.next != null){
            smaller = smaller.next;
        }

        smaller.next = larger;

        return node;
    }


    public static int convertBinaryToInteger(Node<Integer> node){
        if(node == null){
            return 0;
        }
        node = reverse(node);

        Node<Integer> temp = node;
        int sum = 0;
        int current = 0;
        while (temp != null){
            sum += temp.data * Math.pow(2, current);
            current ++;
            temp = temp.next;
        }
        return sum;
    }

    public static Node<Integer> getIntersection(Node<Integer> node1, Node<Integer> node2){
        if(node1 == null || node2 == null){
            return null;
        }

        int size1 = size(node1);
        int size2 = size(node2);

        Node<Integer> temp1 = node1;
        Node<Integer> temp2 = node2;

        if(size1 > size2){
            for (int i = 0; i < size1-size2; i++) {
                temp1 = temp1.next;
            }
        }else{
            for (int i = 0; i < size2-size1; i++) {
                temp2 = temp2.next;
            }
        }

        while (temp1 != null){
            if(temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;

    }

    private static int size(Node<Integer> node) {
        int size = 0;
        Node<Integer> temp = node;
        while (temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }


}
