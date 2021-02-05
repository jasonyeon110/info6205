package HW1;

import java.util.ArrayList;
import java.util.List;

public class FindLeaves {

    public List<List<Integer>> findLeaves(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return null;
        }
        //get the bottom leaves and add to the ArrayList
        getLeaves(result, root);

        return result;
    }

    private int getLeaves(List<List<Integer>> result, TreeNode root) {
        if(root == null){
            return 0;
        }

        int lHeight = getLeaves(result, root);
        int rHeight = getLeaves(result, root);
        int height = Math.max(lHeight, rHeight) + 1;

        if(result.size() <= height){
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        return height;
    }

}
