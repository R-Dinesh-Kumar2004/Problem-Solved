class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int xor=derived[0];

        for(int i=1;i<n;i++){
            xor^=derived[i];
        }

        return xor==0;
    }
}