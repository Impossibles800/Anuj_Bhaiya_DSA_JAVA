import java.util.Arrays;

public class Activity {
    static class Pair implements Comparable<Pair>{
        int s, e;
        public Pair(int s, int e){
            this.s =s;
            this.e =e;
        }
        public int compareTo(Pair that){
            return this.e - that.e;
        }
    }
    public static int activity_selection(int[] start, int[] end, int n){
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(start[i], end[i]);
        }
        Arrays.sort(a);
        int ans = 1;
        int curr_end = a[0].e;
        for (int i = 1; i <n ; i++) {
            if(a[i].s>curr_end){ //
                ans++;
                curr_end= a[i].e;
            }
        }
        return ans;
    }
}
