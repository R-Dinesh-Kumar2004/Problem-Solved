class Solution {
    public int minOperations(int n, int m) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{n,n});
        
        boolean isPrime[] = findPrime(10000);
        if(isPrime[n] || isPrime[m]) return -1;

        boolean vis[] = new boolean[10000];
        vis[n] = true;

        while(!pq.isEmpty()){
            int top[] = pq.poll();
            int val = top[0], cost = top[1];

            if(val == m) return cost;

            char ch[] = (""+val).toCharArray();
            for(int i=0;i<ch.length;i++){
                if(ch[i] == '9') continue;
                else{
                    char pre = ch[i];
                    ch[i] = (char)(pre+1);

                    int newVal = Integer.parseInt(toString(ch));
                    if(!isPrime[newVal] && !vis[newVal] && newVal < 10000){
                        vis[newVal] = true;
                        pq.add(new int[]{newVal,cost+newVal});
                    }

                    ch[i] = pre;
                }
            }

            for(int i=0;i<ch.length;i++){
                if(ch[i] == '0' || (i == 0 && ch[i] == '1')) continue;
                else{
                    char pre = ch[i];
                    ch[i] = (char)(pre-1);

                    int newVal = Integer.parseInt(toString(ch));
                    if(!isPrime[newVal] && !vis[newVal] && newVal < 10000){
                        vis[newVal] = true;
                        pq.add(new int[]{newVal,cost+newVal});
                    }

                    ch[i] = pre;
                }
            }
        }
        return -1;
    }
    public boolean[] findPrime(int n){
        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;

        for(int i=2;i*i<n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    public String toString(char ch[]){
        StringBuffer sb = new StringBuffer();
        for(char c : ch){
            sb.append(c);
        }

        return sb.toString();
    }
}