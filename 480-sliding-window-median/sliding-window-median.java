class Solution {
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        Map<Integer, Integer> removed = new HashMap<>();

        PriorityQueue<Integer> mins = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> maxs = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (int i=0; i<k; i++) {
            maxs.add(nums[i]);
            mins.add(maxs.poll());
            if (mins.size() - maxs.size() > 1) {
                maxs.add(mins.poll());
            }
        }

        for (int i=k; i<=nums.length; i++) {
            res[i-k] = mediane(mins, maxs, k);

            if (i < nums.length) {
                int balance = nums[i-k] <= mins.peek() ? -1 : 1;
                markRemove(nums[i-k], removed);

                if (nums[i] <= mins.peek()) {
                    mins.add(nums[i]);
                    balance++;
                } else {
                    maxs.add(nums[i]);
                    balance--;
                }
                
                if (balance < 0) {
                    mins.add(maxs.poll());
                }
                if (balance > 0) {
                    maxs.add(mins.poll());
                }

                tryRemove(mins, removed);
                tryRemove(maxs, removed);
            }
        }

        return res;
    }

    private void tryRemove(PriorityQueue<Integer> queue, Map<Integer, Integer> removed) {
        while (!queue.isEmpty() && removed.getOrDefault(queue.peek(), 0) > 0) {
            int a = queue.poll();
            removed.put(a, removed.get(a) - 1);
        }
    }

    private void markRemove(int a, Map<Integer, Integer> removed) {
        removed.put(a, removed.getOrDefault(a, 0) + 1);
    }

    private double mediane(PriorityQueue<Integer> mins, PriorityQueue<Integer> maxs, int k) {
        if (k % 2 == 0) {
            double val = mins.peek() * 0.5 + maxs.peek() * 0.5;
            return val; 
        } else {
            return mins.peek();
        }
    }
}

// class Solution {
//     public double[] medianSlidingWindow(int[] nums, int k) {
//         Queue<Integer> minHeap = new PriorityQueue<>();
//         Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
//         double[] res = new double[nums.length - k + 1];
//         for(int i = 0; i< nums.length; i++){
//             if(i >= k){
//                 if(!minHeap.remove(nums[i-k]))
//                     maxHeap.remove(nums[i-k]);
//             }
            
//             // If k is odd, max heap is of odd size and min heap is of even
//             // else both are of even size
//             if(!maxHeap.isEmpty() && nums[i] <= maxHeap.peek()) {
//                 maxHeap.add(nums[i]);
//                 if(((k&1) == 1 && maxHeap.size() > k/2+1) || ((k&1) == 0 && maxHeap.size() > k/2)){
//                     minHeap.offer(maxHeap.poll());
//                 }
//             }else{
//                 minHeap.add(nums[i]);
//                 if(minHeap.size() > k/2){
//                     maxHeap.offer(minHeap.poll());
//                 }
//             }
//             while(!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
//                 int temp1 = maxHeap.poll();
//                 int temp2 = minHeap.poll();
//                 maxHeap.add(temp2);
//                 minHeap.add(temp1);
//             }
//             if(minHeap.size() + maxHeap.size() == k){
//                 if((k&1)==1){
//                     res[i-k+1] = maxHeap.peek();
//                 }else{
//                     res[i-k+1] = ((long)minHeap.peek()+ (long)maxHeap.peek())/2.0;
//                 }
//             }
//         }
//         return res;
//     }
// }


// class Solution {
//     public double[] medianSlidingWindow(int[] nums, int k) {
        
//         double[] result = new double[nums.length - k + 1];
//         int p = 0;
//         PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
//         PriorityQueue<Integer> min = new PriorityQueue<>();
        
//         int i=0, j=0;
//         while(j < nums.length) {
            
//             if(max.size() <= min.size()) {
//                 min.add(nums[j]);
//                 max.add(min.poll());
//             }
//             else {
//                 max.add(nums[j]);
//                 min.add(max.poll());
//             }
//             if(j-i+1 < k) j++;
            
//             else if(j-i+1 == k) {
//                 if(max.size() == min.size())
//                     result[p++] = (double) ((long)max.peek() + (long)min.peek()) / 2.0;
//                 else
//                     result[p++] = (double)max.peek();
                
//                 if(!max.remove(nums[i])) min.remove(nums[i]);
//                 i++; j++;
//             }
//         }
        
//         return result;
//     }
// }








// /**
//  * Using TreeSet. (Here time complexity is most optimized)
//  *
//  * Very similar to https://leetcode.com/problems/find-median-from-data-stream/
//  *
//  * Time Complexity: O((N-K)*log K + N*log K) = O(N * log K)
//  * Add Elements = O(N*Log K)
//  * Remove Elements = O((N-K)*log K) ==> TreeSet.remove() in JAVA is O(log K)
//  *
//  * Space Complexity: O(K)
//  *
//  * N = Length of nums array. K = Input k.
//  */
// class Solution {
//     public double[] medianSlidingWindow(int[] nums, int k) {
//         int len = nums.length;
//         double[] result = new double[len - k + 1];
//         if (k == 1) {
//             // for (int i = 0; i < len; i++) {
//             //     result[i] = (double) nums[i];
//             // }
//             // return result;
//             return Arrays.stream(nums).asDoubleStream().toArray();
//         }

