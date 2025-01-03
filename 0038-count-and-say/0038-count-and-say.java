class Solution {
    public String countAndSay(int n) {
        return rec("1",n-1);
    }
    public static String rec(String t,int n){
        if(n==0) return t;
        t=com(t);
        return rec(t,n-1);
    }

    public static String com(String s){
        int count=1;
        StringBuffer sb = new StringBuffer("");
        int n=s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)) count++;
            else{
                sb.append(count).append(s.charAt(i-1));
                count=1;
            }
        }
        sb.append(count).append(s.charAt(n-1));
        return sb.toString();
    }
}