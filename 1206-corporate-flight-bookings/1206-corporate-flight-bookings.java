class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int sweep[] = new int[n+1];

        for(int it[] : bookings){
            int s = it[0], e = it[1], st = it[2];
            sweep[s] += st;
            if(e+1<=n) sweep[e+1] -= st;
        }
        int ans[] = new int[n];
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += sweep[i];
            ans[i-1] = sum;
            // System.out.print(sum+" ");
        }
        return ans;
    }
}