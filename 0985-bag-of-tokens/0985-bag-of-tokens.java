class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int high = tokens.length-1;
        int low = 0,score = 0;
        int max = 0;

        while(low<=high){
            if(power>=tokens[low]){
                score++;
                power -= tokens[low];
                low++;
                max = Math.max(max,score);
            }
            else if(score>0){
                score--;
                power += tokens[high];
                high--;
            }
            else break;
        }
        return max;
    }
}