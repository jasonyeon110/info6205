package MidTerm1;

import java.util.Stack;

public class Problem2 {

    public static void printPerimeter(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        printPerimeter(root, 0, 0, stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop().val + ", ");
        }
        System.out.println("");
    }
//
    private static void printPerimeter(TreeNode node, int left, int right, Stack<TreeNode> stack){
        if(node != null){
            if(node.left == null && node.right == null){
                System.out.print(node.val + ", ");
            } else {
                if(right == 0){
                    System.out.print(node.val + ", ");
                } else if (left == 0){
                    stack.push(node);
                }
            }

            printPerimeter(node.left, left + 1, right, stack);
            printPerimeter(node.right, left, right + 1, stack);
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);

        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);

        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);

        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);

        printPerimeter(tree);
    }
    /**
     * time and space complexity O(n)
     */
}
