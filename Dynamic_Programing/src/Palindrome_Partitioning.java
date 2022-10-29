public class Palindrome_Partitioning {
   public static int palindrome(char[]s){
       int dp[][] = new int[s.length][s.length];

       for (int len = 1; len < dp.length; len++) {
           for (int row = 0, col = 0; row<s.length- len; row++,col++) {
                    if(!isPalindrome(s, row, col))
                        dp[row][col] = 0;
                    else {
                        dp[row][col] = Integer.MAX_VALUE;
                        for (int k = row; k < col; k++) {
                            dp[row][col] = Math.min(dp[row][col], dp[row][k] + dp[k + 1][col] + 1);
                        }
                    }
           }
       }
       return dp[0][s.length-1];
   }
   public static boolean isPalindrome(char[] s, int i, int j){
       while (i<j){
           if(s[i]!=s[j])
               i++; j++;
       }
       return true;
   }

    public static void main(String[] args) {
       String s = "abacc";
        System.out.println(palindrome(s.toCharArray()));
    }
}
