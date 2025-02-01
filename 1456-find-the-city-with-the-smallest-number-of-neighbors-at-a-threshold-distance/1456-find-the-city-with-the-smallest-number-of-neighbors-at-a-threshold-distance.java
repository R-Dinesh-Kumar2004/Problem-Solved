class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int mat[][] = new int[n][n];
        for(int it[]:mat){
            Arrays.fill(it,100001);
        }
        for(int i=0;i<n;i++) mat[i][i] = 0;
        for(int it[]:edges){
            int s = it[0];
            int d = it[1];
            int wt = it[2];        
            mat[s][d] = wt;
            mat[d][s] = wt;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j] = Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }

        int ans = 0,min = n;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(mat[i][j] <= distanceThreshold) count++;
            }
            if(min>=count){
                min = count;
                ans = i;
            }
        }
        return ans;
    }
}