import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class inorder_traversal_without_recursion {
    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public List<Integer> inorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();

        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node pop = stack.pop();
            ans.add(pop.data);
            cur = pop.right;
        }
        return ans;
    }

    public List<Integer> perorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return null;

        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node pop = stack.pop();

            ans.add(pop.data);

            if (pop.right != null)
                stack.push(root.right);
            if (pop.left != null)
                stack.push(root.left);
        }
        return ans;
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<Node> s1 = new ArrayDeque<>();
        ArrayDeque<Node> s2 = new ArrayDeque<>();

        s1.push(root);
        while (!s1.isEmpty()) {
            Node pop = s1.pop();

            s2.push(pop);
            if (pop.left != null)
                s1.push(pop.left);
            if (pop.right != null)
                s1.push(pop.right);

        }
        while (!s2.isEmpty())
            ans.add(s2.pop().data);

        return ans;
    }

    public int diameter(Node root) {
        if (root == null)
            return 0;
//        int ld = diameter(root.left);
//        int rd = diameter(root.right);
//        int lh = height(root.left);
//        int rh = height(root.right);
//        int cur = lh + rh;
//
//        return Math.max(cur, Math.max(ld, rd));
        int ans = 0;
        height(root, ans);
        return ans;
    }

    public int height(Node root, int a) {
        if (root == null)
            return 0;
        int ans =0;
        int lheight = height(root.left, a);
        int rheight = height(root.right, a);
        a = Math.max(ans, lheight + rheight);
        return 1 + Math.max(lheight, rheight);
    }

}
