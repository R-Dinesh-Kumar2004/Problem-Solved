class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int dp[] = new int[n];
        int prev[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);

        int max = 1,end = 0;
        for(int i=1;i<n;i++){
            int val = 0,idx = -1;
            for(int j=0;j<i;j++){
                if((groups[i] != groups[j]) && findHummingDis(words[i],words[j])){
                    if(val<dp[j]){
                        val = dp[j];
                        idx = j;
                    }
                }
            }
            if(dp[i]+val>dp[i]){
                dp[i] += val;
                prev[i] = idx;
            }
            if(max<dp[i]){
                max = dp[i];
                end = i;
            }
        }
        
        List<String> ans = new ArrayList<>();
        while(end != -1){
            ans.add(words[end]);
            end = prev[end];
        }
        Collections.reverse(ans);

        return ans;
    }
    public boolean findHummingDis(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        int count = 0;

        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }
        return (count == 1);
    }
}