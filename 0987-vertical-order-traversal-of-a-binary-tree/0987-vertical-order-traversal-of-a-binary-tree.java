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
    
    public class Pair implements Comparable<Pair>{
        int col;
        TreeNode node;
        int row;
        
        Pair(int row,int col,TreeNode node){
            this.row = row;
            this.col = col;
            this.node = node;
        }
        
        public int compareTo(Pair o){
            if(this.row!=o.row){
                return this.row - o.row;
            }
            else{
                return this.node.val - o.node.val;   
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,PriorityQueue<Pair>> map = new HashMap<>();
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(0,0,root));
        int loMi = 0;
        while(que.size()>0){
            int size = que.size();
            for(int i=0;i<size;i++){
                Pair rem = que.remove();
                int row = rem.row;
                int col = rem.col;
                
                if(col<loMi){
                    loMi = col;
                }
                
                if(map.containsKey(col)){
                    PriorityQueue<Pair> pq = map.get(col);
                    pq.add(rem);
                }
                else{
                    PriorityQueue<Pair> pq = new PriorityQueue<>();
                    pq.add(rem);
                    map.put(col,pq);
                }
                
                if(rem.node.left!=null){
                    que.add(new Pair(row+1,col-1,rem.node.left));
                }
                
                if(rem.node.right!=null){
                    que.add(new Pair(row+1,col+1,rem.node.right));
                }
            }
        }
        
        // System.out.print(loMi);
        // for(int key : map.keySet()){
        //     System.out.println(key + " " + map.get(key));
        // }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        while(map.containsKey(loMi)){
            PriorityQueue<Pair> pq = map.get(loMi);
            ArrayList<Integer> list = new ArrayList<>();
            while(pq.size()>0){
                list.add(pq.remove().node.val);
            }
            ans.add(list);
            loMi++;
        }
        
        return ans;
    }
}