class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<grid.length;i++){
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<grid[0].length;j++){
                sb.append(grid[i][j]+"*");
            }
            String str = sb.toString();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        int ans = 0;
        for(int j=0;j<grid[0].length;j++){
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<grid.length;i++){
                sb.append(grid[i][j]+"*");
            }
            String str = sb.toString();
            if(map.containsKey(str)){
                ans += map.get(str);
            }
        }
        
        return ans;
    }
}