class ProductOfNumbers {
    List<Long> ele;
    public ProductOfNumbers() {
        ele = new ArrayList<>();
        ele.add(1L);
    }
    
    public void add(int num) {
        if(num != 0){
            long prev = ele.get(ele.size()-1);
            ele.add(num*prev);
        }
        else{
            ele = new ArrayList<>();
            ele.add(1L);
        }
    }
    
    public int getProduct(int k) {
        int n = ele.size();
        if(k>=n) return 0;
        
        long product = ele.get(n-1);
        long div = ele.get(n-k-1);
        return (int)(product/div);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */