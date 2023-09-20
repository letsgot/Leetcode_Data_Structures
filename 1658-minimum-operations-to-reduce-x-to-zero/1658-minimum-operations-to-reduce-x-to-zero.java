class Solution {
    public int minOperations(int[] nums, int x) {
        
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        
        if(sum<x){
            return -1;
        }
        
        if(x<nums[0]&&x<nums[nums.length-1]){
            return -1;
        }
        
        int rsum = sum - x;
        
        int csum = 0;
        
        int i = -1;
        int mlen = 0;
        
        for(int j=0;j<nums.length;j++){
            int val = nums[j];
            csum += val;
            
            if(rsum==csum){
                int len = j - i;
                mlen = Math.max(len,mlen);
            }
            else if(csum>rsum){
                while(csum>rsum){
                    i++;
                    csum -= nums[i];
                }
                
                if(rsum==csum){
                    int len = j - i;
                    mlen = Math.max(len,mlen);
                }
            }
            else{
                
            }
            
        }
      
        
        return nums.length - mlen;
    }
}