class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int lastVis[] = new int[32];
        int ans[] = new int[n];

        for(int i=n-1;i>=0;i--){
            for(int b=0;b<32;b++){
                if(((nums[i]>>b) & 1) == 1){
                    lastVis[b] = i;
                }
            }

            int maxVal = i;
            for(int b=0;b<32;b++){
                maxVal = Math.max(maxVal,lastVis[b]);
            }

            ans[i] = maxVal-i+1;
        }

        return ans;
    }
}