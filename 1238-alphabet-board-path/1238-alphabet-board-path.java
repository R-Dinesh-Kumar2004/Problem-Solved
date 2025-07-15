class Solution {
    class Pair{
        int x,y;
        String s;

        Pair(int x,int y,String s){
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    int posX,posY;
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    char ch[] = {'U','D','L','R'};

    char board[][] = {{'a','b','c','d','e'},{'f','g','h','i','j'},{'k','l','m','n','o'},{'p','q','r','s','t'},{'u','v','w','x','y'},{'z'}};

    public String alphabetBoardPath(String target) {
        int n = target.length();
        posX = posY = 0;

        StringBuffer ans = new StringBuffer();
        for(int i=0;i<n;i++){
            char c = target.charAt(i);
            String cur = bfs(c);
            ans.append(cur).append('!');
        }

        return ans.toString();
    }
    public String bfs(char c){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(posX,posY,""));

        boolean vis[][] = new boolean[6][5];
        vis[posX][posY] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x,y = p.y;
            String s = p.s;

            if(board[x][y] == c){
                posX = x;
                posY = y;
                return s;
            }

            for(int k=0;k<4;k++){
                int newX = x+dx[k];
                int newY = y+dy[k];
                String curS = s+ch[k];

                if(newX>=0 && newY>=0 && newX<6 && newY<board[newX].length && !vis[newX][newY]){
                    vis[newX][newY] = true;
                    q.add(new Pair(newX,newY,curS));
                }
            }
        }
        return "";
    }
}