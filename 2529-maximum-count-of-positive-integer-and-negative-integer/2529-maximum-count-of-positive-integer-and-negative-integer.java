class Solution {
    private static int bisect_left(int[] nums, int target) {
        int lo = 0, hi = nums.length; 
        while (lo < hi) {
            int mid = lo + (hi - lo)/2; 
            if (nums[mid] < target) lo = mid+1; 
            else hi = mid; 
        }
        return lo; 
    }
    
    public int maximumCount(int[] nums) {
        int neg = bisect_left(nums, 0), pos = nums.length - bisect_left(nums, 1); 
        return Math.max(neg, pos); 
    }
}