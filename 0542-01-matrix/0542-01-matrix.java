class Solution {
    public class Pair{
        int x;
        int y;
        int dis;
        Pair(int x,int y,int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        
        Queue<Pair> que = new ArrayDeque<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    que.add(new Pair(i,j,0));
                }
            }
        }
        
        int ans[][] = new int[mat.length][mat[0].length];
        boolean [][] vis = new boolean[ans.length][ans[0].length];
        while(que.size()!=0){
            int sz = que.size();
            for(int i=0;i<sz;i++){
                Pair rem = que.remove();
                int x = rem.x;
                int y = rem.y;
                int d = rem.dis;
                
                if(vis[x][y]){
                    continue;
                }
                
                vis[x][y] = true;
                
                ans[x][y] = d;
                
                add(que,vis,x+1,y,d+1);
                add(que,vis,x-1,y,d+1);
                add(que,vis,x,y+1,d+1);
                add(que,vis,x,y-1,d+1);
            }
        }
        
        return ans;
    }
    
    public void add(Queue<Pair> que,boolean[][]vis,int x,int y,int d){
        if(x<0||y<0||x>=vis.length||y>=vis[0].length||vis[x][y]){
            return;
        }
        
        que.add(new Pair(x,y,d));
    }
}