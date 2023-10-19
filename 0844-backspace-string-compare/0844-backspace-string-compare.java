class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.size()==0){
                if(ch!='#'){
                    st.push(ch);
                }
            }
            else if(ch=='#'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
          
        StringBuilder sb = new StringBuilder();
        while(st.size()>0){
            sb.append(st.pop());
        }
      
        String str = sb.toString();
        
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(st.size()==0){
                if(ch!='#'){
                    st.push(ch);
                }
            }
            else if(ch=='#'){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        
       sb = new StringBuilder();
        while(st.size()>0){
            sb.append(st.pop());
        }
        
        return str.equals(sb.toString());
    }
}