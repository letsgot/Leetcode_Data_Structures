class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length-1;

       while(i<=k){
            int num = nums[i];
            if(num==2){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k--;
            }
            else if(num==1){
                i++;
            }
            else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
    }
}