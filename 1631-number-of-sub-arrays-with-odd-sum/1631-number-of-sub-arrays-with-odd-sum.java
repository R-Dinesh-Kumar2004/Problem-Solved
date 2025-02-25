class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 0,sum = 0;
        int ans = 0, mod = (int)(1e9+7);
        for(int i : arr){
            sum += i;
            if(sum%2 == 1) odd++;
            else even++;

            if(sum%2 == 1){
                ans = (ans+even+1)%mod;
            }
            else{
                ans = (ans+odd)%mod;
            }
        }
        return ans;
    }
}