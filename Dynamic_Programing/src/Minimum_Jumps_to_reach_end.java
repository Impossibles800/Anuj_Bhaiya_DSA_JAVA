import java.util.Arrays;

public class Minimum_Jumps_to_reach_end {
    public static int minimum_jumps(int[]a, int i, int dp[]){
        if(i >= a.length-1){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        if(a[i] == 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <=a[i] ; j++) {
            min = Math.min(min, minimum_jumps(a, i+j, dp)+1);
        }
        return dp[i] =  min;
    }
    public static int jumps(int a[]){
        int dp[] = new int[a.length+1];
        Arrays.fill(dp,-1);
       return minimum_jumps(a,0,dp);
    }

    public static void main(String[] args) {
        int [] a ={3,2,4,1,3,5,1,1,2};
        System.out.println(jumps(a));
    }
}
