class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int adjMat[][] = new int[n+1][n+1];
        int indeg[] = new int[n];

        for(int road[] : roads){
            int u = road[0], v = road[1];
            indeg[u]++; 
            indeg[v]++;

            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
        } 

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) continue;
                int cur = indeg[i] + indeg[j];
                if(adjMat[i][j] == 1) cur -= 1;
                ans = Math.max(ans,cur);
            }
        }

        return ans;
    }
}