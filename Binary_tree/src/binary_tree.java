import java.util.Scanner;

public class binary_tree {
 Scanner sc;
 public binary_tree() {
     sc = new Scanner(System.in);
 }

    public Node create(){
        System.out.println("Enter the data");
        int data = sc.nextInt();

        if(data == -1)
            return null;
        Node node = new Node(data);
        System.out.println("Enter the left data of " +data);
        Node left = create();
        System.out.println("Enter the right data of " +data);
        Node right = create();

        return node;
    }

    public class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    void inOrderTraversal(Node node){
        if(node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
    public static int height(Node node){

     if(node == null)
         return 0;

     return Math.max(height(node.left),height(node.right))+1;
    }

    public static void main(String[] args) {
        binary_tree bt = new binary_tree();
        Node root = bt.create();
        bt.inOrderTraversal(root);
    }
}
