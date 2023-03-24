class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<Integer> [] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<connections.length;i++){
            int v = connections[i][0];
            int u = connections[i][1];
            
            graph[v].add(u);
            graph[u].add(v);
            
            String str = v + "-" + u;
            set.add(str);
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        int ans = 0;
        que.add(0);
        boolean[]vis = new boolean[n];
        while(que.size()>0){
            int v = que.remove();
            
            vis[v] = true;
            
            for(int nbr : graph[v]){
                if(!vis[nbr]){
                    String str = v + "-" + nbr;
                    if(set.contains(str)){
                       System.out.println(str);
                       ans++;   
                    }
                    que.add(nbr);
                }
                // else{
                //     ans++;
                // }
            }
        }
        
        return ans;
    }
}