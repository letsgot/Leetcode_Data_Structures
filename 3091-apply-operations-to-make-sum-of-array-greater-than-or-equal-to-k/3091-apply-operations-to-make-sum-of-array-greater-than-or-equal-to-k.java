class Solution {
    public int minOperations(int k) {
        if(k<=1){
            return 0;
        }
        
        int maxOp = Integer.MAX_VALUE;
        for(int i=2;i<=k;i++){
            int c = i - 1;
            int d = (k % i) == 0 ? (k/i) -1 : k/i ;
            maxOp = Math.min(maxOp,d + c);
        }
        
        return maxOp;
    }
}