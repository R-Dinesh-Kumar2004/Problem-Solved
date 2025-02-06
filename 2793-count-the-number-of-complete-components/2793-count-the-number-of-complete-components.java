class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int it[] : edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        Map<Integer,Integer> hm = new HashMap<>();

        int vis[] = new int[n];
        int id = 1;
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
               int cnt = dfs(i,adj,vis,id);
               hm.put(id,cnt);
               id++;
            }
        }
        int idArr[] = new int[id+1];
        for(int i=0;i<n;i++){
            int gId = vis[i];
            if(hm.get(gId) == adj.get(i).size()+1){
                idArr[gId]++;
            }
        }

        int completeComponent = 0;
        for(int i=1;i<id;i++){
            if(hm.get(i) == idArr[i]) completeComponent++;
        }
        return completeComponent;
    }
    public int dfs(int nd,List<List<Integer>> adj,int vis[],int id){
        vis[nd] = id;
        int size = 1;
        for(int it : adj.get(nd)){
            if(vis[it] == 0){
                size+=dfs(it,adj,vis,id);
            }
        }
        return size;
    }
}