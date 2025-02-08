class Solution {
    class TrieNode {
        TrieNode zero, one;
    }
    void insert(TrieNode root, int n) {
        TrieNode cur = root;
        for(int i=31; i>=0; i--){
            int bit = (n>>i) &1;
            if(bit == 0){
                if(cur.zero == null) {
                    TrieNode newNode = new TrieNode();
                    cur.zero = newNode;
                }
                cur = cur.zero;
            } else {
                if(cur.one == null) {
                    TrieNode newNode = new TrieNode();
                    cur.one = newNode;
                }
                cur = cur.one;
            }
        }
    }
    int findMaxXor(TrieNode root, int n){
        TrieNode cur = root;
        int ans = 0;
        for(int i = 31; i>=0; i--){
            int bit = (n>>i) & 1;
            if(bit == 1){
                if(cur.zero!=null){
                    ans += (1 << i);
                    cur = cur.zero;
                } else {
                    cur = cur.one;
                }
            } else {
                if(cur.one != null) {
                    ans += (1 << i);
                    cur = cur.one;
                } else {
                    cur = cur.zero;
                }
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        TrieNode root = new TrieNode();
        int ans = 0;
        for(int i = 0; i<n; i++){
            insert(root, nums[i]);
        }
        for(int i = 1; i<n; i++){
            ans = Math.max(ans, findMaxXor(root, nums[i]));
        }
        return ans;
    }
}
