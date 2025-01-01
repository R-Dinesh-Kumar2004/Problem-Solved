class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int one=0;
        for(char c:s.toCharArray()){
           if(c=='1')one++;
        }
        int zero=0;
        int max=0;
        s=s.substring(0,n-1);
        for(char c:s.toCharArray()){
            if(c=='0') ++zero;
            else --one;
            max=Math.max(max,zero+one);
        }
        return max;
    }
}