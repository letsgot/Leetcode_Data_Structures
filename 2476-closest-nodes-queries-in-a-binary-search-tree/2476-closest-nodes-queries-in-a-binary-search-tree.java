class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        fill(set,root);
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int val : queries){
            ArrayList<Integer> al = new ArrayList<>();
            
            al.add(set.floor(val)==null?-1:set.floor(val));
            al.add(set.ceiling(val)==null?-1:set.ceiling(val));
            
            list.add(al);
        }
        
        return list;
    }
    
    public void fill(TreeSet<Integer> set,TreeNode root){
        if(root==null){
            return;
        }
        
        set.add(root.val);
        
        fill(set,root.left);
        fill(set,root.right);
    }
}