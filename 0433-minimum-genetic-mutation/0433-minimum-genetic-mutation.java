class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> hs = new HashSet<>();
        for(String s : bank) hs.add(s);

        char change[] = {'A','C','G','T'};

        char ch[] = startGene.toCharArray();
        int steps = 0;

        Queue<String> q = new LinkedList<>();
        q.add(startGene);

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                String s = q.poll();

                if(s.equals(endGene)) return steps;
                char cur[] = s.toCharArray();

                for(int j=0;j<8;j++){
                    char prev = cur[j];
                    for(int k=0;k<4;k++){
                        if(cur[j] == change[k]) continue;

                        cur[j] = change[k];
                        String newS = String.valueOf(cur);
                        if(hs.contains(newS)){
                            q.add(newS);
                            hs.remove(newS);
                        }
                    }
                    cur[j] = prev;
                }
            }
            steps++;
        }
        return -1;
    }
}