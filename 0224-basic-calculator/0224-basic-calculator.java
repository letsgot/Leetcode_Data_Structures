class Solution {
    public int calculate(String s) {
        if(s==null){
            return 0;
        }
        int num = 0;
        int sign = 1;
        int res = 0;
        
        Stack<Integer> st = new Stack<>();
        st.push(sign);
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='0'&&ch<='9'){
                num = ( num * 10 ) + (ch-'0');
            }
            else if(ch=='+'||ch=='-'){
                res += sign * num;
                num = 0;
                sign = st.peek() * (ch=='+'?1:-1);
            }
            else if(ch=='('){
                // st.push(num);
                // st.push(sign);
                // num = 0;
                // sign = 1;
                st.push(sign);
            }
            else if(ch==')'){
                // res += sign * num;
                // sign = st.pop();
                // num = st.pop();
                st.pop();
            }
        }
        
        if(num!=0){
            res += sign * num;
        }
        
        return res;
    }
}