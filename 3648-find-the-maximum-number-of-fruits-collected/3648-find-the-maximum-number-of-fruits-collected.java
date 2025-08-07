class Solution {
    int max = Integer.MAX_VALUE;
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;

        int first = 0;
        for(int i=0;i<n;i++){
            first += fruits[i][i];
        }
        
        Integer dp[][] = new Integer[n][n];
        int dir[][] = {{1,-1},{1,0},{1,1}};
        int second = helper(0,n-1,n-1,fruits,dir,dp);

        for(Integer it[] : dp) Arrays.fill(it,null);

        int dir1[][] = {{-1,1},{0,1},{1,1}};
        int third = helper(n-1,0,n-1,fruits,dir1,dp);

        return first+second+third;
    }
    public int helper(int r,int c,int step,int fruits[][],int dir[][],Integer dp[][]){
        int n = fruits.length;

        if(r == n-1 && c == n-1){
            return (step == 0) ? 0 : max;
        }
        if(r == c || step == 0) return max;
        if(dp[r][c] != null) return dp[r][c];

        int maxFruit = -1;

        for(int d[] : dir){
            int newX = r+d[0];
            int newY = c+d[1];

            if(newX>=0 && newY>=0 && newX<n && newY<n){
                int cur = helper(newX,newY,step-1,fruits,dir,dp);

                if(cur != max){
                    maxFruit = Math.max(maxFruit,cur);
                }
            }
        }
        return dp[r][c] = (maxFruit < 0) ? max : maxFruit+fruits[r][c];
    }
}