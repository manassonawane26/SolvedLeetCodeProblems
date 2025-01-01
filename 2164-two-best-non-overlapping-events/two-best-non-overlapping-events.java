import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int maxVal = 0, ans = 0;
        
        for (int[] event : events) {
            int start = event[0], end = event[1], value = event[2];
            
            // Remove all events that end before the current event's start time
            while (!pq.isEmpty() && pq.peek()[0] < start) {
                maxVal = Math.max(maxVal, pq.poll()[1]);
            }
            
            // Update the maximum sum of values
            ans = Math.max(ans, maxVal + value);
            
            // Add the current event to the priority queue
            pq.offer(new int[] {end, value});
        }
        
        return ans;
    }
}

// class Solution {
//     public int maxTwoEvents(int[][] events) {
//         List<int[]> lineSweep = new ArrayList<>();
//         for (int[] event : events) {
//             lineSweep.add(new int[]{event[0], 1, event[2]});
//             lineSweep.add(new int[]{event[1] + 1, -1, event[2]});
//         }
//         lineSweep.sort((a, b) -> a[0] - b[0]);

//         int maxVal = 0, maxSeen = 0;
//         for (int[] event : lineSweep) {
//             int point = event[0], status = event[1], val = event[2];
//             if (status == 1) {
//                 maxVal = Math.max(maxVal, maxSeen + val);
//             } else {
//                 maxSeen = Math.max(maxSeen, val);
//             }
//         }
//         return maxVal;
//     }
// }


// import java.util.*;

// class Solution {
//     public int maxTwoEvents(int[][] events) {
//         int n = events.length;
        
//         // Step 1: Sort the events by their start time
//         Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
//         // Step 2: Create the suffix array for the maximum event value from each event onward
//         int[] suffixMax = new int[n];
//         suffixMax[n - 1] = events[n - 1][2];  // Initialize the last event's value
        
//         // Populate the suffixMax array
//         for (int i = n - 2; i >= 0; --i) {
//             suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
//         }
        
//         // Step 3: For each event, find the next event that starts after it ends
//         int maxSum = 0;
        
//         for (int i = 0; i < n; ++i) {
//             int left = i + 1, right = n - 1;
//             int nextEventIndex = -1;
            
//             // Perform binary search to find the next non-overlapping event
//             while (left <= right) {
//                 int mid = left + (right - left) / 2;
//                 if (events[mid][0] > events[i][1]) {
//                     nextEventIndex = mid;
//                     right = mid - 1;
//                 } else {
//                     left = mid + 1;
//                 }
//             }
            
//             // If a valid next event is found, update the max sum
//             if (nextEventIndex != -1) {
//                 maxSum = Math.max(maxSum, events[i][2] + suffixMax[nextEventIndex]);
//             }
            
//             // Also consider the case where we take only the current event
//             maxSum = Math.max(maxSum, events[i][2]);
//         }
        
//         return maxSum;
//     }
// }