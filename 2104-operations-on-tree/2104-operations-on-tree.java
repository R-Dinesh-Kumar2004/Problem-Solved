class LockingTree {
    List<Integer>[] children;
    int[] parent,isLocked;
    int n;

    public LockingTree(int[] parent) {
        this.n = parent.length;
        this.parent = parent;
        isLocked = new int[n];
        Arrays.fill(isLocked,-1);
        
        children = new ArrayList[n];
        for(int i=0;i<n;i++) children[i] = new ArrayList<>();

        for(int i=1;i<n;i++){
            children[parent[i]].add(i);
        }

    }
    
    public boolean lock(int num, int user) {
        if(isLocked[num] == -1){
            isLocked[num] = user;
            return true;
        }
        return false;
    }
    
    public boolean unlock(int num, int user) {
        if(isLocked[num] == user){
            isLocked[num] = -1;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        boolean isAlreadyLocked = (isLocked[num] != -1);
        if(isAlreadyLocked) return false;

        boolean itHasLockedAncester = false;
        int t = num;
        while(parent[t] !=-1){
            if(isLocked[parent[t]] != -1){
                itHasLockedAncester = true;
                break;
            }
            t = parent[t];
        }
        if(itHasLockedAncester) return false;

        boolean itHasLockedChild[] = {false};
        checkItHasLockedChild(num,itHasLockedChild);

        if(itHasLockedChild[0]){
            isLocked[num] = user;
        }

        return itHasLockedChild[0];
    }
    public void checkItHasLockedChild(int p,boolean flag[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(p);

        while(!q.isEmpty()){
            int nd = q.poll();

            if(isLocked[nd] != -1){
                flag[0] = true;
                isLocked[nd] = -1;
            }

            for(int it : children[nd]){
                q.add(it);
            }
        }        
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */