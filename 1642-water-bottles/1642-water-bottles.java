class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;

        while((empty+numBottles) >= numExchange){
            ans += numBottles;
            empty += numBottles;
            numBottles = empty/numExchange;
            empty -= (numBottles*numExchange);
            // System.out.print(empty+" ");
        }
        ans += numBottles;
        return ans;
    }
}