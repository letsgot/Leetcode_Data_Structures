class Solution {
    public int longestArithSeqLength(int[] nums) {
        if(nums.length<=2){
            return 2;
        }
        
        // Arrays.sort(nums);
        
        HashMap<Integer,Integer> [] arr = new HashMap[nums.length];
        
        for(int i=0;i<nums.length;i++){
            arr[i] = new HashMap<>();
        }
        
        int ans = 2;
        
        for(int i=nums.length-2;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                int val = nums[j] - nums[i];
                
                HashMap<Integer,Integer> m = arr[j];
                HashMap<Integer,Integer> mi = arr[i];
                if(m.containsKey(val)){
                    int max = m.get(val)+1;
                    mi.put(val,max);
                    ans = Math.max(ans,max);
                }
                else{
                    mi.put(val,2);
                }
            }
        }
        
        return ans;
    }
}