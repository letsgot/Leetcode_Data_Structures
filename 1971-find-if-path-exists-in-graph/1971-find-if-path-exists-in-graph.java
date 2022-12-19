class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        ArrayList<Integer> [] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[]edge : edges){
            int sr = edge[0];
            int nbr = edge[1];
            
            graph[sr].add(nbr);
            graph[nbr].add(sr);
        }
        
        boolean vis[] = new boolean[n];
        
        return dfs(src,dest,graph,vis);
    }
    
    public boolean dfs(int src,int dst,ArrayList<Integer> [] graph,boolean[]vis){
        if(src==dst){
            return true;
        }
        
        vis[src] = true;
        
        for(int nbr : graph[src]){
            if(!vis[nbr]){
                boolean check = dfs(nbr,dst,graph,vis);
                if(check){
                    return true;
                }
            }
        }
        
        return false;
    }
}