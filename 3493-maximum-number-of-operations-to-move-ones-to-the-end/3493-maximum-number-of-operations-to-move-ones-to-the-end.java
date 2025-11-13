class Solution {
    public int maxOperations(String s) {
        s = alter(s);
        int one = 0,ans = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') one++;
            else ans += one;
        }

        return ans;
    }
    public String alter(String s){
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        sb.append(s.charAt(0));

        for(int i=1;i<n;i++){
            char c = s.charAt(i);
            if(c == '0' && sb.charAt(sb.length()-1) == '0') continue;
            else sb.append(c);
        }
        return sb.toString();
    }
}