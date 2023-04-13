class Solution {
    public boolean validateStackSequences(int[] pushed, int[] poped) {
        int i = 0;
        int j = 0;
        
        Stack<Integer> st = new Stack<>();
        i = 1;
        st.push(pushed[0]);
        while(true){
            
            if(i==pushed.length&&j==poped.length){
                break;
            }
            
            
            int pp = poped[j];
            
            if(i==pushed.length&&st.size()==0){
                return false;
            }
            else if(st.size()==0){
                int pu = pushed[i];
                st.push(pu);
                i++;
            }
            else if(st.peek()==pp){
                st.pop();
                j++;
            }
            else if(st.peek()!=pp&&i==pushed.length){
                return false;
            }
            else{
                int pu = pushed[i];
                st.push(pu);
                i++;
            }
        }
        
        return true;
    }
}