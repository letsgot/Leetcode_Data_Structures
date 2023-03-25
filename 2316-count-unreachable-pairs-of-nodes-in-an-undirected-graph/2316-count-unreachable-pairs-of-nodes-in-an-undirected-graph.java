class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[]edge : edges){
            int src = edge[0];
            int nbr = edge[1];
            graph[src].add(nbr);
            graph[nbr].add(src);
        }
        
        boolean [] vis = new boolean[n];
        long ans = 0;
        long total = n;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count = 0;
                dfs(graph,vis,i);
                // list.add(count);
                total = total - count;
                ans += total * count;
            }
        }
        
       
        // for(int num : list){
        //     System.out.println(num);
        // }
        
        return ans;
    }
    
    int count = 0;
    
    public void dfs(ArrayList<Integer>[]graph,boolean[]vis,int src){
        if(vis[src]){
            return;
        }
        
        count++;
        vis[src] = true;
        
        for(int nbr : graph[src]){
            if(vis[nbr]==false){
                dfs(graph,vis,nbr);
            }
        }
    }
}