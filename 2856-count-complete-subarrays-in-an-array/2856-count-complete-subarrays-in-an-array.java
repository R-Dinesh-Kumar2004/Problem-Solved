class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int freq[] = new int[2001];
        int uniq = 0;
        for(int i : nums){
            if(freq[i]++ == 0) uniq++;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            int dist[] = new int[2001];
            int count = 0;
            for(int j=i;j<n;j++){
                if(dist[nums[j]]++ == 0) count++;
                if(count == uniq)ans++;
                else if(count>uniq) break;
            }
        }
        return ans;
    }
}