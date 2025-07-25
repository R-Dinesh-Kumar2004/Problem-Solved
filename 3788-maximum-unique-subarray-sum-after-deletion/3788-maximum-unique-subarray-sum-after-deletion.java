class Solution {
    public int maxSum(int[] nums) {
        int vis[] = new int[101];
        int sum = 0,max = -101;

        for(int val : nums){
            max = Math.max(max,val);
            if(val < 0 || vis[val] == 1) continue;
            vis[val] = 1;
            sum += val;
        }
        if(max < 0) return max;
        return sum;
    }
}