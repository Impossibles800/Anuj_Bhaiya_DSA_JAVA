import com.sun.source.tree.Tree;

public class valid_bst {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
//      This code is not correct
//        if(root == null)
//            return true;
//        if (root.left != null && root.left.val < root.val
//            && root.right != null && root.right.val > root.val)
//            return false;
//        return isValidBST(root.left) && isValidBST(root.right);

        return is_valid(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
    boolean is_valid(TreeNode root, long min_value, long max_value){
        if(root==null)
            return true;
        if(root.val<=min_value || root.val>=max_value)
            return false;
        return is_valid(root.left, min_value, root.val)&&is_valid(root.right, max_value, root.val);
    }

    public int find_min_distance(TreeNode root, int a, int b){
        if (root == null)
            return 0;
        if(root.val>a && root.val>b)
            return find_min_distance(root.left,a,b);
        if (a> root.val && b>root.val)
            return find_min_distance(root.right, a, b);
        return 1+Math.min(find_min_distance(root.left, a, root.val), find_min_distance(root.right, root.val, b));

    }
    public int distance(TreeNode root, int a){
        if(root == null || root.val == a)
            return 0;

        if(a < root.val)
            return 1 + distance(root.left, a);
        return 1 + distance(root.right, a);
    }
}
