class Solution {
    public int minExtraChar(String s, String[] dictionary) {
//         int dp[] = new int[s.length()+1];
//         dp[0] = 0;
        
//         HashSet<String> set = new HashSet<>();
//         for(String str : dictionary){
//             set.add(str);
//         }
        
//         for(int i=1;i<dp.length;i++){
//             int min = Integer.MAX_VALUE;
//             for(int j=0;j<i;j++){
//                 int l = j;
//                 int r = i;
                
//                 String str = s.substring(l,r);
                
//                 System.out.println(str);
                
//                 if(set.contains(str)){
//                     min = Math.min(min,dp[l] + 1);
//                 }
//             }
//             dp[i] = min;
//         }
        
//         return dp[s.length()];
        
        int maxLen = s.length() + 1;
        int[] dp = new int[maxLen];
        Arrays.fill(dp, maxLen);
        
        dp[0] = 0;
        Set<String> wordSet = new HashSet<>(Arrays.asList(dictionary));
        
        for (int i = 1; i < maxLen; i++) {
            dp[i] = dp[i - 1] + 1;
            
            for (int length = 1; length <= i; length++) {
                String substring = s.substring(i - length, i);
                if (wordSet.contains(substring)) {
                    dp[i] = Math.min(dp[i], dp[i - length]);
                }
            }
        }
        
        return dp[maxLen - 1];   
    }
}