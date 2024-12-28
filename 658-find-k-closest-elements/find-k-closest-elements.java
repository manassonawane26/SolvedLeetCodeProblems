// class Solution {

//     // Approach:
//     // Using binary search and a sliding window, find the midpoint where,
//     // the integers between midpoint and midpoint + k is the k closest integers to x.

//     public List<Integer> findClosestElements(int[] arr, int k, int x) {

//         // The sliding window is between 'mid' and 'mid' + k.
//         int left = 0, right = arr.length - k;
//         while (left < right) {
//             int midpoint = left + (right - left) / 2; // same as (left + right) / 2

//             // With midpoint on the left, we use x - arr[midpoint], while arr[midpoint + k] - x because it is on the right.
//             // This is important!
//             // Rather than using Math.abs(), we need the direction keep the x within the sliding window.
//             // If the window is too far left, we shift the window to the right.
//             if (x - arr[midpoint] > arr[midpoint + k] - x) {
//                 left = midpoint + 1;
//             }
//             // If the window is too far right, we shift the window to the left.
//             else {
//                 right = midpoint;
//             }
//         }

//         // Input all the k closest integers into the result.
//         List<Integer> result = new ArrayList<>(k);
//         for (int i = left; i < left + k; i++) {
//             result.add(arr[i]);
//         }
//         return result;
//     }
// }

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int integer : arr) {
            if (k > 0) {
                minHeap.offer(integer);
                k--;
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(integer - x)) {
                minHeap.poll();
                minHeap.offer(integer);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}