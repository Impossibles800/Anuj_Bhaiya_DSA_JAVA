import java.util.*;


public class Level_order_traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return ans;
        q.add(root);
        q.add(null);
        ArrayList<Integer> currList = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                ans.add(currList);
                if (q.isEmpty())
                    return ans;
                q.add(null);
                currList = new ArrayList<>();
            }
            else{
                currList.add(curr.val);

                if(curr.left!=null)
                    q.add(curr.left);
                if (curr.right!=null)
                    q.add(curr.right);
            }
        }
        return ans;
    }
}
