class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, 0, new Boolean[s.length()], wordDict);
    }

    private boolean dfs(String s, int idx, Boolean[] dp, List<String> wordDict) {
        if(idx >= s.length()) {
            return true;
        }
        if(dp[idx] != null) {
            return dp[idx];
        }
        boolean res = false;
        for(String w: wordDict) {
            if(s.startsWith(w, idx) && dfs(s, idx + w.length(), dp, wordDict)) {
                res = true;
                break;
            }
        }
        return dp[idx] = res;
    }
}

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         boolean[] dp = new boolean[n + 1];
//         dp[0] = true;
//         int max_len = 0;
//         for (String word : wordDict) {
//             max_len = Math.max(max_len, word.length());
//         }

//         for (int i = 1; i <= n; i++) {
//             for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
//                 if (dp[j] && wordDict.contains(s.substring(j, i))) {
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }

//         return dp[n];
//     }
// }
// https://leetcode.com/problems/word-break/solutions/3860456/100-dp-dfs-video-segmenting-a-string