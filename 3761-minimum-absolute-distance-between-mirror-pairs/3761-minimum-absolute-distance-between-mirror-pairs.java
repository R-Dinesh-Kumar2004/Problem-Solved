class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        Map<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                ans = Math.min(ans,i-hm.get(nums[i]));
            }
            int rev = reverse(nums[i]);
            hm.put(rev,i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int reverse(int num){
        int rev = 0;
        while(num > 0){
            rev = rev*10+(num%10);
            num /= 10;
        }
        return rev;
    }
}