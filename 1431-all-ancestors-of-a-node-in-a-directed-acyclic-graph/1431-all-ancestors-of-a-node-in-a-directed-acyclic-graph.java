class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        int indeg[] = new int[n];

        for(int edge[] : edges){
           adj.get(edge[0]).add(edge[1]);
           indeg[edge[1]]++;
        }

        List<int[]> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indeg[i] == 0) q.add(i);
            list.add(new int[1001]);
        }

        while(!q.isEmpty()){
            int nd = q.poll();
            int ans[] = list.get(nd);

            for(int nei : adj.get(nd)){
                indeg[nei]--;
                if(indeg[nei] == 0) q.add(nei);
                
                for(int i=0;i<1001;i++){
                    if(ans[i] != 0) list.get(nei)[i]++;
                }
                list.get(nei)[nd]++;
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int nums[] : list){
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<1001;i++){
                if(nums[i] != 0) sub.add(i);
            }
            ans.add(sub);
        }

        return ans;
    }
}