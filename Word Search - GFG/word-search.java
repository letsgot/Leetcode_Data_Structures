//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch = board[i][j];
                if(ch==word.charAt(0)){
                    boolean vis[][] = new boolean[board.length][board[0].length];
                    boolean check = helper(board,word,0,i,j,vis);
                    if(check){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(char [][] board,String word,int idx,int i,int j,boolean[][]vis){
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j]){
            return false;
        }
        else if(idx==word.length()){
            return true;
        }
        
        char ch1 = board[i][j];
        char ch2 = word.charAt(idx);
        if(ch1!=ch2){
            return false;
        }
        
        vis[i][j] = true;
        
        
        boolean check1 = helper(board,word,idx+1,i+1,j,vis);
        if(check1) return true;
        boolean check2 = helper(board,word,idx+1,i-1,j,vis);
        if(check2) return true;
        boolean check3 = helper(board,word,idx+1,i,j+1,vis);
        if(check3) return true;
        boolean check4 = helper(board,word,idx+1,i,j-1,vis);
        if(check4) return true;
        
        return false;
    }
}