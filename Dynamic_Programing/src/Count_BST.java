public class Count_BST {
    public static int count_bst(int n){
        int dp[] = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            int res = 0;
            for (int j = 0; j < i; j++) {
                res += dp[j]*dp[i-j-1];
            }
            dp[i] = res;
        }
        for (int e: dp) {
            System.out.print(e+" ");
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(count_bst(10));

    }
}
