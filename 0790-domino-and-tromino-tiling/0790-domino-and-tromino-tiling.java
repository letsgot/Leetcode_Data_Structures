class Solution {
    public int numTilings(int n) {
        long[]dp = new long[n+3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        
        for(int i=4;i<=n;i++){
            dp[i] = (dp[i-1] * 2 + dp[i-3])%1000000007;
        }
        
        return (int)(dp[n]);
    }
}