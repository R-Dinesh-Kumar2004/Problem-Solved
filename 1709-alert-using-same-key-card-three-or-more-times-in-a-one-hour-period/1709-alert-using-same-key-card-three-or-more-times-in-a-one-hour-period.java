class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String,List<Integer>> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            String name = keyName[i];
            int minutes = StringToMinutes(keyTime[i]);
            hm.putIfAbsent(name,new ArrayList<>());
            hm.get(name).add(minutes);
        }

        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,List<Integer>> en : hm.entrySet()){
            List<Integer> temp = en.getValue();
            Collections.sort(temp);
            int len = temp.size();
            for(int i=0;i<len-2;i++){
                int diff = temp.get(i+2)-temp.get(i);
                if(diff<=60){
                    ans.add(en.getKey());
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
    public int StringToMinutes(String s){
        String str[] = s.split(":");
        int minutes = Integer.parseInt(str[0])*60;
        minutes += Integer.parseInt(str[1]);
        return minutes;
    }
}