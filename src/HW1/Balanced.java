package HW1;

public class Balanced {

    public boolean isBalanced(TreeNode root){
        return MaxHeight(root) != null;

    }

    //find the height of the subTree
    private Integer MaxHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        Integer leftH = MaxHeight(root.left);
        Integer rightH = MaxHeight(root.right);

        if(leftH == null || rightH == null){
            return null;
        }

        if(Math.abs(leftH - rightH)> 1) {
            return null;
        }

        return Math.max(leftH, rightH) + 1;

    }
}
