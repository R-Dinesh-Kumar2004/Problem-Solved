class Solution {
    int mod = (int)(1e9+7);
    public int countGoodNumbers(long n) {
        long even = helper(5,(n+1)/2);
        long odd = helper(4,n/2);
        
        return (int)((even*odd)%mod);
    }
    public long helper(int a,long b){
        if(b == 0) return 1;
        long ans = helper(a,b/2);

        if(b%2 != 0) return (ans*ans*a)%mod;
        else return (ans*ans)%mod;
    }
}