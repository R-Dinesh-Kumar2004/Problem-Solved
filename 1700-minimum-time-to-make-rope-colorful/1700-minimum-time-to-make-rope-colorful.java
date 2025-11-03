class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int st[][] = new int[n][2];
        int top = -1;
        int ans = 0;

        for(int i=0;i<colors.length();i++){
            int color = colors.charAt(i)-'a';

            if(top >= 0 && st[top][0] == color){
                if(neededTime[i] > neededTime[st[top][1]]){
                    ans += neededTime[st[top][1]];
                    st[top][1] = i;
                }
                else{
                    ans += neededTime[i];
                }
            }
            else{
                st[++top][0] = color;
                st[top][1] = i;
            }
        }
        return ans;
    }
}