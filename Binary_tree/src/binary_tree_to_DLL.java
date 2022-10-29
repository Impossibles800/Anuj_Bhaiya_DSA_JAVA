public class binary_tree_to_DLL {

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

    TreeNode prev = null, head = null;

    public void bToDLL(TreeNode root) {
        if (root == null)
            return;
        bToDLL(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        bToDLL(root.right);
    }

    public TreeNode BToDll(TreeNode root) {
        bToDLL(root);
        return head;
    }
}
