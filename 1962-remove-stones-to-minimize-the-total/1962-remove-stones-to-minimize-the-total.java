class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : piles){
            pq.add(i);
        }
        
        while(k-->0){
            int val = pq.remove();
            int c = val/2;
            if(val%2==1){
                c = c+1;
            }
            pq.add(c);
        }
        
        int val = 0;
        while(pq.size()>0){
            val += pq.remove();
        }
        
        return val;
    }
}