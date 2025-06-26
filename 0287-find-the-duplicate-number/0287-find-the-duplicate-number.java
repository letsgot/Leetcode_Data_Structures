class Solution {
    public int findDuplicate(int[] nums) {
        int [] helper = new int[nums.length];

        for(int val : nums){
            if(helper[val-1]<0){
                return val;
            }

            helper[val-1] = -1 * val;
        }

        return -1;
    }
}