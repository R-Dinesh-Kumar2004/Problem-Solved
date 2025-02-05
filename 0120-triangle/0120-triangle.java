class Solution {
    int sum = 0;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int it[]:dp) Arrays.fill(it,-1);
        return rec(0,0,n,triangle,dp);
    }
    public int rec(int i,int j,int n,List<List<Integer>> tri,int dp[][]){
        if(i==n-1){
            return tri.get(i).get(j);
        }
        if(dp[i][j] != -1) return dp[i][j];

        int down = rec(i+1,j,n,tri,dp);
        int dright = rec(i+1,j+1,n,tri,dp);

        dp[i][j] = tri.get(i).get(j)+Math.min(down,dright);

        return dp[i][j];
    }
}