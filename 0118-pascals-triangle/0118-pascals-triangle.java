class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> sub = new ArrayList<>();
            for(int j=0;j<(i+1);j++){
                if(j == 0 || j == i) sub.add(1);
                else{
                    int sum = ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                    sub.add(sum);
                }
            }
            ans.add(sub);
        }
        return ans;
    }
}