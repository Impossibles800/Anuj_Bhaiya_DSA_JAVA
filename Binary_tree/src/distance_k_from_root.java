public class distance_k_from_root {
    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public void print(Node root, int k){
        if(root == null)
            return;
        if (k == 0)
            System.out.println(root.data);
        print(root.left, k-1);
        print(root.right, k-1);
    }

}
