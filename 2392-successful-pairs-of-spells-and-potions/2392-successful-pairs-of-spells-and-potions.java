class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int temp[] = spells.clone();
        Arrays.sort(temp);
        int m = potions.length;
        int n = spells.length;

        Map<Integer,Integer> hm = new HashMap<>();
        int j = m-1;

        for(int i=0;i<n;i++){
            while(j >= 0){
                if(((long)temp[i]*potions[j]) < success) break;
                j--;
            }
            hm.put(temp[i],m-j-1);
            // System.out.println(m-j-1);
        }

        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = hm.get(spells[i]);
        }

        return ans;
    }
}