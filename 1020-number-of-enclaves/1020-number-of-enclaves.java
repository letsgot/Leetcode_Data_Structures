class Solution {
    int size = 0;
    public int numEnclaves(int[][] grid) {
          int count = 0;
        boolean[][]vis = new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1&&!vis[i][0]){
                helper(grid,vis,i,0);
            }
        }
        
        for(int j=0;j<grid[0].length;j++){
            if(grid[0][j]==1&&!vis[0][j]){
                helper(grid,vis,0,j);
            }
        }
        
        for(int i=grid.length-1;i>=0;i--){
            if(grid[i][grid[0].length-1]==1&&!vis[i][grid[0].length-1]){
                helper(grid,vis,i,grid[0].length-1);
            }
        }
        
        for(int j=0;j<grid[0].length;j++){
            if(grid[grid.length-1][j]==1&&!vis[grid.length-1][j]){
                helper(grid,vis,grid.length-1,j);
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&!vis[i][j]){
                    size = 0;
                    helper(grid,vis,i,j);
                    count += size;
                }
            }
        }
        
        return count;
    }
     
    public void helper(int[][]grid,boolean[][]vis,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||vis[i][j]){
            return;
        }
        
        vis[i][j] = true;
        size++;
        helper(grid,vis,i+1,j);
        helper(grid,vis,i-1,j);
        helper(grid,vis,i,j+1);
        helper(grid,vis,i,j-1);
    }
}