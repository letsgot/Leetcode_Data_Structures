//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public class Pair implements Comparable<Pair>{
        int src;
        int nbr;
        int cost;
        
        Pair(int src,int nbr,int cost){
            this.src = src;
            this.nbr = nbr;
            this.cost = cost;
        }
        
        public int compareTo(Pair o){
            return this.cost - o.cost;
        }
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<Pair> [] graph = new ArrayList[N];
		for(int i=0;i<N;i++){
		    graph[i] = new ArrayList<Pair>();
		}
		
		for(int edge[] : edges){
		    int src = edge[0];
		    int nbr = edge[1];
		    int cost = edge[2];
		    
		    Pair rp = new Pair(src,nbr,cost);
		    
		    graph[src].add(rp);
		}
		
		int ans[] = new int[N];
		Arrays.fill(ans,-1);
		boolean vis[] = new boolean[N];
		
		PriorityQueue<Pair> que = new PriorityQueue<>();
		que.add(new Pair(0,0,0));
		
		while(que.size()!=0){
		    int sz = que.size();
		    for(int i=0;i<sz;i++){
		        Pair rem = que.remove();
		        int s = rem.src;
		        int c = rem.cost;
		        
		        if(vis[s]){
		            continue;
		        }
		        vis[s] = true;
		        
		        ans[s] = c;
		        
		        for(Pair r : graph[s]){
		            if(vis[r.nbr]==false){
		                r.cost = c + r.cost;
		                que.add(new Pair(r.nbr,0,r.cost));
		            }
		        }
		    }
		}
		
		return ans;
	}
}