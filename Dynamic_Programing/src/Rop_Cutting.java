import java.util.Arrays;

public class Rop_Cutting {
    public static int rop_cutting_cost(int[]price, int n){
        if(n == 0)
            return n;
        if (n<0)
            return -10000;

        int max_price = Integer.MIN_VALUE;
        for (int i = 0; i < price.length; i++) {
            max_price = Math.max(max_price, rop_cutting_cost(price,n-i-1)+price[i]);
        }
        return max_price;

    }
    public static int dp(int price[], int n, int dp[]){
        if(n<0)
            return Integer.MAX_VALUE;
        if(dp[n]!=-1)
            return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < price.length; i++) {
            min = Math.min(min, dp(price, n-price[i], dp));
        }
        return dp[n] = min+1;

    }

    public static int rop_cutting(int price[], int n){
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp(price,n,dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int price[] ={4,6,10,9,12};
        System.out.println(rop_cutting_cost(price,5));
    }
}
