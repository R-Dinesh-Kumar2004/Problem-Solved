class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> hm=new HashMap<>();
        Set<String> isUsed=new HashSet<>();
        String arr[]=s.split(" ");
        int n=pattern.length();
        if(n!=arr.length) return false;
        for(int i=0;i<n;i++){
            char c=pattern.charAt(i);
            String str=arr[i];

            if(hm.containsKey(c)){
                if(!hm.get(c).equals(str)) return false;
            }
            else{
                if(!isUsed.add(str)) return false;
                hm.put(c,str);
            }
        }
        return true;
    }
}