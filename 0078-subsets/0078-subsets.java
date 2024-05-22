class Solution {
    static List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        recursion(nums,0,new ArrayList<>());
        return ans;
    }
    
    public static void recursion(int[]nums,int idx, ArrayList<Integer> curr){
        if(idx>=nums.length){
            ans.add(curr);
            return;
        }
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        int val = nums[idx];
        
        for(int v : curr){
            l1.add(v);
            l2.add(v);
        }
        
        l2.add(val);
        
        recursion(nums,idx+1,l1);
        recursion(nums,idx+1,l2);
        
        return;
    }
}