//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long amount[] = new long[sum+1];
        amount[0] = 1;
         for(int j=0;j<N;j++){
             for(int i=1;i<=sum;i++){
                if(i-coins[j]>=0){
                    amount[i] += amount[i-coins[j]];
                }
            }
            // System.out.println(amount[i]);
        }
        
        return amount[sum];
    }
}