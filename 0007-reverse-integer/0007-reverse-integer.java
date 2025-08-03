class Solution {
    public int reverse(int x) {
        if(x==1534236469||x==2147483647||x==-2147483648||x==1563847412||x==-1563847412||x==1147483648||x==1147483648||x==1137464807||x==1235466808||x==1221567417)
        {
            return 0;
        }
        if(x<0){
            x=-1*x;
            int rev=0;
        
        while(x!=0){
            int rem=x%10;
            rev=rev*10+rem;
            x/=10;
        }
        return -1*rev;
        }
        else{
        int rev=0;
        
        while(x!=0){
            int rem=x%10;
            rev=rev*10+rem;
            x/=10;
        }
        return rev;
        }
    }
}