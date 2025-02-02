class Solution {
    public int makeConnected(int n, int[][] connections) {
        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        } 
        int extra = 0;
        for(int con[]:connections){
            int s = con[0];
            int d = con[1];

            int p1 = findParent(s,parent);
            int p2 = findParent(d,parent);

            if(p1 == p2) extra++;
            else{
                union(p1,p2,parent,rank);
            }
        }
        int com = 0;
        for(int i=0;i<n;i++){
            if(parent[i] == i) com++;
        }

        if(com-1<=extra) return com-1;
        return -1;
    }
    public int findParent(int nd,int parent[]){
        if(parent[nd] == nd){
            return nd;
        }
        return parent[nd] = findParent(parent[nd],parent);
    }
    public void union(int p1,int p2,int parent[],int rank[]){
        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
        }
        else if(rank[p1]<rank[p2]){
            parent[p1] = p2;
        }
        else{
            parent[p2] = p1;
            rank[p1]++;
        }
    }
}