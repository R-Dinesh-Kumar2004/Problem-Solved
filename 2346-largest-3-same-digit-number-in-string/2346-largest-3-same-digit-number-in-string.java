class Solution {
    public String largestGoodInteger(String num) {
        char ch[] = num.toCharArray();
        char ans = ' ';
        int n = num.length();

        for(int i=0;i<n-2;i++){
            if(ch[i] == ch[i+1] && ch[i] == ch[i+2]){
                if(ans < ch[i]) ans = ch[i];
            }
        }

        if(ans == ' ') return "";
        return (""+ans+ans+ans);
    }
}