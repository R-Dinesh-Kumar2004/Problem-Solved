class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int left = 0, count = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        long ans = 0;

        for(int right=0;right<n;right++){
            int val = nums[right];
            int freq = hm.getOrDefault(val,0);
            int cur = (freq*(freq-1))/2;
            count -= cur; 
            hm.put(val,hm.getOrDefault(val,0)+1);
            freq = hm.get(val);
            cur = (freq*(freq-1))/2; 
            count += cur;
            // System.out.print(count+" ");


            while(left<right && count>=k){
                ans += (n - right);
                val = nums[left];
                freq = hm.get(val);
                cur = (freq*(freq-1))/2;
                hm.put(val,freq-1);
                freq = hm.get(val);
                cur -= (freq*(freq-1))/2; 
                count -= cur;
                left++;
            }
        }
        return ans;
    }
}