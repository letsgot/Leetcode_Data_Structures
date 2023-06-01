class Solution {
    public class Pair{
        int r;
        int c;
        int d;
        Pair(int r,int c,int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
          int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }
        
        
        Queue<Pair> que = new ArrayDeque<>();
        
        que.add(new Pair(0,0,1));
        
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        
        while(que.size()!=0){
            // rm*wa
            Pair rem = que.remove();
            int r = rem.r;
            int c = rem.c;
            int d = rem.d;
            
            System.out.println(r + " " +c);
            
            if(vis[r][c]==true){
                continue;
            }
            vis[r][c] = true;
            
            if(r==grid.length-1&&c==grid[0].length-1){
                return rem.d;
            }
            
            addChild(r+1,c,d+1,vis,grid,que);
            addChild(r,c+1,d+1,vis,grid,que);
            addChild(r,c-1,d+1,vis,grid,que);
            addChild(r-1,c,d+1,vis,grid,que);
            addChild(r+1,c+1,d+1,vis,grid,que);
            addChild(r-1,c-1,d+1,vis,grid,que);
            addChild(r-1,c+1,d+1,vis,grid,que);
            addChild(r+1,c-1,d+1,vis,grid,que);
        }
        
        return -1;
    }
    
    public void addChild(int r, int c, int d, boolean [][] vis, int[][]grid, Queue<Pair> que){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length||vis[r][c]||grid[r][c]==1){
            return;
        }
        
        System.out.println(r + " " + c);
        
        que.add(new Pair(r,c,d));
    }
    
}