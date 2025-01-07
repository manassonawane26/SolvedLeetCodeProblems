class Pair{
    int end;
    int passCount;

    public Pair(int a, int b){
        this.end = a;
        this.passCount = b;
    }
}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b)-> a[1]-b[1]);
          
        int currPass = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.end - b.end);

        for(int[] i: trips){
            int numPass = i[0];
            int first = i[1];
            int last = i[2];
            while(!pq.isEmpty() && pq.peek().end <= first){
                currPass -= pq.poll().passCount;
            }

            currPass += numPass;
            if(currPass > capacity)
                return false;

            pq.offer(new Pair(last, numPass));
        }
        return true;
    }
}