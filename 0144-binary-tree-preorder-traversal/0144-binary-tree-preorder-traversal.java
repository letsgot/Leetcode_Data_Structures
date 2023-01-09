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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode ipo = curr.left;
                while(ipo.right!=null&&ipo.right!=curr){
                    ipo = ipo.right;
                }
                
                if(ipo.right==null){
                    list.add(curr.val);
                    ipo.right = curr;
                    curr = curr.left;
                }
                else{
                    ipo.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
    }
}