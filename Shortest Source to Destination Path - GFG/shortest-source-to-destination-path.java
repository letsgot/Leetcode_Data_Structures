//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(0,0));
        
        boolean [][] vis = new boolean[N][M];
        int len = 0;
        while(que.size()!=0){
            int sz = que.size();
            for(int i=0;i<sz;i++){
                Pair rem = que.remove();
                int x = rem.x;
                int y = rem.y;
                
                if(vis[x][y]){
                    continue;
                }
                vis[x][y] = true;
                
                if(x==X&&y==Y){
                    return len;
                }
                
                addChild(que,x+1,y,vis,A);
                addChild(que,x-1,y,vis,A);
                addChild(que,x,y-1,vis,A);
                addChild(que,x,y+1,vis,A);
            }
            len++;
        }
        
        return -1;
        
    }
    
    
    public static void addChild(Queue<Pair> que,int x,int y,boolean[][]vis,int [][] a){
        int n = vis.length;
        int m = vis[0].length;
        if(x<0||y<0||x>=n||y>=m||vis[x][y]||a[x][y]==0){
            return;
        }
        
        que.add(new Pair(x,y));
    }
};