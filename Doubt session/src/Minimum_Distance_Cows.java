public class Minimum_Distance_Cows {

    public static int aggresiveCows(int[] a, int k) {
        int l = 1;
        int r = a[a.length - 1];
        int ans = -1;
        if (a.length < k)
            return -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (Can_accomodate(a, k, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static boolean Can_accomodate(int[] a, int k, int distance) {
        int prev = a[0];
        int cows = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - prev >= distance) {
                cows++;
                prev = a[i];
                if (cows == k)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println(aggresiveCows(a, k));
    }
}
