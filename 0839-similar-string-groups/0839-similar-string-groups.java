class Solution {
    public int numSimilarGroups(String[] strs) {
        par = new int[strs.length];
        rank = new int[strs.length];
        
        for(int i=0;i<par.length;i++){
            par[i] = i;
            rank[i] = 0;
        }
        
        for(int i=0;i<strs.length-1;i++){
            for(int j=i+1;j<strs.length;j++){
                String s1 = strs[i];
                String s2 = strs[j];
                
                if(isSimilar(s1,s2)){
                    unionHelper(i,j);
                }
            }
        }
        
        int count = 0;
        int ans[] = new int[strs.length];
        for(int i=0;i<par.length;i++){
           int ri = find(par[i]);
           ans[ri]++;
           if(ans[ri]==1){
               count++;
           }
        }
        
        // print(par);
        // print(ans);
        return count;
    }
    int[]par;
    int[]rank;
    
    public void print(int[]arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public boolean isSimilar(String s1,String s2){
        int count = 0;
        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1!=ch2){
                count++;
            }
        }
        
        return count==2||count==0;
    }
    
    void unionHelper(int i,int j){
        int il = find(i);
        int jl = find(j);
        if(il!=jl){
            if(rank[il]>rank[jl]){
                par[jl] = il;
            }
            else if(rank[il]<rank[jl]){
                par[il] = jl;
            }
            else{
                par[jl] = il;
                rank[il]++;
            }
        }
    }
    
    int find(int x){
        if(par[x]==x){
            return x;
        }
        else{
            par[x] = find(par[x]);
            return par[x];
        }
    }
}