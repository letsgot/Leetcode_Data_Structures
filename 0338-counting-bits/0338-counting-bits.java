class Solution {
    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        
        for(int i=1;i<=n;i++){
            String str = Integer.toBinaryString(i);
            int count = 0;
            for(char ch : str.toCharArray()){
                if(ch=='1'){
                    count++;
                }
            }
            ans[i] = count;
        }
        
        return ans;
    }
}