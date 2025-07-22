class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int freq[] = new int[10001];
        int left = 0,count = 0, ans = 0;
        int curSum = 0;

        for(int right=0;right<n;right++){
            int val = nums[right];
            curSum += val;
            if(freq[val]++ == 1) count++;

            while(count>0){
                int del = nums[left];
                curSum -= del;
                if(--freq[del] == 1) count--;

                left++;
            } 
            ans = Math.max(ans,curSum);
        }

        return ans;
    }
}