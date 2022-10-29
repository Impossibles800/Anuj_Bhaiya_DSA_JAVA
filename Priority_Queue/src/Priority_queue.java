import java.util.*;

public class Priority_queue {



    public static int kth_largest_element(int[] a, int k) {
        if (k > a.length)
            return -1;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(a[i]);
        }
        for (int i = k; i < a.length; i++) {
            if (queue.peek() < a[i]) {
                queue.poll();
                queue.offer(a[i]);
            }
        }
        return queue.peek();
    }

    public static int kth_smallest_element(int[] a, int k) {
        if (k > a.length)
            return -1;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            queue.offer(a[i]);
        }
        for (int i = k; i < a.length; i++) {
            if (queue.peek() > a[i]) {
                queue.poll();
                queue.offer(a[i]);
            }
        }
        return queue.peek();
    }
    public static long min_cost(int[]a, int n){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long e: a){
            pq.offer(e);
        }
        long ans = 0;
        while (pq.size()>1){

            long first = pq.poll();
            long second = pq.poll();

            long cost = first+second;
            ans+=cost;
            pq.offer(cost);
        }
        return ans;
    }
    public static int split_array(int[] a, int k){

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(0);
        }
        Arrays.sort(a);
        for (int i = a.length-1; i >=0; i++) {
            int cur = a[i];
            int top = pq.poll();
            int to_add = cur + top;
            pq.offer(to_add);
        }
        int max = -1;
        for (int e: pq) {
            max = Math.max(max,e);
        }
        return max;
    }
//    public static int median(int []a){
//        boolean even = true;
//        PriorityQueue<Integer> min = new PriorityQueue<>();
//        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
//        if(even){
//            min.offer(num);
//            max.offer(min.poll());
//        }
//        else {
//            max.offer(num);
//            min.offer(max.poll);
//        }
//        even = !even;
//
////        median
//        if(even){
//            return (min.peek()+max.peek())/2.0;
//        }
//        else{
//            return (double)max.peek();
//        }
//    }

    public static void main(String[] args) {
        //        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
//
//        queue.offer(23);
//        queue.offer(7523);
//        queue.offer(723);
//        queue.offer(236);
////        System.out.println(-queue);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());

//        int [] a = {1,4,2,4,7,2,4,5,6,3};
//        int k =3;
//        System.out.println(split_array(a, k));
    }
}
