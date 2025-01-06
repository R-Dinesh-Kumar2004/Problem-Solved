class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int dis=0,rBall=0,lBall=0;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                dis+=i;
                rBall++;
            }
        }

        int ans[] = new int[n];
        ans[0] = dis;
        if(boxes.charAt(0)=='1'){
            rBall--;lBall++;
        }
        for(int i=1;i<n;i++){
            dis-=rBall;
            dis+=lBall;
            if(boxes.charAt(i)=='1'){
                rBall--;lBall++;
            }
            ans[i] = dis;
        }
        return ans;
    }
}