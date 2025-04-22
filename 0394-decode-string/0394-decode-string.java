class Solution {
    public String decodeString(String s) {
        int n = s.length();
        String st[] = new String[n];
        int top = -1;

        for(char c : s.toCharArray()){
            String t = ""+c;
            if(t.equals("]")){
                StringBuffer sb = new StringBuffer();
                while(!st[top].equals("[")){
                    sb.insert(0,st[top]); top--;
                }
                top--;
                StringBuffer num = new StringBuffer();
                while(top>=0 && st[top].matches("\\d")){
                    num.insert(0,st[top]); top--;
                }
                int len = Integer.parseInt(num.toString());
                String repeated = sb.toString().repeat(len);
                st[++top] = repeated;
            }
            else st[++top] = t;
        }
        StringBuffer ans = new StringBuffer();
        for(int i=0;i<=top;i++){
            ans.append(st[i]);
            // System.out.print(st[i]+" ");
        }

        return ans.toString();
    }
}