class Solution {
    public int longestSubsequence(String s, int k) {
        s = new StringBuffer(s).reverse().toString();
        int n = s.length();
        int i = 0;
        int len = Math.min(32,n);
        long sum = 0,pos = 1;

        while(i<len){
            if(sum+pos>k) break;
            if(s.charAt(i) == '1') sum += pos;
            pos *= 2;
            i++;
        }

        int one = 0;
        for(int j=i;j<n;j++){
            if(s.charAt(j) == '1') one++;
        }
        return (n-one);
    }
}