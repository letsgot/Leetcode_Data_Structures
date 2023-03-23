class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length+1<n){
            return -1;
        }
        
        ArrayList<Integer> [] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int []arr :connections){
            int src = arr[0];
            int nbr = arr[1];
            graph[src].add(nbr);
            graph[nbr].add(src);
        }
        
        boolean[] vis = new boolean[n];
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,graph,vis);
                ans++;
            }
        }
        
        return ans-1;
    }
    
    public void dfs(int src,ArrayList<Integer>[]graph,boolean[]vis){
        
        vis[src] = true;
        
        for(int nbr : graph[src]){
            if(!vis[nbr]){
                dfs(nbr,graph,vis);
            }
        }
    }
}