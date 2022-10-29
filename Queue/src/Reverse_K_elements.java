import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;

public class Reverse_K_elements {
    public static Queue<Integer> reverse(Queue<Integer> q, int k){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (q.isEmpty() || k<=0 || k>q.size())
            return q;
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }
        while (!stack.isEmpty()){
            q.add(stack.pop());
        }
        for (int i = 0; i < q.size()-k; i++) {
            q.add(q.poll());

        }
        return q;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        System.out.println(q);
        reverse(q, 3);
        System.out.println(q);
    }
}
