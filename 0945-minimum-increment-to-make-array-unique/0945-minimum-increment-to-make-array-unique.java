class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int cost = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1]){
                int val = nums[i];
                int pval = nums[i-1]+1;
                cost += (pval - val);
                   nums[i] = nums[i-1] + 1;
            }
        }     
        return cost;
        
        // Arrays.sort(nums);
        // int ans = 0;
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] <= nums[i - 1]) {
        //         ans += nums[i - 1] - nums[i] + 1;
        //         nums[i] = nums[i - 1] + 1;
        //     }
        // }
        // return ans;
        
    }
}