class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;

        while((empty+numBottles) >= numExchange){
            if(empty >= numExchange){
                numBottles += 1;
                empty -= numExchange;
                numExchange += 1;
            }
            else{
                ans += numBottles;
                empty += numBottles;
                numBottles = 0;
            }
        }
        ans += numBottles;
        return ans;
    }
}