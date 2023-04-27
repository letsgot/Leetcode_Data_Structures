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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int curr = root.val;
        
        while(que.size()!=0){
            int sz = que.size();
            int next = 0;
            for(int i=0;i<sz;i++){
                TreeNode rem = que.remove();
                
                rem.val = curr - rem.val;
                
                if(rem.left!=null){
                    next += rem.left.val;
                    que.add(rem.left);
                }
                if(rem.right!=null){
                    next += rem.right.val;
                    que.add(rem.right);
                }
                
                if(rem.left!=null&&rem.right!=null){
                    int sum = rem.right.val + rem.left.val;
                    rem.right.val = sum;
                    rem.left.val = sum;
                }
                
            }
            curr = next;
        }
        
        return root;
    }
}