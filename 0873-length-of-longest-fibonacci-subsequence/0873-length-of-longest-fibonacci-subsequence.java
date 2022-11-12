class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            set.add(i);
        }
        
        int res = 2;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int a = arr[i],b = arr[j],l = 2;
                while(set.contains(a+b)){
                    int temp = a;
                    a = b;
                    b = a + temp;
                    l++;
                }
                
                res = Math.max(l,res);
            }
        }
        
        return res>2?res:0;
    }
}