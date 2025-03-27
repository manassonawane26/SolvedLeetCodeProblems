class Solution {
    public int specialPerm(int[] nums) {
        int n = nums.length;
        int[][][] dp =new int[n+1][n][1<<n];
         for (int i = 0; i <=n ; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }

        }
        return dfs(0, 0, 0, dp, nums);
    }

    private int dfs(int curr, int prev, int mask, int[][][] dp, int[]  nums) {
        if(curr == nums.length){
            return 1; // if the index is reaches the end than this is an valid permutation so we return 1
        }
        if (dp[prev][curr][mask] != -1) { // the value for the prev index and current index and mask is already computed return tat ans i.e no matter what happens if the current and previous and mask is equal the balance permutation is always constant
            return dp[prev][curr][mask];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & 1 << i) == 0){ // current number nums[i] is not choosen
                if (curr == 0  || nums[prev] % nums[i] == 0 || nums[i] % nums[prev] == 0) { // current number if(i==0) or nums[i] % prev ==0 or nums[i] % prev % nums[i] ==0. 
                    res +=  dfs(curr + 1, i, mask | (1 << i), dp, nums); // mask | (1 << i) mark the bit i as masked(choosed)
                    res %= 1000000007; // to avoid overflow of interger
                }
            }
        }
        return dp[prev][curr][mask] = res;
    }
}