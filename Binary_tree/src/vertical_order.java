import java.security.Key;
import java.security.KeyPair;
import java.util.*;

public class vertical_order {
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

//    public ArrayList<Integer> verticalOrder(TreeNode root){
//        ArrayList<Integer> ans = new ArrayList<>();
//        Queue<Pair> q = new LinkedList<>();
//        Map<Integer, Integer> map = new TreeMap<>();
//        q.add(new Pair(0, root));
//        while(!q.isEmpty()){
//            Pair cur = q.poll();
//            int key = curr.hd;
//            if(!map.containsKey(key))
//                map.put(key, new ArrayList<Integer>());
//            map.get(key).add(cur.TreeNode.value);
//
//            if(curr)
//        }
//    }
//    


}
