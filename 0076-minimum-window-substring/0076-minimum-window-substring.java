class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character,Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> smap = new HashMap<>();
        String ans = "";
        int left = 0,n = s.length();
        int minLen = n+1;
        for(int right=0;right<n;right++){
            char c = s.charAt(right);
            smap.put(c,smap.getOrDefault(c,0)+1);

            while(left<=right && isValid(smap,tmap)){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    ans = s.substring(left,right+1);
                }

                char d = s.charAt(left);
                smap.put(d,smap.get(d)-1);
                if(smap.get(d) == 0) smap.remove(d);

                left++;
            }
        }
        return ans;
    }
    public boolean isValid(Map<Character,Integer> s,Map<Character,Integer> t){
        for(Map.Entry<Character,Integer> en:t.entrySet()){
            char c = en.getKey();
            if(s.getOrDefault(c,0)<en.getValue()){
                return false;
            }
        }
        return true;
    }
}