class Solution {
    public boolean hasSameDigits(String s) {

        while(s.length()>2){
            StringBuffer sb = new StringBuffer();
            for(int i=1;i<s.length();i++){
                int val = (s.charAt(i)-'0'+s.charAt(i-1)-'0')%10;
                sb.append(val);
            }
            s = sb.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}