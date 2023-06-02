class Solution {
    int ans = 0;
    int count = 0;
    public int maximumDetonation(int[][] bombs) {
        
        for(int i=0;i<bombs.length;i++){
            count = 0;
            dfs(i,bombs,new boolean[bombs.length]);
            ans = Math.max(count,ans);
        }
        
        return ans;
    }
    
    public void dfs(int idx,int[][]bombs,boolean[]vis){
        count++;
        vis[idx] = true;
        
        for(int i=0;i<bombs.length;i++){
            if(vis[i]==false&&rangeOf(bombs[i],bombs[idx])){
                dfs(i,bombs,vis);
            }
        }
    }
    
    public boolean rangeOf(int[]a,int[]b){
        long dx = b[0] - a[0];
        long dy = b[1] - a[1];
        long r = b[2];
        
        return (dx*dx)+(dy*dy) <= (r*r);
    }
}