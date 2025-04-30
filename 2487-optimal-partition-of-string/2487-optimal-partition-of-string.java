class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int count = 1;
        int freq[] = new int[26];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(freq[c-'a'] != 0){
                count++;
                Arrays.fill(freq,0);
            }
            freq[c-'a']++;
        }
        return count;
    }
}