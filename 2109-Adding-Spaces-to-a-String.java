class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int n=spaces.length;
        int prev=0;
        for(int i=0;i<n;i++){
            int val=spaces[i];
            String sub=s.substring(prev,val);
            sb.append(sub+" ");
            prev=val;
        }
        sb.append(s.substring(prev,s.length()));
        return sb.toString();
    }
}