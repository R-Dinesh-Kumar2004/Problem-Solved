class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int low = 0,high = Math.min(tasks.length,workers.length);
        int count = 0;

        while(low<=high){
            int mid = (low+high)/2;
            if(canAssign(mid,tasks,workers,pills,strength)){
                count = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return count;
    }
    public boolean canAssign(int mid,int tasks[],int workers[],int pills,int strength){
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int n = workers.length;
        for(int i=n-mid;i<n;i++){
            tm.putIfAbsent(workers[i],0);
            tm.put(workers[i],tm.get(workers[i])+1);
        }

        for(int i=mid-1;i>=0;i--){
            int task = tasks[i];
            Integer worker = tm.lastKey();

            if(task>worker){
                if(pills<=0) return false;
                
                Map.Entry<Integer,Integer> weakWorker = tm.ceilingEntry(task-strength);
                if(weakWorker == null) return false;
                Integer weakKey = weakWorker.getKey();

                pills--;
                tm.put(weakKey,tm.get(weakKey)-1);
                if(tm.get(weakKey) == 0) tm.remove(weakKey);
            }
            else{
                tm.put(worker,tm.get(worker)-1);
                if(tm.get(worker) == 0) tm.remove(worker);
            }
        }
        return true;
    }
}
        // int i = n-1,j = m-1;
        // while(i>=0 && j>=0){
        //     if(tasks[i] <= workers[j]){
        //         count++;
        //         finishedTasks[i] = usedWorkers[j] = true;
        //         i--; j--;
        //     }
        //     else i--;
        // }
        // i = n-1;
        // j = m-1;
        // while(i>=0 && j>=0){
        //     while(i>=0 && finishedTasks[i]) i--;
        //     while(j>=0 && usedWorkers[j]) j--;

        //     if(i>=0 && j>=0 && pills>0 && tasks[i] <= workers[j]+strength){
        //         count++;
        //         pills--;
        //         i--; j--;
        //     }
        //     else i--;
        // }
        // return count;