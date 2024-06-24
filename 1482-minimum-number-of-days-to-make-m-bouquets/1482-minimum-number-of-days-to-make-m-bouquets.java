class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
       if(bloomDay.length/k<m){
            return -1;
        }
        int lo = 1;
        int hi = Integer.MIN_VALUE;
        
        for(int num : bloomDay){
            hi = Math.max(num,hi);
        }
       
        while(lo<hi){
            int mid = lo + (hi - lo)/2;
            int count = 0;
            int f = 0;
            for(int num : bloomDay){
                if(mid>=num){
                    count++;
                }
                else{
                    f += count/k;
                    count = 0;
                }
            }    
            f += count/k;
            if(f>=m){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        
        return lo;
        
    }
}