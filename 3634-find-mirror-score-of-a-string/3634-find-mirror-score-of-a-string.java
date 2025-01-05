class Solution {
    public long calculateScore(String s) {
        int n= s.length();
        Stack<Integer> arr[] = new Stack[26];
        for(int i=0;i<26;i++) arr[i]=new Stack<>();
        long score=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            char mir=getMirror(c);
            
            if(!arr[mir-'a'].isEmpty()){
                score+=i;
                score-=arr[mir-'a'].pop();
            }
            else{
                arr[c-'a'].push(i);
            }
        }
        return score;
    }
    public static char getMirror(char c){
        return (char)('a'+'z'-c);
    }
}