class Solution {
    public int integerReplacement(int n) {
        int n1=n;
        int count=0;
        while(n>1){
            count++;
            if(n%2==0)n/=2;
            // System.out.print(n+" ");
            else{
                if(n==3||(n&2)==0||n==2147483647)n--;
                else n++;
            }
        }
        if(n1==2147483647)return count-1;
        return count;
    }
}