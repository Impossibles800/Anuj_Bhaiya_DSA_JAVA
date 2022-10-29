import java.util.Arrays;

public class Edit_Distance {
    public static int edit_distance(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int [][] dp = new int[n+1][m+1];
//        for (int i = 0; i <=n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
        return tabular_edit_distance(s1,s2,s1.length(),s2.length(),dp);
//        return edit_distance_dp(s1, s2, n, m, dp);
//        return edit_distance_recursion(s1, s2, s1.length(), s2.length());
    }
    public static int edit_distance_recursion(String s1, String s2, int n, int m){

        if(n == 0)
            return m;
        if(m == 0)
            return n;
        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return edit_distance_recursion(s1, s2, n - 1, m - 1);
        }
        else {
            return Math.min(Math.min(edit_distance_recursion(s1,s2,n-1,m), edit_distance_recursion(s1,s2,n,m-1)),edit_distance_recursion(s1,s2,n-1,m-1))+1;
        }
    }
    public static int tabular_edit_distance(String s1, String s2, int n, int m, int[][] dp){
        for (int i = 0; i <=m; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <=n ; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[n][m] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
            }
        }
        return dp[n][m];
    }
    public static int edit_distance_dp(String s1, String s2, int n, int m, int[][]dp){
        if (n == 0)
            return m;
        if (m == 0)
            return n;
        if (dp[n][m] != -1)
            return dp[n][m];
        if (s1.charAt(n-1) == s2.charAt(m-1))
            return dp[n][m] = edit_distance_dp(s1, s2, n-1, m-1, dp);
        else
            return dp[n][m] = Math.min(Math.min(edit_distance_dp(s1, s2, n-1, m, dp), edit_distance_dp(s1, s2, n, m-1, dp)),edit_distance_dp(s1, s2, n-1, m-1, dp))+1;
    }

    public static void main(String[] args) {
        System.out.println(edit_distance("cat","cut"));
    }
}
