//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
          
            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S); 
            System.out.println(ans);
        }
    } 
} 

// } Driver Code Ends
//User function Template for Java

class Solution 
{ 
    String removeReverse(String S) 
    { 
        // code here
        boolean check[] = new boolean[S.length()];
        int arr[] = new int[26];
        for(char ch : S.toCharArray()){
            arr[ch-'a']++;
        }
        
        int fl = 0;
        int i = 0;
        int j = S.length()-1;
        
        while(i<j){
            if(fl==0){
                char ch = S.charAt(i);
                if(arr[ch-'a']>1){
                    arr[ch-'a']--;
                    check[i] = true;
                    // S = S.substring(0,i) + S.substring(i+1); 
                    // i = 0;
                    // j = S.length()-1;
                    i++;
                    fl = 1;
                }
                else{
                    i++;
                }
            }
            else{
                char ch = S.charAt(j);
                if(arr[ch-'a']>1){
                    arr[ch-'a']--;
                    check[j] = true;
                    j--;
                    // S = S.substring(0,j) + S.substring(j+1); 
                    // i = 0;
                    // j = S.length()-1;
                    fl = 0;
                }
                else{
                    j--;
                }
            }
        }
        
        // System.out.println(fl);
        
        StringBuilder sb = new StringBuilder("");
            
        if(fl==1){
            for(int k=S.length()-1;k>=0;k--){
                if(check[k]==false){
                    sb.append(S.charAt(k));
                }
            }
            S = sb.toString();
        }
        else{
            for(int k=0;k<S.length();k++){
                if(check[k]==false){
                    sb.append(S.charAt(k));
                }
            } 
            S = sb.toString();
        }
        
        return S;
    }
} 

//{ Driver Code Starts.

// } Driver Code Ends