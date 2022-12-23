class Solution {
    public int smallestValue(int n) {
        int osum = n;
        
        while(true){
            int nsum = 0;
            int c = 2;
            while(n>1){
                if(n%c==0){
                    n = n/c;
                    nsum += c;
                }
                else{
                    c++;
                }
            }
            n = nsum;
            if(osum==nsum){
                break;
            }
            else{
                osum = nsum;
            }
        }
        
        return osum;
    }
}