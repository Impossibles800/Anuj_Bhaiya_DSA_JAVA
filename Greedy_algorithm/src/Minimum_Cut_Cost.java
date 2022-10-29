import java.util.Arrays;

public class Minimum_Cut_Cost {
    public static int cost(int[] x, int[] y, int M, int N) {
        Arrays.sort(x);
        Arrays.sort(y);

        int i = M - 1, j = N - 1;
//        count of boards present in v and h direction
        int h = 1, v = 1;
        int ans = 0;
        while (i >= 0 && j >= 0) {
            if (x[i] >= y[j]) {
                ans += x[i] * h;
                i--;
                v++;
            } else {
                ans += y[j] * v;
                j--;
                h++;
            }
        }
        if (i >= 0) {
            while (i >= 0) {
                ans += x[i] * h;
                i--;
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                ans += y[j] * v;
                j--;
            }
        }
        return ans;
    }
}
