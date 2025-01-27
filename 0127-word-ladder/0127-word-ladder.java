class Solution {
    class Pair{
        String str;
        int dis;
        Pair(String str,int dis){
            this.str = str;
            this.dis = dis;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s = new HashSet<>(wordList);
        if(!s.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            String cur = q.peek().str;
            int dis = q.peek().dis;
            q.poll();

            if(cur.equals(endWord)) return dis;

            char curArr[] = cur.toCharArray();
            for(int i=0;i<curArr.length;i++){
                char ori = curArr[i];
                for(char j='a';j<='z';j++){
                    if(j==ori) continue;
                    curArr[i] = j;
                    String newString = String.valueOf(curArr);
                    if(s.contains(newString)){
                        q.add(new Pair(newString,dis+1));
                        s.remove(newString);
                    }
                }
                curArr[i] = ori;
            }
        }
        return 0;
    }
}