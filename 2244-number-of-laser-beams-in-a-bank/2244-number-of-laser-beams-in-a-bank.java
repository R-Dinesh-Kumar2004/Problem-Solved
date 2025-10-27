class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        List<Integer> laser = new ArrayList<>();

        for(int i=0;i<n;i++){
            String s = bank[i];
            int count = 0;

            for(int j=0;j<s.length();j++){
                if(s.charAt(j) == '1') count++;
            }

            if(count != 0) laser.add(count);
        }

        int ans = 0;

        for(int i=0;i<laser.size()-1;i++){
            ans += (laser.get(i)*laser.get(i+1));
        }

        return ans;
    }
}