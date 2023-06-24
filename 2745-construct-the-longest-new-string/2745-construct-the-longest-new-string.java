class Solution {
    public int longestString(int x, int y, int z) {
        int min = Math.min(x,y);
        if(x==y){
            return 4*x + 2*z;
        }
        else{
            return 4*min + 2*z + 2;
        }
    }
}