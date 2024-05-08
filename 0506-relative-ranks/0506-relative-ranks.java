class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<score.length;i++){
            map.put(score[i],i);
        }
        
        Arrays.sort(score); 
        reverse(score);
        
        String ans[] = new String[score.length];
        for(int i=0;i<score.length;i++){
            int val = score[i];
            int idx = map.get(val);
            
            if(i<=2){
                if(i==0){
                    ans[idx] = "Gold Medal";
                }
                else if(i==1){
                    ans[idx] = "Silver Medal";
                }
                else if(i==2){
                    ans[idx] = "Bronze Medal";
                }
            }
            else{
               ans[idx] =  "" + (i+1);
            }
        }
        
        return ans;
    }
    
    public static void reverse(int[] array)
    {
        // Length of the array
        int n = array.length;

        // Swapping the first half elements 
        // With last Half Elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half
              // to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half
            // to the first half
            array[n - i - 1] = temp;
        }
    }
}