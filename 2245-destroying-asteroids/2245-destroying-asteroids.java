class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long tot = mass;
        for(int i : asteroids){
            if(tot<i) return false;
            tot += i;
        }
        return true;
    }
}