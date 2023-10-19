//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int v, ArrayList<ArrayList<Integer>> adj, int x)
    {
        // code here
        if(x==0){
            return x;
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);
        
        boolean [] vis = new boolean[v];
        int lvl = 0;
        
        while(que.size()!=0){
            
            int sz = que.size();
            for(int i=0;i<sz;i++){
               // r m* w ac
               int rem = que.remove();
               
               if(vis[rem]){
                   continue;
               }
               
               vis[rem] = true;
               
               if(rem==x){
                   return lvl;
               }
               
               for(int nbr : adj.get(rem)){
                   if(vis[nbr]==false){
                       que.add(nbr);
                   }
               }
            }
            lvl++;
        }
        
        return -1;
    }
}