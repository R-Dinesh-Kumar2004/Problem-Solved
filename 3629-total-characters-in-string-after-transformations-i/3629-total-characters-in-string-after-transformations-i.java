class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = (int)(1e9+7);
        long freq[] = new long[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        while(t-->0){
            long z = freq[25];
            for(int i=25;i>0;i--){
                freq[i] = freq[i-1];
            }
            freq[0] = z;
            freq[1] = (freq[1]+z)%mod;
        }
        long ans = 0;
        for(long i : freq){
            ans = (ans+i)%mod;
        }
        return (int)ans;
    }
}