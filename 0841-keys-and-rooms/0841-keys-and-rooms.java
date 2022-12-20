class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean[]vis = new boolean[rooms.size()];
        dfs(0,rooms,vis);
        for(boolean ch : vis){
            if(!ch){
                return false;
            }
        }
        return true;
    }
    public void dfs(int src,List<List<Integer>> rooms,boolean[]vis){
        vis[src] = true;
        
        List<Integer> list = rooms.get(src);
        for(int nbr : list){
            if(!vis[nbr])
            dfs(nbr,rooms,vis);
        }
    }
}