class Solution {
    public int change(int sum, int[] coins) {
        int amount[] = new int[sum+1];
        amount[0] = 1;
         for(int j=0;j<coins.length;j++){
             for(int i=1;i<=sum;i++){
                if(i-coins[j]>=0){
                    amount[i] += amount[i-coins[j]];
                }
            }
            // System.out.println(amount[i]);
        }
        
        return amount[sum];
    }
}