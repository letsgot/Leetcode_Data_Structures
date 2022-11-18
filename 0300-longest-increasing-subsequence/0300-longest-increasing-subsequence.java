class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        
        dp[0] = nums[0];
        int len = 1;
        for(int i=1;i<nums.length;i++){
            if(dp[len-1]<nums[i]){
                len++;
                dp[len-1] = nums[i];
            }
            else{
                int idx = Arrays.binarySearch(dp,0,len-1,nums[i]);
                if(idx<0){
                    idx = idx * -1;
                    idx--;
                }
                
                dp[idx] = nums[i];
            }
        }
        
        return len;
    }
}