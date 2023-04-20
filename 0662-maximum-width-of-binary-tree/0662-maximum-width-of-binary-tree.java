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
        int width;
        TreeNode node;
        Pair(TreeNode node,int width){
            this.node = node;
            this.width = width;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(root,0));
        int twidth = 1;
        while(que.size()>0){
            int size = que.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                Pair rem = que.remove();
                TreeNode node = rem.node;
                int width = rem.width;
                
                max = Math.max(max,width);
                min = Math.min(min,width);
                
                if(node.left!=null){
                    que.add(new Pair(node.left,2*width+1));
                }
                if(node.right!=null){
                    que.add(new Pair(node.right,2*width+2));
                }
            }
            
            // System.out.println(min + "   " + max);
            
            if(min==max){
                
            }
            else{
                int v = max - min + 1;
                twidth = Math.max(twidth,v);
            }
        }
        return twidth;
    }
}