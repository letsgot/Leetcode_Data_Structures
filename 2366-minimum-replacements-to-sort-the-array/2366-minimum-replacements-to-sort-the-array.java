class Solution {
    public long minimumReplacement(int[] nums) {
        
        long ans = 0;
        int n = nums.length;
        int last = nums[n-1];
        
        for(int i=n-2;i>=0;i--){
            if(nums[i]>last){
                int t = nums[i]/last;
                if (nums[i] % last != 0) {
                    t++;  // If there's a remainder, increment 't'
                }
                last = nums[i] / t;  // Update 'last' for the next comparison
                ans += t - 1;
            }
            else{
                last = nums[i];
            }
        }
        
        return ans;
    }
}