class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer dp[][] = new Integer[n][366];

        return helper(0,0,days,costs,dp);
    }
    public int helper(int idx,int cur,int days[],int costs[],Integer dp[][]){
        int n = days.length;
        while(idx<n && cur>=days[idx]) idx++;
        if(idx == n) return 0;
        if(dp[idx][cur] != null) return dp[idx][cur];

        int oneDay = costs[0] + helper(idx+1,days[idx]+0,days,costs,dp);
        int oneWeek = costs[1] + helper(idx+1,days[idx]+6,days,costs,dp);
        int oneMonth = costs[2] + helper(idx+1,days[idx]+29,days,costs,dp);

        int min = Math.min(oneDay,Math.min(oneWeek,oneMonth));
        return dp[idx][cur] = min;
    }
}