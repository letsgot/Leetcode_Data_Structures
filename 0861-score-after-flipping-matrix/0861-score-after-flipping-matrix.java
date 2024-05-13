class Solution {
    public int matrixScore(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        
        // Step 1: Toggle all rows to ensure the leftmost digit is always 1
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                toggleRow(grid, i);
            }
        }
        
        // Step 2: Toggle columns to maximize the score
        for (int j = 1; j < n; j++) {
            int countOnes = 0;
            for (int i = 0; i < m; i++) {
                countOnes += grid[i][j];
            }
            if (countOnes < m - countOnes) {
                toggleColumn(grid, j);
            }
        }
        
        // Step 3: Calculate the score
        int score = 0;
        for (int i = 0; i < m; i++) {
            score += binaryToDecimal(grid[i]);
        }
        
        return score;
    }
    
    // Helper method to toggle a row
    private void toggleRow(int[][] grid, int row) {
        for (int j = 0; j < grid[0].length; j++) {
            grid[row][j] = grid[row][j] == 0 ? 1 : 0;
        }
    }
    
    // Helper method to toggle a column
    private void toggleColumn(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] = grid[i][col] == 0 ? 1 : 0;
        }
    }
    
    // Helper method to convert a binary array to decimal
    private int binaryToDecimal(int[] binary) {
        int decimal = 0;
        for (int i = binary.length - 1, j = 0; i >= 0; i--, j++) {
            decimal += binary[i] * Math.pow(2, j);
        }
        return decimal;
    
    }
}