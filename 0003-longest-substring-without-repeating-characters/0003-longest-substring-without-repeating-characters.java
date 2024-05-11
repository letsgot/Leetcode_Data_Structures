class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int j = 0;
        
        int max = 0;
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            
            if(set.contains(ch)){
                while(set.contains(ch)){
                    char chj = s.charAt(j);
                    set.remove(chj);
                    j++;
                }
            }
            
            set.add(ch);
            max = Math.max(max,set.size());
        }
        
        return max;
    }
}