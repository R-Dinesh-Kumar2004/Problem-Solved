class RangeFreqQuery {
    Map<Integer,Integer> []st;
    int n;
    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        st = new HashMap[4*n];
        build(0,0,n-1,arr);
    }
    
    public int query(int left, int right, int value) {
        return queryFn(0,0,n-1,left,right,value);
    }
    public void build(int i, int low, int high, int arr[]){
        if(low == high){
            st[i] = new HashMap<>();
            st[i].put(arr[low],1);
            return;
        }
        int mid = low+(high-low)/2;
        build(2*i+1,low,mid,arr);
        build(2*i+2,mid+1,high,arr);
        st[i] = merge(st[2*i+1],st[2*i+2]);
    }

    public Map<Integer,Integer> merge(Map<Integer,Integer> s1, Map<Integer,Integer> s2){
        Map<Integer,Integer> ans = new HashMap<>();
        for(Map.Entry<Integer,Integer> en:s1.entrySet()){
            int val = en.getKey();
            int freq = en.getValue();

            ans.put(val,ans.getOrDefault(val,0)+freq);
        }

        for(Map.Entry<Integer,Integer> en:s2.entrySet()){
            int val = en.getKey();
            int freq = en.getValue();

            ans.put(val,ans.getOrDefault(val,0)+freq);
        }

        return ans;
    }
    public int queryFn(int i,int low,int high,int l,int r,int val){
        if(r<low || high<l) return 0;
        if(l<=low && high<=r) return st[i].getOrDefault(val,0);
        int mid = (low+high)/2;
        int left = queryFn(2*i+1,low,mid,l,r,val);
        int right = queryFn(2*i+2,mid+1,high,l,r,val);

        return left+right;
    }
}

