class Solution {
    
    int par[];
    int ranks[];
    
    public int regionsBySlashes(String[] grid) {
        par = new int[grid.length*4*grid.length];
        ranks = new int[grid.length*4*grid.length];
        
        for(int i=0;i<par.length;i++){
            par[i] = i;
        }
          for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length();j++){
                char ch = grid[i].charAt(j);
                
                int bno = (i * grid[0].length() + j);
                
                if(ch=='/'){
                    unionHelper(4*bno+0,4*bno+3);
                    unionHelper(4*bno+1,4*bno+2);
                }
                
                if(ch=='\\'){
                    unionHelper(4*bno+0,4*bno+1);
                    unionHelper(4*bno+3,4*bno+2);
                }
                
                if(ch==' '){
                    unionHelper(4*bno+0,4*bno+3);
                    unionHelper(4*bno+1,4*bno+2);
                     unionHelper(4*bno+0,4*bno+1);
                    unionHelper(4*bno+3,4*bno+2);
                }
                
                if(i>0){
                     int nbno = (i-1) * grid[0].length() + j;
                     unionHelper(4*bno+0,4*(nbno)+2);
                }
                
                if(i<grid.length-1){
                     int nbno = (i+1) * grid[0].length() + j;
                     unionHelper(4*bno+2,4*(nbno)+0);
                }
                
                if(j>0){
                     int nbno = (i) * grid[0].length() + j-1;
                     unionHelper(4*bno+3,4*(nbno)+1);
                }
                
                if(j<grid[0].length()-1){
                    int nbno = (i) * grid[0].length() + j+1;
                    unionHelper(4*bno+1,4*(nbno)+3);
                }
                
            }
        }
        
        int count = 0;
        for(int i=0;i<par.length;i++){
            if(par[i] == i){
                count++;
            }
        }
        return count;
        
        
    }
    
    public void unionHelper(int src,int nbr){
        int x = find(src);
        int y = find(nbr);
        if(x!=y){
            union(x,y);
        }
    }
    
    public int find(int x){
        if(x==par[x]){
            return x;
        }
        else{
            return par[x] = find(par[x]);
            
        }
    }
    
    public void union(int src,int nbr){
        if(ranks[src]>ranks[nbr]){
            par[nbr] = src;
            // par[src]++;
        }
        else if(ranks[nbr]>ranks[src]){
            par[src] = nbr;
            // ranks[nbr]++;
        }
        else {
            par[nbr] = src;
            ranks[src]++;
        }
    }
}