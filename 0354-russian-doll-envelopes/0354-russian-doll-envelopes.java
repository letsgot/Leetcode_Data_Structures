class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]){
                return b[1] - a[1];
            }
            else{
                return a[0] - b[0];
            }
        });
        
        int len = 1;
        int lis[] = new int[envelopes.length];
        lis[0] = envelopes[0][1];
        
        for(int i=1;i<envelopes.length;i++){
            if(lis[len-1]<envelopes[i][1]){
                len++;
                lis[len-1] = envelopes[i][1];
            }
            else{
                int idx = Arrays.binarySearch(lis,0,len-1,envelopes[i][1]);
                if(idx<0){
                    idx = idx*-1;
                    idx--;
                }
                lis[idx] = envelopes[i][1];
            }
        }
        
        return len;
    }
}