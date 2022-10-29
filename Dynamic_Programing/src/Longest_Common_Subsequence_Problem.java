import java.util.Arrays;
import java.util.Map;

public class Longest_Common_Subsequence_Problem {
    public static int longest_Subsequence(String s1, String s2, int m, int n, int[][]dp){
//        m = s1.length() n = s2.length()
//    if(m == 0 || n == 0)
//        return 0;
//    if(s1.charAt(m-1) == s2.charAt(n-1))
//        return longest_Subsequence(s1,s2,m-1,n-1)+1;
//    else
//        return Math.max(longest_Subsequence(s1,s2,m,n-1), longest_Subsequence(s1, s2, m-1, n));

        if (m == 0 || n == 0)
            return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1))
            return dp[m][n] = longest_Subsequence(s1,s2,m-1,n-1,dp)+1;
        else
            return dp[m][n] = Math.max(longest_Subsequence(s1,s2,m,n-1,dp),longest_Subsequence(s1,s2,m-1,n,dp));
    }
    public static int lcs(String a, String b){
        int[][]dp = new int[a.length()+1][b.length()+1];
        for (int i = 0; i <=a.length(); i++) {
            Arrays.fill(dp[i], -1);
//            Arrays.fill(dp[i], 0);  For tabular Method
        }
        return longest_Subsequence(a,b,a.length(),b.length(),dp);
    }
    public static int lcs_tabular(String a, String b, int m, int n, int dp[][]){
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(lcs("APBDT", "LAT"));
    }
}
