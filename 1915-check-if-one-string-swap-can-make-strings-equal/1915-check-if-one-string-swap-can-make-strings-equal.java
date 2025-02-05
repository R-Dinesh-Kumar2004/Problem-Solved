class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int freq[] = new int[26];
        int count = 0;
        for(int i=0;i<n;i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            freq[c1-'a']++;
            freq[c2-'a']--;
            if(c1 != c2) count++;
            if(count>2) return false;
        }
        for(int it:freq){
            if(it != 0) return false;
        }
        return true;
    }
}