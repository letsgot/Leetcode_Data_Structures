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
        int size = 0;
        int sum = 0;
        Pair(){}
        Pair(int size,int sum){
            this.size = size;
            this.sum = sum;
        }
    }
    
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
       count = 0;
        helper(root);
        return count;
    }
    
    public Pair helper(TreeNode root){
         if(root==null){
            return new Pair();
        }
        
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        int avg = (left.sum + right.sum +root.val) / (left.size + right.size + 1);
        if(avg==root.val){
            count++;
        }
        
        int sum = left.sum + right.sum + root.val;
        int size = left.size + right.size + 1;
        
        return new Pair(size,sum);
    }
}