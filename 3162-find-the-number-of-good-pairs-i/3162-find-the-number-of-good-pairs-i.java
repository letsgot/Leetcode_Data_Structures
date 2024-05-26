class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for(int val : nums1){
            for(int num : nums2){
                int div = num * k;
                if(val % div==0){
                    count++;
                }
            }
        }
        
        return count;
    }
}