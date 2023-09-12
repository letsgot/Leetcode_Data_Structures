class Solution {
    public int minDeletions(String s) {
        int arr[] = new int[26];
        
        for(char ch : s.toCharArray()){
            int idx = ch - 'a';
            arr[idx]++;
        }
        
        HashSet<Integer> set = new HashSet<>();
        int min = 0;
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                int val = arr[i];
                while(val>0&&set.contains(val)){
                    val--;
                    min++;
                }
                if(val>0)
                set.add(val);
            }
        }
        
        return min;
    }
}