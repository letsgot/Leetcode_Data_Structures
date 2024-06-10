class Solution {
    public int heightChecker(int[] heights) {
        int [] test = new int[heights.length];
        for(int i=0;i<test.length;i++){
            test[i] = heights[i];
        }
        
        Arrays.sort(test);
        int sol = 0;
        for(int i=0;i<test.length;i++){
            if(test[i]!=heights[i]){
                sol++;
            }
        }
        
        return sol;
    }
}