class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        else if(strs.length==1){
            return strs[0];
        }
        
        String check = "";
        check = lcp(strs[0],strs[1]);
        
        for(int i=2;i<strs.length;i++){
            check = lcp(check,strs[i]);
        }
        
        return check;
    }
    
    public String lcp(String s1,String s2){
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while(i<s1.length()&&i<s2.length()){
            if(s1.charAt(i)!=s2.charAt(i)){
                return sb.toString();
            }
            sb.append(s1.charAt(i));
            i++;
        }
        
        return sb.toString();
    }
}