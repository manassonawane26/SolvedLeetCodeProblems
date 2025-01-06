class Pair{
    int x, y;
    long dist;
    Pair(int x, int y, long dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
        
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare(b.dist, a.dist));

        for(int[] i:points){
            int x = i[0];
            int y = i[1];
            pq.offer(new Pair(x,y, x*x + y*y ));
            if(pq.size()>k)
                pq.poll();
        }

        int ans[][] = new int[k][2];
        for(int i =0;i<k; i++){
            Pair pair = pq.poll();
            ans[i][0] = pair.x;
            ans[i][1] = pair.y;
        }
        return ans;
    }
}