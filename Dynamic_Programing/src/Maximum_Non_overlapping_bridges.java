import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Non_overlapping_bridges extends Longest_Subsequences {
    public static int max_Non_overlap_bridges(Integer a[][]){
        Arrays.sort(a, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                  if(o1[0] == o2[0])
                      return o1[1]-o2[1];
                  else
                      return o1[0]-o2[0];
            }
        });
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i][1];
        }
        return longest_subsequence(b);
    }

    public static void main(String[] args) {
        Integer a[][] = {
                {0,2},{1,1},{2,7}
        };
    }
}
