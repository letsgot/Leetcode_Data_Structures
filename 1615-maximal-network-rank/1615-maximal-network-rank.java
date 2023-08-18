class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int in[] = new int[n];
        boolean check [][] = new boolean[n][n];
        
        for(int[]road : roads){
            in[road[0]]++;
            in[road[1]]++;
            
            check[road[0]][road[1]] = true;
            check[road[1]][road[0]] = true;
            
        }
        
        int max = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int count = in[i] + in[j] - (check[i][j]==true?1:0);
                max = Math.max(max,count);
            }
        }
        
        return max;
    }
}