class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
       
        for (int i=0; i<n; i++) {
            dp[i][i] = nums[i];
        }
        
        for (int len = 1; len < n; len ++) {
            for (int i=0; i+len < n; i++) {
                dp[i][i+len] = Math.max(nums[i] - dp[i+1][i+len], 
                                        nums[i+len] - dp[i][i+len-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}