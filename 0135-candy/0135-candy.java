class Solution {
    public int candy(int[] rat) {
        int n = rat.length;

        int can[] = new int[n];
        Arrays.fill(can,1);
        int ans = n;

        for(int i=1;i<n;i++){
            if(rat[i-1]<rat[i]){
                ans -= can[i];
                can[i] = can[i-1]+1;
                ans += can[i];
            }
        }
        for(int i=n-2;i>=0;i--){
            if(rat[i+1]<rat[i]){
                if(can[i+1]<can[i]) continue;
                ans -= can[i];
                can[i] = can[i+1]+1;
                ans += can[i];
            }
        }
        // System.out.print(Arrays.toString(can));
        return ans;
    }
}