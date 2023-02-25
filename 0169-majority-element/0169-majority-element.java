class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int pa = 0;
        
        for(int i : nums){
            if(count==0){
                count++;
                pa = i;
            }
            else if(pa==i){
                count++;
            }
            else{
                count--;
                if(count==0){
                    pa = i;
                    count++;
                }
            }
        }
        
        return pa;
    }
}