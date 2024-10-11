class Solution {
    public boolean canArrange(int[] arr, int k) {
        int []one = new int[k];
        for(int element : arr){
            int rem = (((element%k)+k)%k);
            one[rem]++;
        }
        if(one[0]%2 != 0 ){
            return false;
        }
        for(int i = 1; i <= k/2; i++){
            int com = k - i;
            if(one[i] != one[com]){
                return false;
            }
        
        }
            return true;
    }
}