class Solution {
    static int st[];
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length,n = 0;
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<len;i++){
            nums[i]+=10000;
            if(n<nums[i]) n = nums[i];
        }
        n+=1;
        st = new int[4*n];

        int freq[] = new int[n];
        for(int num : nums) freq[num]++;
        
        build(0,0,n-1,freq);

        for(int i=0;i<len;i++){
            int val = nums[i];
            freq[val]--;
            update(0,0,n-1,val,-1);
            int cnt = query(0,0,n-1,0,val-1);
            ans.add(cnt);
        }

        return ans;
    }
    public void build(int idx,int low,int high,int freq[]){
        if(low == high){
            st[idx] = freq[low];
            return;
        }
        int mid = (low+high) >> 1;
        build(2*idx+1,low,mid,freq);
        build(2*idx+2,mid+1,high,freq);
        st[idx] = st[2*idx+1]+st[2*idx+2];
    }
    public void update(int idx,int low,int high,int up,int val){
        if(low == high){
            st[idx] +=val;
            return;
        }
        int mid = (low+high) >> 1;
        if(up<=mid) update(2*idx+1,low,mid,up,val);
        else update(2*idx+2,mid+1,high,up,val);
        st[idx] = st[2*idx+1]+st[2*idx+2];
    }
    public int query(int idx,int low,int high,int l,int r){
        if(low>r || high<l) return 0;
        else if(l<=low && high<=r) return st[idx];
        
        int mid = (low+high) >> 1;
        int left = query(2*idx+1,low,mid,l,r);
        int right = query(2*idx+2,mid+1,high,l,r);

        return left+right;
    }
}