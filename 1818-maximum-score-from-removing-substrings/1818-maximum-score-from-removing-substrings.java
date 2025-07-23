class Solution {
    String s;
    public int maximumGain(String s, int x, int y) {
        this.s = s;
        int ans = 0;

        if(x > y){
            ans = removeAB(x);
            ans += removeBA(y);
        }
        else{
            ans = removeBA(y);
            ans += removeAB(x);
        }

        return ans;
    }
    public int removeAB(int x){
        int n = s.length();
        int score = 0,top = -1;
        char st[] = new char[n];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            
            if(top>=0 && c == 'b' && st[top] == 'a'){
                top--;
                score += x;
            }
            else st[++top] = c;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<=top;i++) sb.append(st[i]);

        s = sb.toString();

        return score;
    }
    public int removeBA(int x){
        int n = s.length();
        int score = 0,top = -1;
        char st[] = new char[n];

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            
            if(top>=0 && c == 'a' && st[top] == 'b'){
                top--;
                score += x;
            }
            else st[++top] = c;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<=top;i++) sb.append(st[i]);

        s = sb.toString();
        
        return score;
    }
}