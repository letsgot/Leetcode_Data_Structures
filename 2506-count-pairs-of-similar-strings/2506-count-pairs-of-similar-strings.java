class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        for(int i=0; i<words.length-1; i++){
            for(int j=i+1; j<words.length; j++){
                count += check(words[i], words[j]);
            }
        }
        return count;
    }
    private int check(String s, String t){
        Set sset = new HashSet();
        for(char c: s.toCharArray())    sset.add(c);
        Set tset = new HashSet();
        for(char c: t.toCharArray())    tset.add(c);
        return sset.equals(tset) ? 1 : 0;
    }
}