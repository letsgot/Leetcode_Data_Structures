class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0,count = 0;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            sum += val;
            
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}