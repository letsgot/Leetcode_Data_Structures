class Solution {
    public boolean isMonotonic(int[] nums) {

        int im = 0;
        int dm = 0;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                
            }
            else if(nums[i]>nums[i-1]){
                if(dm==1){
                    return false;
                }
                im = 1;
            }
            else{
                if(im==1){
                    return false;
                }
                dm = 1;
            }
        }
        
        return true;
    }
}