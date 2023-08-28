class MyStack {
 
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top = 0;
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.add(x);
        top = x;
    }
    
    public int pop() {
        while(q1.size()>1){
            top = q1.remove();
            q2.add(top);
        }
        int ans = q1.remove();
        q1 = q2;
        q2 = new ArrayDeque<>();
        return ans;
    }
    
    public int top() {
        if(q1.size()==0){
            return -1;
        }
        return top;
    }
    
    public boolean empty() {
        if(q1.size()==0){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */