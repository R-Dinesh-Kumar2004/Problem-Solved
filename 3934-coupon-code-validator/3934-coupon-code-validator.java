class Solution {
    class Pair{
        String code,line;
        Pair(String code,String line){
            this.code = code;
            this.line = line;
        }
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.line.equals(b.line)){
                return a.code.compareTo(b.code);
            }
            return a.line.compareTo(b.line);
        });

        HashSet<String> hs = new HashSet<>(Arrays.asList("electronics", "grocery", "pharmacy", "restaurant"));

        int n = code.length;
        for(int i=0;i<n;i++){
            if(isActive[i]){
                if(hs.contains(businessLine[i]) && isValidCode(code[i])){
                    pq.add(new Pair(code[i],businessLine[i]));
                }
            }
        }

        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            String s = pq.poll().code;
            list.add(s);
        }

        return list;
    }
    public boolean isValidCode(String s) {
        return s != null && !s.isEmpty() && s.matches("[a-zA-Z0-9_]+");
    }
}