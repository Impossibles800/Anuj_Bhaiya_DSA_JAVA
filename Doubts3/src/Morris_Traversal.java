import java.util.ArrayList;
import java.util.List;

public class Morris_Traversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        TreeNode cur = root;
        while(cur!=null){
            if (cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode temp = cur.right;
                while (temp!=null && temp!= cur){
                    temp = temp.right;
                }
                if (temp.right == cur){
                    temp.right = null ;
                    ans.add(cur.val);
                    cur = cur.right;
                }
                else{
                    temp.right = cur;
                    cur = cur.left;
                }
            }
        }
        return ans;
    }

}
