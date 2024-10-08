// version 3: O(min(M, N)) space
class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return countSubstrings(t, s);
        
        int res = 0;
        int[][] dp = new int[n+1][2];
        
        for (int i = 0; i < m; i++) {
            int[][] next = new int[n+1][2];
            for (int j = 0; j < n; j++) {
                next[j+1][0] = (s.charAt(i) == t.charAt(j)) ? dp[j][0] + 1 : 0;
                next[j+1][1] = (s.charAt(i) == t.charAt(j)) ? dp[j][1] : dp[j][0] + 1;
                res += next[j+1][1];
            }
            
            dp = next;
        }
        
        return res;
    }
}