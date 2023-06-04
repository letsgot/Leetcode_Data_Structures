class Solution {
    int [] par;
    int [] rank;
    public int findCircleNum(int[][] con) {
        par = new int[con.length];
        rank = new int[con.length];
        
        for(int i=0;i<con.length;i++){
            par[i] = i;
        }
        
        for(int i=0;i<con.length;i++){
            for(int j=0;j<con[0].length;j++){
                if(con[i][j]==1){
                    int x = find(i);
                    int y = find(j);
                    if(x!=y){
                        union(x,y);
                    }
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : par){
            set.add(find(i));
        }
        return set.size();
    }
    
    public int find(int x){
        if(x==par[x]){
            return x;
        }
        else{
            par[x] = find(par[x]);
            return par[x];
        }
    }
    
    public void union(int x,int y){
        if(rank[x]>rank[y]){
            par[y] = x;
            rank[x]++;
        }
        else  if(rank[x]==rank[y]){
            par[y] = x;
            rank[x]++;
        }
        else{
            par[x] = y;
            rank[y]++;
        }
    }
}