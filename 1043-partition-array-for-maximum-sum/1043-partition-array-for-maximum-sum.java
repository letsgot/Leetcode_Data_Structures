class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+1];
    
        dp[n] = 0;
        
        for(int i=n-1;i>=0;i--){
                       int max = 0;
            int best = 0;
            for(int j=0;j<k&&i+j+1<n+1;j++){
                max = Math.max(max,arr[i+j]);
                best = Math.max(best,max*((j+i)-i+1) + dp[i+j+1]);
            }
            dp[i] = best;

        }
        
        return dp[0];
        
//         int n = arr.length;
//         int dp[] = new int[arr.length+1];
        
//         for(int i=n-1;i>=0;i--){
            // int max = 0;
            // int best = 0;
            // for(int j=0;j<k&&i+j+1<n+1;j++){
            //     max = Math.max(max,arr[i+j]);
            //     best = Math.max(best,max*((j+i)-i+1) + dp[i+j+1]);
            // }
            // dp[i] = best;
//         }
        
//         return dp[0];
    }
}