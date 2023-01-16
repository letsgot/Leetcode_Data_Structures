class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        
        int i = 0;
        while(i<intervals.length&&intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
                
        int inter[] = newInterval;
        while(i<intervals.length&&intervals[i][0]<=inter[1]){
            inter[0] = Math.min(inter[0],intervals[i][0]);
            inter[1] = Math.max(inter[1],intervals[i][1]);
            i++;
        }
        
        list.add(inter);
        while(i<intervals.length){
            list.add(intervals[i]);
            i++;
        }
        
        return list.toArray(new int[list.size()][2]);
    }
}