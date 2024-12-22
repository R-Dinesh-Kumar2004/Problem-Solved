class NumArray {
    private int st[]; 
    public NumArray(int[] nums) {
        int n=nums.length;
        st=new int[4*n];
        build(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        int n=st.length/4;
        up(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        int n=st.length/4;
        return query(0,0,n-1,left,right);
    }

    public void build(int i,int low,int high,int arr[]){
        if(low==high){
            st[i]=arr[low];
            return;
        }
        int mid=(low+high)/2;
        build(2*i+1,low,mid,arr);
        build(2*i+2,mid+1,high,arr);
        st[i]=st[2*i+1]+st[2*i+2];
    }
    
    public int query(int i,int low,int high,int l,int r){
        if(l<=low && r>=high) return st[i];
        if(l>high || r<low) return 0;
        int mid=(low+high)/2;
        int left=query(2*i+1,low,mid,l,r);
        int right=query(2*i+2,mid+1,high,l,r);

        return left+right; 
    }

    public void up(int i,int low,int high,int idx,int val){
        if(low==high && idx==low){
            st[i]=val;
            return;
        }
        int mid=(low+high)/2;
        if(idx<=mid){
            up(2*i+1,low,mid,idx,val);
        }
        else up(2*i+2,mid+1,high,idx,val);

        st[i]=st[2*i+1]+st[2*i+2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */