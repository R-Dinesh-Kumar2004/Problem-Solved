class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        char st[] = new char[n];
        int top = -1;

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) top--;
            else st[++top] = c;
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<=top;i++){
            sb.append(st[i]);
        }

        return sb.toString();
    }
}