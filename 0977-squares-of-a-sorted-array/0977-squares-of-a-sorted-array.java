class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];
        int i = 0;
        int j = ans.length-1;
        int k = ans.length-1;
        while(k>=0){
            int left = nums[i]*nums[i];
            int right = nums[j]*nums[j];
            if(left>right){
                i++;
                ans[k] = left;
            }
            else{
                j--;
                ans[k] = right;
            }
            k--;
        }
        return ans;
    }
}