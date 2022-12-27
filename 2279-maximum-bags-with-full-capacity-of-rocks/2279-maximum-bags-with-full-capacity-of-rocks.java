class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for(int i=0;i<capacity.length;i++){
            int cap = capacity[i];
            int roc = rocks[i];
            int rem = capacity[i] - roc;
            if(rem>0){
                pq.add(rem);
            }
            else{
                count++;
            }
        }
        
        System.out.println(count);
        while(pq.size()!=0&&additionalRocks!=0){
            int val = pq.remove();
                    System.out.println(val);

            if(val>additionalRocks){
                break;
            }
            
            additionalRocks -= val;
            count++;
        }
        
       return count;
    }
}