class NumberContainers {
    Map<Integer,Integer> hm;
    Map<Integer,TreeSet<Integer>> num;
    public NumberContainers() {
        hm = new HashMap<>();
        num = new HashMap<>();
    }
    
    public void change(int index, int number) {
        //remove old element
        int old = hm.getOrDefault(index,-1);
        if(old != -1){
            TreeSet<Integer> oldSet = num.get(old);
            oldSet.remove(index);
            if(oldSet.size() == 0) num.remove(old);
            else{
                num.put(old,oldSet);
            }
        }

        // new element
        hm.put(index,number);
        if(!num.containsKey(number)){
            num.put(number,new TreeSet<>());
        }
        num.get(number).add(index);
    }
    
    public int find(int number) {
        if(!num.containsKey(number)) return -1;
        int firstIdx = -1;
        for(int it : num.get(number)){
            firstIdx = it;
            break;
        }
        return firstIdx;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */