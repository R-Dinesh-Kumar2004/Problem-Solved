class Solution {
    public int totalMoney(int n) {
        int sum = 0,init = 1;
        int i = 0;
        while(i < n){
            int val = init;
            int count = 0;
            while(count < 7 && i < n){
                i++;
                count++;
                sum += val;
                val++;
            }
            init++;
        }
        return sum;
    }
}