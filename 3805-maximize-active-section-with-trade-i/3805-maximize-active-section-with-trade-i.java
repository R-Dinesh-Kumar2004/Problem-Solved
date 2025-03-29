class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char ch[] = s.toCharArray();
        int n = ch.length; 

        List<Integer> li = new ArrayList<>();
        int initial = ch[0] == '1' ? 1 : 0, count = 1;

        for(int i=1;i<n;i++){
            if(ch[i] == '1') initial++; 
            if(ch[i] == ch[i-1]) count++;
            else{
                li.add(count);
                count = 1;
            }
        }
        li.add(count);

        int max = 0,len = li.size();

        if(ch[0] == '1') {
            for(int i=1;i<len;i+=2){
                if(i+2<len){
                    max = Math.max(max,li.get(i)+li.get(i+2));
                }
            }
        }
        else{
            for(int i=0;i<len;i+=2){
                if(i+2<len){
                    max = Math.max(max,li.get(i)+li.get(i+2));
                }
            }
        }
        System.out.println(max);
        return initial+max;
    }
}