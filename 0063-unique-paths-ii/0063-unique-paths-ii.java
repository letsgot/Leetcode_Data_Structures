class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0]==1){
            return 0;
        }
        
        int dp[][] = new int[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0&&j==0){
                    dp[0][0] = 1;
                }
                else if(grid[i][j]==1){
                    dp[i][j] = 0;
                }
                else if(j==0){
                    dp[i][j] = dp[i-1][j];
                }
                else if(i==0){
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
    }
}