class Solution {
    public int possibleStringCount(String word) {
        int ans = 0,count = 0;
        int n = word.length();
        char pre = word.charAt(0);

        for(int i=1;i<n;i++){
            char cur = word.charAt(i);
            if(cur == pre){
                count++;
            }
            else{
                ans += count;
                count = 0;
                pre = cur;
            }
        }
        ans += count;

        return ans+1;
    }
}