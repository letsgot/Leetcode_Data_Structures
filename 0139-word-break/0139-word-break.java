class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        
        int dp[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(set.contains(s.substring(0,i+1))){
                dp[i] = 1;
            }
            else{
                for(int j=0;j<i;j++){
                    if(dp[j]==1&&set.contains(s.substring(j+1,i+1))){
                        dp[i] = 1;
                    }
                }
            }
        }
        
        return dp[dp.length-1]==1;
    }
}