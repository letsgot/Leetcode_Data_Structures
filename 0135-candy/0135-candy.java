class Solution {
    public int candy(int[] ratings) {
        int [] candies = new int[ratings.length];
        
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]&&candies[i-1]>=candies[i]){
                candies[i] = candies[i-1] + 1;
            }
        }
        
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&candies[i+1]>=candies[i]){
                candies[i] = candies[i+1] + 1;
            }
        }
        
        int minCandies = 0;
        
        for(int v : candies){
            minCandies += (v + 1);
        }
        
        return minCandies;
    }
}