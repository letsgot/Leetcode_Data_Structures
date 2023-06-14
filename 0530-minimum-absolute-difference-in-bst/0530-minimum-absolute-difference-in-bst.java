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
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return ans;
    }
    
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        
        inorder(root.left);
        if(prev!=null){
            ans = Math.min(ans,Math.abs(root.val - prev.val));
        }
        prev = root;
        inorder(root.right);
            
    }
}