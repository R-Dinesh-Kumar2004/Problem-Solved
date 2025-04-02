class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> sub = new ArrayList<>();

        rec(1,n,k,sub);
        return ans;
    }
    public void rec(int idx, int n, int k, List<Integer> sub){
        if(sub.size() == k){
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i=idx;i<=n;i++){
            sub.add(i);
            rec(i+1,n,k,sub);
            sub.remove(sub.size()-1);
        }
    }
}