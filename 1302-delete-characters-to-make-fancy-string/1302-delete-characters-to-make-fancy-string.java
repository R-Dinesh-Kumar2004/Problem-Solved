class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        if(n<3) return s;

        StringBuffer ans = new StringBuffer();
        char first = s.charAt(0), second = s.charAt(1);
        ans.append(first).append(second);

        for(int i=2;i<n;i++){
           char c = s.charAt(i);
           if(first == second && second == c) continue;
           ans.append(c);

           first = second;
           second = c;
        }

        return ans.toString();
    }
}