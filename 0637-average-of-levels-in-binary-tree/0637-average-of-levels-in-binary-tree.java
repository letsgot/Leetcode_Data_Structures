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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        List<Double> list = new ArrayList<>(); 
        while(que.size()!=0){
            int sz = que.size();
            double sum = 0.0;
            for(int i=0;i<sz;i++){
                TreeNode rem = que.remove();
                
                sum += rem.val;
                
                if(rem.left!=null){
                    que.add(rem.left);
                }
                
                if(rem.right!=null){
                    que.add(rem.right);
                }
            }
            
            list.add(sum/(sz*1.00000));
        }
        
        return list;
    }
}