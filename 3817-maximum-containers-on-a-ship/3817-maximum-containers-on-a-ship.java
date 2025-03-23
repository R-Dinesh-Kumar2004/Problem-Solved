class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int count = 0;
        n *= n;

        while(n-->0 && maxWeight>=w){
            count++;
            maxWeight -= w;
        }
        return count;
    }
}