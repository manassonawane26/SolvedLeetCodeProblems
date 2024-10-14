public class Solution {
    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        // Add all elements to the priority queue
        for (int num : nums) {
            pq.add(num);
        }
        
        long score = 0;
        
        while (k > 0) {
            int ele = pq.poll();  // Extract the max element
            score += ele;
            pq.add((int) Math.ceil(ele / 3.0));  // Re-insert ceil(ele / 3) into the queue
            k--;
        }
        
        return score;
    }
}