class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int l = 0, r = 0,u = 0;
        for(char c:start.toCharArray()){
            if(c=='L') l++;
            else if(c=='R') r++;
            else u++;
        }
        for(char c:target.toCharArray()){
            if(c=='L') l--;
            else if(c=='R') r--;
            else u--;
        }
        if(l!=0 || r!=0 || u!=0) return false;
        int i=0,j=0;
        while(i<n && j<n){
            char s = start.charAt(i);
            char t = target.charAt(j);
            if(s =='L' && t=='L'){
                if(i<j) return false;
                i++;
                j++;
            }
            else if(s == 'R' && t == 'R'){
                if(i>j) return false;
                i++;j++;
            }
            else if(s == '_') i++;
            else if(t == '_') j++;
            else if(s !=t ) return false;
            else{
                i++;j++;
            }
        }
        return true;
    }
}