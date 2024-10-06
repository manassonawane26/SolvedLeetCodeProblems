/**
 * Using TreeSet. (Here time complexity is most optimized)
 *
 * Very similar to https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Time Complexity: O((N-K)*log K + N*log K) = O(N * log K)
 * Add Elements = O(N*Log K)
 * Remove Elements = O((N-K)*log K) ==> TreeSet.remove() in JAVA is O(log K)
 *
 * Space Complexity: O(K)
 *
 * N = Length of nums array. K = Input k.
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        double[] result = new double[len - k + 1];
        if (k == 1) {
            // for (int i = 0; i < len; i++) {
            //     result[i] = (double) nums[i];
            // }
            // return result;
            return Arrays.stream(nums).asDoubleStream().toArray();
        }

        Comparator<Integer> comparator = (a, b) -> (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));
        TreeSet<Integer> smallNums = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> largeNums = new TreeSet<>(comparator);

        for (int i = 0; i < len; i++) {
            if (i >= k) {
                removeElement(smallNums, largeNums, nums, i - k);
            }
            addElement(smallNums, largeNums, i);
            if (i >= k - 1) {
                result[i - (k - 1)] = getMedian(smallNums, largeNums, nums);
            }
        }

        return result;
    }

    private void addElement(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int idx) {
        smallNums.add(idx);
        largeNums.add(smallNums.pollFirst());
        if (smallNums.size() < largeNums.size()) {
            smallNums.add(largeNums.pollFirst());
        }
    }

    private void removeElement(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int[] nums, int idx) {
        if (largeNums.contains(idx)) {
            largeNums.remove(idx);
            if (smallNums.size() == largeNums.size() + 2) {
                largeNums.add(smallNums.pollFirst());
            }
        } else {
            smallNums.remove(idx);
            if (smallNums.size() < largeNums.size()) {
                smallNums.add(largeNums.pollFirst());
            }
        }
    }

    private double getMedian(TreeSet<Integer> smallNums, TreeSet<Integer> largeNums, int[] nums) {
        if (smallNums.size() == largeNums.size()) {
            return ((double) nums[smallNums.first()] + nums[largeNums.first()]) / 2;
        }
        return nums[smallNums.first()];
    }
}