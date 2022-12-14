class Solution {
    public int rob(int[] nums) {
       
        int use = nums[0];
        int not = 0;
        
        for(int i=1;i<nums.length;i++){
            int nuse = nums[i] + not;
            int nnot = Math.max(use,not);
            
            use = nuse;
            not = nnot;
        }
        
        return Math.max(not,use);
    }
}