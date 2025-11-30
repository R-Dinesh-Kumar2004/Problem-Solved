class Solution {
    public int maxDistinct(String s) {
        int freq[] = new int[26];
        int ans = 0;

        for(char c : s.toCharArray()){
            if(freq[c-'a']++ == 0) ans++;
        }

        return ans;
    }
}