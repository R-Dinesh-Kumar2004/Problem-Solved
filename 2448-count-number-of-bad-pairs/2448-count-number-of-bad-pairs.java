class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long tot_pairs = (long)n*(n-1)/2;
        Map<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            int dif = nums[i]-i;
            hm.put(dif,hm.getOrDefault(dif,0)+1);
        }

        for(int it : hm.values()){
            long good_pairs = (long)it*(it-1)/2;
            tot_pairs -= good_pairs;
        }
        return tot_pairs;
    }
}