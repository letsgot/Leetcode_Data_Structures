class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int xtra) {
        int max = Integer.MIN_VALUE;
        for(int i : candies){
            if(i>max){
                max = i;
            }
        }
        ArrayList<Boolean> list = new ArrayList<>();
        for(int i = 0;i<candies.length;i++){
            if(candies[i] + xtra >= max){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        return list;
    }
}