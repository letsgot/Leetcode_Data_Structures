class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length<=2){
            return true;
        }
        Arrays.sort(arr);
        
        int d = 0;
        
        for(int i=1;i<arr.length;i++){
            if(i==1){
                d = arr[i] - arr[i-1];
            }
            else{
                int t = arr[i] - arr[i-1];
                if(t!=d){
                    return false;
                }
            }
        }
        
        return true;
    }
}