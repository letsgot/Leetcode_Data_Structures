class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int lo = 0;
        int hi = nums[n-1] - nums[0];
        
        while(lo<hi){
            
            int mid = (lo + hi)/2;
            
            int countPair = 0;
            
            for(int i=1;i<n&&countPair<p;i++){
                int d = nums[i] - nums[i-1];
                if(d<=mid){
                    i++;
                    countPair++;
                }
            }
            
            if(countPair>=p){
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        
        return lo;
    }
}