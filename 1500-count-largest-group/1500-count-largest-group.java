class Solution {
    public int countLargestGroup(int n) {
        int ht[] = new int[37];
        int max = 0;

        for(int i=1;i<=n;i++){
            int sumOfDigits = findSoD(i);
            if(++ht[sumOfDigits]>max){
                max = ht[sumOfDigits];
            }
        }
        int ans = 0;
        for(int i : ht){
            if(i == max) ans++;
        }
        return ans;
    }
    public int findSoD(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}