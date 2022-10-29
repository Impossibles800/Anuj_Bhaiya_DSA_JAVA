import java.util.Arrays;

public class Optimal_Strategy {
    public static int optimal_strategy(int []a, int i, int j, int [][]dp){
        if(i+1 == j)
            return dp[i][j] =  Math.max(a[i],a[j]);
        if(dp[i][j]!=-1)
            return dp[i][j];
        int left = a[i] + Math.min(optimal_strategy(a,i+2,j,dp),optimal_strategy(a,i+1, j-1,dp));
        int right = a[j] + Math.min(optimal_strategy(a,i+1,j-1,dp),optimal_strategy(a,i,j-2,dp));
        return dp[i][j] = Math.max(left,right);
    }
    public static int solution(int a[], int i, int j){
        int dp[][] = new int[a.length][a.length];
        for (int x[]:dp) {
            Arrays.fill(dp,-1);
        }
        optimal_strategy(a, i, j, dp);
        return dp[0][a.length-1];
    }
}
