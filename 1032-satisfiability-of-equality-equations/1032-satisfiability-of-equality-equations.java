class Solution {
    public boolean equationsPossible(String[] equations) {
        int parent[] = new int[26];
        int rank[] = new int[26];
        for(int i=0;i<26;i++) parent[i] = i;

        for(String s : equations){
            char f = s.charAt(0);
            char l = s.charAt(3);
            if(s.charAt(1) == '='){
                int p1 = findParent(f-'a',parent);
                int p2 = findParent(l-'a',parent);

                if(p1 == p2) continue;
                unionByRank(p1,p2,parent,rank);
            }
        }

        for(String s : equations){
            char f = s.charAt(0);
            char l = s.charAt(3);
            if(s.charAt(1) == '!'){
                int p1 = findParent(f-'a',parent);
                int p2 = findParent(l-'a',parent);

                if(p1 == p2) return false;
            }
        }

        return true;
    }
    public int findParent(int nd,int parent[]){
        if(parent[nd] == nd) return nd;
        return parent[nd] = findParent(parent[nd],parent);
    }
    public void unionByRank(int p1,int p2,int parent[],int rank[]){
        if(rank[p1]>rank[p2]){
            parent[p2] = p1;
        }
        else if(rank[p2]>rank[p1]){
            parent[p1] = p2;
        }
        else{
            parent[p2] = p1;
            rank[p1]++;
        }
    }
}