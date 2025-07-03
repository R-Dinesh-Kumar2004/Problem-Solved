class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer,List<Integer>> tm = new TreeMap<>();
        int n = nums.size();
        int len = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<nums.get(i).size();j++){
                tm.putIfAbsent(i+j,new ArrayList<>());
                tm.get(i+j).add(0,nums.get(i).get(j));
                len++;
            }
        }

        int ans[] = new int[len];
        int idx = 0;

        for(List<Integer> l : tm.values()){
            for(int i : l) ans[idx++] = i;
        }

        return ans;
    }
}