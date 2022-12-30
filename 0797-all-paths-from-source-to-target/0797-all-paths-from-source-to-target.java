class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       if(graph.length==0){
           return new ArrayList<>();
       }   
        
       res = new ArrayList<>();
       int nbsr[] = graph[0]; 
       for(int nbr : nbsr){
          
           boolean[]vis = new boolean[graph.length];
           vis[0] = true;
           // list.add(0);
           dfs(nbr,graph.length-1,graph,""+'a',vis);
       }
        
        return res;
    }
    
    public void dfs(int src,int dest,int[][]graph,String str,boolean[]vis){
        if(vis[src]==true){
            return;
        }
        vis[src] = true;
        if(src==dest){
             ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                list.add(ch-'a');
            }
            // System.out.println(str);
            list.add(src);
            res.add(list);
            vis[src] = false;
            return;
        }
        
        
        
        str +=  (char)('a' + src);
        
        for(int nbr : graph[src]){
            dfs(nbr,graph.length-1,graph,str,vis);
        }
        
        vis[src] = false;
        
    }
}