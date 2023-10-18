class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int in[] = new int[n];
        ArrayList<Integer> [] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
       
        for(int[]relation : relations){
            int src = relation[0]-1;
            int nbr = relation[1]-1;
            graph[src].add(nbr);
            in[nbr]++;
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        int completionTime[] = new int[n];
        for(int i=0;i<n;i++){
            if(in[i]==0){
              que.add(i);
              completionTime[i] = time[i];
            }
        }
        
        while(que.size()>0){
            int u = que.remove();

            for(int v : graph[u]){
                in[v]--;
                 completionTime[v] = Math.max(completionTime[v], completionTime[u] + time[v]);
                if(in[v]==0){
                    que.add(v);
                }
            }
        }
        
        int tt = 0;
        for(int i : completionTime){
            tt = Math.max(tt,i);
        }
        
        return tt;
    }
}