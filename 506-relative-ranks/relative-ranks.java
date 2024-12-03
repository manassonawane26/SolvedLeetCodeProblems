// class Solution {
//     class Score {
//         int idx;
//         int num;

//         public Score(int num, int idx) {
//             this.num = num;
//             this.idx = idx;
//         }
//     }

//     public String[] findRelativeRanks(int[] score) {
//         PriorityQueue<Score> pq = new PriorityQueue<>((a, b) -> b.num - a.num);
//         for (int i = 0; i < score.length; i++) {
//             pq.add(new Score(score[i], i));
//         }
//         String[] result = new String[score.length];
//         int rank = 0;

//         while (!pq.isEmpty()) {
//             Score s = pq.poll();
//             switch (rank) {
//                 case 0:
//                     result[s.idx] = "Gold Medal";
//                     break;

//                 case 1:
//                     result[s.idx] = "Silver Medal";
//                     break;

//                 case 2:
//                     result[s.idx] = "Bronze Medal";
//                     break;

//                 default:
//                     result[s.idx] = String.valueOf(rank + 1);
//             }

//             rank++;
//         }

//         return result;
//     }
// }


/*
Approach 1: Sorting with Index Array
In this approach, we create an auxiliary array, `scoreWithIndex`, to keep track of each score and its original index. We then sort `scoreWithIndex` in descending order based on the score. After sorting, we assign ranks based on their sorted order.

Time Complexity: O(n log n) - sorting the array `scoreWithIndex` takes O(n log n).
Space Complexity: O(n) - to store the `scoreWithIndex` array.

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        
        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];
            scoreWithIndex[i][1] = i;
        }
        
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < n; i++) {
            int originalIndex = scoreWithIndex[i][1];
            if (i == 0) result[originalIndex] = "Gold Medal";
            else if (i == 1) result[originalIndex] = "Silver Medal";
            else if (i == 2) result[originalIndex] = "Bronze Medal";
            else result[originalIndex] = String.valueOf(i + 1);
        }
        
        return result;
    }
}
*/

/*
Approach 2: Priority Queue (Max Heap)
This approach uses a max heap (priority queue) to store the scores along with their indices, sorted in descending order by score. We then pop each element from the heap to assign ranks based on the order in which they’re removed from the queue.

Time Complexity: O(n log n) - inserting into and removing from the heap takes O(log n) per operation, and we do this for each score.
Space Complexity: O(n) - for storing elements in the priority queue.
*/
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);  // Max Heap

        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { score[i], i });
        }

        int rank = 1;

        while (!pq.isEmpty()) {
            int[] athlete = pq.poll();
            int index = athlete[1];

            if (rank == 1) result[index] = "Gold Medal";
            else if (rank == 2) result[index] = "Silver Medal";
            else if (rank == 3) result[index] = "Bronze Medal";
            else result[index] = String.valueOf(rank);

            rank++;
        }

        return result;
    }
}
