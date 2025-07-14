class Solution {
    class Pair{
        int val,label;

        Pair(int val,int label){
            this.val = val;
            this.label = label;
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit){
        int n = values.length;
        Pair arr[] = new Pair[n];

        for(int i=0;i<n;i++){
            arr[i] = new Pair(values[i],labels[i]);
        }
        Arrays.sort(arr,(a,b)->b.val-a.val);

        int usedLabel[] = new int[20001];
        int ans = 0;

        for(int i=0;i<n;i++){
            Pair p = arr[i];
            if(usedLabel[p.label] < useLimit && numWanted>0){
                numWanted -= 1;
                usedLabel[p.label] += 1;
                ans += p.val;
            }
        }

        return ans;
    }
}
    // public int helper(int idx,int values[],int labels[],int k,int useLimit,Integer dp[][]){
    //     if(idx == values.length || k == 0) return 0;
    //     if(dp[idx][k] != null) return dp[idx][k];

    //     int curLabel = labels[idx];
    //     int pick = 0;
    //     if(usedLabel.get(curLabel)<useLimit){
    //         usedLabel.put(curLabel,usedLabel.get(curLabel)+1);
    //         pick = values[idx] + helper(idx+1,values,labels,k-1,useLimit,dp);
    //         usedLabel.put(curLabel,usedLabel.get(curLabel)-1);
    //     }

    //     int not = helper(idx+1,values,labels,k,useLimit,dp);

    //     return dp[idx][k] = Math.max(pick,not);
    // }