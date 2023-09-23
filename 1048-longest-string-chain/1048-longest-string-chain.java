class Solution {
    public int longestStrChain(String[] words) {
         Arrays.sort(words, Comparator.comparing(s->s.length()));
        
        int dp[] = new int[words.length+1];
        dp[1] = 1;
        
        for(int i=1;i<words.length;i++){
            String word2 = words[i];
            int max = 0;
            int k = 1;
            for(int j=i-1;j>=0;j--){
                String word1 = words[j];
                
                   if(word1.length()>=word2.length()){
                       continue;
                    }
                    else if(word2.length()-word1.length()>=2){
                       continue;
                    }
                    else{
                        int w2 = 0;
                        int count = 0;
                        for(int jj=0;jj<word1.length();jj++){
                            char chj = word1.charAt(jj);
                            char chw2 = word2.charAt(w2);

                            if(chj!=chw2){
                                count++;
                                if(count==1){
                                    w2++;
                                    jj--;
                                }
                                else if(count==2){
                                    break;
                                }
                                else{

                                }
                            }
                            else{
                                w2++;
                            }
                        }
                        
                        if(count==2){
                            continue;
                        }

                        if(count!=2){
                            max = Math.max(dp[j+1],max);
                        }

                    }
            }
            
            dp[i+1] = max + 1;
        }
        
        int ans = 1;
        for(int i=1;i<dp.length;i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}