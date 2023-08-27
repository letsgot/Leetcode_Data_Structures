class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for(int stone : stones){
            map.put(stone,new HashSet<Integer>());
        }
        
        map.get(0).add(1);
        
        for(int i=0;i<stones.length;i++){
            int stone = stones[i];
            HashSet<Integer> set = map.get(stone);
            for(int move : set){
                int pmove = stone + move;
                  if (pmove == stones[stones.length - 1]) return true;
                if(map.containsKey(pmove)){
                    map.get(pmove).add(move);
                    map.get(pmove).add(move+1);
                    if (move-1 > 0) {
                        map.get(pmove).add(move-1);
                    }
                }
            }
        }
        
        return false;
    }
}