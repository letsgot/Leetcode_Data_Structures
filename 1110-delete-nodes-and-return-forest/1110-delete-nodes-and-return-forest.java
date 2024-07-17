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
    static List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int val : to_delete){
            set.add(val);
        }
        
        TreeNode r = traverse(set,root);
        if(r!=null){
            ans.add(root);
        }
        
        return ans;
    }
    
    public static TreeNode traverse(HashSet<Integer> set,TreeNode root){
        if(root==null){
            return null;
        }
        
        root.left = traverse(set,root.left);
        root.right =traverse(set,root.right);
        
        int val = root.val;
        if(set.contains(val)){
            set.remove(val);
            if(root.left!=null){
                ans.add(root.left);
            }
            
            if(root.right!=null){
                ans.add(root.right);
            }
            return null;
        }
        
        return root;
    }
}