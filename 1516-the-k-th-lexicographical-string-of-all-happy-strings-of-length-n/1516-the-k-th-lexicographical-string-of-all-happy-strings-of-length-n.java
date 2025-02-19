class Solution {
    Set<String> hs = new TreeSet<>();
    public String getHappyString(int n, int k) {
        
        char arr[] = new char[3];
        arr[0] = 'a'; arr[1] = 'b'; arr[2] = 'c';

        permute(n,arr,new StringBuffer());

        int cnt = 1;
        for(String s : hs){
            if(cnt == k) return s;
            cnt++;
        }
        return "";
    }
    public void permute(int n,char arr[],StringBuffer sb){
        if(sb.length() == n){
            hs.add(sb.toString()); 
            return;
        }
        for(int i=0;i<3;i++){
            int sz = sb.length();
            if(sz == 0 || sb.charAt(sz-1) != arr[i]){
                sb.append(arr[i]);
                permute(n,arr,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}