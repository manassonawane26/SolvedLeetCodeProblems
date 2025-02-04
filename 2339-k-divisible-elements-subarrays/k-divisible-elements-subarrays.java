class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<n; j++){
                if(nums[j] % p == 0)
                    count++;
                if(count > k)
                    break;

                sb.append(nums[j] + " ");
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}

// class Solution {
//     private static class Node {
// 		private int val;
// 		private boolean isEnd;
// 		private Node[] children;

// 		public Node(int val) {
// 			this.val = val;
// 			this.isEnd = false;
// 			this.children = new Node[201];
// 		}
// 	}

// 	private int totalCount = 0;
// 	private Node root = new Node(0);
	
// 	private void insert(int[] nums, int left, int right) {
// 		Node curr = this.root;
// 		for (int i = left; i <= right; i++) {
// 			int childIdx = nums[i];
// 			if (curr.children[childIdx] == null) {
// 				curr.children[childIdx] = new Node(childIdx);
// 			}
// 			curr = curr.children[childIdx];
// 			if (!curr.isEnd) {
// 				totalCount++;
// 				curr.isEnd = true;
// 			}
// 		}
// 	}

// 	public int countDistinct(int[] nums, int k, int p) {
// 		int count = 0;
// 		int n = nums.length;
// 		int left = 0;
// 		int right = 0;
// 		while (left < n) {
// 			while (right < n) {
// 				if (nums[right] % p == 0) {
// 					count++;
// 				}
// 				if (count == k + 1) {
// 					count--;
// 					break;
// 				}
// 				right++;
// 			}
// 			insert(nums, left, right - 1);
// 			if (nums[left] % p == 0) {
// 				count--;
// 			}
// 			left++;
// 		}
// 		return totalCount;
// 	}
// }