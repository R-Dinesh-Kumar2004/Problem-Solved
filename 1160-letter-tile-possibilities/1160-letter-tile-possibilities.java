class Solution {
    public int numTilePossibilities(String tiles) {
        int freq[] = new int[26];
        for(char c : tiles.toCharArray()){
            freq[c-'A']++;
        }

        return rec(freq);
    }
    public int rec(int freq[]){
        int ways = 0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                freq[i]--;
                ways += (1 + rec(freq));
                freq[i]++;
            }
        }
        return ways;
    }
}