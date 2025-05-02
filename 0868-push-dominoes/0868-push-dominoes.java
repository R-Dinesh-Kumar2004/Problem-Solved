class Solution {
    public String pushDominoes(String dominoes) {
        char ch[] = dominoes.toCharArray();
        int n = ch.length;
        int count = 0;

        int LtoR[] = new int[n];
        for(int i=0;i<n;i++){
            if(ch[i] == 'L'){
               count = 0; continue;
            }
            else if(ch[i] == 'R'){
               LtoR[i] = 1; count = 1;
            } 
            else{
               count += (count == 0) ? 0 : 1;
               LtoR[i] = count;
            }
        }
        
        count = 0;
        int RtoL[] = new int[n];
        for(int i=n-1;i>=0;i--){
            if(ch[i] == 'R'){
                count = 0; continue;
            }
            else if(ch[i] == 'L'){
                RtoL[i] = -1; count = -1;
            }
            else{
                count -= (count == 0) ? 0 : 1;
                RtoL[i] = count;
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i=0;i<n;i++){
            int sum = LtoR[i]+RtoL[i];
            if(LtoR[i] == 0 || RtoL[i] == 0){
                if(sum<0) sb.append("L");
                else if(sum>0) sb.append("R");
                else sb.append(".");
            } 
            else{
                if(sum<0) sb.append("R");
                else if(sum>0) sb.append("L");
                else sb.append(".");
            }
            // System.out.println(LtoR[i]+" "+RtoL[i]);
        }
        return sb.toString();
     }
}