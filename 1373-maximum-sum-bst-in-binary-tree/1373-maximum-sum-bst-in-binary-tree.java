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
    public class Pair{
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        boolean check = false;
        
        Pair(int max,int min,int sum,boolean check){
            this.max = max;
            this.min = min;
            this.check = check;
            this.sum = sum;
        }
    }
    
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
    
    public Pair helper(TreeNode root){
        if(root==null){
            return new Pair(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        }
        else if(root.left==null&&root.right==null){
            ans = Math.max(ans,root.val);
            return new Pair(root.val,root.val,root.val,true);
        }
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        int sum = left.sum + right.sum + root.val;
        int min = Math.min(Math.min(root.val,left.min),right.min);
        int max = Math.max(Math.max(root.val,left.max),right.max);
        boolean check = true;
        if(left.check==false||right.check==false){
            check = false;
        }
        else if(left.max>=root.val||right.min<=root.val){
            check = false;
        }
        
        if(check==true){
            ans = Math.max(ans,sum);
        }
        
        return new Pair(max,min,sum,check);
        
    }
}