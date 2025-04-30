class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int linT = hourToMinutes(loginTime);
        int louT = hourToMinutes(logoutTime);

        
        int totalTime = 0;
        if(linT<louT){
            if(linT%15 != 0){
                int rem = linT%15;
                linT += (15-rem);
            }
            totalTime = louT-linT;
        }
        else{
            if(linT%15 != 0){
                int rem = linT%15;
                linT += (15-rem);
            }
            totalTime = 1440 - linT;
            totalTime += louT;
        }
        int ans = totalTime/15;
        return ans;
    }
    public int hourToMinutes(String t){
        int minutes = Integer.parseInt(t.substring(0,2))*60;
        minutes += Integer.parseInt(t.substring(3));
        return minutes;
    }
}