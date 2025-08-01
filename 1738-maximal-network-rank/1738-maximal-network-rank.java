class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean adjMat[][] = new boolean[n][n];
        int indeg[] = new int[n];

        for(int road[] : roads){
            int u = road[0], v = road[1];
            indeg[u]++; 
            indeg[v]++;

            adjMat[u][v] = true;
            adjMat[v][u] = true;
        } 

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cur = indeg[i] + indeg[j];
                if(adjMat[i][j]) cur -= 1;
                ans = Math.max(ans,cur);
            }
        }

        return ans;
    }
}