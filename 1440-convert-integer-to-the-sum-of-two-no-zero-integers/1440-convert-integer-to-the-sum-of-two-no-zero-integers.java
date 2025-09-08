class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n/2;i++){
            if(isValid(i,n-i)){
                return new int[]{i,n-i};
            }
        }
        return new int[0];
    }
    public boolean isValid(int num1,int num2){
        while(num1 > 0){
            if(num1%10 == 0) return false;
            num1 /= 10;
        }
        while(num2 > 0){
            if(num2%10 == 0) return false;
            num2 /= 10;
        }
        return true;
    }
}