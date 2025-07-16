class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 0;
        int firstEvenIdx = -1,firstOddIdx = -1;

        for(int i=0;i<n;i++){
            int val = nums[i];
            if(val%2 == 0){
                even++;
                if(firstEvenIdx == -1) firstEvenIdx = i;
            }
            else{
                odd++;
                if(firstOddIdx == -1) firstOddIdx = i;
            }
        }

        int ans = Math.max(odd,even);
        ans = Math.max(ans,findMaxLen(firstOddIdx,nums));
        ans = Math.max(ans,findMaxLen(firstEvenIdx,nums));

        return ans;
    }
    public int findMaxLen(int st,int nums[]){
        if(st == -1) return 0;
        int count = 1;
        int prev = nums[st];

        for(int i=st+1;i<nums.length;i++){
            if(prev%2 != nums[i]%2){
                prev = nums[i];
                count++;
            }
        }

        return count;
    }
}
    // public int helper(int idx,int hold,int nums[],Integer dp[][]){
    //     if(idx == nums.length) return 0;
    //     if(dp[idx][hold] != null) return dp[idx][hold];

    //     int ans = 0;
    //     int not = helper(idx+1,hold,nums,dp);


    //     if(hold == 0){
    //         int curHold = (nums[idx]%2 == 0) ? 2 : 1;
    //         int pick = 1 + helper(idx+1,curHold,nums,dp);

    //         ans = Math.max(pick,not);
    //     }
    //     else if(hold == 1 && nums[idx]%2 == 0){
    //         int pick = 1 + helper(idx+1,2,nums,dp);
    //         ans = Math.max(pick,not);
    //     }
    //     else if(hold == 2 && nums[idx]%2 != 0){
    //         int pick = 1 + helper(idx+1,1,nums,dp);
    //         ans = Math.max(pick,not);
    //     }

    //     return dp[idx][hold] = ans;
    // }