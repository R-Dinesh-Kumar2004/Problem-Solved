class Solution {
    class Ratio{
        int pass,tot;
        Ratio(int pass,int tot){
            this.pass = pass;
            this.tot = tot;
        }
        double getPassRatio(){
            return (double)pass/tot;
        }
        double gain(){
            return ((double)(pass+1)/(tot+1))-getPassRatio();
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Ratio> pq = new PriorityQueue<>((a,b) ->
            Double.compare(b.gain(),a.gain())
        );

        for(int c[] : classes){
            pq.add(new Ratio(c[0],c[1]));
        }

        while(extraStudents > 0){
            Ratio ratio = pq.poll();
            ratio.pass += 1;
            ratio.tot += 1;
            pq.add(ratio);

            extraStudents--;
        }

        double tot = 0;

        while(!pq.isEmpty()){
            tot += pq.poll().getPassRatio();
        }

        int n = classes.length;

        return tot/n;
    }
}