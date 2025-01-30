class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int it[]:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        int bi[] = new int[n+1];
        Arrays.fill(bi,-1);
        for(int i=1;i<=n;i++){
            if(bi[i] == -1){
                if(!bipartite(i,0,adj,bi)) return -1;
            }
        }
        
        int max_level[] = new int[n+1];
        for(int i=1;i<=n;i++){
            max_level[i] = findLevel(i,adj,n);
        }
        boolean vis[] = new boolean[n+1];
        int tot_level = 0;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                tot_level+=findMaxLevel(i,adj,vis,max_level);
            }
        }
        return tot_level;
    }

    public boolean bipartite(int nd,int c,List<List<Integer>> adj, int bi[]){
        bi[nd] = c;
        for(int it:adj.get(nd)){
            if(bi[it] == -1){
                if(!bipartite(it,1-c,adj,bi)) return false;
            }
            else if(bi[it] == c){
                return false;
            }
        }
        return true;
    }
    public int findLevel(int nd,List<List<Integer>> adj,int n){
        boolean vis[] = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(nd);
        vis[nd] = true;
        int level = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                int node = q.poll();
                for(int it:adj.get(node)){
                    if(!vis[it]){
                        vis[it] = true;
                        q.add(it);
                    }
                }
            }
            level++;
        }
        return level;
    }
    public int findMaxLevel(int nd,List<List<Integer>> adj,boolean vis[],int max_level[]){
        int max = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(nd);
        vis[nd] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            max = Math.max(max,max_level[node]);
            for(int it:adj.get(node)){
                if(!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return max;
    }
}