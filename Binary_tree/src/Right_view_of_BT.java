import java.util.ArrayList;
import java.util.List;

public class Right_view_of_BT {
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

    public List<Integer> rightView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        int level = 0;
        right(root, level, ans);
        return ans;
    }

    void right(TreeNode root, int level, ArrayList<Integer> ans) {
        if (root == null)
            return;
        if (ans.size() == level)
            ans.add(root.val);
        right(root.right, level + 1, ans);
        right(root.left, level + 1, ans);
    }
}


