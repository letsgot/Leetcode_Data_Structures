//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    Integer mod = 1000000007;
    long countStrings(int n) {
        // code here
        long oz = 1;
        long oo = 1;
        
        for(int i=2;i<=n;i++){
            // System.out.println(oz + " " + oo);
            long nz = (oo + oz)%mod;
            long no = oz;
            
            oz = nz;
            oo = no;
        }
        
        return (oz + oo)%mod;
    }
}