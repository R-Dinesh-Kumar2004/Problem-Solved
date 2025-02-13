class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        char st[] = new char[n];
        int top = -1;
        for(char c : num.toCharArray()){
            while(top>=0 && st[top]>c && k>0){
                top--; k--;
            }
            st[++top] = c;
        }
        while(k>0){
           top--;k--;
        } 

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<=top;i++){
            if(sb.length() == 0 && st[i] == '0') continue;
            sb.append(st[i]);
        }
        if(sb.length() == 0) return "0";
        return sb.toString();
    }
}