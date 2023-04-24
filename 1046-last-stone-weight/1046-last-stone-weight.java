class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.add(i);
        }
        
        while(true){
            if(pq.size()==0){
                return 0;
            }
            else if(pq.size()==1){
                return pq.peek();
            }
            else{
                int x = pq.remove();
                int y = pq.remove();
                
                if(x<y){
                    y = y-x;
                    pq.add(y);
                }
                else{
                    x = x-y;
                    pq.add(x);
                }
            }
        }
    }
}