class Solution {
    public int minMoves(int target, int maxDoubles) {
        int steps = 0;

        while(target>1){
            if(target%2 == 0 && maxDoubles > 0){
                target /= 2;
                maxDoubles--;
            }
            else if(maxDoubles == 0){
                return (steps+target-1);
            }
            else{
                target--;
            }
            steps++;
        }

        return steps;
    }
}