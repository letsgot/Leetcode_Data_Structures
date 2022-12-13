//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int dp[][] = new int[s1.length()][s2.length()];
        int max = 0;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0){
                    dp[i][j] = s1.charAt(i)==s2.charAt(j)?1:0;
                }
                else if(j==0){
                    dp[i][j] = s1.charAt(i)==s2.charAt(j)?1:0;
                }
                else{
                    if(s1.charAt(i)==s2.charAt(j)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        
        return max;
    }
}