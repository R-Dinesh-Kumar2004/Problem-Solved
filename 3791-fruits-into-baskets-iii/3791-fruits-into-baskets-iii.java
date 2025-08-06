class Solution {
    int st[];
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        st = new int[4*n];

        build(0,0,n-1,baskets);

        int count = 0;
        for(int fruit : fruits){
            if(st[0]>=fruit){
                count++;
                update(0,0,n-1,fruit);
            }
        }

        return n - count;
    }
    public void build(int idx,int low,int high,int bas[]){
        if(low == high){
            st[idx] = bas[low];
            return;
        }
        int mid = low+(high-low)/2;
        build(2*idx+1,low,mid,bas);
        build(2*idx+2,mid+1,high,bas);

        st[idx] = Math.max(st[2*idx+1],st[2*idx+2]);
    }
    public void update(int idx,int low,int high,int fruit){
        if(low == high){
            st[idx] = 0;
            return;
        }
        int mid = low+(high-low)/2;
        if(st[2*idx+1]>=fruit) update(2*idx+1,low,mid,fruit);
        else update(2*idx+2,mid+1,high,fruit);

        st[idx] = Math.max(st[2*idx+1],st[2*idx+2]);
    }
}