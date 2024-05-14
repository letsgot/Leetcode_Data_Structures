class Solution {
    int max = 0;
    public int getMaximumGold(int[][] grid) {
        boolean[][]vis = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]>0){
                    max = 0;
                    dfs(grid,vis,i,j,0);
                    ans = Math.max(max,ans);
                }
            }
        }
        return ans;
    }
    
    public void dfs(int[][]grid,boolean[][] vis,int i,int j,int ans){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||vis[i][j]==true||grid[i][j]==0){
            return;
        }
        
        vis[i][j] = true;
        ans += grid[i][j]; 
        max = Math.max(max,ans);
        
        dfs(grid,vis,i+1,j,ans);
        dfs(grid,vis,i-1,j,ans);
        dfs(grid,vis,i,j-1,ans);
        dfs(grid,vis,i,j+1,ans);
        
        vis[i][j] = false;
    }
}