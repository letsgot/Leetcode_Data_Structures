class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String str = tokens[i];
            if(str.equals("+")||str.equals("*")||str.equals("-")||str.equals("/")){
                int v1 = st.pop();
                int v2 = st.pop();
                if(str.equals("+")){
                    st.push(v1+v2);
                }
                else if(str.equals("-")){
                    st.push(v2-v1);
                }
                else if(str.equals("*")){
                    st.push(v1*v2);
                }
                else{
                    st.push(v2/v1);
                }
            }
            else{
                int val = Integer.parseInt(str);
                st.push(val);
            }
        }
        
        return st.pop();
    }
    
}

// import java.util.Stack;

// public class Solution {
//     public int evalRPN(String[] tokens) {
//         int a,b;
// 		Stack<Integer> S = new Stack<Integer>();
// 		for (String s : tokens) {
// 			if(s.equals("+")) {
// 				S.add(S.pop()+S.pop());
// 			}
// 			else if(s.equals("/")) {
// 				b = S.pop();
// 				a = S.pop();
// 				S.add(a / b);
// 			}
// 			else if(s.equals("*")) {
// 				S.add(S.pop() * S.pop());
// 			}
// 			else if(s.equals("-")) {
// 				b = S.pop();
// 				a = S.pop();
// 				S.add(a - b);
// 			}
// 			else {
// 				S.add(Integer.parseInt(s));
// 			}
// 		}	
// 		return S.pop();
// 	}
// }