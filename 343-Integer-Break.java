class Solution {
    public int integerBreak(int n) {
        if(n<4)return n-1;
        else if(n==4)return n;

        int ans=1;
        while(n>4){
            ans*=3;
            n-=3;
        }
        ans*=n;
        return ans;
    }
}