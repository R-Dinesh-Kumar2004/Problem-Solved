class Solution {
    class Pair{
        int nd;
        double p;
        Pair(int nd,double d){
            this.nd = nd;
            this.p = d;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int s = edges[i][0], d = edges[i][1];
            adj.get(s).add(new Pair(d,succProb[i]));
            adj.get(d).add(new Pair(s,succProb[i]));
        }

        boolean vis[] = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Double.compare(b.p,a.p));
        pq.add(new Pair(start_node,1.0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int nd = p.nd;
            double wt = p.p;

            if(nd == end_node) return wt;
            if(vis[nd]) continue;
            vis[nd] = true;

            for(Pair it : adj.get(nd)){
                int s = it.nd;
                double prob = it.p;
                if(!vis[s]) pq.add(new Pair(s,wt*prob));
            }
        }
        return 0.0;
    }
}