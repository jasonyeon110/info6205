package HW2;

public class SplitList {
    public ListNode[] splitListToParts(ListNode root, int k){
        ListNode[] result = new ListNode[k];

        //if root is null or k is less then 1, just return the ListNode[]
        if(root == null || k < 1){
            return result;
        }

        int nodeLength = 0;
        ListNode current = root;

        //find the length of the node
        while(current != null){
            nodeLength ++;
            current = current.next;
        }

        if(nodeLength == 0){
            return result;
        }

        //calculate the greatest number of node that goes
        //into an array  ex) 5(nodeLength) / 3(k) = 1 + 1 = 2
        //Therefore two nodes go into the first array
        int largePortion = nodeLength/k ;

        //calculate how many of the largePortions
        int numberOfPortions = nodeLength % k;


        //reset the current node to the root
        current = root;
        int count = 0;

        while (current != null){
            ListNode previous = null;
            result[count++] = current;

            for(int i = 0; i < largePortion; i ++){
                previous = current;
                current = current.next;
            }

            if(numberOfPortions > 0 && count <= numberOfPortions){
                previous = current;
                current = current.next;
            }

            if (previous != null){
                previous.next = null;
            }
        }
        return result;
    }

}
