class Solution {
     public int countBeautifulPairs(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(gcd(Integer.parseInt(String.valueOf(nums[i]).charAt(0)+""),nums[j]%10) == 1) cnt++;
            }
        }
        return cnt;
    }
    int gcd(int a, int b){
        return b == 0 ? a : gcd(b,a%b);
    }
}