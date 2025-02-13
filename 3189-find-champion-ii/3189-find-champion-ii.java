class Solution {
    public int findChampion(int n, int[][] edges) {
        int indeg[] = new int[n];

        for(int it[] : edges){
            indeg[it[1]]++;
        }

        int count = 0,team = 0;
        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                count++;
                team = i;
            }

            if(count>1) return -1;
        }

        return team;
    }
}