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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int htl = height(root.left);
        int htr = height(root.right);
        
        return Math.max(htl,htr) + 1;
    }
    
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        
        if(root.left==null&&root.right==null){
            return true;
        }
        boolean check = false;
        int height = height(root)-2;
        System.out.println(height);
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        int count = 0;
        while(que.size()>0){
            if(count==height+1){
                return true;
            }
                
            int sz = que.size();
            for(int i=0;i<sz;i++){
                TreeNode rem = que.remove();
                
                //work
                // System.out.println(count);
                System.out.println(rem.val);
                System.out.println(check);
                if(count==height){
                    if(check==false){
                        if(rem.left==null&&rem.right==null){
                            check=true;
                        }
                        else if(rem.left==null){
                            check=true;
                        }
                        // if(rem.right==null){
                        //     check = true;
                        // }
                    }
                    if(check==true){
                        if(rem.left!=null){
                            return false;
                        }
                        if(rem.right!=null){
                            return false;
                        }
                    }
                    
                    if(rem.right==null){
                        check = true;
                    }
                }
                
                
               if(count<height){
                    if(rem.left!=null){
                    que.add(rem.left);
                }
                else{
                    return false;
                }
                
                if(rem.right!=null){
                    que.add(rem.right);
                }
                else{
                    return false;
                }
               }
            }
            count++;
        }
        
        return true;
    }
}