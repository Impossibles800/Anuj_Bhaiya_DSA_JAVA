import java.util.HashSet;
import java.util.Set;
// Subarray with sum zero
public class Q1 {
    public static boolean sub_array_with_zero(int[] a){
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int j : a) {
            sum += j;
            if (set.contains(sum))
                return true;
            set.add(sum);
        }
        return false;
    }
}
