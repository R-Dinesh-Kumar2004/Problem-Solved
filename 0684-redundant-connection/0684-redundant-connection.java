class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int v = edges.length;
        int parent[] = new int[v+1];
        Arrays.fill(parent,-1);

        for(int it[]:edges){
            int s = it[0];
            int d = it[1];

            int p1 = find(s,parent);
            int p2 = find(d,parent);

            if(p1 == p2) return new int[]{s,d};

            union(p1,p2,parent);
        }

        return new int[0];
    }
    public int find(int nd,int parent[]){
        if(parent[nd]==-1) return nd;
        return find(parent[nd],parent);
    }
    public void union(int p1,int p2,int parent[]){
        parent[p1] = p2;
    }
}