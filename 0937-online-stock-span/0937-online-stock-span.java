class StockSpanner {
    Stack<Integer> st;
    List<Integer> stock;
    int idx = -1;

    public StockSpanner() {
        st = new Stack<>();
        stock = new ArrayList<>();
    }
    
    public int next(int price) {
        idx++;
        stock.add(price);
        
        while(!st.isEmpty() && stock.get(st.peek()) <= price){
            st.pop();
        }
       
        if(st.isEmpty()){
           st.push(idx); return idx+1;
        } 
        
        int prev = st.peek();
        st.push(idx);

        return idx - prev; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */