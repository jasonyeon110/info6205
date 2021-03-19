package HW6;

import java.util.ArrayList;
import java.util.List;

public class GenParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if(n == 0){
            return res;
        }

        backtrack("", n, n, res);
        return res;
    }


    public void backtrack(String path, int left, int right, List<String> res){
        if(left == 0 && right == 0){
            res.add(path);
            return;
        }
        if(left < right){
            if(left != 0){
                backtrack(path+'(', left-1, right, res);
            }
            backtrack(path+')', left, right-1, res);
        }
        else if(left == right){
            backtrack(path+'(', left-1, right, res);
        }
    }
}
