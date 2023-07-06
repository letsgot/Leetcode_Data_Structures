class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int j = 0;
        int len = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            
            sum += nums[i];
          
            if(sum>=target){
                len = Math.min(len,i-j+1);
            }
            
            while(j<=i&&sum>=target){
                len = Math.min(len,i-j+1);
                sum -= nums[j];
                j++;
            }
            
          
          
        }
        if(len == Integer.MAX_VALUE){
            len = 0;
        }
        return len;
    }
}