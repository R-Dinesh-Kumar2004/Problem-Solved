class Solution {
    public int numRabbits(int[] answers) {
        int freq[] = new int[1000];
        int ans = 0;
        for(int i : answers){
            freq[i]++;
            if(freq[i] == i+1){
                freq[i] = 0;
                ans += (i+1);
            }
        }
        for(int i=0;i<1000;i++){
            if(freq[i] != 0){
                ans += (i+1);
            }
        }
        return ans;
    }
}