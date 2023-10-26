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
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        //code here.
        int count = 0;
        int a = n;
        
        while(a!=1){
            if(a%2==0){
                a = a/2;
            }
            else{
                a--;
            }
            count++;
        }
        
        return count + 1;
    }
}