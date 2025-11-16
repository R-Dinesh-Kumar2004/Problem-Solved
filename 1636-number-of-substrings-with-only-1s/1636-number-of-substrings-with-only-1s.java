class Solution {
    int mod = (int)(1e9+7);
    public int numSub(String s) {
        int n = s.length();
        int idx = 0;
        long ans = 0;

        while(idx < n){
            long count = 0;
            while(idx< n && s.charAt(idx) == '1'){
                count++; idx++;
            }
            ans += (count*(count+1)/2);
            ans %= mod;
            idx++;
        }
        return (int)ans;
    }
}