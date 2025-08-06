class MyCalendarTwo {
    Map<Integer,Integer> hm;

    public MyCalendarTwo() {
        hm = new TreeMap<>();
    }
    
    public boolean book(int st, int et) {
        hm.put(st,hm.getOrDefault(st,0)+1);
        hm.put(et,hm.getOrDefault(et,0)-1);

        boolean isConflict = false;
        int sum = 0;
        for(Map.Entry<Integer,Integer> en : hm.entrySet()){
            sum += en.getValue();
            if(sum > 2){
                isConflict = true;
                break;
            }
        }

        if(isConflict){
            hm.put(st,hm.getOrDefault(st,0)-1);
            hm.put(et,hm.getOrDefault(et,0)+1);

            if(hm.get(st) == 0) hm.remove(st);
            if(hm.get(et) == 0) hm.remove(et);
        }

        return !isConflict;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */