class Solution {
    public int numTrees(int n) {
        if(n==0){
            return 1;
        }
        else if(n==1){
            return 1;
        }
        int [] catalan = new int[n+1];
        catalan[0] = 1;
        catalan[1] = 1;
        
        for(int i=2;i<catalan.length;i++){
            int r = i-1;
            // int sum,l;
            // l = sum = 0;
            int l = 0;
            int sum = 0;
            while(r>=0){
                sum += catalan[l] * catalan[r];
                l++;
                r--;
            }
            catalan[i] = sum;
        }
        
        return catalan[n];
    }
}