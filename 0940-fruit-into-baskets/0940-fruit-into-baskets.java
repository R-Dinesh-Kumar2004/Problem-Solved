class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int freq[] = new int[100001];
        int left = 0,ans = 0, count = 0;

        for(int right=0;right<n;right++){
            int fruit = fruits[right];

            if(freq[fruit]++ == 0) count++;

            while(count > 2){
                int del = fruits[left];
                if(--freq[del] == 0) count--;
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }

        return ans;
    }
}