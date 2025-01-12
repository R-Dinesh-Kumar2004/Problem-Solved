class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if((n&1)==1) return false;
        int w=0,o=0,c=0;
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0') w++;
            else if(s.charAt(i)=='(') o++;
            else c++;

            if(w<(c-o)) return false;
        }
        w=o=c=0;
        System.out.print("hi");
        for(int i=n-1;i>=0;i--){
            if(locked.charAt(i)=='0') w++;
            else if(s.charAt(i)=='(') o++;
            else c++;

            if(w<(o-c)) return false;
        }
        return true;
    }
}