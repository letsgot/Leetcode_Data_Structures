class Solution {
    public int maxProfit(int[] prices, int fee) {
        int ob = -prices[0];
        int os = 0;
        
        for(int i=1;i<prices.length;i++){
            int nb = Math.max(ob,os-prices[i]);
            int ns = Math.max(os,prices[i] + ob - fee);
            
            ob = nb;
            os = ns;
        }
        
        return os;
    }
}