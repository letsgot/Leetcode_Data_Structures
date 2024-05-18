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
    public class Pair {
        int coin;
        int node;
    }
    
    int move = 0;
    public int distributeCoins(TreeNode root) {
        move = 0;
        helper(root);
        return move;
    }
    
    public Pair helper(TreeNode node){
        if(node==null){
            return new Pair();
        }
        
        Pair left = helper(node.left);
        Pair right = helper(node.right);
        
        Pair rp = new Pair();
        rp.coin = left.coin + right.coin + node.val;
        rp.node = left.node + right.node + 1;
        
        move += Math.abs(rp.coin - rp.node);
        
        return rp;
    }
}