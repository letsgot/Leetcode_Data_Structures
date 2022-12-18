class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int ans[] = new int[temp.length];
        for(int i=1;i<temp.length;i++){
            while(st.size()>0&&temp[st.peek()]<temp[i]){
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}