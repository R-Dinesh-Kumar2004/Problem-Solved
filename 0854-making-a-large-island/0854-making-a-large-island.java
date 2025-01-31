class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int dummy[][] = new int[n][n];

        for(int i=0;i<n;i++){
            dummy[i] = grid[i].clone();
        }
        int groupId = 2;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dummy[i][j] == 1){
                    int size = dfs(i,j,n,groupId,dummy);
                    hm.put(groupId,size);
                    // System.out.println(groupId+" "+size);
                    groupId++;
                }
            }
        }

        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};

        int max_isLand = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    Set<Integer> s = new HashSet<>();
                    int count = 1;
                    for(int k=0;k<4;k++){
                        int x = i+dx[k];
                        int y = j+dy[k];
                        
                        if(isValid(x,y,n,grid)){
                            int id = dummy[x][y];
                            if(s.add(id)){
                                count+=hm.get(id);
                            }
                        }
                    }
                    max_isLand = Math.max(max_isLand,count);
                }
            }
        }
       
        return max_isLand == 0 ? n*n : max_isLand;
    }
    // public int bfs(int i,int j,int n,int grid[][]){
    //     boolean vis[][] = new boolean[n][n];
    //     vis[i][j] = true;

    //     int dx[] = {-1,1,0,0};
    //     int dy[] = {0,0,-1,1};

    //     Queue<int[]> q = new LinkedList<>();
    //     q.add(new int[]{i,j});
        
    //     int isLand = 1;

    //     while(!q.isEmpty()){
    //         int top[] = q.poll();
    //         for(int k=0;k<4;k++){
    //             int x = top[0]+dx[k];
    //             int y = top[1]+dy[k];

    //             if(isValid(x,y,n,grid) && !vis[x][y]){
    //                 isLand++;
    //                 q.add(new int[]{x,y});
    //                 vis[x][y] = true;
    //             }
    //         }
    //     }
    //     return isLand;
    // }

    public boolean isValid(int i,int j,int n,int grid[][]){
        return (i>=0 && j>=0 && i<n && j<n && grid[i][j] == 1);
    }

    public int dfs(int i,int j,int n,int g,int dummy[][]){
        if(!isValid(i,j,n,dummy)) return 0;
        int size = 1;
        dummy[i][j] = g;
        size+=dfs(i+1,j,n,g,dummy);
        size+=dfs(i-1,j,n,g,dummy);
        size+=dfs(i,j+1,n,g,dummy);
        size+=dfs(i,j-1,n,g,dummy);
        return size;
    }
}