import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman_Coding {

    static class Node{
        char c;
        int f;
        Node left, right;
        public Node(char c, int f, Node left, Node right){
            this.c = c;
            this.f = f;
            this.left = left;
            this.right= right;
        }
    }

    public static Node Huffman_Encoding(char[] c, int[] freq){
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)-> n1.f- n2.f);
        int n = c.length;
        for (int i = 0; i < n; i++) {
            pq.add(new Node(c[i],freq[i],null,null));
        }
        while (pq.size()>1){
            Node left = pq.poll();
            Node right = pq.poll();

            Node node = new Node('_', left.f+ right.f, left, right);
            pq.add(node);
        }
        return pq.poll();
    }
    public static void traversal(Node root, String s, Map<Character, String> map){
        if(root == null)
            return;
        if(root.left==null && root.right==null){
            map.put(root.c,s);
            return;
        }
        traversal(root.left, s+'0', map);
        traversal(root.right, s+'1', map);
    }

    public static String encoding(String s, Map<Character, String>map){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(map.get(s.charAt(i)));
        }
        return sb.toString();
    }
    public static String decoding(Node root, String s){
        StringBuilder sb = new StringBuilder();
        Node curr = root;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='0')
                curr = curr.left;
            else
                curr = curr.right;
            if(curr.left==null && curr.right==null){
                sb.append(curr.c);
                curr = root;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        char [] c= {'a','b','c','d'};
        int freq[] ={5,3,2,1};
        Map<Character, String> map = new HashMap<>();
        Node root = Huffman_Encoding(c,freq);
        traversal(root,"", map);
        System.out.println(map);
        String s = "abcd";
        System.out.println(encoding(s, map));
    }

}
