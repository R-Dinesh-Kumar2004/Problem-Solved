class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        for(int i=1;i<n;i++){
            ans += 4*i;
        }
        return ans;
    }
}