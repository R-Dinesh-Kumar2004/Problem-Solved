class Solution {
    public int maximum69Number (int num) {
        char ch[] = (""+num).toCharArray();

        for(int i=0;i<ch.length;i++){
            if(ch[i] == '6'){
                ch[i] = '9';
                break;
            }
        }

        int ans = 0;
        for(int i=0;i<ch.length;i++){
            ans = ans * 10;
            ans += (ch[i]-'0');
        }

        return ans;
    }
}