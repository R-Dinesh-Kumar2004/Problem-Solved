class Solution {
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String arr[] = text.split(" ");
        int n = arr.length;

        Arrays.sort(arr,(a,b)->a.length()-b.length());

        StringBuffer ans = new StringBuffer();
        for(int i=0;i<n;i++){
            ans.append(arr[i]).append(" ");
        }
        ans.setCharAt(0,(char)(ans.charAt(0)^32));
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}