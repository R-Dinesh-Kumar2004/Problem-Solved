class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int first[] = new int[26];
        Arrays.fill(first,-1);
        int last[] = new int[26];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(first[c-'a'] == -1) first[c-'a'] = i;
            last[c-'a'] = i;
        }

        int ans = 0;
        for(int i=0;i<26;i++){
            if(first[i] != last[i]){
                ans += countUnique(first[i]+1,last[i],s);
            }
        }

        return ans;
    }
    public int countUnique(int l,int r,String s){
        boolean vis[] = new boolean[26];
        int count = 0;

        for(int i=l;i<r;i++){
            if(!vis[s.charAt(i)-'a']){
                vis[s.charAt(i)-'a'] = true;
                count++;
            }
        }
        return count;
    }
}