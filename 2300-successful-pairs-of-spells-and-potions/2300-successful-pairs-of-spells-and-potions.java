class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        // int pairs[] = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            int val = spells[i];
            
            int lo = 0;
            int hi = potions.length-1;
            
            while(lo<=hi){
                int mid = lo + (hi-lo)/2;
                // System.out.println(mid);
                long mul = (long)(val) * (long)(potions[mid]);
                if(mul>=success){
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            int count = potions.length - 1 - hi;
            spells[i] = count;
        }
        
        return spells;
    }
}