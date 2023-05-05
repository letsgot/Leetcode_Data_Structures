class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int vc = 0;
        int max = 0;
        int j = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vc++;
            }
            if(i<k){
                
            }
            else{
                char chj = s.charAt(j);
                j++;
                if(chj=='a'||chj=='e'||chj=='i'||chj=='o'||chj=='u'){
                  vc--;
                }
            }
            max = Math.max(max,vc);
            i++;
        }
        return max;
    }
}