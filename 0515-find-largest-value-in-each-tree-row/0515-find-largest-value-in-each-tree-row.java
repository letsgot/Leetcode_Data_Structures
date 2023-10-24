/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<>();
        
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        
        while(que.size()>0){
            int sz = que.size();
            int val = Integer.MIN_VALUE;
            for(int i=0;i<sz;i++){
                //  r w ac
                TreeNode rem = que.remove();
                
                val = Math.max(val,rem.val);
                
                if(rem.left!=null){
                    que.add(rem.left);
                }
                
                if(rem.right!=null){
                    que.add(rem.right);
                }
            }
            ans.add(val);
        }
        
        return ans;
    }
}