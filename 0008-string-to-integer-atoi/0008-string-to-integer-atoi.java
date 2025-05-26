class Solution {
    public int myAtoi(String s) {
        char ch[] = s.toCharArray();
        int n = ch.length;
        int idx = 0;

        while(idx<n && ch[idx] == ' '){
            idx++;
        }
        int sign = 1;
        if(idx<n && ch[idx] == '-'){
            sign = -1;
            idx++;
        }
        else if(idx<n && ch[idx] == '+') idx++;

        StringBuffer sb = new StringBuffer();
        while(idx<n && sb.length()<=10){
            int val = ch[idx]-'0';
            if(val>=0 && val<10){
                if(sb.length() == 0 && val == 0){
                    idx++; continue;
                }
                sb.append(ch[idx]);
            }
            else break;
            idx++;
        }

        long ans = 0;
        if(sb.length()>0) ans = Long.parseLong(sb.toString());
        ans *= sign;

        if(ans > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        else if(ans < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)ans;
    }
}