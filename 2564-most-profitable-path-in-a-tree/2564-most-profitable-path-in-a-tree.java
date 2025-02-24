class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = amount.length;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int it[] : edges){
            int s = it[0], d= it[1];
            adj.get(s).add(d);
            adj.get(d).add(s);
        }

        List<Integer> bPath = new ArrayList<>();
        bPath.add(bob);
        
        findBobPath(bob,-1,adj,bPath);

        int idx = 1,max = Integer.MIN_VALUE;

        Queue<int[]> a = new LinkedList<>();
        a.add(new int[]{0,-1,0});
        Queue<Integer> b = new LinkedList<>();
        b.add(bob);

        while(!a.isEmpty()){  
            int nodeB = -1;
            if(!b.isEmpty()){
                nodeB = b.poll();
                if(idx<bPath.size()){
                    b.add(bPath.get(idx)); idx++;
                }
            } 
            int sz = a.size();
            while(sz-->0){
                int top[] = a.poll();
                int nodeA = top[0];
                int p = top[1];
                int wt = top[2];

                if(nodeA == nodeB){
                    wt += (amount[nodeA]/2);
                } 
                else{
                    wt += amount[nodeA];
                }   
                boolean isLeaf = true;
                for(int it : adj.get(nodeA)){
                    if(it != p){
                        isLeaf = false;
                        a.add(new int[]{it,nodeA,wt});
                    }
                }

                if(isLeaf){
                    max = Math.max(max,wt);
                }
            }
            if(nodeB != -1) amount[nodeB] = 0;
        }
        return max;
    }

    public boolean findBobPath(int nd,int p,List<List<Integer>> adj, List<Integer> path){
        if(nd == 0){
            return true;
        } 

        for(int it : adj.get(nd)){
            if(p != it){
                path.add(it);
                if(findBobPath(it,nd,adj,path)) return true;
                path.remove(path.size()-1);
            }
        }
        return false;
    }
}