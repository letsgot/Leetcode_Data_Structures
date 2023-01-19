class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                while(set.contains(ch)){
                    char ch1 = s.charAt(j);
                    set.remove(ch1);
                    j++;
                }
            }
            set.add(ch);
            max = Math.max(max,set.size());
        }
        
        return max;
    }
}