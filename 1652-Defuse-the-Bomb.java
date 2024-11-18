class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        if(k==0)return new int[n];
        int ans[]=new int[n];
        int l=Math.abs(k);
        int dir=k>0?1:-1;

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=1;j<=l;j++){
                int idx=(i+j*dir+n)%n;
                sum+=code[idx];
            }
            ans[i]=sum;
        }
        return ans;
    }
}