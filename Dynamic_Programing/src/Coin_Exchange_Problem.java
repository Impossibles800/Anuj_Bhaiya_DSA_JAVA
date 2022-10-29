import java.lang.reflect.Array;
import java.util.Arrays;

public class Coin_Exchange_Problem {
    public static int min_coins(int[] coins, int target, int dp[]){
        if(target == 0)
            return 0;
        if(dp[target]!=0)
            return dp[target];
        int min_coin = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            min_coin = Math.min(min_coin, min_coins(coins, target-coins[i],dp));
        }
        return dp[target]=min_coin+1;


    }
    public static int helper(int a[], int n){

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        min_coins(a, n, dp);
        return dp[n];

    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int target = 13;
        System.out.println(helper(coins, target));
    }
}
