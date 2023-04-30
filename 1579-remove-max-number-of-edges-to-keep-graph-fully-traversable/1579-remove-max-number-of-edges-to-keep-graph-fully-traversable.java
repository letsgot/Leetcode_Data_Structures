class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int par [] = new int[n+1];
        int rank [] = new int[n+1];
        
        for(int i=0;i<n;i++){
            par[i] = i;
        }
        
        int type1 = 0;
        int type2 = 0;
        int we = 0;
        
        for(int[]edge : edges){
            int type = edge[0];
            int src = edge[1];
            int nbr = edge[2];
            
            if(type==3){
                boolean check = union(src,nbr,par,rank);
                if(check==true){
                 type1++;
                 type2++;
                }
                else{
                    we++;
                }
            }
        }
        
        int[]par1 = par.clone();
        int[]rank1 = rank.clone();
        for(int[]edge : edges){
            int type = edge[0];
            int src = edge[1];
            int nbr = edge[2];
            
            if(type==2){
                boolean check = union(src,nbr,par,rank);
                if(check==true){
                    type2++;
                }
                else{
                    we++;
                }
            }
            else if(type==1){
               boolean check = union(src,nbr,par1,rank1);
                if(check==true){
                    type1++;
                }
                else{
                    we++;
                }
            }
            else{
                
            }
        }
       
        if(type1==n-1&&type2==n-1){
            return we;
        }
        else{
            return -1;
        }
    }
    
    public int find(int x,int []par){
        if(x==par[x]){
            return x;
        }
        else{
            par[x] = find(par[x],par);
            return par[x];
        }
    }
    
    public boolean union(int src,int nbr,int [] par,int [] rank){
        int u = find(src,par);
        int v = find(nbr,par);

        if(u!=v){
            if(rank[u]>=rank[v]){
                par[v] = par[u];
                rank[u]++;
            }
            else{
                par[u] = par[v];
                rank[v]++;
            }
            return true;
        }
        else{
            return false;
        }
        
    }
}