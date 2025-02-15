class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long max = (long)(1e15);
        long path[][] = new long[26][26];
        for(long it[] : path) Arrays.fill(it,max);

        for(int i=0;i<26;i++) path[i][i] = 0;

        int n = original.length;
        for(int i=0;i<n;i++){
            int s = original[i]-'a';
            int d = changed[i]-'a';
            path[s][d] = Math.min(path[s][d],cost[i]);
        }

        for(int k=0;k<26;k++){
           for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    path[i][j] = Math.min(path[i][j],path[i][k]+path[k][j]);
                }
           }
        }

        long ans = 0;
        int len = source.length();
        for(int i=0;i<len;i++){
            int s = source.charAt(i)-'a';
            int d = target.charAt(i)-'a';
            if(path[s][d] == max) return -1;
            ans += path[s][d];
        }
        return ans;
    }
}