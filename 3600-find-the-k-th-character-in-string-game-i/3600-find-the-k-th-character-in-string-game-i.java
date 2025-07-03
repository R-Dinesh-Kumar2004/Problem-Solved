class Solution {
    public char kthCharacter(int k) {
        StringBuffer sb = new StringBuffer();
        sb.append('a');

        while(sb.length()<k){
            int n = sb.length();
            for(int i=0;i<n;i++){
                char c = (char)((sb.charAt(i)+1)%123);
                sb.append(c);
            }
        }
        return sb.charAt(k-1);
    }
}