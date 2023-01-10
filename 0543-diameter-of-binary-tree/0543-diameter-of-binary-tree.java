class Solution {
   static int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dia = 0;
        helper(root);
        return dia;
    }
    
    public int helper(TreeNode root){
        if(root==null){
            return -1;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int ht = left + right + 2;
        dia = Math.max(dia,ht);
        
        return Math.max(left,right)+1;
    }
}