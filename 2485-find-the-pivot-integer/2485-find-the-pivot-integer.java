class Solution {
    public int pivotInteger(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += i;
        }
        
        int csum = 0;
        for(int i=n;i>=1;i--){
            int val = i;
            csum += val;
            
//             System.out.println(sum + " " + csum);
            
            if(csum==sum){
                return i;
            }
            sum -= val;
        }
        
        return -1;
    }
}