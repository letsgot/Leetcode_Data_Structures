class Solution {
    public int partitionString(String s) {
        int p = 0;
        
        int arr[]= new int[26];
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(arr[ch-'a']!=0){
                p++;
                arr = new int[26];
            }
            arr[ch-'a']++;
        }
        
        return p +1;
    }
}