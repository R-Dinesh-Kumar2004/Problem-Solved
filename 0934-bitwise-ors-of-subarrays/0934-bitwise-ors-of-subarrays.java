class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for(int val : arr){
            Set<Integer> curr = new HashSet<>();

            for(int val1 : prev){
                curr.add(val|val1);
            }
            curr.add(val);

            prev = curr;
            res.addAll(curr);
        }

        return res.size();
    }
}