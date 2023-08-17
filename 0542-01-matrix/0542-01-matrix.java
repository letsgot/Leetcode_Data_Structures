class Solution {
   public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                dp[row][col] = mat[row][col];
            }
        } 

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (dp[row][col] == 0) {
                    continue;
                }

                int minNeighbor = m * n;
                if (row > 0) {
                    minNeighbor = Math.min(minNeighbor, dp[row - 1][col]);
                }
                
                if (col > 0) {
                    minNeighbor = Math.min(minNeighbor, dp[row][col - 1]);
                }
                
                dp[row][col] = minNeighbor + 1;
            }
        }
        
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (dp[row][col] == 0) {
                    continue;
                }
                
                int minNeighbor = m * n;
                if (row < m - 1) {
                    minNeighbor = Math.min(minNeighbor, dp[row + 1][col]);
                }
                
                if (col < n - 1) {
                    minNeighbor = Math.min(minNeighbor, dp[row][col + 1]);
                }
                
                dp[row][col] = Math.min(dp[row][col], minNeighbor + 1);
            }
        }
        
        return dp;
    }
}