class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm = new HashMap<>();
        HashSet<Character> isUsed = new HashSet<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);

            if(hm.containsKey(sc)){
                if(hm.get(sc)!=tc)return false;
            }
            else{
                if(!isUsed.add(tc)) return false;
                hm.put(sc,tc);
            }
        }
        return true;
    }
}