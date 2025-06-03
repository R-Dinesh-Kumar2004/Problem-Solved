class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes){
        int n = candies.length;
        Queue<Integer> q = new LinkedList<>();
        boolean hasRoom[] = new boolean[n];
        boolean hasKey[] = new boolean[n];
        boolean vis[] = new boolean[n];

        for(int i : initialBoxes){
            if(status[i] == 0){
                hasRoom[i] = true;
                continue;
            }
            vis[i] = hasKey[i] = hasRoom[i] = true;
            q.add(i);
        }
        int ans = 0;
        while(!q.isEmpty()){
            int r = q.poll();
            ans += candies[r];

            for(int con : containedBoxes[r]){
                if(!vis[con] && status[con] == 1){
                    vis[con] = hasKey[con] = true;
                    q.add(con);
                }
                else if(!vis[con] && hasKey[con]){
                    vis[con] = true;
                    q.add(con);
                } 
                hasRoom[con] = true;
            }
            for(int key : keys[r]){
                if(!vis[key] && hasRoom[key]){
                    q.add(key);
                    vis[key] = true;
                }
                hasKey[key] = true;
            }
        }
        return ans;
    }
}