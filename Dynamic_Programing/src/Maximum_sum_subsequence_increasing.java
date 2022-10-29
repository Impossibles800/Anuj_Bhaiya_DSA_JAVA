public class Maximum_sum_subsequence_increasing {
    public static int max_sum(int arr[]){
        int dp[] = new int[arr.length];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length ; i++) {
            dp[i] = arr[i];
            for (int j = 0; j <i ; j++) {
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+arr[i]);
                }
            }
        }
        int max = 0;
        for (int e:arr) {
            max = Math.max(max, e);
        }
        return max;
    }
}
