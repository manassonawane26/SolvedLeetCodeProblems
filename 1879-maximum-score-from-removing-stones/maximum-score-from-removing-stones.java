// class Solution {
//     public int maximumScore(int a, int b, int c) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>(3, Comparator.reverseOrder());
//         pq.offer(a);
//         pq.offer(b);
//         pq.offer(c);
//         int count= 0;
//         while(pq.size()>1){
//             int x = pq.poll();
//             int y = pq.poll();
//             count++;
//             x--; y--;
//             if(x>0) pq.offer(x);
//             if(y>0) pq.offer(y);
//         }
//         return count;
//     }
// }


import java.util.Arrays;

class Solution {
    public int maximumScore(int a, int b, int c) {
        int[] piles = new int[] {a, b, c};
        Arrays.sort(piles);

        if (piles[0] + piles[1] <= piles[2]) {
            return piles[0] + piles[1];
        }
        
        return (a + b + c) / 2;
    }
}