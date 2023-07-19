//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s)
    {
        //code here
        if(s.length()==1||s.length()==0){
            return s.length();
        }
        else if(s.length()==2){
            return s.charAt(0)==s.charAt(1)?2:1;
        }
        
        int dp[][] = new int[s.length()][s.length()];
        
        for(int g=0;g<dp[0].length;g++){
            for(int i=0,j=g;j<dp[0].length;i++,j++){
                if(g==0){
                    dp[i][j] = 1;
                }
                else if(g==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j)?2:1;
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        
        return dp[0][s.length()-1];
    }
}