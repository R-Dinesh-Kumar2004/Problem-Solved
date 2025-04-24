class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int freq[] = new int[2001];
        int uniq = 0;
        for(int i : nums){
            if(freq[i]++ == 0) uniq++;
        }
        Arrays.fill(freq,0);

        int ans = 0,left = 0,count = 0;
        for(int right=0;right<n;right++){
            if(freq[nums[right]]++ == 0) count++;

            while(count == uniq){
                ans += (n-right);
                if(--freq[nums[left]] == 0) count--;
                left++;
            }
        }
        return ans;
    }
}