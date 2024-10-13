import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int maxVal = Integer.MIN_VALUE;   // Max value in the current window
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])   // Min-heap based on the first element
        );
        
        int k = nums.size();
        for (int i = 0; i < k; ++i) {     // Push first values of each list
            maxVal = Math.max(maxVal, nums.get(i).get(0));
            minHeap.offer(new int[]{nums.get(i).get(0), i, 0});
        }
        
        int min_L = 0;        // Start of the range
        int max_R = Integer.MAX_VALUE;  // End of the range
        
        while (true) {   // Process the heap until 1 element from each list is present
            int[] curr = minHeap.poll();
            int r = curr[1];
            int c = curr[2];
            int currVal = curr[0];
            
            // Update the result if the current range is smaller
            if (max_R - min_L > maxVal - currVal) {
                min_L = currVal;
                max_R = maxVal;
            }
            
            // Push the next item of the list if possible
            if (c < nums.get(r).size() - 1) {
                minHeap.offer(new int[]{nums.get(r).get(c + 1), r, c + 1});
                maxVal = Math.max(maxVal, nums.get(r).get(c + 1));
            } else {
                break;
            }
        }
        return new int[]{min_L, max_R};
    }
}