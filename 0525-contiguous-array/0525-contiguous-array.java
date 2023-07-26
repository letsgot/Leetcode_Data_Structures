class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0,-1);
        
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            sum += val==1?1:-1;
            if(map.containsKey(sum)==false){
               map.put(sum,i); 
            }
            else{
                int fi = map.get(sum);
                ans = Math.max(i-fi,ans);
            }
            
            
        }
        
        return ans;
    }
}