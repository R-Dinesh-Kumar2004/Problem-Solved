class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int len = (int)Math.ceil((double)n/k);
        String ans[] = new String[len];
        int idx = 0;

        for(int i=0;i<len;i++){
            StringBuffer sb = new StringBuffer();
            while(sb.length() != k && idx<n){
                sb.append(s.charAt(idx));
                idx++;
            }
            while(sb.length() != k) sb.append(fill);

            ans[i] = sb.toString();
        }
        return ans;
    }
}