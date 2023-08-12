//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int nums[])
    {
        // code here
        // int dp[] = new int[size];
        // int len = 1;
        // dp[0] = nums[0];
        
        // for(int i=1;i<size;i++){
        //     if(dp[len-1]<nums[i]){
        //         len++;
        //         dp[len-1] = nums[i];
        //     }
        //     else{
        //         int idx = Arrays.binarySearch(nums,0,len-1,nums[i]);
        //         if(idx<0){
        //             idx *= -1;
        //             idx--;
        //         }
                
        //         dp[idx] = nums[i];
        //     }
        // }
        
        // return len;
         int dp[] = new int[nums.length];
        
        dp[0] = nums[0];
        int len = 1;
        for(int i=1;i<nums.length;i++){
            if(dp[len-1]<nums[i]){
                len++;
                dp[len-1] = nums[i];
            }
            else{
                int idx = Arrays.binarySearch(dp,0,len-1,nums[i]);
                if(idx<0){
                    idx = idx * -1;
                    idx--;
                }
                
                dp[idx] = nums[i];
            }
        }
        
        return len;
    }
} 