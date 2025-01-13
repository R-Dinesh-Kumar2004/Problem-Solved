class Solution {
    public int minimumLength(String s) {
        int freq[] = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        int count=0;
        for(int i:freq){
           if(i==0) continue;
           else if(i%2==0) count+=2;
           else count+=1;
        }
        return count;
    }
}