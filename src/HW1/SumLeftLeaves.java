package HW1;

public class SumLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        } else if((root.left != null) && isLeaf(root.left)){
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }
}
