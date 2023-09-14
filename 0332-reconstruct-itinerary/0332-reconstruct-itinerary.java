class Solution {
    HashMap<String,PriorityQueue<String>> map;
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        
        for(List<String> list : tickets){
            String src = list.get(0);
            String nbr = list.get(1);
            
            if(!map.containsKey(src)){
                PriorityQueue<String> pq = new PriorityQueue<>();
                pq.add(nbr);
                map.put(src,pq);
            }
            else{
                PriorityQueue<String> pq = map.get(src);
                pq.add(nbr);
            }
        }
        
      
        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK",ans);
        return ans;
    }
    
    public void dfs(String str,LinkedList<String> ans){
        if(!map.containsKey(str)||map.get(str).size()==0){
            ans.addFirst(str);
            return;
        }
        
        PriorityQueue<String> pq = map.get(str);
        while(pq.size()>0){
            String nbr = pq.remove();
            // size--;
            dfs(nbr,ans);
        }
        
      
        
        ans.addFirst(str);
    }
}