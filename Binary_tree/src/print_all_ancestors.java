import java.util.ArrayList;

public class print_all_ancestors {
    public static class TreeNode {
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

    public static ArrayList<Integer> Ancestors(TreeNode root, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        is_Present(root, target, ans);
        return ans;
    }

    public static boolean is_Present(TreeNode root, int target, ArrayList<Integer> ans) {
        if (root == null)
            return false;
        if (root.val == target)
            return true;

        if (is_Present(root.left, target, ans) || is_Present(root.right, target, ans)) {
            ans.add(root.val);
            return true;
        }
        return false;
    }

    public static TreeNode Lowest_Common_Ancestor(TreeNode root, TreeNode p, TreeNode q) {

        if ((root == null))
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = Lowest_Common_Ancestor(root.left, p, q);
        TreeNode right = Lowest_Common_Ancestor(root.right, p, q);

        if (right == null)
            return left;
        if (left == null)
            return right;

        return root;
    }
}