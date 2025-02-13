class Solution {
    public int distMoney(int money, int children) {
        if(children > money) return -1;
        money -= children;
        int count = 0; 
        while(money>6 && children>0){
            money-=7;
            count++;
            children--;
        }
        if(money == 0) return count;
        else if(money == 3 && children == 1) return count-1;
        else if(money != 0 && children == 0) return count-1;
        return count;
    }
}