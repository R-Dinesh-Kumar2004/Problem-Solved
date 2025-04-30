class Solution {
    int mod = (int)(1e9+7);
    public int countHomogenous(String s) {
        int n = s.length();
        char ch[] = s.toCharArray();
        char prev = ch[0];
        long count = 1,ans = 0;
        
        for(int i=1;i<n;i++){
            if(prev == ch[i]) count++;
            else{
                ans = (ans+(count*(count+1)/2))%mod;
                count = 1;
                prev = ch[i];
            }
        }
        ans = (ans+(count*(count+1)/2))%mod;
        return (int)ans;
    }
}