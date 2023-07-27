class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        
        for(int i=1;i<dp.length;i++){
            int ans = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&dp[i-coins[j]]!=-1){
                    ans = Math.min(ans,dp[i-coins[j]]);
                }
            }
            
            if(ans==Integer.MAX_VALUE){
               dp[i] = -1;
           }
            else{
                 dp[i] = ans + 1;
            }
        }
        
        return dp[amount];
    }
}