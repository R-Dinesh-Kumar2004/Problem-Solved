class MinStack {
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private Stack<Integer> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        pq.offer(val);
    }
    
    public void pop() {
        pq.remove(st.pop());
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */