class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;
    int top;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
        top = 0;
    }
    
    public void push(int x) {
        if(in.size()==0){
            top = x;
        }
        in.push(x);
    }
    
    public int pop() {
        while(in.size()!=0){
            out.push(in.pop());
        }
        int val = out.pop();
        while(out.size()!=0){
            if(in.size()==0){
                top = out.peek();
            }
            in.push(out.pop());
        }
        return val;
    }
    
    public int peek() {
        return top;
    }
    
    public boolean empty() {
        return in.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */