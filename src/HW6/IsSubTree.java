package HW6;

public class IsSubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null){
            return false;
        }

        boolean res = isEqual(s, t);

        if(!res){
            res = isSubtree(s.left, t);
        }
        if(!res){
            res = isSubtree(s.right, t);
        }
        return res;
    }

    public boolean isEqual(TreeNode s, TreeNode t){
        if(t == s) {
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        return (s.val == t.val) && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }
}


