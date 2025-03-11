class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0, left = 0;
        int freq[] = new int[3];


        for(int right = 0;right<n;right++){
            char c = s.charAt(right);
            freq[c-'a']++;

            while(freq[0] !=0 && freq[1] != 0 && freq[2] != 0){
                ans += n-right;
                char t = s.charAt(left);
                freq[t-'a']--;
                left++;
            }
        }
        return ans;
    }
}