public class Count_no_of_ways_to_cover_Distance {
    public static int count_ways(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <dp.length ; i++) {
            dp[i] = dp[i-2]+dp[i-1]+dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(count_ways(5));
    }
}
