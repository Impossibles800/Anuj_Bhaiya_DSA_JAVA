public class Longest_Subsequences {
    public static int longest_subsequence(int []a){
        int n = a.length;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i <n ; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);

            }
        }
//        for maximum element in the array
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i <n ; i++) {
//            max = Math.max(max, dp[i]);
//        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(longest_subsequence(new int[]{4,6,1,3,5,9,8}));
    }
}
