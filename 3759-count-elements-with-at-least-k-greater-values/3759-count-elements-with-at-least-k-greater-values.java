class Solution {
    public int countElements(int[] nums, int k) {
        Map<Integer,Integer> tm = new TreeMap<>(Collections.reverseOrder());
        for(int i : nums){
            tm.putIfAbsent(i,0);
            tm.put(i,tm.get(i)+1);
        }

        int ans = 0,count = 0;
        for(int val : tm.values()){
            if(count >= k) ans += val;
            count += val;
        }

        return ans;
    }
}