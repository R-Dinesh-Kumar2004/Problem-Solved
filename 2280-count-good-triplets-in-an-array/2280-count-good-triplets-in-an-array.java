class Solution {
    int st[];
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        st = new int[4*n];
        int pos[] = new int[n];

        for(int i=0;i<n;i++){
            pos[nums2[i]] = i;
        }
        update(0,0,n-1,pos[nums1[0]]);
        long ans = 0;
        for(int i=1;i<n-1;i++){
            int idx = pos[nums1[i]];
            int leftCommon = RMQ(0,0,n-1,0,idx);
            int leftUnCommon = i-leftCommon;
            int rightCommon = (n-idx-1)-leftUnCommon;
            ans += ((long)leftCommon*rightCommon);
            update(0,0,n-1,idx);
        }
        return ans;
    }
    public int RMQ(int idx,int low,int high,int l,int r){
        if(l<=low && high<=r) return st[idx];
        if(l>high || r<low) return 0;
        int mid = (low+high)/2;
        int left = RMQ(2*idx+1,low,mid,l,r);
        int right = RMQ(2*idx+2,mid+1,high,l,r);
        return left+right;
    }
    public void update(int idx,int low,int high,int up){
        if(low == high){
            st[idx]++;
            return;
        }
        int mid = (low+high)/2;
        if(up<=mid) update(2*idx+1,low,mid,up);
        else update(2*idx+2,mid+1,high,up);
        st[idx] = st[2*idx+1]+st[2*idx+2];
    }
}