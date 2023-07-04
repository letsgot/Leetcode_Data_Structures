class Solution {
    public int singleNumber(int[] arr) {
         int tn = -1;
    int tn1 = 0;
    int tn2 = 0;
    
    for(int val : arr){
        int ctn = val & tn;   // on the bits of tn1 and off the bits of tn
        int ctn1 = val & tn1;  // on the bits of tn2 and off the bits of tn1
        int ctn2 = val & tn2; // on the bits of tn and off the bits of tn2
        
        tn = tn & ~ctn;
        tn1 = tn1 | ctn;
        
        tn1 = tn1 & ~ctn1;
        tn2 = tn2 | ctn1;
        
        tn2 = tn2 & ~ctn2;
        tn = tn | ctn2;
        
    }
    
        return tn1;
    }
}