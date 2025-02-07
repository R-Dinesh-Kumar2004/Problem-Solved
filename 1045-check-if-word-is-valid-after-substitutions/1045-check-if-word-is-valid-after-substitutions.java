class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == 'c' && !st.isEmpty()){
                char b = st.pop();
                if(b != 'b') return false;
                if(st.isEmpty()) return false;
                char a = st.pop();
                if(a != 'a') return false; 
            }
            else st.push(c);
        }
        return st.isEmpty();
    }
}