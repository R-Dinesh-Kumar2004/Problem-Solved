class Solution {
    class Pair{
        char ch;
        int freq;

        Pair(char ch,int val){
            this.ch = ch;
            this.freq = val;
        }
    }
    public String minimizeStringValue(String s) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int freq[] = new int[26];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.freq == b.freq) return a.ch-b.ch;
            return a.freq-b.freq;
        });
        
        PriorityQueue<Character> requiredChar = new PriorityQueue<>();
        int count = 0;

        for(int i=0;i<n;i++){
            if(arr[i] == '?') count++;
            else freq[arr[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            pq.add(new Pair((char)(i+'a'),freq[i]));
        }

        for(int i=0;i<count;i++){
            Pair p = pq.poll();
            requiredChar.add(p.ch);
            p.freq += 1;

            pq.add(p);
        }
        
        for(int i=0;i<n;i++){
            if(arr[i] == '?') arr[i] = requiredChar.poll();
        }

        return String.valueOf(arr);
    }
}