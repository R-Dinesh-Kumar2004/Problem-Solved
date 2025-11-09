class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer,List<Integer>> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            hm.putIfAbsent(nums[i],new ArrayList<>());
            hm.get(nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;
        for(List<Integer> l : hm.values()){
            if(l.size() < 3) continue;
            for(int i=0;i<l.size()-2;i++){
                int a = l.get(i), b = l.get(i+1), c = l.get(i+2);
                ans = Math.min(ans,(c-b)+(c-a)+(b-a));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}