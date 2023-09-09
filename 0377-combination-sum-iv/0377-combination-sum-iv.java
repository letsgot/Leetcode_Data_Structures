class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        
        for(int i=1;i<=target;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                int idx = i-nums[j];
                if(idx>=0){
                    count += dp[i-nums[j]];
                }
            }
            dp[i] = count;
        }
        
        return dp[target];
    }
}