class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int arr[] = people.clone();
        Arrays.sort(arr);
        TreeMap<Integer,Integer> tm = new TreeMap<>();

        for(int it[] : flowers){
            int st = it[0],ed = it[1]+1;
            tm.put(st,tm.getOrDefault(st,0)+1);
            tm.put(ed,tm.getOrDefault(ed,0)-1);
        }
        
        int n = people.length;
        int flowerSum = 0;
        int idx = 0;
        Map<Integer,Integer> hm = new HashMap<>();

        for(Map.Entry<Integer,Integer> en : tm.entrySet()){

            int curDay = en.getKey();
            while(idx<n && arr[idx]<curDay){
                hm.put(arr[idx],flowerSum);
                idx++;
            }

            flowerSum += en.getValue();

            while(idx<n && arr[idx]<=curDay){
                hm.put(arr[idx],flowerSum);
                idx++;
            }
        }

        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            int val = hm.getOrDefault(people[i],0);
            ans[i] = val;
        }
        return ans;
    }
}