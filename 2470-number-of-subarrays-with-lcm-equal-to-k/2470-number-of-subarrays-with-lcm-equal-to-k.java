class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            int c = 1;
            for(int j=i;j<n;j++){
                c = task(c,nums[j]);
                ans += (c==k)?1:0;
            }
        }
        
        return ans;
    }
    
    public int task(int a,int b){
        return a*b / gcd(a,b);
    }
    
    public int gcd(int a,int b){
        if(a==0){
            return b;
        }
        
        return gcd(b%a,a);
    }
}