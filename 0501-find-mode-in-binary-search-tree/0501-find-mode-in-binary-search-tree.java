class Solution {
    Integer prev = null;
    int max = 0, cnt = 1;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> modes = new ArrayList<>();
        traverse(root, modes);
        int[] res = new int[modes.size()];
        for(int i=0;i<modes.size();i++){
            res[i] = modes.get(i);
        }
        return res;
        
    }
    public void traverse(TreeNode root, List<Integer> modes){
        if(root == null){
            return;
        }
        traverse(root.left, modes);
        
        if(prev != null){
            if(prev == root.val)
                cnt++;
            else
                cnt = 1;
        }
        if(cnt > max){
            max = cnt;
            modes.clear();
            modes.add(root.val);
        }
        else if(cnt == max){
            modes.add(root.val);
        }
        prev = root.val;
        traverse(root.right, modes);
    }
}