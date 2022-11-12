class Solution {
    Random r;
    HashMap<Integer,List<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<>();
        r = new Random();
        
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(!map.containsKey(val)){
                map.put(val,new ArrayList<>());
            }
            map.get(val).add(i);
        }
    }
    
    public int pick(int target) {
        if(!map.containsKey(target)){
            return -1;
        }
        
        return map.get(target).get(r.nextInt(map.get(target).size()));
    }
}

//  List<Integer> curList = map.get(target);
//         return curList.get(random.nextInt(curList.size()));

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */