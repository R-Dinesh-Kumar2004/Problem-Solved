class Solution {
    int st[][];
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        st = new int[4*n][26];
        build(0,0,n-1,s);

        List<Boolean> ans = new ArrayList<>();

        for(int query[] : queries){
            int t[] = query(0,0,n-1,query[0],query[1]);
            int count = -1;
            for(int i : t){
                if(i%2 != 0) count++;
            }
            count = (int)Math.ceil(count/2.0);
            // System.out.print(count+" ");
            ans.add(count<=query[2]);
        }
        return ans;
    }
    public void build(int idx,int low,int high,String s){
        if(low == high){
            char c = s.charAt(low);
            st[idx][c-'a']++;
            return;
        }
        int mid = (low+high)/2;
        build(2*idx+1,low,mid,s);
        build(2*idx+2,mid+1,high,s);

        st[idx] = merge(st[2*idx+1],st[2*idx+2]).clone();
    }
    public int[] merge(int arr1[],int arr2[]){
        int res[] = arr1.clone();
        for(int i=0;i<26;i++){
            res[i] += arr2[i];
        }
        return res;
    }
    public int[] query(int idx,int low,int high,int l,int r){
        if(low>r || high<l) return new int[26];
        if(low>=l && high<=r) return st[idx];

        int mid = (low+high)/2;
        int left[] = query(2*idx+1,low,mid,l,r);
        int right[] = query(2*idx+2,mid+1,high,l,r);

        return merge(left,right);
    }
}