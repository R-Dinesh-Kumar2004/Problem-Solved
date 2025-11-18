class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int idx = 0;

        while(idx+1 < n){
            if(bits[idx] == 0) idx++;
            else if(bits[idx] == 1 && idx+2 < n) idx += 2;
            else return false;
        }
        return true;
    }
}