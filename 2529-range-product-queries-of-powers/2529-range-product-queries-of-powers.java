class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = (int)(1e9+7);
        int m = queries.length;
        int ans[] = new int[m];


        String s = Integer.toBinaryString(n);
        n = s.length();
        int len = 0;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1') len++;
        }
        long arr[] = new long[len];
        int idx = 0;
        long pow = 1;

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '1'){
                arr[idx++] = pow;
            }
            pow = pow*2;
        }

        for(int i=0;i<m;i++){
            int st = queries[i][0], ed = queries[i][1];
            long mul = 1;
            for(int j=st;j<=ed;j++){
                mul = (mul*arr[j])%mod;
            }
            ans[i] = (int)mul;
        }

        return ans;
    }
}