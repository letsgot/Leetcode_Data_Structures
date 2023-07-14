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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i=0;i<preorder.length;i++){
            if(i==0){
                root = new TreeNode(preorder[0]);
            }
            else{
                root = helper(root,preorder[i]);
            }
        }
        return root;
    }
    
    public TreeNode helper(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        else if(val<root.val){
            root.left = helper(root.left,val);
        }
        else if(val>root.val){
            root.right = helper(root.right,val);
        }
        else{
            return root;
        }
        return root;
    }
}