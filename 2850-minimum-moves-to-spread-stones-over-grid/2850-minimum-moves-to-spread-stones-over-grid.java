class Solution {
    public int minimumMoves(int[][] grid) {
         int t = 0;
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                if (grid[i][j] == 0)
                    t++;
        if (t == 0)
            return 0;
        
        int ans = Integer.MAX_VALUE;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]==0){
                    for(int ni=0;ni<3;ni++){
                        for(int nj=0;nj<3;nj++){
                            int d = Math.abs(i-ni) + Math.abs(j-nj);
                            if(grid[ni][nj]>1){
                                grid[ni][nj]--;
                                grid[i][j]++;
                                ans = Math.min(ans,d+minimumMoves(grid));
                                grid[ni][nj]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}