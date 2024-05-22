class Solution {
    public boolean isArraySpecial(int[] nums) {
        
        for(int i=1;i<nums.length;i++){
            int v1 = nums[i-1];
            int v2 = nums[i];
            
            if(v1%2==v2%2){
                return false;
            }
        }
        
        return true;
    }
}