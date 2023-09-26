class Solution {
    public String removeDuplicateLetters(String s) {
        int res[] = new int[26];
        char [] ch = s.toCharArray();
        for(char c : ch){
            res[c-'a']++;
        }
        
        Stack<Character> st = new Stack<>();
        boolean vis[] = new boolean[26];
        int index;
        
        for(char c : ch){
            index = c-'a';
            res[index]--;
            if(vis[index]){
                continue;
            }
            
            while(st.size()>0&&c<st.peek() && res[st.peek()-'a']!=0){
                vis[st.pop()-'a']=false;
            }
            
             st.push(c); //add current character and mark it as visited
             vis[index]=true;
        }
        
        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}