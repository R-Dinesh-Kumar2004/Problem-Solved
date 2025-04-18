class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int i=1;i<n;i++){
            StringBuffer sb = new StringBuffer();
            int len = s.length(), count = 1;
            char prev = s.charAt(0);
            for(int j=1;j<len;j++){
                if(s.charAt(j) == prev) count++;
                else{
                    sb.append(count).append(prev);
                    count = 1;
                }
                prev = s.charAt(j);
            }
            sb.append(count).append(prev);
            s = sb.toString();
        }
        return s;
    }
}