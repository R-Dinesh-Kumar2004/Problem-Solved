class Solution {
    public String removeOccurrences(String s, String part) {
        char st[] = new char[1000];
        int n = part.length();
        int top = -1;
        for(char c : s.toCharArray()){
            int flag = 0;
            if(c == part.charAt(n-1)){
                int t = top, i = n-2;
                flag = 1;
                while(top>=0 && i>=0 && st[top] == part.charAt(i)){
                    i--;top--;
                }
                if(i >= 0){
                   top = t;
                   flag = 0;
                } 
            }
            if(flag == 0) st[++top] = c;
        }
        // System.out.print(top+" ");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<=top;i++){
            sb.append(st[i]);
        }
        return sb.toString();
    }
}