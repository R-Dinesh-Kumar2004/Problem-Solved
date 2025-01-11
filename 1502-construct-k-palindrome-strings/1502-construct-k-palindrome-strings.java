class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        if(n<k) return false;
        int freq[] = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int count=0;
        for(int i:freq){
            if(i%2!=0) count++;
        }
        return count<=k;
    }
}