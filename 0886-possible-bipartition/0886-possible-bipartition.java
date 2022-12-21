class Solution {
    public class Pair{
        int col;
        int src;
        Pair(int src,int col){
            this.src = src;
            this.col = col;
        }
    }
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer> [] graph = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int e[]:dislikes){
            int s = e[0]-1;
            int nb = e[1]-1;
            graph[s].add(nb);
            graph[nb].add(s);
        }
        
        int vis[] = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]!=0){continue;}
            
            Queue<Pair> que = new ArrayDeque<>();
            que.add(new Pair(i,1));
            
            while(que.size()>0){
                Pair rem = que.remove();
                int col = rem.col;
                int src = rem.src;
                
                if(vis[src]!=0){
                    if(vis[src]!=col){
                        return false;
                    }
                    continue;
                }
                vis[src] = col;
                
                for(int nbr : graph[src]){
                    que.add(new Pair(nbr,-1*col));
                }
            }
        }
        
        return true;
    }
}