//         Comparator<Integer> comparator = (a, b) -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));
//         TreeSet<Integer> smallNums = new TreeSet<>(comparator.reversed());
//         TreeSet<Integer> largeNums = new TreeSet<>(comparator);

//         for (int i = 0; i < len; i++) {
//             if (i >= k) {
//                 removeElement(smallNums, largeNums, nums, i - k);
//             }
//             addElement(smallNums, largeNums, i);
//             if (i >= k - 1) {
//                 result[i - (k - 1)] = getMedian(smallNums, largeNums, nums);
//             }
//         }

//         return result;
//     }

//     private void addElement(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int idx) {
//         smallNums.add(idx);
//         largeNums.add(smallNums.pollFirst());
//         if (smallNums.size() < largeNums.size()) {
//             smallNums.add(largeNums.pollFirst());
//         }
//     }

//     private void removeElement(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int[] nums, int idx) {
//         if (largeNums.contains(idx)) {
//             largeNums.remove(idx);
//             if (smallNums.size() == largeNums.size() + 2) {
//                 largeNums.add(smallNums.pollFirst());
//             }
//         } else {
//             smallNums.remove(idx);
//             if (smallNums.size() < largeNums.size()) {
//                 smallNums.add(largeNums.pollFirst());
//             }
//         }
//     }

//     private double getMedian(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int[] nums) {
//         if (smallNums.size() == largeNums.size()) {
//             return ((double) nums[smallNums.first()] + nums[largeNums.first()]) / 2;
//         }
//         return nums[smallNums.first()];
//     }
// }


// /*
// import java.util.*;

// class Solution {
    
//     PriorityQueue<Integer> maxHeap; // max heap is small list so that root is largest
//     PriorityQueue<Integer> minHeap; // min heap is large list so that the root is smallest
//     Map<Integer, Integer> removedElements;

//     public double[] medianSlidingWindow(int[] nums, int k) {
//         maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
//         minHeap = new PriorityQueue<>();
//         removedElements = new HashMap<>();

//         double[] medians = new double[nums.length - k + 1];
//         for (int i=0; i<k; i++) {
//             addNum(nums[i]);
//         }
//         medians[0] = findMedian(k);

//         int start, end;
//         for (int i=1; i<nums.length-k+1; i++) {
//             start=i; end = i+k-1;
//             int outgoingNum = nums[start-1], incomingNum = nums[end];
            
//             removedElements.put(outgoingNum, removedElements.getOrDefault(outgoingNum, 0)+1);
//             int balance = outgoingNum <= maxHeap.peek() ? -1 : 1;
            
//             if (!maxHeap.isEmpty() && incomingNum <= maxHeap.peek()) {
//                 maxHeap.add(incomingNum);
//                 balance++;
//             } else {
//                 minHeap.add(incomingNum);
//                 balance--;
//             }
            
//             if (balance < 0) {
//                 maxHeap.add(minHeap.poll());
//             } else if (balance > 0) {
//                 minHeap.add(maxHeap.poll());
//             }
//             lazyRemoval();
            
//             medians[start] = findMedian(k);
//         }
//         return medians;
//     }
    
//     private void lazyRemoval() {
//         while (!maxHeap.isEmpty() && removedElements.containsKey(maxHeap.peek()) && removedElements.get(maxHeap.peek()) > 0) {
//             Integer removed = maxHeap.poll();
//             removedElements.put(removed, removedElements.get(removed)-1);
//         }
//         while (!minHeap.isEmpty() && removedElements.containsKey(minHeap.peek()) && removedElements.get(minHeap.peek()) > 0) {
//             Integer removed = minHeap.poll();
//             removedElements.put(removed, removedElements.get(removed)-1);
//         }
//     }
    
//     private void addNum(int num) {
//         if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
//             maxHeap.add(num);
//         } else {
//             minHeap.add(num);
//         }
//         balanceHeaps();
//     }
    
//     private void balanceHeaps() {
//         if (maxHeap.size() - minHeap.size() > 1) {
//             minHeap.add(maxHeap.poll());
//         } else if (minHeap.size() > maxHeap.size()) {
//             maxHeap.add(minHeap.poll());
//         }
//     }
    
//     private double findMedian(int k) {
//         if (k%2 == 0) {
//             return ((long) maxHeap.peek() + (long) minHeap.peek())/2.0;
//         } else {
//             return  maxHeap.peek();
//         }
//     }
// }
// */
