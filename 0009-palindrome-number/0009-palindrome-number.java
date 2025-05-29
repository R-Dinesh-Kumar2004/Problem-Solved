class Solution {
    public boolean isPalindrome(int x) {
        int rem=0;
        if(0>x){
            return false;
        }
        int t=x;
        int rev;
        while(x!=0){
            rev=x%10;
            rem=rem*10+rev;
            x=x/10;
        }
       if(rem==t){
        return true;
       }
       else
        return false;
    }
}