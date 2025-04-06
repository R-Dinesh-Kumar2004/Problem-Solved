class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int lis = 1;

        for(int i=1;i<n;i++){
            int max = 0;
           for(int j=0;j<i;j++){
             if(nums[i]%nums[j] == 0) max = Math.max(max,dp[j]);
           }
           dp[i] += max;
           lis = Math.max(lis,dp[i]);
        }
        // System.out.print(Arrays.toString(dp));
        // System.out.print(lis);
        List<Integer> ans = new ArrayList<>();
        int prev = -1;

        for(int i=n-1;i>=0;i--){
            if(dp[i] == lis){
                if(prev == -1 || prev%nums[i] == 0){
                    ans.add(nums[i]); lis--;
                    prev = nums[i];
                }
            }
        }
        return ans;
    }
}