class Solution {
    public class Pair{
        int src = 0;
        int r = 0;
        
        Pair(int src,int r){
            this.src = src;
            // this.nbr = nbr;
            this.r = r;
        }
    }
    
    public boolean isBipartite(int[][] grap) {
        ArrayList<Integer> [] graph = new ArrayList[grap.length];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<grap.length;i++){
            int [] edge = grap[i];
            for(int e : edge){
                graph[i].add(e);
            }
        }
        
        int vis[] = new int[grap.length];
        
        for(int i=0;i<grap.length;i++){
            if(vis[i]==0){
                boolean check = isBi(i,vis,graph);
                if(check==false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isBi(int src,int[]vis,ArrayList<Integer> [] graph){
        
        
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(src,1));
        
        int ite = 1;
        
        while(q.size()!=0){
            // rm*wac
            int size = q.size();
            while(size-->0){
                Pair rem = q.remove();
                int s = rem.src;
                if(vis[s]!=0){
                    int o = vis[s];
                    int c = rem.r;
                    if(o==c){
                       continue; 
                    }
                    else{
                        return false;
                    }
                }
                
                vis[s] = rem.r;
                
                for(int nbr : graph[s]){
                    q.add(new Pair(nbr,rem.r*-1));
                }
            }
            ite++;
        }
        
        
        
       return true;
        
        
        
    }
}