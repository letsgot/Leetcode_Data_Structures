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
    
    // 0 :- not installed and not monitored
    // 1 :- monitored
    // 2 :- camera installed
    
    int ci = 0;
    int m = 1;
    int c = 2;
    int n = 3;
    public int minCameraCover(TreeNode root) {
        if(root==null){
            return 0;
        }
        else if(root.left==null&&root.right==null){
            return 1;
        }
        ci =0;
        int v = helper(root);
        if(v==3){ci++;}
        return ci;
    }
    
    public int helper(TreeNode root){
        if(root==null){
            return 1;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left==3||right==3){
            ci++;
            return 2;
        }
        else if(left==2||right==2){
            return 1;
        }
        else{
            return 3;
        }
    }
    
//     int count = 0;
//     int monitored = 1;
//     int camera = 2;
//     int notMonitored = 3;
//     public int minCameraCover(TreeNode root) {
//         if(root==null){
//             return 0;
//         }
//         else if(root.left==null&&root.right==null){
//             return 1;
//         }
        
//         count = 0;
//         int val = helper(root);
//         if(val==3){
//             count++;
//         }
//         return count;
//     }
    
//     public int helper(TreeNode root){
//         if(root==null){
//             return 1;
//         }
        
//         int left = helper(root.left);
//         int right = helper(root.right);
        
//         if(left==3||right==3){
//             count++;
//             return 2;
//         }
//         else if(left==2||right==2){
//             return 1;
//         }else{
//             return 3;
//         }
//     }
}