import java.util.Arrays;

public class Fibonacci_Number {
    public static int fibonacci_number(int n){

        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        fibdp(n, dp);
        return dp[n];

    }
    public static int fibdp(int n, int []dp){
        if(dp[n]!=-1)
            return dp[n];
        return dp[n] = fibdp(n-1,dp)+fibdp(n-2, dp);
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(fibonacci_number(n));
    }
}
