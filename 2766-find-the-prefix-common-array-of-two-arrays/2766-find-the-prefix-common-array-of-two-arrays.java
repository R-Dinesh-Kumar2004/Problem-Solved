class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int ans[] = new int[n];
        Set<Integer> f = new HashSet<>();
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            int a=A[i],b=B[i];
            if(!f.add(a)) s.add(a);
            if(!f.add(b)) s.add(b);

            ans[i]=s.size();
        }
        return ans;
    }
}