class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        int max = 0;
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<s.length();i++,j++){
                if(g==0){
                   dp[i][j] = true;
                    // if(max==0){
                    //     max = 1;
                    //     ans = s.charAt(i) + "";
                    // }
                }
                else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = true;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        if(dp[i+1][j-1]){
                            dp[i][j] = true;
                        }
                    }
                }
                
                if(dp[i][j]){
                    int check = j - i + 1;
                    if(check>max){
                        max = check;
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }
        
        return ans;
    }
}