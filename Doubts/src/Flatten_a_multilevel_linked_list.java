public class Flatten_a_multilevel_linked_list {
    class Node {
        int data;
        Node next, down;

        Node(int data) {
            this.data = data;
            next = null;
            down = null;
        }
    }

    public Node fatten(Node root) {
        Node curr = root, last = root;

        while (curr != null) {
            while (last.next != null) {
                last = last.next;
            }
            if (curr.down == null) {
                last.next = curr.down;
            }

            curr = curr.next;
        }
        return root;
    }

}
