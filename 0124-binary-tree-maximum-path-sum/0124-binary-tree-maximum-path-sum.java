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
    
    static int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        sumPaths(root);
        return max;
    }
    
    public int sumPaths(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int left = sumPaths(root.left);
        int right = sumPaths(root.right);
        
        int ldash = Math.max(0,left);
        int rdash = Math.max(0,right);
        
        int sum = ldash + rdash + root.val;
        max = Math.max(sum,max);
        
        int val = Math.max(Math.max(ldash + root.val,rdash + root.val),root.val);
        return val;
    }
}