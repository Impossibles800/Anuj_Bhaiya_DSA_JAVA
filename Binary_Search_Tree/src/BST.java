public class BST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isPresent(Node root, int key) {
        if (root == null)
            return false;
//        if (root.data == key)
//            return true;
//        if (key>root.data)
//            return isPresent(root.right, key);
//        return isPresent(root.left, key);

        Node cur = root;
        while (cur != null) {
            if (cur.data == key)
                return true;
            if (key > cur.data)
                cur = cur.right;
            else
                cur = cur.left;
        }
        return false;
    }

    public static Node insert(Node root, int value) {
//        Node parent = null, cur = root;
//        while (cur != null) {
//            if (value > cur.data) {
//                parent = cur;
//                cur = cur.right;
//            } else if (value < cur.data){
//                parent = cur;
//                cur = cur.left;
//            }
//        }
//        Node new_node = new Node(value);
//        if (parent == null)
//            parent.right = new_node;
//        else if (value < parent.data)
//            parent.left = new_node;
//        else
//            parent.right = new_node;

        if (root==null)
            return new Node(value);
        if (value>root.data)
            root.right = insert(root.right, value);
        else if (value< root.data) {
            root.left = insert(root.left, value);
        }
        return root;
    }
     static Node parent = null;
//    public static Node delete(Node root, int key){
////        Node cur = root;
////        while (cur!=null){
////            if (cur.data == key)
////                break;
////            else if (key> cur.data) {
////                parent = cur;
////                cur = cur.right;
////            }
////            else {
////                parent = cur;
////                cur = cur.left;
////            }
////            if (cur == null)
////                return root;
////
////            if (cur.left == null){
////                if (cur.data< parent.data)
////                    parent.left = cur.right;
////                else if (cur.data> parent.data) {
////                    parent.right = cur.right;
////                }
////            }
////            if (cur.right == null){
////                if (cur.data< parent.data)
////                    parent.left = cur.left;
////                else if (cur.data > parent.data) {
////                    parent.right = cur.left;
////                }
////            }
////        }
////        int inorder_successor = findMin(cur.right);
////        cur.data = inorder_successor;
////        delete(root.right, inorder_successor);
////        return root;
//
//
//    }
//    public int findMin(Node root){
//        Node cur = root;
//        while (cur.left!=null)
//            cur = cur.left
//    }

}
