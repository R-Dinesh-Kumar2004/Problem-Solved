class Solution {
    public int minimizeXor(int num1, int num2) {
        int bits = Integer.bitCount(num2);
        int ans=0;
        int i=31;
        while(bits>0 && i>=0){
            if((num1&(1<<i))!=0){
               bits--;
               ans+=(1<<i);
            }
            i--;
        }
        i=0;
        while(i<32 && bits>0){
            if((num1&(1<<i))==0){
               bits--;
               ans+=(1<<i);
            }
            i++;
        }
        return ans;
    }
}