class Solution {
    public int findDuplicate(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            int v = Math.abs(nums[i]);
            
            if(nums[v-1]<0){
                return v;
            }
            else{
                nums[v-1] = -1 * nums[v-1];
            }
        }
        
        return -1;
        
        // for(int i : nums){
        //     if(nums[Math.abs(i)]<0){
        //         return Math.abs(i);
        //     }
        //     else{
        //         nums[Math.abs(i)] = -1 * nums[Math.abs(i)];
        //     }
        // }
        // return -1;
    }
}