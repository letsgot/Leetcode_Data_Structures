class Solution {
    int par[];
    public int minScore(int n, int[][] roads) {
        int arr[] = new int[n+1];
        par =  new int[n+1];
        for(int i = 0; i <= n; i++) par[i] = i;
        Arrays.fill(arr, Integer.MAX_VALUE);
        for(int[]road : roads){
            int a = road[0];
            int b = road[1];
            int d = road[2];
            
            int pa = find(a);
            int pb = find(b);
            
            par[pa] = par[pb];
            arr[pa] = arr[pb] = Math.min(d,Math.min(arr[pa],arr[pb]));
        }
        
        return arr[find(par[1])];
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
}