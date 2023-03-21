class Solution {
    long count = 0;
    
    public long zeroFilledSubarray(int[] nums) {
        count = 0;
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                ans += ++count;
            }
            else{
                count = 0;
            }
        }
        return ans;
    }
}