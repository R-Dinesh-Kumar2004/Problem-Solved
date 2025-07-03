class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer,List<Integer>> tm = new TreeMap<>();
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tm.putIfAbsent(i+j,new ArrayList<>());
                if((i+j)%2 == 0){
                    tm.get(i+j).add(0,mat[i][j]);
                } 
                else tm.get(i+j).add(mat[i][j]);
            }
        }

        int ans[] = new int[n*m];
        int idx = 0;

        for(List<Integer> l : tm.values()){
            for(int i : l) ans[idx++] = i;
        }

        return ans;
    }
}