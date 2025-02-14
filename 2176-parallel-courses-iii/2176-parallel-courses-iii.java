class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        int indeg[] = new int[n+1];
        for(int it[]:relations){
            int s = it[0];
            int d = it[1];
            adj.get(s).add(d);
            indeg[d]++;
        }
        
        int months[] = new int[n+1];
        Arrays.fill(months,Integer.MIN_VALUE);

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indeg[i] == 0){
               q.add(i);
               months[i] = time[i-1];
            } 
        }
        // for(int i=1;i<=n;i++) System.out.print(months[i]+" ");
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.add(it);
                months[it] = Math.max(months[it],months[node]+time[it-1]);
            }
        }

        int total_time = 0;
        for(int it : months)
            total_time = Math.max(total_time,it);

        return total_time;
    }
}