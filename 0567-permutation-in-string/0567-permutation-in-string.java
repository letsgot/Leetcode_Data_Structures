class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()){
            return false;
        }
        
        for(int i=0;i<=s2.length()-s1.length();i++){
            if(check(s1,s2.substring(i,i+s1.length()))){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean check(String s1,String s2){
        
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        
        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            
            arr1[ch1-'a']++;
            arr2[ch2-'a']++;
        }
        
        for(int i=0;i<26;i++){
           if(arr1[i]!=arr2[i]){
               return false;
           }
        }
        
        return true;
    }
}