class Solution {
    public int minimumLength(String s) {
        int freq[] = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int count=0;
        for(int i:freq){
           while(i>=3){
            i-=2;
           }
           count+=i;
        }
        return count;
    }
}