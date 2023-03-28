class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length==0){
            return 0;
        }
        else if(days.length==1){
            return Math.min(Math.min(costs[0],costs[1]),costs[2]);
        }
        
        int dp[] = new int[366];
        
        dp[0] = 0;
        int j = 0;
        
        for(int i=1;i<dp.length;i++){
            if(j==days.length){
                return dp[days[days.length-1]];
            }
            
            if(days[j]!=i){
                dp[i] = dp[i-1];
            }
            else{
                int one = costs[0] + dp[i-1];
                int seven = costs[1] + dp[Math.max(0,i-7)];
                int month = costs[2] + dp[Math.max(0,i-30)];
                dp[i] = Math.min(Math.min(one,seven),month);
                // System.out.println(dp[i]);
                j++;
            }
        }
        return dp[days[days.length-1]];
    }
}