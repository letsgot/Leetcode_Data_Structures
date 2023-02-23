class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int marea = 0;
        
        while(i<j){
            int left = height[i];
            int right = height[j];
            
            int area = (Math.min(left,right))*(j-i);
            marea = Math.max(area,marea);
            
            if(left<right){
                i++;
            }
            else{
                j--;
            }
        }
        
        return marea;
    }
}